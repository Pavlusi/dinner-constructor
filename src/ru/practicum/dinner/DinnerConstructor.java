package ru.practicum.dinner;

import java.util.*;

public class DinnerConstructor {
    private final Random random = new Random();

    private HashMap<String, List<String>> allDishes = new HashMap<>();


    public void addNewDish(String dishType, String dishName) {
        if (allDishes.containsKey(dishType)) {
            if (chekIsDishInList(dishType, dishName)) {
                System.out.println("Блюдо " + dishName + " типа " + dishType + " уже есть в программе, попробуйте снова.");
            } else {
                allDishes.get(dishType).add(dishName);
                System.out.println("Блюдо " + dishName + " добавленно в категорию " + dishType);
            }
        } else {
            List<String> dishesList = new ArrayList<>();
            dishesList.add(dishName);
            allDishes.put(dishType, dishesList);
            System.out.println("Блюдо " + dishName + " добавленно в категорию " + dishType);
        }
    }

    public Set<List<String>> getDishCombo(List<String> dishTypes, int numberOfCombos) {
        Set<List<String>> comboList = new HashSet<>();
        while (comboList.size() != numberOfCombos) {
            List<String> allDishesList = new ArrayList<>();
            for (String dishType : dishTypes) {
                String randomDish = getRandomDishByType(dishType);
                allDishesList.add(randomDish);
            }
            comboList.add(allDishesList);
        }
        return comboList;
    }

    public boolean chekIsDishTypeInMap(String dishType) {
        return allDishes.containsKey(dishType);
    }

    private String getRandomDishByType(String dishType) {
        List<String> allDishesByType = allDishes.get(dishType);
        return allDishesByType.get(random.nextInt(allDishesByType.size()));
    }

    public void printMap() {
        for (Map.Entry<String, List<String>> pair : allDishes.entrySet()) {
            System.out.println(pair.getKey());
            for (String str : pair.getValue()) {
                System.out.println(str);
            }
        }
    }

    public boolean chekIsDishInList(String dishType, String dishName) {
        List<String> allDishesByType = allDishes.get(dishType);
        return allDishesByType.contains(dishName);
    }
}
