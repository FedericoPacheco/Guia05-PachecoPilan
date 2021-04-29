package clases;

import java.time.LocalDate;

import interfaces.Contratable;
import interfaces.Identificable;

public abstract class Trabajo implements Contratable, Identificable
{
	static protected Integer contadorIds = 1;
	static protected Double porcentajeExtraPorUrgencia = 0.5;
	
	protected Integer id;
	protected LocalDate diaDeInicio;
	protected LocalDate diaDeFinalizacion;
	protected Boolean esUrgente;
	protected Servicio servicio;
	protected Trabajador trabajador;
	protected ReparaFix app;
	
	public Trabajo(Boolean esUrgente, LocalDate diaDeInicio, Servicio servicio, Trabajador trabajador, ReparaFix app) 
	{	
		this.id = contadorIds++;
		this.esUrgente = esUrgente;
		this.diaDeInicio = diaDeInicio;
		this.servicio = servicio;
		this.trabajador = trabajador;
		this.app = app;
	}

	public Boolean diaComprendido(LocalDate dia)
	{
		Boolean auxBoolean;
		
		if (!this.fueFinalizado())
			auxBoolean = diaDeInicio.isEqual(dia);
		else
			auxBoolean = 
				(dia.isEqual(diaDeInicio) || dia.isAfter(diaDeInicio)) && 
				(dia.isEqual(diaDeFinalizacion) || dia.isBefore(diaDeFinalizacion));
		
		return auxBoolean;
	}
	
	public LocalDate getDiaDeInicio() 		{ return diaDeInicio; 		}
	public LocalDate getDiaDeFinalizacion() { return diaDeFinalizacion; }
	public Boolean getEsUrgente() 			{ return esUrgente; 		}
	public Servicio getServicio() 			{ return servicio; 			}
	public Trabajador getTrabajador() 		{ return trabajador; 		}
	
	public void setDiaDeFinalizacion(LocalDate diaDeFinalizacion) { this.diaDeFinalizacion = diaDeFinalizacion; };

	@Override
	public Integer getId()		   { return id; 						  }
	public Integer getMes() 	   { return diaDeInicio.getMonthValue();  }
	public Boolean fueFinalizado() { return diaDeFinalizacion != null; 	  }
	public Double multiplicadorPorUrgencia() 
	{
		Double auxDouble = 1.0;
		if (esUrgente) 
			auxDouble += porcentajeExtraPorUrgencia;
		return auxDouble;
	}
}
