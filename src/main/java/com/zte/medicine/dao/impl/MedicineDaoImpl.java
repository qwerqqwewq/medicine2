package com.zte.medicine.dao.impl;

import com.zte.medicine.dao.MedicineDao;
import com.zte.medicine.entity.Medicine;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:helloboy
 * Date:2020-03-13 9:12
 * Description:<描述>
 */
@Transactional(rollbackFor = Exception.class)
@Repository("MedicineDao")
public class MedicineDaoImpl implements MedicineDao {

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public void insertMedicine(Medicine medicine) {
        sessionFactory.getCurrentSession().save(medicine);
    }

    @Override
    public void updateMedicine(Medicine medicine) {
        sessionFactory.getCurrentSession().update(medicine);
    }

    @Override
    public List<Medicine> advancedSearch(String name, String code2, String code3, String listPrice,String listPrice2,String price,String price2,Timestamp date1, Timestamp date2,Timestamp date3,Timestamp date4){
        StringBuilder hql=new StringBuilder("from Medicine where 1=1");


        Map<String, Object> map = new HashMap<String, Object>();

        if (name.length()!=0) {
             hql.append(" and MedicineName like :MedicineName");
            map.put("MedicineName", "%" + name + "%");
        }

        if (code2.length()!=0) {
            hql.append(" and KindCode = :KindCode");
            map.put("KindCode", code2);
        }

        if (code3.length()!=0){
            hql.append(" and FirmCode = :FirmCode");
            map.put("FirmCode", code3);
        }

        if (listPrice.length()!=0) {
            hql.append(" and ListPrice >= :ListPrice ");
            map.put("ListPrice", listPrice);
        }

        if (listPrice2.length()!=0) {
            hql.append(" and ListPrice <= :ListPrice2" );
            map.put("ListPrice2", listPrice2);
        }

        if (price.length()!=0) {
            hql.append(" and Price >= :Price" );
            map.put("Price", price);
        }

        if (price2.length()!=0) {
            hql.append(" and Price <= :Price2") ;
            map.put("Price2", price2);
        }

        if (date1 != null) {
            hql.append(" and FirstDate >= :date1");
            map.put("FirstDate", date1);
        }

        if (date2 != null) {
            hql.append(" and FirstDate <= :date2");
            map.put("FirstDate2", date2);
        }

        if (date3 != null) {
            hql.append(" and UsefullDate >= :date3");
            map.put("UsefullDate", date3);
        }

        if (date4 != null) {
            hql.append(" and UsefullDate <= :date4");
            map.put("UsefullDate2", date4);
        }

        Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
        query.setProperties(map);
        return query.list();


        //return (List<Medicine>)sessionFactory.getCurrentSession().createSQLQuery(hql).list();
    }

    @Override
    public List<Medicine> selectMedicineByCode(String code) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Medicine where medicineCode = :MedicineCode");
        query.setParameter("MedicineCode", code);
        return query.list();
    }

    @Override
    public List<Medicine> selectMedicineByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Medicine where medicineName like :MedicineName");
        query.setParameter("MedicineName","%"+name+"%");
        return query.list();
    }

    //@Override
    //public Medicine selectMedicineByKind(String code) {
    //    return (Medicine)sessionFactory.getCurrentSession().createSQLQuery("select * from t_medicine where KindCode="+code+";");
    //}
    //
    //@Override
    //public Medicine selectMedicineByFirm(String code) {
    //    return (Medicine)sessionFactory.getCurrentSession().createSQLQuery("select * from t_medicine where FirmCode="+code+";");
    //}
    //
    //@Override
    //public Medicine selectMedicineByDate(Timestamp date) {
    //    return (Medicine)sessionFactory.getCurrentSession().createSQLQuery("select * from t_medicine where FirstDate="+date+";");
    //}
    //
    //@Override
    //public Medicine selectMedicineByUsefulDate(Timestamp date) {
    //    return (Medicine)sessionFactory.getCurrentSession().createSQLQuery("select * from t_medicine where UsefullDate="+date+";");
    //}

    @Override
    public void deleteMedicine(Medicine medicine) {
        sessionFactory.getCurrentSession().delete(medicine);
    }

    @Override
    public List<Medicine> selectAll(){
        Query query = sessionFactory.getCurrentSession().createQuery("from Medicine");
        return query.list();
    }
}
