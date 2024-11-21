package menujaxb;

import generated.Menu;
import generated.Plato;
import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class MenuJAXB {

    private JAXBContext contexto;
    private Unmarshaller u;
    private Menu platos;
    private List<Plato> lPlatos;
    protected int contador = 1;

    public MenuJAXB(File f) {

        try {
            contexto = JAXBContext.newInstance(Menu.class);

            u = contexto.createUnmarshaller();

            platos = (Menu) u.unmarshal(f);

            lPlatos = platos.getPlato();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public int recorrerMenuYMostrar() {
        Plato pl;
        for (int i = 0; i < lPlatos.size(); i++) {
            pl = lPlatos.get(i);
            System.out.println("Plato nº: " + contador + ": " + pl.getNombre());
            System.out.println("Descripcion: " + pl.getDescripcion());
            System.out.println("Precio: " + pl.getPrecio());
            System.out.print("Calorias: " + pl.getCalorias());
            System.out.println("\n-------------");
            contador++;
        }
        return 0;
    }

    public int borrarPlato(String nombrePlato) {
        boolean encontrado = false;

        Plato pl;
        for (int i = 0; i < lPlatos.size(); i++) {
            pl = lPlatos.get(i);
            if (nombrePlato.equals(pl.getNombre())) {
                lPlatos.remove(i);
                System.out.println("Plato eliminado correctamente");
                encontrado = true;
                return 0;
            }
        }

        if (!encontrado) {
            System.out.println("El plato " + nombrePlato + " no existe");
            return -1;
        }
        return 0;
    }

    public int insertarPlato(String nombre, String precio, String descripcion, int calorias) {

        Plato plato1 = new Plato();

        plato1.setNombre(nombre);
        plato1.setPrecio(precio);
        plato1.setDescripcion(descripcion);
        plato1.setCalorias(calorias);

        lPlatos.add(plato1);
        System.out.println("Se ha introducido el plato correctamente");

        return 0;
    }

    public int buscarPlatoContiene(String buscado) {
        Plato pl;
        int contador = 0;

        for (int i = 0; i < lPlatos.size(); i++) {
            pl = lPlatos.get(i);

            if (pl.getNombre().contains(buscado) || pl.getNombre().contains(buscado)) {
                System.out.println("Nombre: " + pl.getNombre());
                System.out.print("Descripcion: " + pl.getDescripcion());
                System.out.println("\n------------------------------------------");
                contador++;
            }
        }

        System.out.println("Numero total de platos que contienen: " + buscado + " es: " + contador);
        return 0;
    }

    public void incrementarPrecios(int incremento) {
        Plato pl;

        for (int i = 0; i < lPlatos.size(); i++) {
            pl = lPlatos.get(i);

            // Para eliminar el $.
            String precioSinDolar = pl.getPrecio().replace("$", "");
            double precioDouble = Double.parseDouble(precioSinDolar);

            double precioIncrementado = (precioDouble * incremento) / 100 + precioDouble;
            String precioFormateado = String.format("%.2f", precioIncrementado);

            System.out.println("Plato: " + pl.getNombre() + ", precio original: " + pl.getPrecio() + ", precio incrementado: " + "$" + precioFormateado);
            pl.setPrecio("$" + precioFormateado);
        }
        
        System.out.println("");
    }

    public void platosMenosCalorias(int limiteCalorias) {
        Plato pl;
        boolean valido = false;

        for (int i = 0; i < lPlatos.size(); i++) {
            pl = lPlatos.get(i);

            if (pl.getCalorias() <= limiteCalorias) {
                System.out.println("Plato: " + pl.getNombre() + ", calorias: " + pl.getCalorias());
                valido = true;
            }
        }

        if (!valido) {
            System.out.println("Lo sentimos, no tenemos platos con menos de esas calorias");
        }
    }

    public void platoConIVA() {
        Plato pl;
        for (int i = 0; i < lPlatos.size(); i++) {
            pl = lPlatos.get(i);

            String precioSinDolar = pl.getPrecio().replace("$", "");
            double precioDouble = Double.parseDouble(precioSinDolar);

            double precioConIVA = (precioDouble * 10) / 100 + precioDouble;
            String precioFormateado = String.format("%.2f", precioConIVA);

            System.out.println("Plato: " + pl.getNombre() + ", precio original: " + pl.getPrecio() + ", precio con IVA: " + precioFormateado + "$");
        }
    }
}
