package ph.gov.deped.common;

/**
 * Created with IntelliJ IDEA.
 * User: elbertlayco
 * Date: 2013/16/10
 * Time: 16:39
 * To change this template use File | Settings | File Templates.
 */
public interface Constants {

    public static final String XML_REDIRECT_ROOT_ELEMENT = "redirect";

    public static final String XML_REDIRECT_DATA_ELEMENT = "data";

    public static final byte[] ALPHANUM_CHARS = {
            '\u0041', '\u0042', '\u0043', '\u0044', '\u0045', '\u0046', '\u0047', '\u0048', '\u0049', '\u004A',
            '\u004B', '\u004C', '\u004D', '\u004E', '\u004F', '\u0050', '\u0051', '\u0052', '\u0053', '\u0054',
            '\u0055', '\u0056', '\u0057', '\u0058', '\u0059', '\u005A', '\u0030', '\u0031', '\u0032', '\u0033',
            '\u0034', '\u0035', '\u0036', '\u0037', '\u0038', '\u0039'
    };

    public static final String DS_SUFFIX = "DataSource";

    public static final String EMF_SUFFIX = "EntityManagerFactory";

    public static final String TXM_SUFFIX = "TransactionManager";

    public static final String PU_SUFFIX = "_PU";

    public static final String PROPS_SUFFIX = ".properties";

    public static final String TRUE = Boolean.TRUE.toString();

    public static final String FALSE = Boolean.FALSE.toString();

    public static final String MYSQL_PREFIX = "mysql.";

    public static final String DB_URL_SUFFIX = ".db.url";

    public static final String DB_USER_SUFFIX = ".db.user";

    public static final String DB_PASS_SUFFIX = ".db.pass";

    public static final String MAIN_PACKAGE_PREFIX = "ph.gov.deped.";

    public static final String DATA_PACKAGE_PREFIX = MAIN_PACKAGE_PREFIX + "data.";

    public static final String REPO_PACKAGE_PREFIX = MAIN_PACKAGE_PREFIX + "repo.";

    public static final String JPA_REPO_PACKAGE_PREFIX = REPO_PACKAGE_PREFIX + "jpa.";

    public static final String SERVICE_PACKAGE_PREFIX = MAIN_PACKAGE_PREFIX + "service.";
}
