package ph.gov.deped.service.data.api;

import ph.gov.deped.common.util.builders.impl.ColumnElement;

import java.util.List;

/**
 * Created by PSY on 2014/10/15.
 */

@Deprecated //use ExportService instead
public interface ExportServiceOld {

    String export(String sessionId, List<List<ColumnElement>> data, ExportType exportType);
}
