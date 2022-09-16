package com.autumn.zen.generics;

import java.util.HashSet;
import java.util.Set;

/**
 * contains
 *
 * @since 2022-08-26
 */
public class CollectionContains {


    public static void main(String[] args) {

        Set set = new HashSet<>();
        set.add(1L);
        set.add(2.2);
        set.add("3");

        System.out.println("set = " + set);


    }
}
