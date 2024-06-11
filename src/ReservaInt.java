
/*
 * 
• RESERVA INTERFACE
•
•
•
•
•
Obtener el cliente, getCliente(): Cliente
Obtener la habitación, getHabitacion(): Habitacion
Obtener las fechas, getFechaInicio(): LocalDate, getFechaFin(): LocalDate
Calcular el costo total, calcularCosto(): double
Cancelar la reserva, cancelarReserva(): void
Modificar la fecha, modificarFechas(fechaInicio: LocalDate, fechaFin: LocalDate):
void
 */

import java.time.LocalDate;

public interface ReservaInt {
    Cliente getCliente();
    HabitacionInt<?> getHabitacion();
    LocalDate getFechaInicio();
    LocalDate getFechaFin();
    double calcularCosto();
    void cancelarReserva();
    void modificarFechas(LocalDate fechaInicio, LocalDate fechaFin);
}
