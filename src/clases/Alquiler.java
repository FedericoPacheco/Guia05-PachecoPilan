package clases;

import java.time.Duration;
import java.time.LocalDate;

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
		return (diaDeDevolucion.isAfter(diaDeFinalizacion) ||
				LocalDate.now().isAfter(diaDeFinalizacion)); 
	}
	public void setDiaDeDevolucion() { diaDeDevolucion = LocalDate.now(); }
	
	public LocalDate getDiaDeInicio() 		{ return diaDeInicio;	    }
	public LocalDate getDiaDeFinalizacion() { return diaDeFinalizacion; }
	public LocalDate getDiaDeDevolucion() 	{ return diaDeDevolucion;   }
	public Herramienta getHerramienta() 	{ return herramienta; 		}
	
	public void setDiaDeDevolucion(LocalDate diaDeDevolucion) 	  {	this.diaDeDevolucion = diaDeDevolucion; 	}
	
	@Override
	public Integer getId(){ return id; }
	public Boolean fueFinalizado() { return diaDeDevolucion != null; }
	public Double calcularCosto() 
	{
		// https://docs.oracle.com/javase/8/docs/api/java/time/Duration.html
		Long auxLong;
		
		if (this.enMora()) 															// No se consideran multas.
			auxLong = Duration.between(diaDeFinalizacion, diaDeInicio).toDays();
		else
			if (this.fueFinalizado()) 											    // Se devolvio la herramienta antes de tiempo.
				auxLong = Duration.between(diaDeDevolucion, diaDeInicio).toDays();
			else   																	// Precio a dia de hoy.
				auxLong = Duration.between(LocalDate.now(), diaDeInicio).toDays();
		
		return auxLong * herramienta.getCostoPorDia();
	}
}
