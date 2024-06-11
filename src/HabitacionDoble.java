/*
 *CLASS  HabitacionDoble
class HabitacionDoble extends HabitacionGeneral<ComodidadDoble>
 * 
 */

import java.time.LocalDate;
import java.util.List;

public class HabitacionDoble extends HabitacionGeneral<ComodidadBasica> {
    public HabitacionDoble(String tipo, double precio, List<ComodidadBasica> comodidades) {
        super(tipo, precio, comodidades);
    }


    /*
     * La habitación estará disponible si no hay reservas para dichas fechas, y se quedarán al menos 2 noches
     */
    @Override
    public boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin) {
        int cantReservas = App.getGestor().contarReservas(this, fechaInicio, fechaFin);
        return cantReservas == 0;
    }

    /*
     * Si se queda más de 3 noches, se aplica un 10% de descuento sobre el precio total 
     */
    @Override
    public double calcularPrecioTotal(LocalDate fechaInicio, LocalDate fechaFin) {
        double costoTotal = precio;
        long dias = fechaInicio.until(fechaFin).getDays();
        System.out.print("Comodidad doble contratada: ");
        for (ComodidadBasica comodidad : comodidades) {
            System.out.print(" " + comodidad.getNombre()+ ", ");
            costoTotal += comodidad.calcularCosto(fechaInicio, fechaFin);
        }
        if (dias > 3) {
            costoTotal *= 0.9; // 10% de descuento
        }
        return costoTotal;
    }
}
