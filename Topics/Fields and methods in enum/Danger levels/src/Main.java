enum DangerLevel {
    HIGH("HIGH", 3),
    MEDIUM("MEDIUM", 2),
    LOW("LOW", 1);

    String state;
    int level;

    DangerLevel(String state, int level) {
        this.level = level;
        this.state = state;
    }

    public int getLevel() {
        return this.level;
    }
}