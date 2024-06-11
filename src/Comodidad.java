/*
 * CLASE ABSTRACTA COMODIDAD 
Se definirá la clase abstracta Comodidad que cuente con la información básica de una de la siguiente forma.
 
abstract class Comodidad { protected String nombre; protected double precio;
// getters y setters
public abstract double calcularCosto(LocalDate fechaInicio, LocalDate fechaFin);
}
  */


import java.time.LocalDate;

public abstract class Comodidad {
    protected String nombre;
    protected double precio;

    public Comodidad(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public abstract double calcularCosto(LocalDate fechaInicio, LocalDate fechaFin);
}
