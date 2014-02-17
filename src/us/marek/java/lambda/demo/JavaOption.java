package us.marek.java.lambda.demo;

import java.util.Collection;
import java.util.NoSuchElementException;

/* note the two interfaces - Java's @FunctionalInterface requires a single abstract method (SAM),
   so you can't include map() and flatMap() in the same interface
 */
public class JavaOption<T> implements OptionMapMonad<T>, OptionFlatMapMonad<T> {

    final protected T value;

    protected JavaOption(final T value) {
        this.value = value;
    }

    public T get() throws NoSuchElementException {
        if (this instanceof JavaNone) {
            throw new NoSuchElementException();
        }
        return value;
    }

    public T getOrElse(final T t) {
        if (this instanceof JavaNone) {
            return t;
        }
        return value;
    }


    @Override
    public <R> JavaOption<R> map(final MyFunction<T, R> f) {
        if (this instanceof JavaNone) {
            return JavaNone.getInstance();
        }

        return new JavaSome<R>(f.apply(value));
    }

    @Override
    public <R> JavaOption<Iterable<R>> flatMap(final MyFunction<T, Iterable<R>> f) {
        if (this instanceof JavaNone) {
            return JavaNone.getInstance();
        }

        return new JavaSome<Iterable<R>>(f.apply(value));
    }
}