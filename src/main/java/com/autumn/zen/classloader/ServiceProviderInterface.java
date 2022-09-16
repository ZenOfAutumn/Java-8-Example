package com.autumn.zen.classloader;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @since 2022-08-22
 */
public class ServiceProviderInterface {


    public static void nativeSPI() {
        ServiceLoader<Life> loader = ServiceLoader.load(Life.class);
        Iterator<Life> iterator = loader.iterator();
        while (iterator.hasNext()) {
            Life l = iterator.next();
            System.out.println("l.period() = " + l.period());
        }
    }

    public static void springSPI() {
        List<Life> lifes = SpringFactoriesLoader.loadFactories(Life.class, Life.class.getClassLoader());
        lifes.forEach(l -> System.out.println(l.period()));
    }

    public static void dubboSPI() {
        ExtensionLoader loader = ExtensionLoader.getExtensionLoader(Life.class);

        loader.getExtension("x");
        List<Life> lifes = SpringFactoriesLoader.loadFactories(Life.class, Life.class.getClassLoader());
        lifes.forEach(l -> System.out.println(l.period()));
    }


    public static void main(String[] args) {
        springSPI();
    }


}
