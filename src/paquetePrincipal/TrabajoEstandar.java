package paquetePrincipal;

import java.time.LocalDate;

public class TrabajoEstandar extends Trabajo
{
	private Integer horasTrabajadas;
	
	public TrabajoEstandar(Boolean esUrgente, Servicio servicio, Trabajador trabajador, ReparaFix app)
	{
		super(esUrgente, servicio, trabajador, app);
		this.horasTrabajadas = 0;
	}

	@Override
	public Boolean fueFinalizado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	// No me queda del todo claro como se calcula el costo.
	public Double calcularCosto() { return this.multiplicadorPorUrgencia() * ((1 + trabajador.getComision()) * servicio.getMonto() + trabajador.getCosto(horasTrabajadas)); }
	public void setHorasTrabajadas(Integer horasTrabajadas) { this.horasTrabajadas = horasTrabajadas; }
}
