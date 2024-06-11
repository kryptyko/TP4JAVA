/*
 * CLIENTE INTEFACE
•
•
•
Obtener el nombre del cliente, getNombre(): String
Obtener puntos del cliente, getPuntos(): Integer
Acumular puntos en su cuenta, acumularPuntos(reserva: Reserva): void
 * 
 */


public interface ClienteInt {
    String getNombre();
    int getPuntos();
    void acumularPuntos(Reserva reserva);
}
