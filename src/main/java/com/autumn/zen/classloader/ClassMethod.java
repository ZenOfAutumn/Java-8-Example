package com.autumn.zen.classloader;

/**
 * Class Method
 *
 * @since 2022-08-22
 */
public class ClassMethod {


    public static interface Inner {

        void foo();
    }


    public static void name(Class cls) {

        System.out.print(" cls.getName() = " + cls.getName());
        System.out.print(" cls.getSimpleName() = " + cls.getSimpleName());
        System.out.print(" cls.getCanonicalName() = " + cls.getCanonicalName());
        System.out.println();

    }

    public static abstract class Abs {
        abstract void method();
    }

    public static class AbsImpl extends Abs {
        @Override
        void method() {


        }
    }


    public static void nameTest() {

        class PhoneNumber {

        }

        name(PhoneNumber.class);
        name(String.class);
        name(Inner.class);

        Inner inner = new Inner() {
            public void foo() {
                return;
            }
        };
        name(inner.getClass());
        Long[] x = new Long[10];
        name(x.getClass());
    }


    public static void main(String[] args) {
        System.out.println(Abs.class.isInterface());
    }
}
