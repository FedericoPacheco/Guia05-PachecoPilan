package paquetePrincipal;

import java.time.LocalDate;

public abstract class Trabajo implements Contratable, Identificable
{
	static protected Integer contadorIds = 0;
	
	protected Integer id;
	protected LocalDate diaDeFinalizacion;
	protected Boolean esUrgente;
	protected Servicio servicio;
	protected ReparaFix app;
	
	public Trabajo(LocalDate diaDeFinalizacion, Boolean esUrgente, Servicio servicio, ReparaFix app) 
	{	
		this.id = contadorIds++;
		this.diaDeFinalizacion = diaDeFinalizacion;
		this.esUrgente = esUrgente;
		this.servicio = servicio;
		this.app = app;
	}

	@Override
	public Integer getId() {
		return id;
	}
}
