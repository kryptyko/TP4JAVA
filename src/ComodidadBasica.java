/* COMODIDAD BASICA
 * Recordemos lo que tenemos en la clase abstracta Comodidad.
abstract class Comodidad {
protected String nombre;
protected double precio;
// getters y setters
public abstract double calcularCosto(LocalDate fechaInicio, LocalDate fechaFin);
}
 * 
 * 
 */


import java.time.LocalDate;

public class ComodidadBasica extends Comodidad {
    public ComodidadBasica(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public double calcularCosto(LocalDate fechaInicio, LocalDate fechaFin) {
        long dias = fechaInicio.until(fechaFin).getDays();
        return dias * precio;
    }
}
