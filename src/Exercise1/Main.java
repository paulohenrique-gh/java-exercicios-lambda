package Exercise1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12, 23, 31, 44, 53, 98);

        filterWithAnonymousClass(numbers);
        filterAssigningLambdaToVariable(numbers);
        filterPassingLambdasDirectly(numbers);
    }

    public static void filterWithAnonymousClass(List<Integer> numbers) {
        System.out.println("Using anonymous class...");
        Predicate<Integer> filterEvenNumbersAnonClass = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        };
        Consumer<Integer> printNumbersAnonClass = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };

        System.out.println("Original list:");
        numbers.forEach(printNumbersAnonClass);
        System.out.println("Filtered list:");
        numbers.stream().filter(filterEvenNumbersAnonClass).forEach(printNumbersAnonClass);
        System.out.println("========");
    }

    public static void filterAssigningLambdaToVariable(List<Integer> numbers) {
        System.out.println("Assigning lambdas to variables...");
        Predicate<Integer> filterEvenNumbersLambda = n -> n % 2 == 0;
        Consumer<Integer> printNumbersLambda = n -> System.out.println(n);

        System.out.println("Original list:");
        numbers.forEach(printNumbersLambda);
        System.out.println("Filtered list:");
        numbers.stream().filter(filterEvenNumbersLambda).forEach(printNumbersLambda);
        System.out.println("========");
    }

    public static void filterPassingLambdasDirectly(List<Integer> numbers) {
        System.out.println("Passing lambdas directly...");
        System.out.println("Original list:");
        numbers.forEach(n -> System.out.println(n));
        System.out.println("Filtered list:");
        numbers.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.println(n));
        System.out.println("========");
    }
}