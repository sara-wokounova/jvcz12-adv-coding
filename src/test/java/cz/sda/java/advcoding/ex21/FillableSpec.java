package cz.sda.java.advcoding.ex21;

import cz.sda.java.advcoding.ex22.Fillable;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class FillableSpec {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final PrintStream originalErr = System.err;

    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterAll
    public static void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void checksOverflowed() {
        Fillable fillable = new Cube(3);
        fillable.fill(30);
        assert outContent.toString().contains("Overflowed.");
    }

    @Test
    void checksFilledToTheBrim() {
        Fillable fillable = new Cube(3);
        fillable.fill(27);
        assert outContent.toString().contains("Filled to the brim");
    }
    @Test
    void checksNotEnoughVolumeToFill() {
        Fillable fillable = new Cube(3);
        fillable.fill(20);
        assert outContent.toString().contains("Not enough volume to fill");
    }
}
