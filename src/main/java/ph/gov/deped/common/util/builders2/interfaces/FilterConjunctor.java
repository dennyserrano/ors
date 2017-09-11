package ph.gov.deped.common.util.builders2.interfaces;

import java.util.List;

public interface FilterConjunctor extends WhereBuilder {
	FilterComparator and(String prefix,String fieldName);
	FilterComparator or(String prefix,String fieldName);
	
}
