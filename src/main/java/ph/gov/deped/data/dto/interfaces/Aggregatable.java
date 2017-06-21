package ph.gov.deped.data.dto.interfaces;

import com.bits.sql.AggregateTypes;

public interface Aggregatable 
{
	public boolean hasAggregate();
	public AggregateTypes getAggregate();
	public void setAggregate(AggregateTypes aggregate);
}
