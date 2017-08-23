package lishf.work.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * properties文件工具类
 * Created by Administrator on 2017\8\21
 */
public class PropertiesUtil {

    /**
     * 交易场景配置
     */
    private static String configPath = "work.properties";

    private static Properties configProperty = null;

    private static PropertiesUtil propUtil;

    private PropertiesUtil() {
        loadProperty();
    }

    // 单例模式
    public synchronized static PropertiesUtil getInstance() {
        if (propUtil == null) {
            propUtil = new PropertiesUtil();
        }
        return propUtil;
    }

    /**
     * 加载配置文件
     */
    private void loadProperty() {
        if (configProperty == null) {
            try {
                configProperty = new Properties();
                InputStream in = this.getClass().getResourceAsStream(configPath);
                configProperty.load(in);
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 根据key获取value
     * @param key
     * @return
     */
    public String getValueByKey(String key) {
        String value = null;
        if (configProperty != null) {
            try {
                String tmp = configProperty.getProperty(key);
                value = new String(tmp.getBytes("UTF-8"), "UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
                value = null;
            }
        }
        return value;
    }

}
