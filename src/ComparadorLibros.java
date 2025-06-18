import java.util.Comparator;

public class ComparadorLibros implements Comparator<Libro> {
    @Override
    public int compare(Libro o1, Libro o2) {
        return o1.getCantDisponible().compareTo(o2.getCantDisponible());
    }

    @Override
    public Comparator<Libro> reversed() {
        return Comparator.super.reversed();
    }
}
