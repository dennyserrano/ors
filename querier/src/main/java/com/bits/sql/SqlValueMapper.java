package com.bits.sql;

import java.io.Serializable;
import java.util.function.Function;

/**
 * Created by PSY on 2014/10/04.
 */
@FunctionalInterface
public interface SqlValueMapper<O extends Serializable> extends Function<Serializable, O> {

}
