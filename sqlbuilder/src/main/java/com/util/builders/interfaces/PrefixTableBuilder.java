package com.util.builders.interfaces;

import java.util.List;

import com.model.support.Dataset;
import com.model.support.Element;
import com.model.support.Filter;
import com.util.builders.impl.PrefixTable;



public interface PrefixTableBuilder extends TableBuilder<Dataset, Element, List<Filter>, Element, Element,PrefixTable>
{

}
