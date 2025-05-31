import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            // Create the calculator object
            CalculatorImpl calculator = new CalculatorImpl();
            
            // Start RMI registry on port 1099 (default)
            Registry registry = LocateRegistry.createRegistry(1099);
            
            // Bind the calculator to the name "CalculatorService"
            registry.rebind("CalculatorService", calculator);
            
            System.out.println("Calculator server is running...");
        } catch (Exception e) {
            System.err.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}