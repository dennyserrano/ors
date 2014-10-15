package ph.gov.deped.service.data.api;

/**
 * Created by PSY on 2014/10/15.
 */
public enum ExportType {
    XLSX("xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),
    XLS("xls", "application/vnd.ms-excel"),
    CSV("csv", "text/csv"),

    ;

    String extension;

    String contentType;

    ExportType(String _extension, String _contentType) {
        this.extension = _extension;
        this.contentType = _contentType;
    }

    public String getExtension() {
        return extension;
    }

    public String getContentType() {
        return contentType;
    }
}
