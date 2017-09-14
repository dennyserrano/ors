package ph.gov.deped.service.data.impl;
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

import ph.gov.deped.common.AppMetadata;
import ph.gov.deped.common.util.builders.impl.ColumnElement;
import ph.gov.deped.common.util.builders.impl.ColumnExpression;

@Service
public class SqlToData {
	
	@Autowired @Qualifier(AppMetadata.DS)
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
						value= JdbcTypes.getValue(rs, ce.alias(), ce.alias().getClass().getSimpleName().toLowerCase());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
                	ColumnElement ce1=new ColumnElement();
                	ce1.setValue(value);
                   
                  
                  row.add(ce1);
          });
          return row;
      });
		
		ArrayList<ColumnElement> headers=new ArrayList<ColumnElement>();
		
		for(ColumnExpression col:columns)
			{
				ColumnElement ce=new ColumnElement();
				ce.setValue(col.alias());
				headers.add(ce);
			}
		data.add(0, headers);
		
		return data;
	}
}
