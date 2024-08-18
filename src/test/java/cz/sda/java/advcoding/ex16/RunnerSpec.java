package cz.sda.java.advcoding.ex16;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RunnerSpec {

    @Test
    void checksGetFitnessLevel() {
        assert Runner.getFitnessLevel(240) == Runner.BEGINNER;
        assert Runner.getFitnessLevel(241) == Runner.BEGINNER;
        assert Runner.getFitnessLevel(239) == Runner.INTERMEDIATE;
        assert Runner.getFitnessLevel(150) == Runner.INTERMEDIATE;
        assert Runner.getFitnessLevel(151) == Runner.INTERMEDIATE;
        assert Runner.getFitnessLevel(149) == Runner.ADVANCED;
        assert Runner.getFitnessLevel(0) == Runner.ADVANCED;
        assertThrows(IllegalArgumentException.class, () -> Runner.getFitnessLevel(-1));
    }

}
