public class Libro extends Producto {

    private final Integer cantPaginas;

    public Libro(String nombre, Integer cantDisponible, Double precio, Integer cantPaginas) throws InvalidParametrExeption {
        super(nombre, cantDisponible, precio);
        this.cantPaginas = cantPaginas;
    }

    public Integer getCantPaginas() {
        return cantPaginas;
    }


}
