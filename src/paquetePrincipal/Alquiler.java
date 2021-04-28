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
