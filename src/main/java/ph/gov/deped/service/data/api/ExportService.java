package ph.gov.deped.service.data.api;

import java.io.Serializable;
import java.util.List;

/**
 * Created by PSY on 2014/10/15.
 */
public interface ExportService {

    String export(List<List<Serializable>> data, ExportType exportType);
}
