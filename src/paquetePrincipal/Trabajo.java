package paquetePrincipal;

import java.time.LocalDate;

public abstract class Trabajo implements Contratable, Identificable
{
	protected Integer id;
	protected LocalDate diaDeFinalizacion;
	protected Boolean esUrgente;
	protected Servicio servicio;
	
	public Trabajo(LocalDate diaDeFinalizacion, Boolean esUrgente, Servicio servicio) 
	{	
		this.diaDeFinalizacion = diaDeFinalizacion;
		this.esUrgente = esUrgente;
		this.servicio = servicio;
	}

	@Override
	public Integer getId() {
		return id;
	}
}
