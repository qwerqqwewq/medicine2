package com.zte.medicine.dao.impl;

import com.zte.medicine.dao.MedicineDao;
import com.zte.medicine.entity.Medicine;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

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
        String hql="select * from t_medicine;";

        if (name != null) {
             String hql1 = "select * from t_medicine where MedicineName like'%" + name + "%';";
             hql = hql+"intersect"+hql1;
        }

        if (code2 != null) {
            String hql2 = "select * from t_medicine where KindCode=" + code2 + ";";
            hql = hql+"intersect"+hql2;
        }

        if (listPrice != null) {
            String hql3 = "select * from t_medicine where ListPrice>=" + listPrice + ";";
            hql = hql+"intersect"+hql3;
        }

        if (listPrice2 != null) {
            String hql4 = "select * from t_medicine where ListPrice<=" + listPrice2 + ";";
            hql = hql+"intersect"+hql4;
        }

        if (price != null) {
            String hql5 = "select * from t_medicine where Price>=" + price + ";";
            hql = hql+"intersect"+hql5;
        }

        if (price2 != null) {
            String hql6 = "select * from t_medicine where Price<=" + price2 + ";";
            hql = hql+"intersect"+hql6;
        }

        if (date1 != null) {
            String hql7 = "select * from t_medicine where FirstDate>=to_date('" + date1 + "');";
            hql = hql+"intersect"+hql7;
        }

        if (date2 != null) {
            String hql8 = "select * from t_medicine where FirstDate<=to_date('" + date2 + "');";
            hql = hql+"intersect"+hql8;
        }

        if (date3 != null) {
            String hql9 = "select * from t_medicine where UsefullDate>=to_date('" + date3 + "');";
            hql = hql+"intersect"+hql9;
        }

        if (date4 != null) {
            String hql10 = "select * from t_medicine where UsefullDate<=to_date('" + date4 + "');";
            hql = hql+"intersect"+hql10;
        }

        Query query = sessionFactory.getCurrentSession().createQuery(hql);


        return (List<Medicine>)sessionFactory.getCurrentSession().createSQLQuery(hql).list();
    }

    @Override
    public Medicine selectMedicineByCode(String code) {
        return (Medicine) sessionFactory.getCurrentSession().createSQLQuery("select * from t_medicine where MedicineCode like '%"+code+"%';");
    }

    @Override
    public List<Medicine> selectMedicineByName(String name) {
        return (List<Medicine>)sessionFactory.getCurrentSession().createSQLQuery("select * from t_medicine where MedicineName like '%"+name+"%';");
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
}
