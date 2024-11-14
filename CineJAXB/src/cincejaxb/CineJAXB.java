package cincejaxb;

import generated.Cine;
import generated.Pelicula;
import java.io.File;
import java.math.BigDecimal;
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
        System.out.println("Numero de peliculas:" + lPeliculas.size() + "\n");
        //Extraemos la información con los métodos de la clase Libro y la mostramos
        // Usaremos la variable lib para recorrer la lista de objetos Libro
        Pelicula peli;
        for (int i = 0; i < lPeliculas.size(); i++) {
            peli = lPeliculas.get(i);//asignamos a l el valor del libro en la lista
            System.out.println("Titulo: " + peli.getTitulo());
            System.out.println("Calificacion: " + peli.getCalificacion());
            System.out.println("Precio: " + peli.getPrecio());
            System.out.println("Sala: " + peli.getSala());
            System.out.println("Idioma: " + peli.getIdioma() + "\n-------------");
        }
    }

    public void mostrarCarterleraIdioma(String idiomaBuscar) {
        boolean encontrado = false;

        if (idiomaBuscar == null) {
            System.out.println("Idioma no valido");
            return;
        }

        Pelicula pl;

        if (idiomaBuscar.isEmpty()) {
            System.out.println("Debes de introducir un idioma");
            encontrado = true;
        } else {
            System.out.println("Las peliculas en " + idiomaBuscar + " son:");
        }

        for (int i = 0; i < lPeliculas.size(); i++) {
            pl = lPeliculas.get(i);
            if (idiomaBuscar.equals(pl.getIdioma())) {
                if (idiomaBuscar != null) {
                    encontrado = true;
                    System.out.println("Titulo: " + pl.getTitulo());
                    System.out.println("Calificacion: " + pl.getCalificacion());
                    System.out.println("Precio: " + pl.getPrecio());
                    System.out.println("Sala: " + pl.getSala());
                    System.out.println("Idioma: " + pl.getIdioma() + "\n-------------");
                }
            }
        }
        if (!encontrado) {
            System.out.println("Lo sentimos, no tenemos peliculas con ese idioma");
        }
    }

    public int insertaPelicula(String titulo, Integer sala, String calificacion, String idioma, double precio) {
        Pelicula pl;

        if (sala != null) {
            for (int i = 0; i < lPeliculas.size(); i++) {
                pl = lPeliculas.get(i);
                if (sala.equals(pl.getSala())) {
                    System.out.println("La sala está ocupada, no se puede introducir la pelicula");
                    return -2;
                }
            }
        }
        
        Pelicula peli1 = new Pelicula();

        peli1.setTitulo(titulo);
        if (sala != null && sala > 0) {
            peli1.setSala(sala);
        }

        peli1.setCalificacion(calificacion);
        peli1.setIdioma(idioma);

        //Para pasar de double a BigDecimal
        BigDecimal precioBigDecimal = BigDecimal.valueOf(precio);
        peli1.setPrecio(precioBigDecimal);
        lPeliculas.add(peli1);

        System.out.println("Se insertado correctamente la pelicula");

        return 0;
    }

    public double averagePrice() {
        Pelicula pl;
        double total = 0.0;

        for (int i = 0; i < lPeliculas.size(); i++) {
            pl = lPeliculas.get(i);
            if (pl.getPrecio().equals(pl.getPrecio())) {

                total += pl.getPrecio().doubleValue();
            }
        }
        System.out.println("Precio medio de las peliculas: " + total + "$");
        return total;
    }

    public int cambiarSala(String titulo, Integer nuevaSala) {
        boolean encontrado = false;

        if (titulo.isEmpty()) {
            System.out.println("Debes de introducir un titulo");
            return -1;
        }

        if (nuevaSala == null) {
            System.out.println("Sala no válida, no se harán cambios");
            return -3;
        }

        Pelicula pl;

        for (int i = 0; i < lPeliculas.size(); i++) {
            pl = lPeliculas.get(i);
            if (nuevaSala.equals(pl.getSala())) {
                System.out.println("La sala está ocupada, no se harán cambios");
                return -2;
            }
        }

        for (int i = 0; i < lPeliculas.size(); i++) {
            pl = lPeliculas.get(i);
            if (titulo.equals(pl.getTitulo())) {
                encontrado = true;

                if (nuevaSala.equals(pl.getSala())) {
                    System.out.println("La sala en la que estás es la misma que a la que quieres cambiar, no se harán cambios");
                    return 1;
                }

                pl.setSala(nuevaSala);
                System.out.println("La sala se ha cambiado correctamente");

                return 0;
            }
        }

        if (!encontrado) {
            System.out.println("No existe ninguna pelicula con ese titulo");
            return -3;
        }
        return 0;
    }

    public int borrarPelicula(String titulo) {
        boolean encontrado = false;
        if (titulo.isEmpty()) {
            System.out.println("El titulo está vacío");
            return -1;
        }

        Pelicula pl;
        for (int i = 0; i < lPeliculas.size(); i++) {
            pl = lPeliculas.get(i);

            if (titulo.equals(pl.getTitulo())) {
                encontrado = true;
                lPeliculas.remove(i);
                System.out.println("Pelicula eliminada");
                return 0;
            }
        }

        if (!encontrado) {
            System.out.println("La pelicula no existe");
            return 1;
        }
        return 0;
    }

    public int cambiarMayúsculas(boolean modo) {
        Pelicula pl;
        if (modo == true) {
            System.out.println("Titulos de las peliculas en mayúscula:");
            for (int i = 0; i < lPeliculas.size(); i++) {
                pl = lPeliculas.get(i);
                System.out.println("Titulo:" + pl.getTitulo().toUpperCase());
            }
        }

        if (modo == false) {
            System.out.println("Titulos de las peliculas en minúscula:");
            for (int i = 0; i < lPeliculas.size(); i++) {
                pl = lPeliculas.get(i);
                System.out.println("Titulo:" + pl.getTitulo().toLowerCase());
            }
        }
        return 0;
    }
}
