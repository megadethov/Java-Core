package ua.mega.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class SortCollectionsTest {
    public static void main(String[] args) {
        // имеем массив интов
        int[] numbers = {5, 1, 3, 2, 4};
        // имеем массив сотрудников
        Employee[] employees = {
                new Employee("Vasya Pupkin", 22),
                new Employee("Ivan Ivanov", 44),
                new Employee("Petr Petrov", 33)};
        // массив интов сортироуем легко
        System.out.println(Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        // для сортировки сотрудников они должны быть comparable
        System.out.println(Arrays.toString(employees));
        // если попытаться отсортировать без компаратора - класс каст
//        Arrays.sort(employees); // java.lang.ClassCastException: ua.mega.lambda.Employee cannot be cast to java.lang.Comparable
        Arrays.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        System.out.println(Arrays.toString(employees));

        // трабла в том, что каждый раз нужно создавать новый анонимный одноразовый компаратор
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");

        // заменяем создание инстанса компаратора на чисто реализацию (точная копия - [new] + [->])
        Arrays.sort(employees, (Employee e1, Employee e2) -> {
            return Integer.compare(e1.getAge(), e2.getAge());
            });
        // упрощаем
        Arrays.sort(employees, (Employee e1, Employee e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        System.out.println(Arrays.toString(employees));
        // упрощаем еще
        Arrays.sort(employees, (e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        System.out.println(Arrays.toString(employees));

        // @FunctionalInterface - если интерфейс имеет такую аннотацию(Comparator имеет),
        // то мы можем юзать лямбда выражения

        // ВЫВОД - если интерфейс является ф-циональным, то его имплементацию можно заменить
        // анонимной ф-цией в виде лямбда выражения
    }
}

class Employee {
    private String name;
    private int age;

    public Employee() {
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
