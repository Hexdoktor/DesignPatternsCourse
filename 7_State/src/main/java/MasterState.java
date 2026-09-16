public class MasterState implements LevelState{
    @Override
    public void train(GameCharacter character){
        System.out.println("You are a master, Training is no longer needed.");
    }

    @Override
    public void meditate(GameCharacter character){
        System.out.println("You are a master. Meditation is no longer needed");
    }

    @Override
    public void fight(GameCharacter character){
        System.out.println("You are a master. Fighting is beneath you.");
    }

    @Override
    public String getName(){
        return "Master";
    }
}
