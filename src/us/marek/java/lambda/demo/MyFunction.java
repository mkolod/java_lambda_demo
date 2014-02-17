package us.marek.java.lambda.demo;

@FunctionalInterface
interface MyFunction<T, R> {

    public R apply(T t);

    // default (concrete) methods
    default int getMagicNumber() { return 42; };

}