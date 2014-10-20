package ph.gov.deped.data.export.xlsx;

import ph.gov.deped.data.dto.ColumnElement;

/**
 * Created by ej on 10/17/14.
 */
@FunctionalInterface
public interface ElementFormatter {
    
    FormattedElement format(ColumnElement columnElement);
}
