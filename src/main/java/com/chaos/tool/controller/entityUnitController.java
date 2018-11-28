package com.chaos.tool.controller;

import com.chaos.tool.service.IentityUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//返回json字符串
@RestController
public class entityUnitController {

    @Autowired
    @Qualifier("entityUnitService")
    private IentityUnitService entityUnitService ;

    @RequestMapping("/createEntity")
    public String createEntity(@RequestParam(value = "table",required = false) String table){
        if((table+"").equals("null")){
            return "传入参数无效值！";
        }else{
            return entityUnitService.createEntity(table);
        }

    }
}
