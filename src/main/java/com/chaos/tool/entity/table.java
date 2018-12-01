package com.chaos.tool.entity;

import java.util.List;

public class table {

    private String tableName;
    private List<column> columns;
    private String className;
    private String comments;

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setColumns(List<column> columns) {
        this.columns = columns;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getTableName() {
        return tableName;
    }

    public List<column> getColumns() {
        return columns;
    }

    public String getClassName() {
        return className;
    }

    public String getComments() {
        return comments;
    }
}
