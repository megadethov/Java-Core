package ua.mega.lambda;

public class Ссылка_на_метод {
    public static void main(String[] args) {
        String message = "HELLO";

        // вариант 1 - ссылка на статический метод
//        toConsole(message, str -> PrintUtils.toPrint(str)); // варик вызова статик метода без ссылки на метод
        toConsole(message, PrintUtils::toPrint); // аналог вызова статик метода через точку
        System.out.println();

        // вариант 2 - ссылка на не статический метод
        PrintUtils utils = new PrintUtils();
//        toConsole(message, str -> utils.print(str)); // варик без ссылки на метод
        toConsole(message, utils::print); // варик со ссылкой на метод
    }

    // второй параметр - ф-циональный интерфейс
    public static void toConsole(String message, Printable p) {
        p.toPrint(message);
    }
}

@FunctionalInterface
interface Printable {
    void toPrint(String str);
}

class PrintUtils {
    // статический метод
    public static void toPrint(String str) {
        System.out.println(str);
    }

    // не статический метод
    public void print(String str) {
        System.out.println(str);
    }
}