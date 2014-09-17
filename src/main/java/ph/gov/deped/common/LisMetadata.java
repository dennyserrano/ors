package ph.gov.deped.common;

/**
 * Created by ej on 8/5/14.
 */
public interface LisMetadata extends Constants {

    public static final String LIS = "LIS";

    public static final String lis = "lis";

    public static final String DS = lis + DS_SUFFIX;

    public static final String EMF = lis + EMF_SUFFIX;

    public static final String PU = LIS + PU_SUFFIX;

    public static final String LIS_PROPS = lis + PROPS_SUFFIX;

    public static final String TXM = lis + TXM_SUFFIX;

    public static final String DS_URL_KEY = lis + DB_URL_SUFFIX;

    public static final String DS_USER_KEY = lis + DB_USER_SUFFIX;

    public static final String DS_PASS_KEY = lis + DB_PASS_SUFFIX;

    public static final String DATA_PACKAGE = DATA_PACKAGE_PREFIX + lis;

    public static final String REPO_PACKAGE = JPA_REPO_PACKAGE_PREFIX + lis;
}
