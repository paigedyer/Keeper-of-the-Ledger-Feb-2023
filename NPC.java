public class NPC {
    private int charisma;
    private int strength;
    private int endurance;
    private int killXP;
    private int charismaXP;

    private String name;

    public NPC(int charisma, int strength, int endurance, int killXP, int charismaXP, String name) {
        this.charisma = charisma;
        this.strength = strength;
        this.endurance = endurance;
        this.killXP = killXP;
        this.charismaXP = charismaXP;
        this.name = name;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int i) {
        this.strength = i;
    }
    public int getStrength() {
        return strength;
    }

    public void setStrength(int i) {
        this.strength = i;
    }
    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int i) {
        this.endurance = i;
    }
    public int getCharismaXP() {
        return charismaXP;
    }

    public void setCharismaXP(int i) {
        this.charismaXP = i;
    }
    public int getKillXP() {
        return killXP;
    }

    public void setKillXP(int i) {
        this.killXP = i;
    }

    public void setName(String i) {
        this.name = i;
    }
    public String getName() {
        return this.name;
    }


}
