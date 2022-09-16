package com.autumn.zen.stream;

/**
 * @since 2022-09-07
 */
public class User {

    private int id;

    private String name;

    private User(Builder builder) {
        setId(builder.id);
        setName(builder.name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static final class Builder {
        private int id;
        private String name;

        public Builder() {
        }

        public Builder id(int val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
