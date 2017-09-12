package ph.gov.deped.service.data.api;

import ph.gov.deped.common.util.builders.impl.ColumnElement;
import ph.gov.deped.data.dto.ds.Dataset;

import java.util.List;

/**
 * Created by PSY on 2014/10/15.
 */
public interface ExportService {

    String export(Dataset dataset);
}
