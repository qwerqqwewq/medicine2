package com.zte.medicine.service.impl;

import com.zte.medicine.dao.KindDao;
import com.zte.medicine.entity.Kind;
import com.zte.medicine.service.KindService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author:helloboy
 * Date:2020-02-07 17:26
 * Description:<描述>
 */
@Service("KindService")
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class KindServiceImpl implements KindService {

    public KindDao getKindDao() {
        return kindDao;
    }

    public void setKindDao(KindDao kindDao) {
        this.kindDao = kindDao;
    }

    private KindDao kindDao;

    @Override
    public Kind findKindByCode(String code) {
        return kindDao.selectKindByCode(code);
    }

    @Override
    public void addKind(Kind kind) {
        kindDao.insertKind(kind);
    }

    @Override
    public void modifyKind(Kind kind) {
        kindDao.updateKind(kind);
    }

    @Override
    public void removeKindByCode(String code) {
        kindDao.deleteKindByCode(code);
    }
}
