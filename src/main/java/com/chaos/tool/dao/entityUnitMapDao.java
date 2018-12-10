package com.chaos.tool.dao;

import java.util.List;
import java.util.Map;

public interface entityUnitMapDao {

  String createEntity(String table) ;

  List<Map<String,String>> queryColumn(String table);

}
