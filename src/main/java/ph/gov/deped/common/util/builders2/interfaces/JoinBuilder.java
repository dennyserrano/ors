package ph.gov.deped.common.util.builders2.interfaces;

import java.util.List;

import ph.gov.deped.common.util.builders.JoinProperty;
import ph.gov.deped.common.util.builders.JoinPropertyBuilder;
import ph.gov.deped.data.dto.GenericKeyValue;
import ph.gov.deped.data.dto.PrefixTable;

public interface JoinBuilder extends Builder<List<GenericKeyValue<PrefixTable, JoinProperty>>> {

}
