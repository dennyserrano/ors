package ph.gov.deped.common.query;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static com.bits.sql.Projections.column;
import static com.bits.sql.QueryBuilders.read;

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
                    .leftJoin("ref_municipality", "mun")
                        .on("mun", "id").eq("rsc", "municipality")
                        .and("rc", "id").eq("rsc", "another_id")
                .where("rcs", "id").eq(1)
                    .and("rcs", "created_by").eq(0)
                .orderBy("rcs", "updated_at", false)
                .build();
        String expected = "SELECT * FROM ref_code AS rc LEFT JOIN ref_code_setting AS rcs ON rc.id = rcs.rcs_id "
                + "LEFT JOIN ref_municipality AS mun ON mun.id = rsc.municipality AND rc.id = rsc.another_id "
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