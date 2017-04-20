package ph.gov.deped.common.util;

import java.util.ArrayList;
import java.util.List;

import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.JoinInfo;
import ph.gov.deped.data.dto.PrefixTable;

import com.bits.sql.CriteriaChainBuilder;
import com.bits.sql.CriteriaFilterBuilder;
import com.bits.sql.FromClauseBuilder;
import com.bits.sql.JoinOrWhereClauseBuilder;
import com.bits.sql.Projection;
import com.bits.sql.ProjectionBuilder;

import static com.bits.sql.QueryBuilders.read;

public class ServiceQueryBuilder
{
	private FromClauseBuilder fromClauseBuilder;
	private JoinOrWhereClauseBuilder joinWhereBuilder;
	
	public ServiceQueryBuilder()
	{
		
	}
	
	public String buildQuery(PrefixTable pt)
	{
		
		return null;
	}
	
	public void doBuild(PrefixTable leftTable, PrefixTable rightTable)
	{
		
		rightTable.setJoinColumns(new ArrayList<JoinInfo<ColumnElement,ColumnElement>>());
		
		
		if(rightTable.getJoinTable()==null)
			return;
		
		
		
	}
	
	
}
