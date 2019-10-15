import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Properties;
import java.util.Set;

public class PropertiesUtils {
    private static final Path BASE_DIR = Paths.get("./");
    private static Properties properties;

    static {
        try {
            properties = readAllProperty();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(String key) {
        return properties.getProperty(key);
    }
//   read all  properties of the project into one object of properties
    private static Properties readAllProperty() throws IOException {
        Properties properties = new Properties();
        Files.walkFileTree(BASE_DIR, new SimpleFileVisitor <Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                if (Files.isRegularFile(file) && file.toString().endsWith(".properties")) {
                    properties.putAll(loadProperties(file));
                }
                return FileVisitResult.CONTINUE;
            }
        });
        return properties;
    }

    public static Properties loadProperties(Path path) {
        Properties result = new Properties();
        try (FileInputStream fis = new FileInputStream(path.toFile())) {
            result.load(fis);
        } catch (IOException e) {
            throw new IllegalStateException("Couldn't load properties from resource with path:"
                    + path.toString(), e);
        }
        return result;
    }
//  Set DesiredCapabilities with Spring from ConfigurableEnvironment without prefix from properties
//    public DesiredCapabilities setUpRemoteDriver(ConfigurableEnvironment env, String prefix) {
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        Properties desiredCapabilitiesProperties = getProperties(env, prefix);
//        Set <String> keys = desiredCapabilitiesProperties.stringPropertyNames();
//        for (String key : keys) {
//            String value = desiredCapabilitiesProperties.getProperty(key);
//            desiredCapabilities.setCapability(key.replace(prefix, ""), value);
//        }
//        return desiredCapabilities;
//    }
//
//    private Properties getProperties(ConfigurableEnvironment env, String prefix) {
//        Properties props = new Properties();
//        for (PropertySource <?> source : env.getPropertySources()) {
//            if (source instanceof EnumerablePropertySource) {
//                EnumerablePropertySource <?> enumerable = (EnumerablePropertySource <?>) source;
//                for (String name : enumerable.getPropertyNames()) {
//                    if (name.startsWith(prefix)) {
//                        props.putIfAbsent(name, enumerable.getProperty(name));
//                    }
//                }
//            }
//        }
//        return props;
//    }



}





