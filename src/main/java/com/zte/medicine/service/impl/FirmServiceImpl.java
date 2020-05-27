package com.zte.medicine.service.impl;

import com.zte.medicine.dao.FirmDao;
import com.zte.medicine.entity.Firm;
import com.zte.medicine.service.FirmService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:helloboy
 * Date:2020-02-07 17:26
 * Description:<描述>
 */
@Service("firmService")
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class FirmServiceImpl implements FirmService {

    @Resource
    private FirmDao firmDao;

    @Override
    public void addFirm(Firm firm) {
        firmDao.insertFirm(firm);
    }

    @Override
    public List<Firm> findFirmByCode(String code) {
        return firmDao.selectFirmByCode(code);
    }

    @Override
    public List<Firm> findAll(){
        return firmDao.selectAll();
    }

    @Override
    public List<Firm> findFirmByName(String firmName) {
        return firmDao.selectFirmByName(firmName);
    }

    @Override
    public List<Firm> findFirm(String code, String name){
        return firmDao.selectFirm(code, name);
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
