import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {
    
    public CalculatorImpl() throws RemoteException {
        super(); // Calls UnicastRemoteObject constructor
    }
    
    public double add(double a, double b) throws RemoteException {
        return a + b;
    }
    
    public double subtract(double a, double b) throws RemoteException {
        return a - b;
    }
    
    public double multiply(double a, double b) throws RemoteException {
        return a * b;
    }
    
    public double divide(double a, double b) throws RemoteException {
        if (b == 0) throw new RemoteException("Cannot divide by zero!");
        return a / b;
    }
}