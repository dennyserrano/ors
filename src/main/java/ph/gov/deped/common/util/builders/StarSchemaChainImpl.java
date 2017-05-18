package ph.gov.deped.common.util.builders;

import java.util.ArrayList;
import java.util.List;

import ph.gov.deped.common.util.builders.JoinPropertyBuilder.JoinPropertyManualBuilder;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;

//This defines the formation of star schema.
//the given heads are the children that to be joined into the parent table
//the parent table (i.e school_profile_history) is fixed currently.

public class StarSchemaChainImpl implements TableChainer {

	private PrefixTableBuilder tableBuilder;
	private static final List<DatasetElement> parentElements;
	
	static{
		parentElements=new ArrayList<DatasetElement>();
		DatasetElement de1=new DatasetElement();
		de1.setName("school_id");
		DatasetElement de2=new DatasetElement();
		de2.setName("sy_from");
		parentElements.add(de1);
		parentElements.add(de2);
		
	}
	
	@Override
	public PrefixTable chain(List<DatasetHead> heads) {
		PrefixTable parentTable=tableBuilder.build(new DatasetHead());  //parent
		
		JoinPropertyManualBuilder jpmBuilder=new JoinPropertyBuilder().getManualBuilder();
		
//		for(DatasetElement de:parentElements)
//		{
//			jpmBuilder.add(leftPrefix, leftElementName, rightPrefix, rightElementName)
//		}
//		
//		for(DatasetHead dh:heads)
//		{
//			PrefixTable childTable=tableBuilder.build(dh);
//			
//		}
		
		
		return null;
	}

}
