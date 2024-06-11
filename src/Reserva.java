/*
 * Clase Reserva
Recordemos la info de la interface de Reserva.
•
Obtener el cliente, getCliente(): Cliente
•
Obtener la habitación, getHabitacion(): Habitacion
•
Obtener las fechas, getFechaInicio(): LocalDate, getFechaFin(): LocalDate
•
Calcular el costo total, calcularCosto(): double
•
Cancelar la reserva, cancelarReserva(): void
•
Modificar la fecha, modificarFechas(fechaInicio: LocalDate, fechaFin: LocalDate):
void
La clase Reserva necesita la siguiente información:
•
•
•
Cliente
Habitacion
Fecha de inicio y fecha de fin
Recordemos que estos objetos serán gestionados por la clase GestorReservas.
 * 
 * 
 */



import java.time.LocalDate;

public class Reserva implements ReservaInt {
    private Cliente cliente;
    private HabitacionInt<?> habitacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Reserva(Cliente cliente, HabitacionInt<?> habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    @Override
    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public HabitacionInt<?> getHabitacion() {
        return habitacion;
    }

    @Override
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    @Override
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    @Override
    public double calcularCosto() {
        return habitacion.calcularPrecioTotal(fechaInicio, fechaFin);
    }

    @Override
    public void cancelarReserva() {
        // TODO: implementar cancelarReserva()
        }

    @Override
    public void modificarFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
}
