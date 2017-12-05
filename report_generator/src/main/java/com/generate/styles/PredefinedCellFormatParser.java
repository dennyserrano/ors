package com.generate.styles;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * @author ej
 * @since Oct 23, 2014 10:46
 */
public class PredefinedCellFormatParser implements CellFormatParser {

    private static final Logger log = LogManager.getLogger(PredefinedCellFormatParser.class);
    
    private static final String VALUE = "Value";
    
    public ElementFormatter parse(String format) {
        String methodName = format + VALUE;
        Optional<Method> optional = methods.parallelStream().filter(m -> m.getName().equals(methodName)).findFirst();
        if (!optional.isPresent()) {
            throw new RuntimeException(String.format("Invalid pre-defined formatting specified [%s]", format));
        }
        Method method = optional.get();
        try {
            return (ElementFormatter) method.invoke(null);
        }
        catch (IllegalAccessException|InvocationTargetException ex) {
            log.error("Unable to retrieve/call pre-defined formatting [{}]", format);
            throw log.throwing(new RuntimeException(ex));
        }
    }
}
