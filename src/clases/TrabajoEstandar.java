package clases;

import java.time.LocalDate;

public class TrabajoEstandar extends Trabajo
{
	private Integer horasTrabajadas;
	
	public TrabajoEstandar(Boolean esUrgente, LocalDate diaDeInicio, Servicio servicio, Trabajador trabajador, ReparaFix app)
	{
		super(esUrgente, diaDeInicio, servicio, trabajador, app);
		this.horasTrabajadas = 0;
	}

	public Integer getHorasTrabajadas() {return horasTrabajadas; }
	
	public void setHorasTrabajadas(Integer horasTrabajadas) { this.horasTrabajadas = horasTrabajadas; }
	
	@Override
	public Double calcularCosto() { return this.multiplicadorPorUrgencia() * ((1 + trabajador.getComision()) * servicio.getMonto() + trabajador.getCosto(horasTrabajadas)); } 
	// No me queda del todo claro como se calcula el costo.
}
