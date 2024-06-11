
/* COMODIDAD PREMIUIM
 * Usando la misma clase abstracta, sumaremos el atributo `especialidad`, una cadena que
nos podría decir el material del mueble, o la velocidad de WiFi disponible.
El costo se calculará similar a ComodidadBasica, solo que tendrá un 25% de recargo final
una vez calculado el costo.
 * 
 * 
 */

import java.time.LocalDate;

public class ComodidadPremium extends Comodidad {
    private String especialidad;

    public ComodidadPremium(String nombre, double precio, String especialidad) {
        super(nombre, precio);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public double calcularCosto(LocalDate fechaInicio, LocalDate fechaFin) {
        long dias = fechaInicio.until(fechaFin).getDays();
        return dias * precio * 1.25; // 25% de recargo
    }
}
