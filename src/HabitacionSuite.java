/*
 * 
 * HabitacionSuite
class HabitacionSuite extends HabitacionGeneral<ComodidadPremium>
 * 
 */


import java.time.LocalDate;
import java.util.List;

public class HabitacionSuite extends HabitacionGeneral<ComodidadPremium> {
    public HabitacionSuite(String tipo, double precio, List<ComodidadPremium> comodidades) {
        super(tipo, precio, comodidades);
    }

    /*
     * La habitación estará disponible si hay menos de 5 reservas dentro del rango, y se quedará al menos 3 noches
     */
    @Override
    public boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin) {
        int cantReservas = App.getGestor().contarReservas(this, fechaInicio, fechaFin);
        long dias = fechaInicio.until(fechaFin).getDays();
        return cantReservas < 5 && dias >= 3;
    }
 /*
  * Si la estancia es mayor a 5 noches, se aplica un descuento del 15% sobre el precio total.
  */
    @Override
    public double calcularPrecioTotal(LocalDate fechaInicio, LocalDate fechaFin) {
        double costoTotal = precio;
        long dias = fechaInicio.until(fechaFin).getDays();
        System.out.println("comodidad de Habitacion Suite contratada: ");
        for (ComodidadPremium comodidad : comodidades) {
            
            costoTotal += comodidad.calcularCosto(fechaInicio, fechaFin);
            System.out.print(" " + comodidad.getNombre()+ ", ");
        }
        if (dias > 5) {
            costoTotal *= 0.85; // 15% de descuento
        }
        return costoTotal;
    }
}
