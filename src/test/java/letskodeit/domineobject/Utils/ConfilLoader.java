package letskodeit.domineobject.Utils;



import letskodeit.constants.EnvType;

import java.io.IOException;
import java.util.Properties;
public class ConfilLoader {
    private  static ConfilLoader confilLoader;
    private final Properties properties;
    private  ConfilLoader() throws IOException {
        String env=System.getProperty("env",String.valueOf(EnvType.STAGE));
        switch (EnvType.valueOf(env)) {
            case STAGE ->
                    properties = PropertyUtils.readPropertiesFile("C:\\Users\\srinuvas\\eclipse-workspace\\letskodeit\\src\\test\\resources\\Stage_Config.properties");
            case PROD ->
                    properties = PropertyUtils.readPropertiesFile("C:\\Users\\srinuvas\\eclipse-workspace\\letskodeit\\src\\test\\resources\\Prod_Config.properties");
            default -> throw new IllegalStateException("Invali env " + env);
        }
    }
    public static  ConfilLoader getInstance() throws IOException {
        if(confilLoader==null)
        {
            confilLoader=new ConfilLoader();
        }
        return confilLoader;
    }
    public String getBaseUrl()
    {
        String url= (String) properties.get("baseUrl");
        if(url!=null)
        {
            return url;
        }
        else {
            throw new RuntimeException("property baseurl is not specified in the properties file");
        }
    }
}


