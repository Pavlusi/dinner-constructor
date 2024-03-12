package ru.practicum.dinner;

import java.util.*;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine().trim();

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
        String dishType = scanner.nextLine().trim();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine().trim();
        dc.addNewDish(dishType, dishName);
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
                System.out.println("Такого типа блдюда нет в списке! Попробуйте снова.");
                nextItem = scanner.nextLine();
                continue;
            }
            nextItem = scanner.nextLine();
        }
        printResultList(dishTypes, numberOfCombos);
    }

    private static void printResultList(List<String> dishTypes, int numberOfCombos) {
        Set<List<String>> resultList = dc.getDishCombo(dishTypes, numberOfCombos);
        int counter = 1;
        for (List<String> list : resultList) {
            System.out.println("Комбо " + counter);
            System.out.println(list.toString());
            counter++;
        }
    }
}
