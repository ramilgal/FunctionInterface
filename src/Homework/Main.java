package Homework;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Numbers number = new Numbers(5);
        Numbers number1 = new Numbers(-3);
        Numbers number2 = new Numbers(-16);
        Numbers number3 = new Numbers(1);
        Numbers number4 = new Numbers(32);
        Numbers number5 = new Numbers(-8);
        List<Numbers> listNumbers = new ArrayList<>();
        listNumbers.add(number);
        listNumbers.add(number1);
        listNumbers.add(number2);
        listNumbers.add(number3);
        listNumbers.add(number4);
        listNumbers.add(number5);
        Predicate<Numbers> predicate = new Predicate<Numbers>() {
            @Override
            public boolean output(Numbers numbers) {
                return numbers.getNumber()>0;
            }
        };
            listNumbers.removeIf(predicate);
    }
    public interface Predicate<T> {
        boolean output(T t);
    }
}