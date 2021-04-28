package paquetePrincipal;

import java.time.LocalDate;

public class TrabajoEstandar extends Trabajo
{
	public TrabajoEstandar(Boolean esUrgente, Servicio servicio, Trabajador trabajador, ReparaFix app)
	{
		super(esUrgente, servicio, trabajador, app);
	}

	@Override
	public Boolean fueFinalizado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double calcularCosto() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
