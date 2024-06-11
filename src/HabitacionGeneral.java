/*
 * Clases abstractas HabitacionGeneral
Se definirá la clase abstracta HabitacionGeneral considerando los subtipos de Comodidad, implementando la interface Habitacion.
 
abstract class HabitacionGeneral<T extends Comodidad> implements Habitacion<T> { protected String tipo;
protected double precio; protected List<T> comodidades;
public HabitacionGeneral(String tipo, double precio, List<T> comodidades){ this.tipo = tipo;
this.precio = precio;
 
this.comodidades = comodidades;
}
// getters y setters
// Métodos abstractos necesarios
 * 
 * 
 * 
 */

import java.time.LocalDate;
import java.util.List;

public abstract class HabitacionGeneral<T extends Comodidad> implements HabitacionInt<T> {
    protected String tipo;
    protected double precio;
    protected List<T> comodidades;

    public HabitacionGeneral(String tipo, double precio, List<T> comodidades) {
        this.tipo = tipo;
        this.precio = precio;
        this.comodidades = comodidades;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public List<T> getComodidades() {
        return comodidades;
    }

    public abstract boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin);
    public abstract double calcularPrecioTotal(LocalDate fechaInicio, LocalDate fechaFin);
}
