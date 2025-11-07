package ua.opnu;

public class Printer {

    // Узагальнений метод, який приймає масив будь-якого типу
    public <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}
