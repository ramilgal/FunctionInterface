package Homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("----------Stream API и Optional------------");
        System.out.println("----------Задание 1------------");
        Stream<Integer> testStream = Stream.of(1,2,3,4,5,6,7,8,9);
        BiConsumer<Integer, Integer> biConsumer = (min, max) -> System.out.println("Минимальное число: " +
                min.toString() + ", максимальное число: " + max.toString());
        Comparator<Integer> comparator = Comparator.comparing(Integer::intValue);
        findMinMax(testStream, comparator, biConsumer);
        System.out.println("----------Задание 2------------");
        List<Integer> testNumbers = new ArrayList<>();
        testNumbers.add(1);
        testNumbers.add(2);
        testNumbers.add(3);
        testNumbers.add(4);
        testNumbers.add(5);
        testNumbers.add(6);
        testNumbers.add(7);
        testNumbers.add(8);
        findNumberOfEvenNumbers(testNumbers);
    }
    //Метод в задании 1
    public static <T> void findMinMax(Stream <? extends T> stream,Comparator<? super T> order,
    BiConsumer<? super T, ? super T> minMaxConsumer) {
List<T> testList = stream.collect(Collectors.toList());
        if (testList.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            testList.sort(order);
            minMaxConsumer.accept(testList.get(0), testList.get(testList.size()-1));
        }
    }
    //Метод в задании 2
    public static void findNumberOfEvenNumbers(List<Integer> list) {
        Stream<Integer> stream = list.stream();
        Predicate<Integer> predicate = i -> i % 2 == 0;
        Stream<Integer> nextStream = stream.filter(predicate);
        System.out.println("Количество четных чисел равно: " + nextStream.count());

    }
}