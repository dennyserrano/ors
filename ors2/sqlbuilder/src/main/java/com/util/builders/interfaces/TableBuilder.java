package com.util.builders.interfaces;

public interface TableBuilder<P,E,F,G,O,T> extends Builder<T>
{
	void addColumn(E element);
	void addSpecialColumn(E element);
	void addJoin(P dataset);
	void where (F filter);
	void addGroupBy(G group);
	void addOrderBy(O order);
	void setAlias(String alias);
}
