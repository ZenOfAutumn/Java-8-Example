package com.autumn.zen.stream;

/**
 * @since 2022-09-07
 */
public class Employee {

    private int id;

    private String job;

    private Employee(Builder builder) {
        setId(builder.id);
        setJob(builder.job);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


    public static final class Builder {
        private int id;
        private String job;

        public Builder() {
        }

        public Builder id(int val) {
            id = val;
            return this;
        }

        public Builder job(String val) {
            job = val;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
