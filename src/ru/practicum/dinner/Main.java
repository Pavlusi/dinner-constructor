package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    //return;
                    dc.printMap();
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        if (dc.chekIsDishInList(dishType, dishName)) {
            System.out.println("Такое блюдо уже есть в этой категории");
        } else {
        dc.addNewDish(dishType, dishName);
        System.out.println("Блюдо " + dishName + "добавленно в категорию " + dishType);
        }
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");
        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();
        List<String> dishTypes = new ArrayList<>();
        while (!nextItem.isEmpty()) {
            if (dc.chekIsDishTypeInMap(nextItem)) {
                dishTypes.add(nextItem);
            } else {
                System.out.println("Такого типа блдюда нет в программе! Попробуйте снова.");
                return;
            }
            nextItem = scanner.nextLine();
        }
        List<List<String>> resultList = dc.getDishCombo(dishTypes, numberOfCombos);
        for (int i = 0; i < resultList.size() ; i++) {
            System.out.println("Комбо " + (i + 1));
            System.out.println(resultList.get(i).toString());
            }
    }
}
