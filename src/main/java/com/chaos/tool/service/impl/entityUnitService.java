package com.chaos.tool.service.impl;

import com.chaos.tool.commUnit.ChangeCharset;
import com.chaos.tool.commUnit.generatorUtils;
import com.chaos.tool.dao.entityUnitMapDao;
import com.chaos.tool.entity.column;
import com.chaos.tool.entity.table;
import com.chaos.tool.service.IentityUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.core.env.Environment;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;


@Service("entityUnitService")
public class entityUnitService implements IentityUnitService {

    @Autowired
    entityUnitMapDao  entityUnitMapDao;
    Environment environment;
    List<column> lists=new ArrayList<column>();

    @Override
    public  String  createEntity(String table) throws IOException {
        String tableName= entityUnitMapDao.createEntity(table);
        ChangeCharset changeCharset=new ChangeCharset();
        tableName=changeCharset.changeCharsetOfHrp(tableName);

        List<Map<String,String>> mapTemp =entityUnitMapDao.queryColumn(table);

        table tables=new table();

        for (int i=1;i<mapTemp.size();i++){
            column column=new column();
            column.setColumnName(mapTemp.get(i).get("COLUMN_NAME").toString());
            column.setDataType(mapTemp.get(i).get("DATA_TYPE").toString(),0);
           lists.add(column);
        }
        tables.setColumns(lists);
        tables.setClassName(table);
        tables.setTableName(table);

        doGeneration(tables);
        return tableName;
    }


    private void doGeneration(table tables) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try  {
            ZipOutputStream zos = new ZipOutputStream(bos);
            FileOutputStream fos = new FileOutputStream("D:\\2.rar");
            generatorUtils.generatorCode(tables, zos, getConfig());
            fos.write(bos.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private Map<String, String> getConfig() {
        Map<String, String> config = new HashMap<>();

        //config.put("package", environment.getProperty("generator.package", ""));
        //config.put("resources", environment.getProperty("generator.resources", ""));
        config.put("package", "generator.package");
        config.put("resources", "generator.resources");
        return config;
    }
}
