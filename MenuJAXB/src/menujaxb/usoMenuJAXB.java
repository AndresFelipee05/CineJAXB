package menujaxb;

import java.io.File;

public class usoMenuJAXB {

    public static void main(String[] args) {

        MenuJAXB usoMenu = new MenuJAXB(new File("Menu.xml"));
        
        // 1. Mostrar
        // usoMenu.recorrerMenuYMostrar();
        
        // 2. Borrar plato
        // usoMenu.borrarPlato("Gofres de nata");
        // usoMenu.recorrerMenuYMostrar();
        
        //3. Insertar plato
        // usoMenu.insertarPlato("Creep de chocolate", "5.50", "Creep con chocolate fundido y azucar glass", 500);
        // usoMenu.recorrerMenuYMostrar();
        
        // 4. Buscar plato que contiene
        //usoMenu.buscarPlatoContiene("Gofre");
        
        // 5. Incrementar precio
        usoMenu.incrementarPrecios(15);
        usoMenu.recorrerMenuYMostrar();

        // 6. Mostrar el plato con menos calorías.
        //usoMenu.platosMenosCalorias(500);
        
        // 7. Cambiar atributos.
        
        
        // 8. Precio con IVA.
        //usoMenu.platoConIVA();
        

    }

}
