package ph.gov.deped.service.data.api;

import ph.gov.deped.data.dto.ds.Dataset;

public interface ExportBulkService 
{
	public String export(Dataset dataset,ExportType exportType);
}
