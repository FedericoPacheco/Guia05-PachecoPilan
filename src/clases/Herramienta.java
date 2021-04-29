package clases;

import java.time.LocalDate;

import interfaces.Identificable;

public class Herramienta implements Identificable
{
	private static Integer contadorIds = 0;
	
	private Integer id;
	private String nombre;
	private Double costoPorDia;
	private ReparaFix app;
	
	public Herramienta(String nombre, Double costoPorDia, ReparaFix app) 
	{
		this.id = contadorIds++;
		this.nombre = nombre;
		this.costoPorDia = costoPorDia;
		this.app = app;
	}

	public Double getCostoPorDia() { return costoPorDia; }
	public String getNombre() 	   { return nombre; 	 }

	public void setCostoPorDia(Double costoPorDia) { this.costoPorDia = costoPorDia; }

	@Override
	public Integer getId() { return id; }
	public Alquiler contratarAlquiler(Integer cantidadDeDias, LocalDate diaDeInicio)
	{
		Alquiler auxAlquiler;
		LocalDate diaDeFinalizacion = diaDeInicio.plusDays(cantidadDeDias);
		
		auxAlquiler = new Alquiler(diaDeInicio, diaDeFinalizacion, this, app);
		app.agregarContratable(auxAlquiler);
		
		return auxAlquiler;
	}
}
