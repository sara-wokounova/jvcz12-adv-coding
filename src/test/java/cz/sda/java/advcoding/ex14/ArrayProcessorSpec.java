package cz.sda.java.advcoding.ex14;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ArrayProcessorSpec {

    private static int[] testArray;
    private static ArrayProcessor arrayProcessor;

    @BeforeAll
    static void setup() {
        testArray = new int[1000];
        for (int i = 0; i < 50; i++) {
            testArray[i] = i + 50;
        }
        for (int i = 50; i < 100; i++) {
            testArray[i] = i % 25;
        }
        for (int i = 100; i < testArray.length; i++) {
            testArray[i] = i % 50;
        }
        arrayProcessor = new ArrayProcessor();
        arrayProcessor.process(testArray);
    }

    @Test
    void checksUniquesItems() {
        var uniqueItems = arrayProcessor.uniqueItems();
        for (int i = 0; i < 100; i++) {
            assert uniqueItems.contains(i);
        }
        assert uniqueItems.size() == 100;
    }

    @Test
    void checksRepeatedItems() {
        var repeatedItems = arrayProcessor.repeatedItems();
        for (int i = 0; i < 50; i++) {
            assert repeatedItems.contains(i);
        }
        assert repeatedItems.size() == 50;
    }

    @Test
    void checksMostFrequentItems() {
        var mostFrequentItems = arrayProcessor.mostFrequentItems();
        for (int i = 0; i < 25; i++) {
            assert mostFrequentItems.contains(i);
        }
        assert mostFrequentItems.size() == 25;
    }

    @Test
    void checksDeduplication() {
        var arrayToDeduplicate = new int[1000];
        System.arraycopy(testArray, 0, arrayToDeduplicate, 0, testArray.length);
        var arrayProcessor = new ArrayProcessor();
        arrayProcessor.process(arrayToDeduplicate);
        arrayProcessor.deduplicate(arrayToDeduplicate);
        assert arrayProcessor.repeatedItems().isEmpty();
    }

}
