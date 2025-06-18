import org.junit.Assert;
import org.junit.Test;

public class LibreriaV2Test {
    @Test
    public void crearLibroValidoTest() throws InvalidParametrExeption {
        Libro l1 = new Libro("Moby Dick", 10, 250.0, 200);

        Assert.assertEquals(Integer.valueOf(200), l1.getCantPaginas());
    }

    @Test(expected = InvalidParametrExeption.class)
    public void crearLibroInvalidoTest() throws InvalidParametrExeption {
        Libro l1 = new Libro("Moby Dick", 10, -250.0, 200);

        Assert.assertEquals(Integer.valueOf(200), l1.getCantPaginas());
    }

    @Test
    public void CrearLibreriaTest() {
        Libreria libreria = new Libreria("Israel");
        Assert.assertEquals("Israel", libreria.getNombre());
    }

    @Test
    public void agregarLibroNuevoAlInventarioStock() throws InvalidParametrExeption, LibreriaExeption {
        Libro l1 = new Libro("Moby Dick", 10, 250.0, 200);
        Libreria libreria = new Libreria("Israel");

        libreria.agregarLibro(1, l1);

        Assert.assertEquals("{1=Producto{nombre= 'Moby Dick', cantDisponible= 10, precio= 250.0}}", libreria.getListadoDeLibros());
    }

    @Test
    public void actualizarStockLibroTest() throws InvalidParametrExeption, LibreriaExeption {
        Libro l1 = new Libro("Moby Dick", 10, 250.0, 200);
        Libreria libreria = new Libreria("Israel");

        libreria.agregarLibro(1, l1);
        libreria.actualizarStock(1, 5);

        Assert.assertEquals("{1=Producto{nombre= 'Moby Dick', cantDisponible= 5, precio= 250.0}}", libreria.getListadoDeLibros());
    }

    @Test
    public void solicitarStockLibroTest() throws InvalidParametrExeption, LibreriaExeption {
        Libro l1 = new Libro("Moby Dick", 10, 250.0, 200);
        Libreria libreria = new Libreria("Israel");

        libreria.agregarLibro(1, l1);
        libreria.actualizarStock(1, 5);


        Assert.assertEquals(Integer.valueOf(5), libreria.solicitarStock(1));
    }

    @Test(expected = LibreriaExeption.class)
    public void solicitarStockIdInvalidoTest() throws InvalidParametrExeption, LibreriaExeption {
        Libro l1 = new Libro("Moby Dick", 10, 250.0, 200);
        Libreria libreria = new Libreria("Israel");

        libreria.agregarLibro(1, l1);
        libreria.actualizarStock(1, 5);


        Assert.assertEquals(Integer.valueOf(5), libreria.solicitarStock(18));
    }

    @Test
    public void eliminarLibroDeInventarioTest() throws InvalidParametrExeption, LibreriaExeption {
        Libro l1 = new Libro("Moby Dick", 10, 250.0, 200);
        Libro l2 = new Libro("El Talisman", 10, 210.0, 350);
        Libreria libreria = new Libreria("Israel");

        libreria.agregarLibro(1, l1);
        libreria.agregarLibro(5, l2);

        libreria.actualizarStock(1, 5);
        libreria.eliminarLibro(1);

        Assert.assertEquals("{5=Producto{nombre= 'El Talisman', cantDisponible= 10, precio= 210.0}}", libreria.getListadoDeLibros());
    }

    @Test(expected = LibreriaExeption.class)
    public void eliminarLibroInexistenteDeInventarioTest() throws InvalidParametrExeption, LibreriaExeption {
        Libro l1 = new Libro("Moby Dick", 10, 250.0, 200);
        Libro l2 = new Libro("El Talisman", 10, 210.0, 350);
        Libro l3 = new Libro("Corazones en la Atlantida", 13, 180.0, 550);
        Libro l4 = new Libro("The Economist", 1, 780.0, 450);
        Libro l5 = new Libro("El arte de la guerra", 25, 340.0, 150);
        Libreria libreria = new Libreria("Israel");

        libreria.agregarLibro(1, l1);
        libreria.agregarLibro(5, l2);
        libreria.agregarLibro(6, l3);
        libreria.agregarLibro(10, l4);
        libreria.agregarLibro(58, l5);

        libreria.actualizarStock(1, 5);
        libreria.eliminarLibro(1);
        libreria.eliminarLibro(1);

        Assert.assertEquals("{5=Producto{nombre= 'El Talisman', cantDisponible= 10, precio= 210.0}}", libreria.getListadoDeLibros());
    }

    @Test
    public void solicitarPrecio() throws LibreriaExeption, InvalidParametrExeption {

        Libro l1 = new Libro("Moby Dick", 10, 250.0, 200);
        Libro l2 = new Libro("El Talisman", 10, 210.0, 350);
        Libro l3 = new Libro("Corazones en la Atlantida", 13, 180.0, 550);
        Libro l4 = new Libro("The Economist", 1, 780.0, 450);
        Libro l5 = new Libro("El arte de la guerra", 25, 340.0, 150);
        Libreria libreria = new Libreria("Israel");

        libreria.agregarLibro(1, l1);
        libreria.agregarLibro(5, l2);
        libreria.agregarLibro(6, l3);
        libreria.agregarLibro(10, l4);
        libreria.agregarLibro(58, l5);

        libreria.actualizarStock(1, 5);
        libreria.eliminarLibro(1);

        Double precio = libreria.getPrecioLibroPorId(6);
        Assert.assertEquals(Double.valueOf(180),precio);
    }

}

//Se desea construir un sistema simple de gestión de stock para una tienda de libros.
// Cada libro tiene un nombre (String) y un stock (cantidad disponible, Integer).
// El sistema debe permitir:
// 1. Agregar un libro nuevo al inventario con su cantidad inicial.
// 2. Actualizar el stock de un libro existente (sumar o restar cantidad).
// 3. Consultar la cantidad disponible de un libro.
// 4. Eliminar un libro del inventario.
// 5. Verificar si un libro está disponible (stock > 0).
// 6. (Extra) Obtener todos los libros disponibles (stock > 0).