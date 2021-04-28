package paquetePrincipal;

import java.time.LocalDate;

public class TrabajoPersonalizado extends Trabajo
{	
	private Double valorPresupuestado;
	private Double costoDeMateriales;
	private Double costoDeTransporte;
	
	public TrabajoPersonalizado(LocalDate diaDeFinalizacion, Boolean esUrgente, Servicio servicio, ReparaFix app)
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
