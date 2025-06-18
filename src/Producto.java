public abstract class Producto implements Vendible {

    private final String nombre;
    private Integer cantDisponible;
    private Double precio;

    public Producto(String nombre, Integer cantDisponible, Double precio) throws InvalidParametrExeption {
        this.nombre = nombre;

        if (cantDisponible > 0) {
            this.cantDisponible = cantDisponible;
        } else throw new InvalidParametrExeption();

        this.precio = validation(precio);
    }

    protected String getNombre() {
        return nombre;
    }

    protected Integer getCantDisponible() {
        return cantDisponible;
    }

    protected Double getPrecio() {
        return precio;
    }

    public void setCantDisponible(Integer cantDisponible) {
        this.cantDisponible = cantDisponible;
    }

    protected void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void actualizarCantidad(Integer cantVendida) throws InvalidParametrExeption {
        if (cantVendida > this.cantDisponible || cantVendida <= 0) {
            throw new InvalidParametrExeption();
        } else this.cantDisponible = this.cantDisponible - cantVendida;

    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre= '" + nombre + '\'' +
                ", cantDisponible= " + cantDisponible +
                ", precio= " + precio +
                '}';
    }

    @Override
    public Double validation(Double nro) throws InvalidParametrExeption {
        if (nro > 0.0) {
            return nro;
        } else throw new InvalidParametrExeption();
    }
}
