import java.time.LocalDate;
import java.util.List;

public class GestorDisponibilidad {
    private List<HabitacionGeneral<? extends Comodidad>> habitaciones;
    private List<Reserva> reservas;

    public GestorDisponibilidad(List<HabitacionGeneral<? extends Comodidad>> habitaciones, List<Reserva> reservas) {
        this.habitaciones = habitaciones;
        this.reservas = reservas;
    }

    public int contarReservas(HabitacionGeneral<?> habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        int count = 0;
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().equals(habitacion) && 
                reserva.getFechaInicio().isBefore(fechaFin) && 
                reserva.getFechaFin().isAfter(fechaInicio)) {
                count++;
            }
        }
        return count;
    }

    public boolean agregarReserva(Reserva reserva) {
        if (reserva.getHabitacion().estaDisponible(reserva.getFechaInicio(), reserva.getFechaFin())) {
            reservas.add(reserva);
            return true;
        }
        return false;
    }
}
