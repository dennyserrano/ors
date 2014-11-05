package ph.gov.deped.service.data.api;

import ph.gov.deped.data.dto.ColumnElement;

import java.util.List;

/**
 * Created by PSY on 2014/10/15.
 */
public interface ExportService {

    String export(String sessionId, List<List<ColumnElement>> data, ExportType exportType);
}
