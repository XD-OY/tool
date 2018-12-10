package com.chaos.tool.controller;

import com.chaos.tool.service.IentityUnitService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


//@Mpper和MapperScan都是浏览dao层的
@MapperScan("com.chaos.tool.dao")
//返回json字符串
@RestController
public class entityUnitController {

    @Autowired
    @Qualifier("entityUnitService")
    private IentityUnitService entityUnitService;

    @RequestMapping("/createEntity")
    public String createEntity(@RequestParam(value = "table", required = false) String table) throws IOException {
        if ((table + "").equals("null")) {
            return "传入参数无效值！";
        } else {
            String result = entityUnitService.createEntity(table);
            System.out.print(result);
            return result;
        }

    }
}
