package com.autumn.zen.classloader;

import java.net.URL;

/**
 * @since 2022-08-22
 */
public class ClassLoaderMethod {

    private static final String PREFIX = "META-INF/services/";


    public static void foo() throws Exception {
        Class<?> x = Class.forName("[I");
        System.out.println(x);
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("systemClassLoader = " + systemClassLoader.getClass().getName());
    }

    public static void getResource(String name) {
        URL url = Thread.currentThread().getContextClassLoader().getResource(name);
        System.out.println("url = " + url);
    }

    public static void main(String[] args) throws Exception {
        getResource("META-INF/services/com.autumn.zen.classloader.Life");
        getResource("conf/config.properties");
        getResource("kafka/kafka-version.properties");
        getResource("META-INF/services/org.apache.kafka.common.config.provider.ConfigProvider");

    }
}
