package clases;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import interfaces.Identificable;

public class Trabajador implements Identificable
{
	private static Integer contadorIds = 1;
	
	private Integer id;
	private String nombre;
	private String correoElectronico;
	private Double costoPorHora;
	private Double porcentajeDeComision;
	private Oficio oficio;
	private List<Trabajo> trabajosARealizar;
	@SuppressWarnings("unused")
	private ReparaFix reparaFix;
	
	public Trabajador(String nombre, String correoElectronico, Double costoPorHora, Double porcentajeDeComision, Oficio oficio, ReparaFix reparaFix) 
	{
		this.id = contadorIds++;
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.costoPorHora = costoPorHora;
		this.porcentajeDeComision = porcentajeDeComision;
		this.oficio = oficio;
		trabajosARealizar = new LinkedList<Trabajo>();
		this.reparaFix = reparaFix;
	}

	public Boolean agendaOcupada(LocalDate dia)
	{
		Boolean agendaOcupada = false; 
		Integer i = 0;
		
		while (i < trabajosARealizar.size() && !agendaOcupada)
			if (trabajosARealizar.get(i).diaComprendido(dia))
				agendaOcupada = true;
			else
				i++;
		
		return agendaOcupada;
	}
	
	public void agregarTrabajo(Trabajo trabajo)	{ trabajosARealizar.add(trabajo); }
	
	public String getNombre() 			    		{ return nombre; 			   			 }
	public String getCorreoElectronico()    		{ return correoElectronico;    	  		 }
	public Double getCostoPorHora() 	    		{ return costoPorHora; 		   			 }
	public Double getPorcentajeDeComision()		 	{ return porcentajeDeComision; 			 }
	public Oficio getOficio() 						{ return oficio; 			   			 }
	public Double getCosto(Integer horasTrabajadas) { return costoPorHora * horasTrabajadas; }
	public Double getComision() 					{ return porcentajeDeComision; 			 }
	
	public void setNombre(String nombre) 					   		 { this.nombre = nombre; }
	public void setCorreoElectronico(String correoElectronico) 		 { this.correoElectronico = correoElectronico; }
	public void setCostoPorHora(Double costoPorHora) 		   		 { this.costoPorHora = costoPorHora; }
	public void setPorcentajeDeComision(Double porcentajeDeComision) { this.porcentajeDeComision = porcentajeDeComision; }

	@Override
	public Integer getId() { return id; }
}
