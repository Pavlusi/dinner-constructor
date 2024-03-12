package ru.practicum.dinner;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class DinnerConstructor {
    private Random random = new Random();

    private HashMap<String, List<String>> dishes = new HashMap<>();


    public void addNewDish(String dishType, String dishName) {
        if (dishes.containsKey(dishType)) {
            List<String> listToChek = dishes.get(dishType);
            if (listToChek.contains(dishName)) {
                System.out.println();
            }
        } else {
            List<String> dishesList = new ArrayList<>();
            dishesList.add(dishName);
            dishes.put(dishType, dishesList);
        }
    }

    public List<List<String>> getDishCombo(List<String> dishTypes, int numberOfCombos) {
        List<List<String>> comboList = new ArrayList<>();
        for (int i = 0; i < numberOfCombos; i++){
            List<String> dishesList = new ArrayList<>();
            for(String dishType: dishTypes){
               String randomDish = getRandomDishByType(dishType);
               dishesList.add(randomDish);
            }
            comboList.add(dishesList);
        }
        return comboList;
    }
    public boolean chekIsDishTypeInMap(String dishType) {
        if (dishes.containsKey(dishType)) {
            return true;
        } else {
            return false;
        }
    }
    private String getRandomDishByType(String dishType){
       List<String> dishesByType = dishes.get(dishType);
       return dishesByType.get(random.nextInt(dishesByType.size()));
    }

    public void printMap(){
        for(Map.Entry<String, List<String>> pair: dishes.entrySet()){
            System.out.println(pair.getKey());
            for(String str: pair.getValue()){
                System.out.println(str);
            }
        }
    }

    public boolean chekIsDishInList(String dishType, String dishName) {
        List<String> dishesByType = dishes.get(dishType);
        if(dishesByType.contains(dishName)) {
            return true;
        } else {
            return false;
        }
    }
}
