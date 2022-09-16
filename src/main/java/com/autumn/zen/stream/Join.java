package com.autumn.zen.stream;

import org.jooq.lambda.Seq;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @since 2022-09-07
 */
public class Join {


    public static Stream<User> users() {
        return Stream.of(new User.Builder().id(1).name("A").build(), new User.Builder().id(2).name("B").build());
    }

    public static Stream<Employee> employees() {
        return Stream.of(new Employee.Builder().id(1).job("a").build(), new Employee.Builder().id(2).job("b").build());
    }

    private static Stream<Tuple<User, Employee>> innerJoin() {
        return users().flatMap(v1 -> employees().filter(v2 -> Objects.equals(v1.getId(), v2.getId())).map(v2 -> new Tuple.Builder<User, Employee>().t1(v1).t2(v2).build()));
    }


    public static void main(String[] args) {

        List<Tuple<User, Employee>> ret = innerJoin().collect(Collectors.toList());
    }

    public static void sequence() {


        // (1, 2, 3, 4, 5, 6)
        Seq.ofType(users(), User.class).innerJoin(Seq.ofType(employees(), Employee.class), (v1, v2) ->
                Objects.equals(v1.getId(), v2.getId()));


    }


}
