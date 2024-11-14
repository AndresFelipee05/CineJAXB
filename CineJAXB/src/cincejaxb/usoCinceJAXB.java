package cincejaxb;

import java.io.File;

public class usoCinceJAXB {

    public static void main(String[] args) {

        CineJAXB usoCine = new CineJAXB(new File("Cine.xml"));

//        usoCine.mostrarCine();
//        usoCine.mostrarCarterleraIdioma("");
//        usoCine.averagePrice();
//        usoCine.cambiarSala("Odio el verano", 5);
//        usoCine.mostrarCine();
//        usoCine.borrarPelicula("Odio el verano");
//        usoCine.cambiarMayúsculas(true);

        try {
            usoCine.insertaPelicula("Baranova la loca", null, "TP", "castellano", 5.50);
        } catch(java.lang.NullPointerException a){ 
            
        }
        
        usoCine.mostrarCine();
    }

}
