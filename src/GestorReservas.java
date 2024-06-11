/* CLASS GESTORRESERVAS
 * Se encarga de las operaciones relacionadas con las reservas y su costo, esta cuenta con
la siguiente estructura de clase.
class GestorReservas {
private List<Reserva> reservas;
// Constructor que instancia la lista de reservas vacía
}
void realizarReserva(Cliente cliente, Habitacion hab, fechaInicio y fechaFin LocalDate);
void cancelarReserva(Reserva reserva);
void modificarReserva(Reserva reserva, fechaInicio y fechaFin LocalDate);
double calcCostoReserva(Reserva reserva);
Nota: Los métodos cancelarReserva y modificarReserva trabajarán con los métodos implementados en
Reserva que la interface nos solicitó.
 * 
 */


import java.time.LocalDate;

public class GestorReservas {
    public boolean realizarReserva(Cliente cliente, HabitacionInt<?> habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        Reserva reserva = new Reserva(cliente, habitacion, fechaInicio, fechaFin);
        if (App.getGestor().agregarReserva(reserva)) {
            cliente.acumularPuntos(reserva);
            return true;
        }
        return false;
    }
}
