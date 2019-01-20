package com.bits.sql;

import java.util.function.Supplier;

/**
* Created by ej on 9/2/14.
*/
@SuppressWarnings({"unchecked"})
public interface ProjectionBuilder {

    FromClauseBuilder selectAsterisk();

    FromClauseBuilder selectAsterisk(String tablePrefix);

    FromClauseBuilder select(Projection... projections);

    FromClauseBuilder select(Supplier<? extends Projection>... projections);
}
