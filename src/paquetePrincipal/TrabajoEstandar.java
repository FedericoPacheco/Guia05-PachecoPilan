package paquetePrincipal;

import java.time.LocalDate;

public class TrabajoEstandar extends Trabajo
{
	public TrabajoEstandar(LocalDate diaDeFinalizacion, Boolean esUrgente, Servicio servicio, ReparaFix app)
	{
		super(diaDeFinalizacion, esUrgente, servicio, app);
	}
	
	@Override
	public void contratar() {
		// TODO Auto-generated method stub
		
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
