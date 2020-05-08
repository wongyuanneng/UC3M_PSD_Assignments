package Transport4Future.TokenManagement.Boundary;

public class Main {
    /**
     * Main method of execution
     *
     * 
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        // Usamos la estrategia A
        Strategy initialStrategy = new StrategyA();
        Context context = new Context(initialStrategy);
        context.some_method();
        
        // Decidimos usar la estrategia B
        Strategy strategy2 = new StrategyB();
        context.setStrategy(strategy2);
        context.some_method();
        
        // Finalmente,usamos de nuevo la estrategia A
        context.setStrategy(initialStrategy);
        context.some_method();
    }

}
