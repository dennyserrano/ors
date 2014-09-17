package ph.gov.deped.common;

/**
 * Created by ej on 8/5/14.
 */
public interface EbeisMetadata extends Constants {

    public static final String EBEIS = "EBEIS";

    public static final String ebeis = "ebeis";

    public static final String DS = ebeis + DS_SUFFIX;

    public static final String EMF = ebeis + EMF_SUFFIX;

    public static final String PU = EBEIS + PU_SUFFIX;

    public static final String EBEIS_PROPS = ebeis + PROPS_SUFFIX;

    public static final String TXM = ebeis + TXM_SUFFIX;

    public static final String DS_URL_KEY = ebeis + DB_URL_SUFFIX;

    public static final String DS_USER_KEY = ebeis + DB_USER_SUFFIX;

    public static final String DS_PASS_KEY = ebeis + DB_PASS_SUFFIX;

    public static final String DATA_PACKAGE = DATA_PACKAGE_PREFIX + ebeis;

    public static final String REPO_PACKAGE = JPA_REPO_PACKAGE_PREFIX + ebeis;
}
