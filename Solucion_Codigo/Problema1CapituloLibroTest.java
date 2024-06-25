public class Problema1CapituloLibroTest {
    public static void main(String[] args) {        
    }    
}
class CapituloLibro{
   Secciones sec1 = new Secciones();
}
class Secciones{
   ComponenteSecciones compsec1 = new ComponenteSecciones();
}
class ComponenteSecciones{    
}
class Parrafos extends ComponenteSecciones{
   Sentencias sent1 = new Sentencias(); 
}
class Sentencias{
   Palabras pala1 = new Palabras();
}
class Palabras{    
}
class figuras extends ComponenteSecciones{    
}