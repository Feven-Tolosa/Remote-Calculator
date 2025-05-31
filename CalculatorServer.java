import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            CalculatorImpl calculator = new CalculatorImpl();
            
            // Connect to existing registry instead of creating one
            Registry registry = LocateRegistry.getRegistry(1099);
            
            registry.rebind("CalculatorService", calculator);
            System.out.println("Server connected to existing RMI registry.");
        } catch (Exception e) {
            System.err.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}