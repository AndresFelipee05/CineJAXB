package cincejaxb;

import generated.Cine;
import generated.Pelicula;
import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class CineJAXB {

    private JAXBContext contexto;
    private Unmarshaller u;
    private Cine pelis;
    private List<Pelicula> lPeliculas;

    public CineJAXB(File f) {

        try {
            contexto = JAXBContext.newInstance(Cine.class);

            u = contexto.createUnmarshaller();
            
            pelis = (Cine) u.unmarshal(f);

            lPeliculas = pelis.getPelicula();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    
    public void mostrarCine() {
        System.out.println("Numero de libros:" + lPeliculas.size() + "\n");
        //Extraemos la información con los métodos de la clase Libro y la mostramos
        // Usaremos la variable lib para recorrer la lista de objetos Libro
        Pelicula peli;
        for (int i = 0; i < lPeliculas.size(); i++) {
            peli = lPeliculas.get(i);//asignamos a l el valor del libro en la lista
            System.out.println("Titulo: " + peli.getTitulo());
            System.out.println("Calificacion: " + peli.getCalificacion());
            System.out.println("Precio: " + peli.getPrecio());  
            System.out.println("Sala: " + peli.getSala());
            System.out.println("Idioma: " + peli.getIdioma()+ "\n-------------");
        }
    }
    
    public void mostrarCarterleraIdioma(String idioma){
        if(idioma == null){
            System.out.println("Idioma no valido");
            return;
        }
        
        Pelicula peli;
        if(idioma.equals(peli)){
            
        }
        
    }
}
