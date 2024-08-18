package cz.sda.java.advcoding.ex01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Exercise01Spec {

    @Test
    void testExercise01() {
        List<String> list = new ArrayList<>(List.of("a", "b", "c"));
        Exercise01.sort(list);
        assertEquals(List.of("c", "b", "a"), list);
    }
}
