package Homework;

import java.util.Objects;

public class Numbers {
    private double number;

    public Numbers(double number) {
        this.number = number;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers = (Numbers) o;
        return number == numbers.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
