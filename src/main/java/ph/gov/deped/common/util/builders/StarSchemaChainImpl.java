package ph.gov.deped.common.util.builders;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.bits.sql.JoinType;

import ph.gov.deped.common.util.ConvertUtil;
import ph.gov.deped.common.util.builders.JoinPropertyBuilder.JoinPropertyManualBuilder;
import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.dto.interfaces.TableColumn;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;

//This defines the formation of star schema.
//the given heads are the children that to be joined into the parent table
//the parent table (i.e school_profile_history) is fixed currently.

public class StarSchemaChainImpl implements TableChainer {

	private PrefixTableBuilder tableBuilder;
	private static final String[] MANDATORY_FIELDS=new String[]{"sy_from"};
	private static final String[] JOINING_ELEMENTS=new String[]{"sy_from"};
	public StarSchemaChainImpl()
	{
		tableBuilder=new PrefixTableBuilder();
	}
	
	public PrefixTable chain(DatasetHead parent, List<DatasetHead> children)
	{
		
		HashSet<DatasetElement> mandatoryFieldList=new HashSet<>();
		HashSet<DatasetElement> joinElementList=new HashSet<>();
		
		for(DatasetElement de:parent.getDatasetElements())
			{
				for(String mandatoryName:MANDATORY_FIELDS)
					if(de.getName().equals(mandatoryName))
						mandatoryFieldList.add(de);
				
				for(String joinElement:JOINING_ELEMENTS)
					if(de.getName().equals(joinElement))
						joinElementList.add(de);
			}
		
		parent.setDatasetElements(mandatoryFieldList);
		
		PrefixTable parentPT=ConvertUtil.toPrefixTable(parent);
		parentPT.setTablePrefix("sph");
		
		for(DatasetHead child:children)
		{
			JoinPropertyManualBuilder jpBuilder=new JoinPropertyBuilder().getManualBuilder();
			PrefixTable childPrefixTable= tableBuilder.build(child);
			for(DatasetElement joinElement:joinElementList)
			{
				jpBuilder.add(parentPT.getTablePrefix(), joinElement.getName(), childPrefixTable.getTablePrefix(), joinElement.getName());
				jpBuilder.set(JoinType.LEFT_JOIN);
			}
			
			parentPT.addJoin(childPrefixTable, jpBuilder.build());
		}
		
		for(TableColumn tc:parentPT.getColumns())
		{
			ColumnElement ce=(ColumnElement) tc;
			if(ce.getTablePrefix()==null)
				ce.setTablePrefix(parentPT.getTablePrefix());
		}
		
		return parentPT;
	}

}
