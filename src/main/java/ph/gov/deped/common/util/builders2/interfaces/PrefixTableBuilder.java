package ph.gov.deped.common.util.builders2.interfaces;

import ph.gov.deped.data.dto.PrefixTable;

public interface PrefixTableBuilder<P,E,F,G,O> extends Builder<PrefixTable>
{
	void addColumn(E element);
	void addJoin(P dataset);
	void addWhere (F filter);
	void addGroupBy(G group);
	void addOrderBy(O order);
	void setAlias(String alias);
}
