/*
 * CLASS HabitacionSimple
class HabitacionSimple extends HabitacionGeneral<ComodidadBasica>
 * 
 */

import java.time.LocalDate;
import java.util.List;

public class HabitacionSimple extends HabitacionGeneral<ComodidadBasica> {
    public HabitacionSimple(String tipo, double precio, List<ComodidadBasica> comodidades) {
        super(tipo, precio, comodidades);
    }

    /*
     * habitación estará disponible si hay menos de 4 reservas dentro del rango de fechas
     */
    @Override
    public boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin) {
        int cantReservas = App.getGestor().contarReservas(this, fechaInicio, fechaFin);
        return cantReservas < 4;
    }

    /*
     * Se calcula el precio total sumando el precio de la habitación y el costo de las comodidades 
     *      
     */
    @Override
    public double calcularPrecioTotal(LocalDate fechaInicio, LocalDate fechaFin) {
        double costoTotal = precio;
        //System.out.print("Comodidad simple contratada: ");   
        for (ComodidadBasica comodidad : comodidades) {
          //  System.out.print(" " + comodidad.getNombre()+ ", ");
            costoTotal += comodidad.calcularCosto(fechaInicio, fechaFin);
        }
        return costoTotal;
    }
}
