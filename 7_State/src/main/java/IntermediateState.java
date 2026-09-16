public class IntermediateState implements LevelState{

    @Override
    public void train(GameCharacter character){
        System.out.println("You train as an intermediate. +15 XP");
        character.addExperience(15);

        if (character.getExperience() >= 120){
            System.out.println("You advanced to EXPERT level");
            character.setState(new ExpertState());
        }
    }

    @Override
    public void meditate(GameCharacter character){
        System.out.println("You meditate. +10 XP");
        character.addHealth(10);
    }

    @Override
    public void fight(GameCharacter character){
        System.out.println("Intermediates cannot fight yet");
    }

    @Override
    public String getName(){
        return "Intermediate";
    }
}
