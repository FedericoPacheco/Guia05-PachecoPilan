package clases;

import java.time.LocalDate;

import excepciones.SinTrabajadoresDisponiblesException;

public class ServicioPersonalizado extends Servicio
{
	public ServicioPersonalizado(String nombre, Oficio oficio, ReparaFix app) 
	{
		super(nombre, oficio, app);
	}

	@Override
	public Double getMonto() { return 0.0; }
	public Trabajo contratarTrabajo(LocalDate diaDeInicio, Boolean esUrgente) throws SinTrabajadoresDisponiblesException 
	{
		TrabajoPersonalizado auxTrabajo;
		Trabajador auxTrabajador;
		
		auxTrabajador = app.buscarTrabajadorConOficio(oficio, diaDeInicio);
		auxTrabajo = new TrabajoPersonalizado(esUrgente, diaDeInicio, this, auxTrabajador, app);
		app.agregarContratable(auxTrabajo);
		auxTrabajador.agregarTrabajo(auxTrabajo);
		
		return auxTrabajo;
	}
}
