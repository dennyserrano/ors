package com.util.builders.interfaces;

import java.util.List;

public interface FilterComparator{
	FilterConjunctor eq(Object obj);
	FilterConjunctor ne(Object obj);
	FilterConjunctor ge(Object obj);
	FilterConjunctor le(Object obj);
	FilterConjunctor in(List list);
}
