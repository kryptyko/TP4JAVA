/*
 * Recordemos la info de la interface de Cliente.
•
•
•
Obtener el nombre del cliente, getNombre(): String
Obtener puntos del cliente, getPuntos(): Integer
Acumular puntos en su cuenta, acumularPuntos(reserva: Reserva): void
La clase tendrá los atributos nombre y puntos los cuales almacena el objeto.
El método acumularPuntos será llamado luego de realizar una reserva y aumentará en una
proporción 1 a 100 (1 punto cada 100$ de costo). Es decir:
puntos = puntos + reserva.CalcularCosto() / 100;
 * 
 */

public class Cliente implements ClienteInt {
    private String nombre;
    private int puntos;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getPuntos() {
        return puntos;
    }

    @Override
    public void acumularPuntos(Reserva reserva) {
        puntos += reserva.calcularCosto() / 100;
    }
}
