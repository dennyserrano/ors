package ph.gov.deped.repo.jpa.ors;

import ph.gov.deped.service.export.xlsx.ElementFormatter;
import ph.gov.deped.service.export.xlsx.Formats;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Set;

import static org.reflections.ReflectionUtils.getAllMethods;
import static org.reflections.ReflectionUtils.withModifier;

/**
 * @author ej
 * @since Oct 23, 2014 10:36
 */
@SuppressWarnings({"unchecked"})
public interface CellFormatParser {
    
    public static final String PIPE = "|";
    
    public static final String SEMICOLON = ";";

    Set<Method> methods = getAllMethods(Formats.class,
            withModifier(Modifier.PUBLIC),
            withModifier(Modifier.STATIC));
    
    ElementFormatter parse(String format);
}
