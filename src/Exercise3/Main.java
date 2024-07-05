package Exercise3;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Pessoa1", 24);
        Person person2 = new Person("Pessoa2", 33);
        Person person3 = new Person("Pessoa3", 19);
        Person person4 = new Person("Pessoa4", 41);

        List<Person> personList = Arrays.asList(person1, person2, person3, person4);

        int ageSum = personList.stream().map(p -> p.getAge()).reduce(0, (a, b) -> a + b);
        System.out.println("Sum of ages: " + ageSum);
    }
}
