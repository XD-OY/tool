package com.chaos.tool.service.impl;

import com.chaos.tool.dao.entityUnitMapDao;
import com.chaos.tool.service.IentityUnitService;
import org.springframework.stereotype.Service;


@Service("entityUnitService")
public class entityUnitService implements IentityUnitService {

    entityUnitMapDao  entityUnitMapDao;

    @Override
    public  String  createEntity(String table){
        return entityUnitMapDao.createEntity(table);
    }
}
