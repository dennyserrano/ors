package ph.gov.deped.service.export.xlsx;

import ph.gov.deped.common.util.builders.impl.ColumnElement;

/**
 * Created by ej on 10/17/14.
 */
@FunctionalInterface
public interface ElementFormatter {
    
    FormattedElement format(ColumnElement columnElement);
}
