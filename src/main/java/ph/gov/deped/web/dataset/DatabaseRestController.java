package ph.gov.deped.web.dataset;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ph.gov.deped.common.dw.DbType;
import ph.gov.deped.data.dto.ds.Database;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * Created by PSY on 2014/09/25.
 */
@RestController
@RequestMapping("/database")
public class DatabaseRestController {

    @RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Database> list() {
        return asList(DbType.values()).stream()
                .map(dt -> new Database(dt.ordinal(), dt.getDbName().toUpperCase()))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public Database get(int id) {
        DbType dt = DbType.values()[id];
        return new Database(id, dt.getDbName().toUpperCase());
    }
}
