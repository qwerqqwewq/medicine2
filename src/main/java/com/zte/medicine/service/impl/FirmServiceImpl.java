package com.zte.medicine.service.impl;

import com.zte.medicine.dao.FirmDao;
import com.zte.medicine.entity.Firm;
import com.zte.medicine.service.FirmService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author:helloboy
 * Date:2020-02-07 17:26
 * Description:<描述>
 */
@Service("FirmService")
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class FirmServiceImpl implements FirmService {

    private FirmDao firmDao;

    @Override
    public void addFirm(Firm firm) {
        firmDao.insertFirm(firm);
    }

    @Override
    public Firm findFirmByCode(String code) {
        return firmDao.selectFirmByCode(code);
    }

    @Override
    public Firm findFirmByName(String name) {
        return firmDao.selectFirmByName(name);
    }

    @Override
    public void modifyFirm(Firm firm) {
        firmDao.updateFirm(firm);
    }

    @Override
    public void removeFirmByCode(String code) {
        firmDao.deleteFirmByCode(code);
    }
}
