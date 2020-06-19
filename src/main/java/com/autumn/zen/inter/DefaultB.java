package com.autumn.zen.inter;

/**
 * @author wuliang
 * @create 2019-05-26
 */
public interface DefaultB {

    default void foo() {
        System.out.println("foo");
    }
}
