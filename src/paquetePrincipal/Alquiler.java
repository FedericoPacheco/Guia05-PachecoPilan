package paquetePrincipal;

import java.time.LocalDate;

public class Alquiler implements Contratable, Identificable
{
	private static Integer contadorIds = 0;
	
	private Integer id;
	private LocalDate diaDeInicio;
	private LocalDate diaDeFinalizacion;
	private LocalDate diaDeDevolucion;
	private Herramienta herramienta;
	
	public Alquiler(LocalDate diaDeInicio, LocalDate diaDeFinalizacion, LocalDate diaDeDevolucion, Herramienta herramienta) 
	{
		this.id = contadorIds++;
		this.diaDeInicio = diaDeInicio;
		this.diaDeFinalizacion = diaDeFinalizacion;
		this.diaDeDevolucion = diaDeDevolucion;
		this.herramienta = herramienta;
	}
	
	@Override
	public Integer getId(){
		return id;
	}
	

	public Boolean enMora()
	{
		//previsional
		return false;
	}

	@Override
	public void contratar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean fueFinalizado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double calcularCosto() {
		// TODO Auto-generated method stub
		return null;
	}
}
