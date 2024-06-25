
import java.util.ArrayList;
import java.util.Arrays;
public class Problema4_NominaTrabajadores {
    public static void main(String[] args) {
        Jefe jefe1 = new Jefe("Luis ", "Alejo", "asdfasd", 34242342, 1232);
        ArrayList <Trabajador> trabajadores = new ArrayList(Arrays.asList(
                new FijosMensual(1000, "Luis", "Solano", "24 de Mayo", 3423453,jefe1),
                new Comisionario(13, 13.5, "Sebastian", "Solano", "centro", 34545, jefe1),
                new PorHora(15, 12.5 , 5.4, "Luis", "Sebastian", "centro", 656564, jefe1)
        ));
        
        for (Trabajador trabajador : trabajadores) {
            trabajador.calcularSueldo();
            System.out.println(trabajador);
        }
    }
}
class Jefe {
    public String nombre;
    public String apellidos;
    public String direccion;
    public int dni;
    public double salario;

    public Jefe(String nombre, String apellidos, String direccion, int dni, double salario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.dni = dni;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Jefe{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", dni=" + dni + ", salario=" + salario + '}';
    }
    
}

abstract class Trabajador {

    public String nombre;
    public String apellidos;
    public String direccion;
    public int dni;
    public Jefe jefe;

    public Trabajador(String nombre, String apellidos, String direccion, int dni, Jefe jefe) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.dni = dni;
        this.jefe = jefe;
    }

    public abstract void calcularSueldo();

    @Override
    public String toString() {
        return "Trabajador{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", dni=" + dni + ", jefe=" + jefe + '}';
    }
    
}

class FijosMensual extends Trabajador {

    public double salarioMensual;

    public FijosMensual(double salarioMensual, String nombre, String apellidos, String direccion, int dni, Jefe jefe) {
        super(nombre, apellidos, direccion, dni, jefe);
        this.salarioMensual = salarioMensual;
    }

    @Override
    public void calcularSueldo() {
        this.salarioMensual /= 30;
    }

    @Override
    public String toString() {
        return "FijoMensual{" +super.toString()+ "salarioMensual=" + salarioMensual + '}';
    }
    
}

class Comisionario extends Trabajador {

    public int ventasRealizadas;
    public double porcentajeComision;
    public double salario;

    public Comisionario(int ventasRealizadas, double porcentajeComision, String nombre, String apellidos, String direccion, int dni, Jefe jefe) {
        super(nombre, apellidos, direccion, dni, jefe);
        this.ventasRealizadas = ventasRealizadas;
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public void calcularSueldo() {
        this.salario = ventasRealizadas * porcentajeComision;
    }

    @Override
    public String toString() {
        return "Comisionista{" +super.toString()+ "ventasRealizadas=" + ventasRealizadas + ", porcentajeComision=" + porcentajeComision + ", salario=" + salario + '}';
    }
    
}

class PorHora extends Trabajador {

    public double numHoras;
    public double tarifaHora;
    public double numHorasExtras;
    public double salario;

    public PorHora(int numHoras, double tarifaHora, double numHorasExtras, String nombre, String apellidos, String direccion, int dni, Jefe jefe) {
        super(nombre, apellidos, direccion, dni, jefe);
        this.numHoras = numHoras;
        this.tarifaHora = tarifaHora;
        this.numHorasExtras = numHorasExtras;
    }

    @Override
    public void calcularSueldo() {
        this.salario = (numHoras + numHorasExtras) * tarifaHora;
    }
    @Override
    public String toString() {
        return "PorHoras{" +super.toString()+ "numHoras=" + numHoras + ", tarifaHora=" + tarifaHora + ", numHorasExtras=" + numHorasExtras + ", salario=" + salario + '}';
    }
    
}
