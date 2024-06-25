
public class Problema6SistemaBanco {
    
    public static void main(String[] args) {
        Cuenta cuenta1 = new Cuenta(1, "Juan Pérez");
        cuenta1.depositar(1000);
        cuenta1.retirar(200);
        System.out.println("Saldo actual de la cuenta 1: $" + cuenta1.obtenerBalance());

        CuentaCheques cuenta2 = new CuentaCheques(2, "María López");
        cuenta2.depositar(500);
        cuenta2.retirar(700);
        System.out.println("Saldo actual de la cuenta 2: $" + cuenta2.obtenerBalance());

        CuentaAhorros cuenta3 = new CuentaAhorros(3, "Pedro Gómez");
        cuenta3.depositar(3000);
        cuenta3.calcularInteresMensual();
        cuenta3.retirar(500);
        System.out.println("Saldo actual de la cuenta 3: $" + cuenta3.obtenerBalance());

        CuentaPlatino cuenta4 = new CuentaPlatino(4, "Luisa Martínez");
        cuenta4.depositar(5000);
        cuenta4.calcularInteresMensual();
        cuenta4.retirar(1000);
        System.out.println("Saldo actual de la cuenta 4 (Platino): $" + cuenta4.obtenerBalance());
    }

}

 class Cuenta {
    protected int numeroCuenta;
    protected String nombreCliente;
    protected double balance;

    public Cuenta(int numeroCuenta, String nombreCliente) {
        this.numeroCuenta = numeroCuenta;
        this.nombreCliente = nombreCliente;
        this.balance = 0.0; 
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            balance += cantidad;
            System.out.println("Depósito de $" + cantidad + " realizado. Nuevo saldo: $" + balance);
        } else {
            System.out.println("Error: La cantidad a depositar debe ser mayor que cero.");
        }
    }
    public void retirar(double cantidad) {
        if (cantidad > 0) {
            if (balance >= cantidad) {
                balance -= cantidad;
                System.out.println("Retiro de $" + cantidad + " realizado. Nuevo saldo: $" + balance);
            } else {
                System.out.println("Error: Fondos insuficientes para realizar el retiro.");
            }
        } else {
            System.out.println("Error: La cantidad a retirar debe ser mayor que cero.");
        }
    }
    public double obtenerBalance() {
        return balance;
    }
}
 class CuentaCheques extends Cuenta {
    public CuentaCheques(int numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
    }    
}

 class CuentaAhorros extends Cuenta {
    private double tasaInteresAnual = 0.05; 

    public CuentaAhorros(int numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
    }

        
    public void calcularInteresMensual() {
        double interes = balance * (tasaInteresAnual / 12); 
        balance += interes;
        System.out.println("Interés mensual de $" + interes + " calculado. Nuevo saldo: $" + balance);
    }
}
class CuentaPlatino extends Cuenta {
    private double tasaInteresAnual = 0.10; 

    public CuentaPlatino(int numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
    }

    
    public void calcularInteresMensual() {
        double interes = balance * (tasaInteresAnual / 12); 
        balance += interes;
        System.out.println("Interés mensual de $" + interes + " calculado. Nuevo saldo: $" + balance);
    }
    
}
