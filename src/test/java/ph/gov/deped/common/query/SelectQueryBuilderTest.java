package ph.gov.deped.common.query;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ph.gov.deped.common.query.Projections.column;
import static ph.gov.deped.common.query.QueryBuilders.read;

public class SelectQueryBuilderTest {

    public @Test void testSimpleSql() {
        StringBuilder sql = read()
                .selectAsterisk()
                .from("ref_code")
                .build();
        String expected = "SELECT * FROM ref_code";
        System.out.println("SQL Generated: " + sql);
        assertEquals(expected, sql.toString());
    }

    public @Test void testMidBuilder() {
        StringBuilder sql = read()
                .selectAsterisk()
                .from("ref_code", "rc")
                    .leftJoin("ref_code_setting", "rcs")
                    .on("rc", "id").eq("rcs", "rcs_id")
                .where("rcs", "id").eq(1)
                    .and("rcs", "created_by").eq(0)
                .orderBy("rcs", "updated_at", false)
                .build();
        String expected = "SELECT * FROM ref_code AS rc LEFT JOIN ref_code_setting AS rcs ON rc.id = rcs.rcs_id "
                + "WHERE rcs.id = 1 AND rcs.created_by = 0 ORDER BY rcs.updated_at DESC";
        System.out.println("SQL Generated: " + sql);
        assertEquals(expected, sql.toString());
    }

    public @Test void testWithAliases() {
        final String expected = "SELECT rc.code AS kode FROM ref_code AS rc";
        StringBuilder sql=  read()
                .select(column("rc", "code", "kode"))
                .from("ref_code", "rc")
                .build();
        System.out.println("SQL Generated: " + sql);
        assertEquals(expected, sql.toString());
    }
}