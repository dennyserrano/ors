package com.generate.core;
import static java.lang.String.format;
import static java.util.stream.Collectors.toCollection;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bits.sql.JdbcTypes;
import com.generate.enums.ConfigurationConstants;
import com.util.builders.impl.ColumnElement;
import com.util.builders.impl.ColumnExpression;


@Service
public class SqlToData {
	
	@Autowired
	@Qualifier(ConfigurationConstants.DATA_SOURCE_NAME)
	private DataSource dataSource;
	
	public List<List<ColumnElement>> get(String sql,List<ColumnExpression> columns)
	{
		JdbcTemplate template = new JdbcTemplate(dataSource);
		List<List<ColumnElement>> data = template.query(sql, (rs, rowNum) -> {
          List<ColumnElement> row = new LinkedList<>();
          
          columns.forEach(ce -> {
//              try {
//                  ColumnElement columnElementWithValue = ce.clone(); 
                  //TODO getColumnName has a problem if the field has alias..
                  Serializable value=null;
                	try {
						value= JdbcTypes.getValue(rs, ce.alias(), ce.dataType());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
                	ColumnElement ce1=new ColumnElement();
                	ce1.setValue(value);
                   ce1.setDataType(ce.dataType());
                  
                  row.add(ce1);
          });
          return row;
      });
		
		ArrayList<ColumnElement> headers=new ArrayList<ColumnElement>();
		
		for(ColumnExpression col:columns)
			{
				ColumnElement ce=new ColumnElement();
				ce.setValue(col.alias());
				ce.setDataType(col.dataType());
				headers.add(ce);
			}
		data.add(0, headers);
		
		return data;
	}
	
	public long getDataSize(String sql)
	{
		JdbcTemplate template = new JdbcTemplate(dataSource);
		Object o= template.query(sql, (rs, rowNum)->{return rs.getLong("COUNT(*)");}).get(0);
		return (long) o;
	}
	
}
