public class GameCharacter {
    private String name;
    private int experience;
    private int health;
    private LevelState state;

    public GameCharacter(String name){
        this.name = name;
        this.experience = 0;
        this.health = 100;
        this.state = new NoviceState();
    }

    public void setState(LevelState newState){
        this.state = newState;
    }

    public void addExperience(int xp){
        this.experience += xp;
    }

    public void addHealth(int hp){
        this.health += hp;
        if(this.health > 100) this.health = 100;
    }

    public int getExperience() {return experience;}
    public int getHealth(){return health;}
    public String getLevelName(){return state.getName();}

    public void train(){state.train(this);}
    public void meditate(){state.meditate(this);}
    public void fight(){state.fight(this);}

    public void printStatus(){
        System.out.println("\n=== CHARACTER STATUS ===");
        System.out.println("Name: " + name);
        System.out.println("Level: " + getLevelName());
        System.out.println("XP: " + experience);
        System.out.println("HP: " + health);
        System.out.println("==========================");
    }
}
