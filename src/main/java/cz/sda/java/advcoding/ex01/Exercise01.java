package cz.sda.java.advcoding.ex01;

import java.util.Comparator;
import java.util.List;

class Exercise01 {
    public static void sort(List<String> list) {
        list.sort(Comparator.reverseOrder());
    }
}
