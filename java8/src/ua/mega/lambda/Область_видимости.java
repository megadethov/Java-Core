package ua.mega.lambda;

import java.util.function.Consumer;

/**
 * [Udemy] - Java. От простого к сложному. - Видеоуроки
 * Урок 85. Область видимости переменных в Lambda
 */
public class Область_видимости {
    public static void main(String[] args) {
        ScopeTest scopeTest = new ScopeTest(); // создаем мнстанс внешнего класса
        ScopeTest.InnerClass innerClass = scopeTest.new InnerClass(); // создаем мнстанс внутреннего класса
        innerClass.testScope("parameter");
        // Результат:
//        name = parameter
//        name = innerName
//        name = outerName
    }
}

class ScopeTest {
    private String name = "outerName";

    class InnerClass {
        private String name = "innerName";

        // скоуп в лямбдах аналогичен иннер классам
        void testScope(String name) { // параметр всегда должен быть final
//            name = "changed"; // если изменить параметр, то уже компайл ошибка при попытке юзать его в лямбдах
            Consumer<String> res = x -> {
                System.out.println("name = " + name);
                System.out.println("name = " + this.name);
                System.out.println("name = " + ScopeTest.this.name);
            };

            res.accept("fake string"); // фейковый параметр, тк требуется для интерфейса Consumer
        }
    }
}


