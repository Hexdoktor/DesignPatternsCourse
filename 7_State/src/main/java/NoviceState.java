public class NoviceState implements LevelState{

    @Override
    public void train(GameCharacter character){
        System.out.println("You train hard as a novice. +10 XP");
        character.addExperience(10);

        if(character.getExperience() >= 50){
            System.out.println("You advanced to INTERMEDIATE level!");
            character.setState(new IntermediateState());
        }
    }

    @Override
    public void meditate(GameCharacter character){
        System.out.println("Novices cannot meditate yet.");
    }

    @Override
    public void fight(GameCharacter character){
        System.out.println("Novices cannot fight yet.");
    }

    @Override
    public String getName() {
        return "Novice";
    }
}
