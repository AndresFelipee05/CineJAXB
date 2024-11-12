package cincejaxb;

import java.io.File;

public class usoCinceJAXB {

    public static void main(String[] args) {
        
        CineJAXB usoCine = new CineJAXB(new File("Cine.xml"));
        
        usoCine.mostrarCine();
    }
    
}
