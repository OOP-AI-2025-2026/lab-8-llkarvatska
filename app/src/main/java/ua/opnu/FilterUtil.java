package ua.opnu;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Predicate;

public class FilterUtil {

    // Узагальнений метод filter
    public static <T> T[] filter(T[] input, Predicate<T> predicate) {
        // Тимчасовий масив
        Object[] temp = new Object[input.length];
        int counter = 0;

        for (T element : input) {
            if (predicate.test(element)) {
                temp[counter++] = element;
            }
        }

        // Створюємо масив правильного типу (через reflection)
        @SuppressWarnings("unchecked")
        T[] result = (T[]) Array.newInstance(input.getClass().getComponentType(), counter);
        System.arraycopy(temp, 0, result, 0, counter);

        return result;
    }
}
