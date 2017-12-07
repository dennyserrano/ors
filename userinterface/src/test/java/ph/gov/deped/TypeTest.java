package ph.gov.deped;

/**
 * @author ej
 * @since Oct 22, 2014 15:59
 */
public class TypeTest {

    public static void main(String[] args) {
        Double value = 0.1;
        System.out.println(value.getClass().isAssignableFrom(Number.class));
        System.out.println(value.getClass().isAssignableFrom(Double.class));
        System.out.println(Number.class.isAssignableFrom(value.getClass()));
        System.out.println(double.class.isAssignableFrom(value.getClass()));

        value = new Double(3.1416);
        System.out.println(value.getClass().isAssignableFrom(Number.class));
        System.out.println(value.getClass().isAssignableFrom(Double.class));
        System.out.println(Number.class.isAssignableFrom(value.getClass()));
        System.out.println(double.class.isAssignableFrom(value.getClass()));
    }
}
