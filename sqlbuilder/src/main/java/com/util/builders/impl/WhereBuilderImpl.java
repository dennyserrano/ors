package com.util.builders.impl;

import java.util.ArrayList;
import java.util.List;

import com.util.builders.interfaces.FilterComparator;
import com.util.builders.interfaces.FilterConjunctor;
import com.util.builders.interfaces.FilterWhere;


public class WhereBuilderImpl implements FilterConjunctor,FilterComparator,FilterWhere{

	private Where where;
	private Operational opt;
	private Conjunctive conj;
	public WhereBuilderImpl()
	{
		where=new Where();
	}
	
	@Override
	public Where build() {
		
		return where;
	}


	@Override
	public FilterConjunctor eq(Object obj) {
		conj=opt.eq(obj.toString());
		return this;
	}

	@Override
	public FilterConjunctor ne(Object obj) {
		conj=opt.notEq(obj.toString());
		return this;
	}

	@Override
	public FilterConjunctor ge(Object obj) {
		
		return null;
	}

	@Override
	public FilterConjunctor le(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FilterComparator and(String prefix,String fieldName) {
		opt=conj.and(prefix, fieldName);
		return this;
	}

	@Override
	public FilterComparator or(String prefix,String fieldName) {
		opt=conj.or(fieldName);
		return this;
	}


	@Override
	public FilterComparator where(String prefix,String fieldName) {
		opt=where.where(fieldName, prefix);
		return this;
	}

	@Override
	public FilterConjunctor in(List list) {
		conj=opt.in(list);
		
		return this;
	}

	
}
