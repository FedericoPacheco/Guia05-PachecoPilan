package clases;

import java.time.LocalDate;

import excepciones.SinTrabajadoresDisponiblesException;

public class ServicioEstandar extends Servicio
{
	private Double monto;
	
	public ServicioEstandar(String nombre, Oficio oficio, ReparaFix app, Double monto)
	{
		super(nombre, oficio, app);
		this.monto = monto;
	}

	@Override
	public Trabajo contratarTrabajo(LocalDate diaDeInicio, Boolean esUrgente) throws SinTrabajadoresDisponiblesException 
	{
		TrabajoEstandar auxTrabajo;
		Trabajador auxTrabajador;
		
		auxTrabajador = app.buscarTrabajadorConOficio(oficio, diaDeInicio);
		auxTrabajo = new TrabajoEstandar(esUrgente, diaDeInicio, this, auxTrabajador, app);
		app.agregarContratable(auxTrabajo);
		auxTrabajador.agregarTrabajo(auxTrabajo);
		
		return auxTrabajo;
	}
	
	public void setMonto(Double monto) { this.monto = monto; }
	
	@Override
	public Double getMonto() { return monto; }
	
}
