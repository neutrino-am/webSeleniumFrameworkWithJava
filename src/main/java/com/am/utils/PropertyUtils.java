package com.am.utils;

import com.am.constants.FrameworkConstants;
import com.am.enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public final class PropertyUtils {

    protected PropertyUtils() {
    }

    private static Properties property = new Properties();
    private static final Map<String, String> CONFIGMAP = new HashMap<>();

    static {
        //9th May 2021
        try {
            FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath());
            property.load(file);
            for (Map.Entry<Object, Object> entry : property.entrySet()){
                CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
            }
              } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String get(ConfigProperties key) throws Exception{
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
            throw new Exception ("Property name"+ key+ "is not found. Please check config.Properties");
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }
}
