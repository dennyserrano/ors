package com.generate.styles;

import com.util.builders.impl.ColumnElement;


/**
 * Created by ej on 10/17/14.
 */
@FunctionalInterface
public interface ElementFormatter {
    
    FormattedElement format(ColumnElement columnElement);
}
