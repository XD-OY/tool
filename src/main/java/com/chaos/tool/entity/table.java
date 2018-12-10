package com.chaos.tool.entity;

import java.util.List;

public class table {

    private String tableName;
    private List<column> columns;
    private String className;
    private String comments;

    /**
     * 表名
     * @param tableName
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * 列信息
     * @param columns
     */
    public void setColumns(List<column> columns) {
        this.columns = columns;
    }

    /**
     * 类名
     * @param className
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 表备注
     * @param comments
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * 获取表名
     * @return
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 获取列
     * @return
     */
    public List<column> getColumns() {
        return columns;
    }

    /**
     * 获取类名
     * @return
     */
    public String getClassName() {
        return className;
    }

    /**
     * 获取列备注
     * @return
     */
    public String getComments() {
        return comments;
    }
}
