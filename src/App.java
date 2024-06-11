import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static GestorDisponibilidad gestorDisp;

    public static void main(String[] args) {
        List<HabitacionGeneral<? extends Comodidad>> habitaciones = new ArrayList<>();
        List<Reserva> reservas = new ArrayList<>();
        gestorDisp = new GestorDisponibilidad(habitaciones, reservas);

        GestorReservas gestorReservas = new GestorReservas();

        // Crear instancias de habitaciones
        List<ComodidadBasica> comodidadesBasicas = new ArrayList<>();
        comodidadesBasicas.add(new ComodidadBasica("Wifi", 5000.0));
        comodidadesBasicas.add(new ComodidadBasica("TV", 4000.0));
        comodidadesBasicas.add( new ComodidadBasica("Desayuno Incluido", 5000.0));
        
        HabitacionSimple habitacionSimple = new HabitacionSimple("Simple", 50000.0, comodidadesBasicas);

        List<ComodidadBasica> comodidadesDobles = new ArrayList<>();
        comodidadesDobles.add(new ComodidadBasica("Wifi", 5000.0));
        comodidadesDobles.add( new ComodidadBasica("TV", 10000.0));
        comodidadesDobles.add(new ComodidadBasica("Aire Acondicionado", 15000.0));
        HabitacionDoble habitacionDoble = new HabitacionDoble("Doble", 60000.0, comodidadesDobles);

        List<ComodidadPremium> comodidadesSuites = new ArrayList<>();
        comodidadesSuites.add(new ComodidadPremium("Jacuzzi", 20000.0, "Lujoso"));
        comodidadesSuites.add( new ComodidadPremium("Minibar", 20000.0, "Completo"));
        comodidadesSuites.add (new ComodidadPremium("Vista al Mar", 25000.0, "Espectacular"));
        HabitacionSuite habitacionSuite = new HabitacionSuite("Suite", 90000.0, comodidadesSuites);

        habitaciones.add(habitacionSimple);
        habitaciones.add(habitacionDoble);
        habitaciones.add(habitacionSuite);

        // Crear instancias de clientes
        Cliente cliente1 = new Cliente("Juan Barrionuevo");
        Cliente cliente2 = new Cliente("Pedro Cortes");

        // Realizar reservas
        gestorReservas.realizarReserva(cliente1, habitacionSimple, LocalDate.of(2024, 6, 1), LocalDate.of(2024, 6, 5));
        gestorReservas.realizarReserva(cliente2, habitacionDoble, LocalDate.of(2024, 6, 3), LocalDate.of(2024, 6, 7));
        gestorReservas.realizarReserva(cliente1, habitacionSuite, LocalDate.of(2024, 6, 8), LocalDate.of(2024, 6, 13));
        gestorReservas.realizarReserva(cliente2, habitacionSimple, LocalDate.of(2024, 6, 14), LocalDate.of(2024, 6, 18));
        gestorReservas.realizarReserva(cliente1, habitacionDoble, LocalDate.of(2024, 6, 20), LocalDate.of(2024, 6, 25));

        // Calcular costos de las reservas y mostrar
        for (Reserva reserva : reservas) {
            System.out.println("Costo de la reserva: " + reserva.calcularCosto());
        }

        // Calcular puntos acumulados para cada cliente y mostrarlos
        System.out.println("Puntos acumulados para " + cliente1.getNombre() + ": " + cliente1.getPuntos());
        System.out.println("Puntos acumulados para " + cliente2.getNombre() + ": " + cliente2.getPuntos());
    }

    public static GestorDisponibilidad getGestor() {
        return gestorDisp;
    }
}
