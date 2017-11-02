package com.util.builders.interfaces;

import java.util.List;

import ph.gov.deped.common.util.builders.impl.PrefixTable;
import ph.gov.deped.common.util.builders.impl.Where;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.dto.ds.Filter;


public interface PrefixTableBuilder extends TableBuilder<Dataset, Element, List<Filter>, Element, Element,PrefixTable>
{

}
