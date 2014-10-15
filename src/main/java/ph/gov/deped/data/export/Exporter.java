package ph.gov.deped.data.export;

import java.io.Serializable;
import java.util.List;

/**
 * Created by PSY on 2014/10/15.
 */
public interface Exporter {

    void export(String filename, List<List<Serializable>> data);
}
