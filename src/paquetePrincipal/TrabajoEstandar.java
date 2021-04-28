package paquetePrincipal;

import java.time.LocalDate;

public class TrabajoEstandar extends Trabajo
{
	static private Integer contadorIds = 0;
	
	public TrabajoEstandar(LocalDate diaDeFinalizacion, Boolean esUrgente, Servicio servicio)
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
