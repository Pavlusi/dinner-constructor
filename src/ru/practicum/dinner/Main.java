package ru.practicum.dinner;

import java.util.*;

public class Main {

    private static DinnerConstructor dinnerConstructor;
    private static Scanner scanner;

    public static void main(String[] args) {
        dinnerConstructor = new DinnerConstructor();
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
                    return;
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
        if (dinnerConstructor.chekIsDishTypeInMap(dishType) && dinnerConstructor.chekIsDishInList(dishType,dishName)) {
            System.out.println("Блюдо " + dishName + " типа " + dishType + " уже есть в программе." + "\n");
        } else {
            dinnerConstructor.addNewDish(dishType, dishName);
            System.out.println("Блюдо " + dishName + " добавленно в категорию " + dishType + "\n");
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
            if (dinnerConstructor.chekIsDishTypeInMap(nextItem)) {
                dishTypes.add(nextItem);
            } else {
                System.out.println("Такого типа блдюда нет в программе: " + nextItem  + "\n");
                return;
            }
            nextItem = scanner.nextLine();
        }
        printResultList(dishTypes, numberOfCombos);
    }

    private static void printResultList(List<String> dishTypes, int numberOfCombos) {
        List<List<String>> resultList = dinnerConstructor.getDishCombo(dishTypes, numberOfCombos);
        for (int i = 0; i < resultList.size(); i++) {
            System.out.println("Комбо " + (i + 1));
            System.out.println(resultList.get(i).toString());
        }
    }
}
