package ph.gov.deped.service.data.api;

import java.util.List;

import com.model.support.Dataset;
import com.util.builders.impl.ColumnElement;


public interface DataService {
	public List<List<ColumnElement>> getPreviewData(Dataset ds);
}
