package cz.sda.java.advcoding.ex13;

public enum SelectionOperator {
    EQUALS, GREATER_THAN, LESS_THAN, GREATER_THAN_OR_EQUALS, LESS_THAN_OR_EQUALS, NOT_EQUALS;

    public boolean test(int y, int year) {
        return switch (this) {
            case EQUALS -> y == year;
            case GREATER_THAN -> y > year;
            case LESS_THAN -> y < year;
            case GREATER_THAN_OR_EQUALS -> y >= year;
            case LESS_THAN_OR_EQUALS -> y <= year;
            case NOT_EQUALS -> y != year;
        };
    }
}
