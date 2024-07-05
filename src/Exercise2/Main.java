package Exercise2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "Test", "Java", "Lambda", "String");

        toUpperWithAnonClass(strings);
        toUpperAssigningLambdaToVariable(strings);
        toUpperPassingLambdaDirectly(strings);
    }

    public static void toUpperWithAnonClass(List<String> strings) {
        System.out.println("Using anonymous classes...");
        Function<String, String> toUpperAnonClass = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };
        Consumer<String> printStringsAnonClass = new Consumer<String>() {
            public void accept(String s) {
                System.out.println(s);
            }
        };

        System.out.println("Original strings:");
        strings.forEach(printStringsAnonClass);
        System.out.println("Strings converted to uppercase:");
        strings.stream().map(toUpperAnonClass).forEach(printStringsAnonClass);
        System.out.println("===========");
    }

    public static void toUpperAssigningLambdaToVariable(List<String> strings) {
        System.out.println("Assigning lambda to variable...");
        Function<String, String> toUpperLambda = s -> s.toUpperCase();
        Consumer<String> printStringsLambda = s -> System.out.println(s);

        System.out.println("Original strings:");
        strings.forEach(printStringsLambda);
        System.out.println("Strings converted to uppercase:");
        strings.stream().map(toUpperLambda).forEach(printStringsLambda);
        System.out.println("===========");
    }

    public static void toUpperPassingLambdaDirectly(List<String> strings) {
        System.out.println("Passing lambdas directly...");
        System.out.println("Original strings:");
        strings.forEach(s -> System.out.println(s));
        System.out.println("Strings converted to uppercase:");
        strings.stream().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
        System.out.println("=========");
    }
}
