public class Problema3_EnvioMensajes {
    public static void main(String[] args) {
        Movil movil1 = new Movil(123456789, "Alice");
        Movil movil2 = new Movil(987654321, "Bob");
        
        SMS mensajeTexto = new SMS(movil1, movil2, "¡Hola Bob! ¿Cómo estás?");
        MMS mensajeImagen = new MMS(movil2, movil1, "foto_de_vacaciones.jpg");
        System.out.println(mensajeTexto);
        System.out.println(mensajeImagen);
    }  
}
class Movil {
    public int numero;
    public String nombre;

    public Movil(int numeroMovil, String nombre) {
        this.numero = numeroMovil;
        this.nombre = nombre;
    }
}

abstract class Mensaje {
    protected Movil remitente;
    protected Movil destinatario;

    public Mensaje(Movil remitente, Movil destinatario) {
        this.remitente = remitente;
        this.destinatario = destinatario;
    }

    public void enviarMensaje(){ 
    };
    public abstract String visualizarMensaje();
}


class SMS extends Mensaje {
    private String texto;

    public SMS(Movil remitente, Movil destinatario, String texto) {
        super(remitente, destinatario);
        this.texto = texto;
    }

    @Override
    public String visualizarMensaje() {
        return texto;
    }

    @Override
    public String toString() {
        return "SMS{" + "texto=" + texto + '}';
    }
    
}

class MMS extends Mensaje {
    private String nombreFicheroImagen;

    public MMS(Movil remitente, Movil destinatario, String nombreFicheroImagen) {
        super(remitente, destinatario);
        this.nombreFicheroImagen = nombreFicheroImagen;
    }

    @Override
    public String visualizarMensaje() {
        return nombreFicheroImagen;
    }

    @Override
    public String toString() {
        return "MMS{" + "nombreFicheroImagen=" + nombreFicheroImagen + '}';
    }
    
}