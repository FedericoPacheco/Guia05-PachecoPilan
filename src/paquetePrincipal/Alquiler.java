package paquetePrincipal;

import java.time.LocalDate;

public class Alquiler implements Contratable
{
	private LocalDate diaDeInicio;
	private LocalDate diaDeFinalizacion;
	private LocalDate diaDeDevolucion;
	
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
