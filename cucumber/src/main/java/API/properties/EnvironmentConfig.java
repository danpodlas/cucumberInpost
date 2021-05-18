package API.properties;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:EnvironmentConfig.properties")
public interface EnvironmentConfig extends Config {

    @Key("BASE_URI")
    String baseUri();

    @Key("BASE_PATH")
    String basePath();

}
