public class Self {
    private int charisma;
    private int strength;
    private int endurance;

    private boolean levelUp;

    public Self(int charisma, int strength, int endurance, boolean levelUp) {
        this.charisma = charisma;
        this.strength = strength;
        this.endurance = endurance;
        this.levelUp = levelUp;

    }

    public int getCharisma() {
        return charisma;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getStrength() {
        return strength;
    }

    public boolean getLevelUp() { return levelUp; }

    public void setLevelUp(boolean levelUp) {
        this.levelUp = levelUp;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

}
