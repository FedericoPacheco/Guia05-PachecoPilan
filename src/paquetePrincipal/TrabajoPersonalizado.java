package paquetePrincipal;

import java.time.LocalDate;

public class TrabajoPersonalizado extends Trabajo
{
	static private Integer contadorIds = 0;
	
	private Double valorPresupuestado;
	private Double costoDeMateriales;
	private Double costoDeTransporte;
	
	public TrabajoPersonalizado(LocalDate diaDeFinalizacion, Boolean esUrgente, Servicio servicio)
	{
		super(diaDeFinalizacion, esUrgente, servicio);
		this.id = contadorIds++;
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
