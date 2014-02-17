package us.marek.java.lambda.demo;

import java.util.Arrays;


import java.util.stream.Collectors;
import java.util.List;

public class JavaLambdaDemo {

    public static void main(final String[] args) {

        // built-in FP over collections

        final List<Integer> l1 = Arrays.asList(new Integer[] { 1, 5, 27, 4, 12 });

        final List<Integer> l2 = l1.stream()
                                   .map(i -> i * 2)
                                   .collect(Collectors.toList());

        print("l1", l1);
        print("l2", l2);

        // custom FP - see below

        final JavaOption<Integer> jo1 = new JavaOption<>(5);
        final JavaOption<Integer> i1 = jo1.map(i -> i * 2);
        final JavaOption<Iterable<Integer>> i2 = jo1.flatMap(i -> new Range(0, i));
        final JavaOption<Integer> jo2 = JavaNone.getInstance();
        final Integer i3 = jo2.getOrElse(42);

        print("jo1", jo1.get());
        print("i1", i1.get());
        print("i2", i2.get());
        print("i3", i3);
    }

    private static void print(final String name, final Object obj) {
        System.out.printf("%s = %s\n", name, obj);
    }
}
