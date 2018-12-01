package com.chaos.tool.entity;

import java.util.HashMap;
import java.util.Map;

public class column {

    private static Map<String,String> mySqlTypeMap=new HashMap<String,String>();
    private static Map<String,String> oracleTypeMap=new HashMap<String,String>();
    private String columnName;
    private String dataType;
    private String attrName;
    private String attrType;

    //静态块（初始化，类加载等只执行一次）
    //数据库的字段类型转化存储Java代码一致的类型
    static{
        mySqlTypeMap.put("tinyint", "Integer");
        mySqlTypeMap.put("smallint", "Integer");
        mySqlTypeMap.put("mediumint", "Integer");
        mySqlTypeMap.put("int", "Integer");
        mySqlTypeMap.put("integer", "Integer");
        mySqlTypeMap.put("bigint", "Long");
        mySqlTypeMap.put("float", "Float");
        mySqlTypeMap.put("double", "Double");
        mySqlTypeMap.put("decimal", "Long");
        mySqlTypeMap.put("bit", "Boolean");
        mySqlTypeMap.put("char", "String");
        mySqlTypeMap.put("varchar", "String");
        mySqlTypeMap.put("tinytext", "String");
        mySqlTypeMap.put("text", "String");
        mySqlTypeMap.put("mediumtext", "String");
        mySqlTypeMap.put("longtext", "String");
        mySqlTypeMap.put("date", "Date");
        mySqlTypeMap.put("datetime", "Date");
        mySqlTypeMap.put("timestamp", "Date");

        oracleTypeMap.put("CHAR","String");
        oracleTypeMap.put("VARCHAR2","String");
        oracleTypeMap.put("LONG","String");
        oracleTypeMap.put("NUMBER1","BigDecimal");
        oracleTypeMap.put("NUMBER2","boolean");
        oracleTypeMap.put("NUMBER3","byte");
        oracleTypeMap.put("NUMBER4","short");
        oracleTypeMap.put("NUMBER5","int");
        oracleTypeMap.put("NUMBER6","long");
        oracleTypeMap.put("NUMBER7","float");
        oracleTypeMap.put("NUMBER8","double");
        oracleTypeMap.put("DATE","Date");
        oracleTypeMap.put("BLOB","Blob");
        oracleTypeMap.put("CLOB","Clob");
    }

    /**
     * 插入字段名
     * @param columnName
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    /**
     * 数据库字段类型,dateType是数据库的字段类型，i是数据库类型0：Oracle，1：mysql
     * @param dataType
     * @param i
     */
    public void setDataType(String dataType,int i) {
        this.dataType = dataType;
        if(i==0){
            this.attrType=oracleTypeMap.get(dataType);
        }else if (i==1){
            this.attrType=mySqlTypeMap.get(dataType);
        }else {
            this.attrType= "String";
        }
    }



    /**
     * 获取字段名
     * @return
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * 获取字段数据库类型
     * @return
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * 获取字段名称
     * @return
     */
    public String getAttrName() {
        return attrName;
    }

    /**
     * 获取字段类型
     * @return
     */
    public String getAttrType() {
        return attrType;
    }
}
