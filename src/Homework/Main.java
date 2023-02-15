package Homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------Задание 1------------");
        Numbers number = new Numbers(5.5);
        Numbers number1 = new Numbers(-3.456);
        Numbers number2 = new Numbers(-16.121);
        Numbers number3 = new Numbers(1.47);
        Numbers number4 = new Numbers(32.157);
        Numbers number5 = new Numbers(-8.7898);
        List<Numbers> listNumbers = new ArrayList<>();
        listNumbers.add(number);
        listNumbers.add(number1);
        listNumbers.add(number2);
        listNumbers.add(number3);
        listNumbers.add(number4);
        listNumbers.add(number5);
        Predicate<Numbers> predicate = new Predicate<Numbers>() {
            @Override
            public boolean test(Numbers numbers) {
                return numbers.getNumber() < 0;
            }
        };
        listNumbers.removeIf(predicate);
        for (Numbers numbers : listNumbers) {
            System.out.println(numbers);
        }
        System.out.println("----------------------");
        Predicate<Numbers> predicate2 = numbers -> numbers.getNumber() == 5;
        listNumbers.removeIf(predicate2);
        for (Numbers numbers : listNumbers) {
            System.out.println(numbers);
        }
        System.out.println("----------Задание 2------------");
        Person person = new Person("Pavel", 22);
        Person person1 = new Person("Ivan", 45);
        List<Person> names = new ArrayList<>();
        names.add(person);
        names.add(person1);
        Consumer<Person> consumer = new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println("Привет " + person.getName());
            }
        };
        for (Person name : names) {
            consumer.accept(name);
        }
        System.out.println("----------------------");
        Consumer<Person> consumer1 = person2 -> System.out.println("Привет " + person2.getName());
        for (Person name : names) {
            consumer1.accept(name);
        }
        System.out.println("----------Задание 3------------");

        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return aDouble.longValue();
            }
        };
        for (Numbers numbers : listNumbers) {
            System.out.println(function.apply(numbers.getNumber()));
        }
        System.out.println("----------------------");
        Function<Double, Long> function1 = aDouble -> aDouble.longValue();
        for (Numbers numbers : listNumbers) {
            System.out.println(function1.apply(numbers.getNumber()));
        }
        System.out.println("----------Задание 4------------");
        Supplier<Integer> t = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt(100);
            }
        };
        System.out.println(t.get());
        System.out.println("----------------------");
        Supplier<Integer> i = () -> new Random().nextInt(100);
        System.out.println(i.get());
    }
}