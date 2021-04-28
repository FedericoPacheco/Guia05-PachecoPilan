package paquetePrincipal;

import java.time.LocalDate;

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
