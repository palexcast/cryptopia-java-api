package no.avexis.cryptopia.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    private final Properties properties = new Properties();

    public PropertiesUtil(final String file) throws IOException {
        final FileReader fr = new FileReader(file);
        properties.load(fr);
    }

    public String getPrivateKey() {
        return properties.getProperty("private_key");
    }

    public String getPublicKey() {
        return properties.getProperty("public_key");
    }
}
