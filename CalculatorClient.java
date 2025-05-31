import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            // Connect to the RMI registry running on localhost:1099
            Registry registry = LocateRegistry.getRegistry("localhost", 2099);
            
            // Look up the remote calculator object
            Calculator calculator = (Calculator) registry.lookup("CalculatorService");
            
            // User input
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter operation (add/sub/mul/div) and two numbers:");
            String op = scanner.next();
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            
            // Perform the operation
            double result = 0;
            switch (op) {
                case "add": result = calculator.add(x, y); break;
                case "sub": result = calculator.subtract(x, y); break;
                case "mul": result = calculator.multiply(x, y); break;
                case "div": result = calculator.divide(x, y); break;
                default: System.out.println("Invalid operation!"); return;
            }
            
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}