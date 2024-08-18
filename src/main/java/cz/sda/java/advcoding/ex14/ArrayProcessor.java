package cz.sda.java.advcoding.ex14;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayProcessor {
    
    private HashMap<Integer, Integer> valuesCounts;

    public void process(int[] values) {
        valuesCounts = new HashMap<>();
        for (int value : values) {
            valuesCounts.put(value, valuesCounts.getOrDefault(value, 0) + 1);
        }
    }

//    return a list of unique items
    public List<Integer> uniqueItems() {
        return valuesCounts.keySet().stream().toList();
    }

//    return a list of elements that have been repeated at least once in the generated array
    public List<Integer> repeatedItems() {
        return valuesCounts.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
    }

//    return a list of the 25 most frequently recurring items
    public List<Integer> mostFrequentItems() {
        return valuesCounts.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(25)
                .map(Map.Entry::getKey)
                .toList();
    }

//    Implement a method that deduplicates items in the list. If a duplicate is found, it replaces it with a new
//    random value that did not occur before.

    public void deduplicate(int[] values) {
        for (int i = 0; i < values.length; i++) {
            if (valuesCounts.getOrDefault(values[i], 0) > 1) {
                valuesCounts.put(values[i], valuesCounts.get(values[i]) - 1);
                values[i] = getRandomUniqueValue();
                valuesCounts.put(values[i], 1);
            }
        }
    }

    private int getRandomUniqueValue() {
        var randomValue = (int) (Math.random() * Integer.MAX_VALUE);
        while (valuesCounts.containsKey(randomValue)) {
            randomValue = (int) (Math.random() * Integer.MAX_VALUE);
        }
        return randomValue;
    }
}
