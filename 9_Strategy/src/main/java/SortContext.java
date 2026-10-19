public class SortContext {

    private SortingStrategy strategy;

    public void setStrategy(SortingStrategy strategy){
        this.strategy = strategy;
    }

    public void sort(int[] array){
        strategy.sort(array);
    }

    public String getStrategyName(){
        return strategy.getName();
    }
}
