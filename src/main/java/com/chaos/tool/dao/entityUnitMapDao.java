package com.chaos.tool.dao;

import com.chaos.tool.entity.tableColumn;

import java.util.List;
import java.util.Map;

public interface entityUnitMapDao {

  String createEntity(String table) ;

  List<Map<String,String>> queryColumn(String table);

}
