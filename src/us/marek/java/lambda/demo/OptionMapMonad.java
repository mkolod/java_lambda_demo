package us.marek.java.lambda.demo;

@FunctionalInterface
interface OptionMapMonad<T> {

    public <R> JavaOption<R> map(final MyFunction<T, R> f);

}