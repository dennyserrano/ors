package ph.gov.deped.data.dto.ds;

/**
 * @author ej
 * @since Nov 07, 2014 14:25
 */
public enum InputType {

    /**
     * Enum constant for a simple text box input.
     * Will render a HTML input with type of text.
     */
    TEXT,
    
    /**
     * Appropriate enum constant of filters that has a fixed set of selection.
     * Will render a HTML select element.
     */
    SELECT,

    /**
     * Enum constant for multiple selected values
     * Will render a HTML input type of checkbox for each selection.
     */
    CHECK,

    /**
     * Enum constant for single selected value from a set of values.
     * Will render a HTML input type of radio for each selection
     */
    RADIO
}
