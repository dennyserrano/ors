package ph.gov.deped.common.util.builders.impl;

import java.util.List;

public class TableWrapper
{
	
	private PrefixTable head;
	private PrefixTable tail;
	public TableWrapper(PrefixTable head)
	{
		this.head=head;
		this.tail=findTail();
	}
	
	public PrefixTable getHead()
	{
		return head;
	}
	
	public void chain(PrefixTable pt,JoinProperty jp)
	{
		tail.addJoin(pt, jp);
		tail=pt;
	}
	
	public PrefixTable getTail()
	{
		return tail;
	}
	
	public void append(PrefixTable pt,JoinProperty jp)
	{
		tail.addJoin(pt, jp);
	}
	
	public PrefixTable findTail()
	{
		tail= find(head);
		return tail;
	}
	
	private PrefixTable find(PrefixTable pt) //finds the first encounters of all successor PrefixTables
	{
		if(pt.getJoinTables().size()!=0)
		{
			PrefixTable firstOne = null;
			for(PrefixTable nextPt:pt.getJoinTables().keySet())
				firstOne=nextPt;
			
			return find(firstOne);
		}else
			return pt;
	}
	
}
