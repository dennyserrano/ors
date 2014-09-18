package ph.gov.deped.common.query;

import ph.gov.deped.data.ors.ds.DatasetElement;

import java.util.function.Supplier;

/**
* Created by ej on 9/2/14.
*/
public interface ProjectionBuilder {

    FromClauseBuilder selectAsterisk();

    FromClauseBuilder selectAsterisk(String tablePrefix);

    FromClauseBuilder select(DatasetElement... elements);

    FromClauseBuilder select(Projection... projections);

    FromClauseBuilder select(@SuppressWarnings("unchecked") Supplier<? extends Projection>... projections);
}
