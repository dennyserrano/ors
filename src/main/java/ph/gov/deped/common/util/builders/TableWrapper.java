package ph.gov.deped.common.util.builders;

import ph.gov.deped.data.dto.PrefixTable;

public class TableWrapper
{
	
	private PrefixTable head;
	private PrefixTable tail;
	public TableWrapper(PrefixTable head)
	{
		this.head=head;
	}
	
	public PrefixTable getHead()
	{
		return head;
	}
	
	public void chain(PrefixTable pt,JoinProperty jp)
	{
		head.addJoin(pt, jp);
		tail=pt;
	}
	
	public PrefixTable getTail()
	{
		return tail;
	}
	
	public void append(PrefixTable pt,JoinProperty jp)
	{
		head.addJoin(pt, jp);
	}
}
