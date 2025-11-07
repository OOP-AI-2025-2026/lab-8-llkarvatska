package ua.opnu;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        // ===== Завдання 1: Тестування MyOptional =====
        System.out.println("=== Завдання 1: MyOptional ===");

        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName);
        System.out.println("isPresent: " + middleName.isPresent());
        System.out.println("orElse: " + middleName.orElse("немає"));

        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username);
        System.out.println("isPresent: " + username.isPresent());
        System.out.println("get(): " + username.get());
        System.out.println("orElse: " + username.orElse("guest"));

        try {
            String test = middleName.get();
            System.out.println("unexpected: " + test);
        } catch (IllegalStateException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }

        try {
            MyOptional<String> broken = new MyOptional<>(null);
            System.out.println("unexpected: " + broken);
        } catch (IllegalArgumentException ex) {
            System.out.println("Правильно не дозволив null: " + ex.getMessage());
        }


        // ===== Завдання 2: Тестування BookData =====
        System.out.println("\n=== Завдання 2: BookData ===");

        List<BookData> books = new ArrayList<>();
        books.add(new BookData("Java Basics", "John Doe", 10, 45.0));   // рейтинг 4.5
        books.add(new BookData("Spring Boot", "Jane Smith", 5, 24.0)); // рейтинг 4.8
        books.add(new BookData("Algorithms", "Cormen", 8, 32.0));      // рейтинг 4.0
        books.add(new BookData("Patterns", "GoF", 5, 24.0));           // рейтинг 4.8

        System.out.println("\nДо сортування:");
        for (BookData b : books) System.out.println(b);

        Collections.sort(books);

        System.out.println("\nПісля сортування:");
        for (BookData b : books) System.out.println(b);


        // ===== Завдання 3: Printer =====
        System.out.println("\n=== Завдання 3: Printer ===");
        Printer printer = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};

        System.out.println("Масив чисел:");
        printer.printArray(intArray);

        System.out.println("Масив рядків:");
        printer.printArray(stringArray);


        // ===== Завдання 4: FilterUtil =====
        System.out.println("\n=== Завдання 4: FilterUtil ===");

        Integer[] numbers = {1, 2, 3, 4, 5, 6};
        Predicate<Integer> evenPredicate = n -> n % 2 == 0;

        Integer[] evenNumbers = FilterUtil.filter(numbers, evenPredicate);
        System.out.println("Парні числа: " + Arrays.toString(evenNumbers));

        String[] words = {"Java", "C++", "Python", "Go"};
        Predicate<String> longWord = s -> s.length() > 3;
        String[] filteredWords = FilterUtil.filter(words, longWord);
        System.out.println("Довгі слова: " + Arrays.toString(filteredWords));


        // ===== Завдання 5: ContainsUtil =====
        System.out.println("\n=== Завдання 5: ContainsUtil ===");

        String[] langs = {"Java", "Python", "C++", "Kotlin"};
        Integer[] nums = {1, 2, 3, 4, 5};

        System.out.println("Містить 'Java'? " + ContainsUtil.contains(langs, "Java"));
        System.out.println("Містить 'Ruby'? " + ContainsUtil.contains(langs, "Ruby"));
        System.out.println("Містить 3? " + ContainsUtil.contains(nums, 3));
        System.out.println("Містить 10? " + ContainsUtil.contains(nums, 10));


        // ===== Завдання 6: GenericTwoTuple та GenericThreeTuple =====
        System.out.println("\n=== Завдання 6: GenericTwoTuple і GenericThreeTuple ===");

        GenericTwoTuple<String, Integer> studentTuple = new GenericTwoTuple<>("Іваненко", 95);
        System.out.println("Двійковий кортеж: " + studentTuple);

        GenericThreeTuple<String, Integer, Double> productTuple =
                new GenericThreeTuple<>("Ноутбук", 10, 25999.99);
        System.out.println("Трійковий кортеж: " + productTuple);

        // Приклад з різними типами
        GenericThreeTuple<String, String, Boolean> userTuple =
                new GenericThreeTuple<>("admin", "root", true);
        System.out.println("Користувач: " + userTuple);

    }
}
