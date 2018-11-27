package com.chaos.tool.controller;

import com.chaos.tool.service.IentityUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//返回json字符串
@RestController
public class entityUnitController {

    @Autowired
    private IentityUnitService entityUnitService ;

    @RequestMapping("/createEntity")
    public String createEntity(){
        return entityUnitService.createEntity();
    }
}
