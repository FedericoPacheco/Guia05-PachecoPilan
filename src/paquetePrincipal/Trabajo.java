package paquetePrincipal;

import java.time.LocalDate;

public abstract class Trabajo implements Contratable, Identificable
{
	static protected Integer contadorIds = 0;
	
	protected Integer id;
	protected LocalDate diaDeFinalizacion;
	protected Boolean esUrgente;
	protected Servicio servicio;
	protected Trabajador trabajador;
	protected ReparaFix app;
	
	public Trabajo(Boolean esUrgente, Servicio servicio, Trabajador trabajador, ReparaFix app) 
	{	
		this.id = contadorIds++;
		this.esUrgente = esUrgente;
		this.servicio = servicio;
		this.trabajador = trabajador;
		this.app = app;
	}

	@Override
	public Integer getId() {
		return id;
	}
}
