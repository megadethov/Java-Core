package ua.mega.lambda;

/**
 * [Udemy] - Java. От простого к сложному. - Видеоуроки
 * Урок 83. Функциональные интерфейсы в Lambda выражениях
 */
public class Функциональные_интерфейсы {
    public static void main(String[] args) {
        // здесь заюзаем метод processNum
        // вместо ф-ционального интерфейса передаем лямбда выраженеие
        processNum(2, a -> a*a); // = 4.0

        // как видим здесь можен что угодно, принимающее на вход int и возвращающее double
        processNum(3, a -> Math.cos(a)); // -0.9899924966004454
    }

// есть метод процессинга, принимает int и Convertible
    private static void processNum(int num, Convertible func) {
        System.out.println(func.convert(num));
    }

}

// есть ф-циональный интерфейс с 1 методом - принимает int, возвращает double
@FunctionalInterface
interface Convertible {
    double convert(int number);
}

@FunctionalInterface
interface NonConvertible {
    double nonConvert(int number);
}