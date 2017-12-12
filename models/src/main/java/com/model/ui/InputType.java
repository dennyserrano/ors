package com.model.ui;

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
     * The filter can only select a single value or option from the list.
     * Will render a HTML select element with single selected value.
     */
    SELECT_VALUE,

    /**
     * Enum constant for multiple selected values
     * Will render a HTML input type of checkbox for each selection.
     */
    CHECK,

    /**
     * Enum constant for single selected value from a set of values.
     * Will render a HTML input type of radio for each selection
     */
    RADIO,

    /**
     * Enum constant for filters that has a fixed set of selection.
     * The filter can select multiple values.
     * Will render HTML select element with multiple selection of option.
     */
    SELECT_VALUES
}
