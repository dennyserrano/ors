package ph.gov.deped.common;

/**
 * Created by ej on 8/15/14.
 */
public interface AppMetadata extends Constants {

    public static final String ORS = "ORS";

    public static final String ors = "ors";

    public static final String PU = ORS + PU_SUFFIX;

    public static final String DS = ors + DS_SUFFIX;

    public static final String DS_URL_KEY = ors + DB_URL_SUFFIX;

    public static final String DS_USER_KEY = ors + DB_USER_SUFFIX;

    public static final String DS_PASS_KEY = ors + DB_PASS_SUFFIX;

    public static final String PROPS = ors + PROPS_SUFFIX;

    public static final String ORS_EMF_PACKAGES_KEY = "ors.emf.packagesToScan";

    public static final String ORS_REPO_PACKAGES_KEY = "ors.repo.packagesToScan";

    public static final String DATA_PACKAGE = DATA_PACKAGE_PREFIX + ors;

    public static final String REPO_PACKAGE = JPA_REPO_PACKAGE_PREFIX + ors;

    public static final String TXM = "transactionManager";
}
