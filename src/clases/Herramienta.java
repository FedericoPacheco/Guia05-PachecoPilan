package clases;

import java.time.LocalDate;

import excepciones.HerramientaYaAlquiladaException;
import interfaces.Identificable;

public class Herramienta implements Identificable
{
	private static Integer contadorIds = 1;
	
	private Integer id;
	private String nombre;
	private Double costoPorDia;
	private Alquiler alquiler;
	private ReparaFix reparaFix;
	
	public Herramienta(String nombre, Double costoPorDia, ReparaFix reparaFix) 
	{
		this.id = contadorIds++;
		this.nombre = nombre;
		this.costoPorDia = costoPorDia;
		this.reparaFix = reparaFix;
	}

	public Boolean estaAlquilada() { return alquiler != null; }
	
	public Double getCostoPorDia() { return costoPorDia; }
	public String getNombre() 	   { return nombre; 	 }
	public Alquiler getAlquiler()  { return alquiler;    }
	
	public void setCostoPorDia(Double costoPorDia) { this.costoPorDia = costoPorDia; }

	@Override
	public Integer getId() { return id; }
	public Alquiler contratarAlquiler(Integer cantidadDeDias, LocalDate diaDeInicio) throws HerramientaYaAlquiladaException
	{
		Alquiler auxAlquiler;
		LocalDate diaDeFinalizacion = diaDeInicio.plusDays(cantidadDeDias);
		
		if (!this.estaAlquilada())
		{
			auxAlquiler = new Alquiler(diaDeInicio, diaDeFinalizacion, this, reparaFix);
			reparaFix.agregarAlquiler(auxAlquiler);
			this.alquiler = auxAlquiler;
			return auxAlquiler;
		}
		else
			throw new HerramientaYaAlquiladaException(id, nombre);
		
	}
}
