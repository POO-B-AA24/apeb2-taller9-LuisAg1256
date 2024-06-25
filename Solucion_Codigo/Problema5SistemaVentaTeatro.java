public class Problema5SistemaVentaTeatro {
    public static void main(String[] args) {
        Zona principal = new Zona("Principal", 200, 25.0, 17.5);
        Zona palcoB = new Zona("PalcoB", 40, 70.0, 40.0);
        Zona central = new Zona("Central", 400, 20.0, 14.0);
        Zona lateral = new Zona("Lateral", 100, 15.5, 10.0);

        principal.venderEntrada("Juan Pérez", "normal");
        palcoB.venderEntrada("María López", "abonado");
        central.venderEntrada("Pedro Gómez", "reducida");

        System.out.println("Estado de las zonas después de las ventas:");
        System.out.println(principal);
        System.out.println(palcoB);
        System.out.println(central);
        System.out.println(lateral);
    }
}

class Zona {
    public String nombre;
    public int capacidad;
    public double precioNormal;
    public double precioAbonado;

    public Zona(String nombre, int capacidad, double precioNormal, double precioAbonado) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precioNormal = precioNormal;
        this.precioAbonado = precioAbonado;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean hayLocalidadesDisponibles() {
        return capacidad > 0;
    }

    public void venderEntrada(String nombreComprador, String tipoEntrada) {
        if (!hayLocalidadesDisponibles()) {
            System.out.println("No hay localidades disponibles en la zona " + nombre);
            return;
        }

        Entrada entrada = null;
        switch (tipoEntrada.toLowerCase()) {
            case "normal":
                entrada = new EntradaNormal(this, nombreComprador);
                break;
            case "abonado":
                entrada = new EntradaAbonada(this, nombreComprador);
                break;
            case "reducida":
                entrada = new EntradaReducida(this, nombreComprador);
                break;
            default:
                System.out.println("Tipo de entrada no válido.");
                return;
        }

        if (entrada != null) {
            capacidad--;
            System.out.println("Entrada vendida correctamente:");
            System.out.println(entrada);
        }
    }

    @Override
    public String toString() {
        return "Zona{" +
                "nombre='" + nombre + '\'' +
                ", capacidad=" + capacidad +
                ", precioNormal=" + precioNormal +
                ", precioAbonado=" + precioAbonado +
                '}';
    }
}

class Entrada {
    protected Zona zona;
    protected int id;
    protected String nombreComprador;
    protected double precio;

    public Entrada(Zona zona, String nombreComprador) {
        this.zona = zona;
        this.nombreComprador = nombreComprador;
        this.id = -1; 
        this.precio = 0.0; 
    }

    public void calcularPrecioEntrada() {
        
    }

    @Override
    public String toString() {
        return "Entrada{" +
                "id=" + id +
                ", zona=" + zona.getNombre() +
                ", nombreComprador='" + nombreComprador + '\'' +
                ", precio=" + precio +
                '}';
    }
}

class EntradaNormal extends Entrada {
    public EntradaNormal(Zona zona, String nombreComprador) {
        super(zona, nombreComprador);
        calcularPrecioEntrada();
    }

    @Override
    public void calcularPrecioEntrada() {
        this.precio = zona.precioNormal;
    }
}

class EntradaReducida extends Entrada {
    public EntradaReducida(Zona zona, String nombreComprador) {
        super(zona, nombreComprador);
        calcularPrecioEntrada();
    }

    @Override
    public void calcularPrecioEntrada() {
        this.precio = zona.precioNormal * 0.85; 
    }
}

class EntradaAbonada extends Entrada {
    public EntradaAbonada(Zona zona, String nombreComprador) {
        super(zona, nombreComprador);
        calcularPrecioEntrada();
    }

    @Override
    public void calcularPrecioEntrada() {
        this.precio = zona.precioAbonado;
    }
}

