package us.marek.java.lambda.demo;

import java.util.Collection;

@FunctionalInterface
interface OptionFlatMapMonad<T> {

    public <R> JavaOption<Iterable<R>> flatMap(final MyFunction<T, Iterable<R>> f);

}