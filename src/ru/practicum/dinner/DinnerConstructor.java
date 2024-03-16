package ru.practicum.dinner;

import java.util.*;

public class DinnerConstructor {
    private  Random random = new Random();

    private HashMap<String, List<String>> allDishes = new HashMap<>();


    public void addNewDish(String dishType, String dishName) {
        if (allDishes.containsKey(dishType)) {
            allDishes.get(dishType).add(dishName);
        } else {
            List<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            allDishes.put(dishType, dishes);
        }
    }

    public List<List<String>> getDishCombo(List<String> dishTypes, int numberOfCombos) {
        List<List<String>> allCombos = new ArrayList<>();
        while (allCombos.size() != numberOfCombos) {
            List<String> combo = new ArrayList<>();
            for (String dishType : dishTypes) {
                String randomDish = getRandomDishByType(dishType);
                combo.add(randomDish);
            }
            allCombos.add(combo);
        }
        return allCombos;
    }

    private String getRandomDishByType(String dishType) {
        List<String> allDishesByType = allDishes.get(dishType);
        return allDishesByType.get(random.nextInt(allDishesByType.size()));
    }

    public boolean chekIsDishTypeInMap(String dishType) {
        return allDishes.containsKey(dishType);
    }

    public boolean chekIsDishInList(String dishType, String dishName) {
        List<String> allDishesByType = allDishes.get(dishType);
        return allDishesByType.contains(dishName);
    }
}
