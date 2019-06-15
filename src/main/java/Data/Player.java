package Data;

public class Player {

    private int id;
    private String name;
    private int age;
    private int wage;
    private int weight;
    private int interceptions;
    private int crossing;
    private int finishing;
    private int dribbling;
    private int shotPower;
    private int jumping;
    private int reactions;

    public Player(int id, String name, int age, int wage, int weight, int interceptions,
                  int crossing, int finishing, int dribbling, int shotPower, int jumping,
                  int reactions){
        this.id = id;
        this.name = name;
        this.age = age;
        this.wage = wage;
        this.weight = weight;
        this.interceptions = interceptions;
        this.crossing = crossing;
        this.finishing = finishing;
        this.dribbling = dribbling;
        this.shotPower = shotPower;
        this.jumping = jumping;
        this.reactions = reactions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getInterceptions() {
        return interceptions;
    }

    public void setInterceptions(int interceptions) {
        this.interceptions = interceptions;
    }

    public int getCrossing() {
        return crossing;
    }

    public void setCrossing(int crossing) {
        this.crossing = crossing;
    }

    public int getFinishing() {
        return finishing;
    }

    public void setFinishing(int finishing) {
        this.finishing = finishing;
    }

    public int getDribbling() {
        return dribbling;
    }

    public void setDribbling(int dribbling) {
        this.dribbling = dribbling;
    }

    public int getShotPower() {
        return shotPower;
    }

    public void setShotPower(int shotPower) {
        this.shotPower = shotPower;
    }

    public int getJumping() {
        return jumping;
    }

    public void setJumping(int jumping) {
        this.jumping = jumping;
    }

    public int getReactions() {
        return reactions;
    }

    public void setReactions(int reactions) {
        this.reactions = reactions;
    }
}
