package com.util.builders.interfaces;

import java.util.List;

import com.model.support.GenericKeyValue;
import com.util.builders.impl.JoinProperty;
import com.util.builders.impl.PrefixTable;

public interface JoinBuilder extends Builder<List<GenericKeyValue<PrefixTable, JoinProperty>>> {

}
