package cz.sda.java.advcoding.ex16;

public enum Runner {
    BEGINNER(240, 16*60),
    INTERMEDIATE(150, 240),
    ADVANCED(0,150);

    private int minTime;
    private int maxTime;

    Runner(int minTime, int maxTime) {
        this.minTime = minTime;
        this.maxTime = maxTime;
    }

    public static Runner getFitnessLevel(int marathonTime) {
        for (Runner runner : values()) {
            if (marathonTime >= runner.minTime && marathonTime < runner.maxTime) {
                return runner;
            }
        }
        throw new IllegalArgumentException("Invalid marathon time: " + marathonTime);
    }
}
