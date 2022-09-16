package com.autumn.zen.stream;

/**
 * @since 2022-09-07
 */
public class Tuple<T1, T2> {


    private T1 t1;

    private T2 t2;

    private Tuple(Builder<T1, T2> builder) {
        setT1(builder.t1);
        setT2(builder.t2);
    }

    public T1 getT1() {
        return t1;
    }

    public void setT1(T1 t1) {
        this.t1 = t1;
    }

    public T2 getT2() {
        return t2;
    }

    public void setT2(T2 t2) {
        this.t2 = t2;
    }


    public static final class Builder<T1, T2> {
        private T1 t1;
        private T2 t2;

        public Builder() {
        }

        public Builder<T1, T2> t1(T1 val) {
            t1 = val;
            return this;
        }

        public Builder<T1, T2> t2(T2 val) {
            t2 = val;
            return this;
        }

        public Tuple<T1, T2> build() {
            return new Tuple<T1, T2>(this);
        }
    }
}
