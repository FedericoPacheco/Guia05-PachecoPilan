package clases;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import interfaces.Contratable;
import interfaces.Identificable;

public class Alquiler implements Contratable, Identificable
{
	private static Integer contadorIds = 1;
	
	private Integer id;
	private LocalDate diaDeInicio;
	private LocalDate diaDeFinalizacion;
	private LocalDate diaDeDevolucion;
	private Herramienta herramienta;
	private ReparaFix app;
	
	public Alquiler(LocalDate diaDeInicio, LocalDate diaDeFinalizacion, Herramienta herramienta, ReparaFix app) 
	{
		this.id = contadorIds++;
		this.diaDeInicio = diaDeInicio;
		this.diaDeFinalizacion = diaDeFinalizacion;
		this.herramienta = herramienta;
		this.app = app;
	}
	
	public Boolean enMora() 
	{ 
		if (!this.fueFinalizado())
			return LocalDate.now().isAfter(diaDeFinalizacion);
		else
			return diaDeDevolucion.isAfter(diaDeFinalizacion);
			 
	}
	public void setDiaDeDevolucion() { diaDeDevolucion = LocalDate.now(); }
	
	public LocalDate getDiaDeInicio() 		{ return diaDeInicio;	    }
	public LocalDate getDiaDeFinalizacion() { return diaDeFinalizacion; }
	public LocalDate getDiaDeDevolucion() 	{ return diaDeDevolucion;   }
	public Herramienta getHerramienta() 	{ return herramienta; 		}
	
	public void setDiaDeDevolucion(LocalDate diaDeDevolucion) {	this.diaDeDevolucion = diaDeDevolucion; }
	
	@Override
	public Integer getId()		   { return id; 						  }
	public Integer getMes() 	   { return diaDeInicio.getMonthValue();  }
	public Boolean fueFinalizado() { return diaDeDevolucion != null; 	  }
	
	public Double calcularCosto() 
	{
		// https://docs.oracle.com/javase/8/docs/api/java/time/Duration.html
		// https://stackoverflow.com/a/48732307
		Long cantidadDeDias;
		LocalDateTime hoy = LocalDateTime.now();
		LocalDateTime auxDiaDeInicio = diaDeInicio.atStartOfDay();
		LocalDateTime auxDiaDeFinalizacion = diaDeFinalizacion.atStartOfDay();
		
		if (this.enMora()) // No se consideran multas.
			cantidadDeDias = Duration.between(auxDiaDeFinalizacion, auxDiaDeInicio).toDays();
		else
			if (this.fueFinalizado()) // Se devolvio la herramienta antes de tiempo.
				cantidadDeDias = Duration.between(diaDeDevolucion.atStartOfDay(), auxDiaDeInicio).toDays();
			else // Precio a dia de hoy.
				cantidadDeDias = Duration.between(hoy, auxDiaDeInicio).toDays();
		
		return Math.abs(cantidadDeDias * herramienta.getCostoPorDia());
	}
}
