import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Libreria {

    private final String nombre;
    private final Map<Integer, Libro> stockLibros = new TreeMap<Integer, Libro>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    });


    public Libreria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarLibro(Integer id, Libro libro) throws LibreriaExeption {
        if (!stockLibros.containsKey(id)) {
            if (!stockLibros.containsValue(libro)) {
                stockLibros.put(id, libro);
            } else checkLibro(libro);
        } else checkLibroID(id);
    }

    public Boolean checkLibroID(Integer id) throws LibreriaExeption {
        if (stockLibros.containsKey(id)) {
            return true;
        } else throw new LibreriaExeption("Id ya existente");
    }

    public Boolean checkLibro(Libro l) throws LibreriaExeption {
        if (stockLibros.containsValue(l)) {
            return true;
        } else throw new LibreriaExeption("Libro ya asociado a un id");
    }

    public String getListadoDeLibros() {
        return stockLibros.toString();
    }

    public void actualizarStock(Integer id, Integer cantVendida) throws LibreriaExeption {
        if (stockLibros.containsKey(id)) {
            if (stockLibros.get(id).getCantDisponible() >= cantVendida) {
                Integer actual = stockLibros.get(id).getCantDisponible();
                stockLibros.get(id).setCantDisponible(actual - cantVendida);
            } else throw new LibreriaExeption("Stock insuficiente");
        } else throw new LibreriaExeption("Id no existente");
    }

    public Integer solicitarStock(Integer id) throws LibreriaExeption {
        if (stockLibros.get(id) != null) {
            return stockLibros.get(id).getCantDisponible();
        } else throw new LibreriaExeption("id no existente");
    }

    public void eliminarLibro(Integer i) throws LibreriaExeption {
        if (stockLibros.containsKey(i)) {
            stockLibros.remove(i);
        } else throw new LibreriaExeption("Id no existente");
    }

    public Double getPrecioLibroPorId(Integer id) throws LibreriaExeption {

        if (checkLibroID(id)) {
            return stockLibros.get(id).getPrecio();
        }else throw new LibreriaExeption("Libro no existente");
    }
}
