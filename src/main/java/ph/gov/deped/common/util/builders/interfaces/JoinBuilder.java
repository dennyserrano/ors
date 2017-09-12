package ph.gov.deped.common.util.builders.interfaces;

import java.util.List;

import ph.gov.deped.common.util.builders.impl.JoinProperty;
import ph.gov.deped.common.util.builders.impl.JoinPropertyBuilder;
import ph.gov.deped.common.util.builders.impl.PrefixTable;
import ph.gov.deped.data.dto.GenericKeyValue;

public interface JoinBuilder extends Builder<List<GenericKeyValue<PrefixTable, JoinProperty>>> {

}
