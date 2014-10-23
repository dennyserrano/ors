package ph.gov.deped.repo.jpa.ors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import ph.gov.deped.service.export.xlsx.ElementFormatter;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static ph.gov.deped.service.export.xlsx.Formats.stringValue;

/**
 * @author ej
 * @since Oct 23, 2014 10:17
 */
@Repository class FormattingRepositoryImpl implements FormattingRepository, InitializingBean {

    private static final Logger log = LogManager.getLogger(FormattingRepositoryImpl.class);
    
    private static final String COLON = ":";
    
    private Properties properties;
    
    private Map<String, String> formats = new HashMap<>();
    
    private Map<Predicate<String>, Supplier<CellFormatParser>> parsers = new HashMap<>();
    
    @Value("classpath:formattings.properties")
    public void setFormattingSource(Resource resource) {
        properties = new Properties();
        try (InputStream is = resource.getInputStream()) {
            properties.load(is);
        }
        catch (IOException ex) {
            log.error("Unable to load formatting resource file [{}].", resource.getFilename());
            throw log.throwing(new RuntimeException(ex));
        }
    }

    public void afterPropertiesSet() throws Exception {
        Set<String> keys = properties.stringPropertyNames();
        keys.parallelStream().forEach(key -> formats.put(key, properties.getProperty(key)));

        parsers.put(format -> !(format.contains(CellFormatParser.PIPE) &&
                        format.contains(CellFormatParser.SEMICOLON)),
                PredefinedCellFormatParser::new);
        parsers.put(format -> format.contains(CellFormatParser.PIPE) ||
                        format.contains(CellFormatParser.SEMICOLON),
                DefaultCellFormatParser::new);
    }

    public ElementFormatter findByKey(String key) {
        String format = formats.get(key);
        if (isBlank(format)) {
            return null;
        }
        Optional<Map.Entry<Predicate<String>, Supplier<CellFormatParser>>> optional = parsers.entrySet().stream()
                .filter(e -> e.getKey().test(format))
                .findFirst();
        if (!optional.isPresent()) {
            return stringValue();
        }
        return optional.get().getValue().get().parse(format);
    }

    public ElementFormatter findByDatasetElement(long headId, String elementName) {
        return findByKey(headId + COLON + elementName);
    }
}
