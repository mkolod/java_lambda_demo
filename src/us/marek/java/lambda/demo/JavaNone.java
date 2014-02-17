package us.marek.java.lambda.demo;

// None singleton
class JavaNone<T> extends JavaOption<T> {

    final private static JavaNone instance = new JavaNone();

    private JavaNone() {

        super(null);

    };

    public static JavaNone getInstance() { return instance; };
}