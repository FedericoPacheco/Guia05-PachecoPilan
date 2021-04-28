package paquetePrincipal;

import java.time.Duration;
import java.time.LocalDate;

public class Alquiler implements Contratable, Identificable
{
	private static Integer contadorIds = 0;
	
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
	
	@Override
	public Integer getId(){ return id; }

	@Override
	public Boolean fueFinalizado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double calcularCosto() 
	{
		// https://docs.oracle.com/javase/8/docs/api/java/time/Duration.html
		Long auxLong;
		
		if (this.enMora()) 															// No se consideran multas.
			auxLong = Duration.between(diaDeFinalizacion, diaDeInicio).toDays();
		else
			if (diaDeDevolucion != null) 											// Se devolvio la herramienta antes de tiempo.
				auxLong = Duration.between(diaDeDevolucion, diaDeInicio).toDays();
			else   																	// Precio a dia de hoy.
				auxLong = Duration.between(LocalDate.now(), diaDeInicio).toDays();
		
		return auxLong * herramienta.getCostoPorDia();
	}
	
	public Boolean enMora() { return (diaDeDevolucion.isAfter(diaDeFinalizacion) || LocalDate.now().isAfter(diaDeFinalizacion)); }
}
