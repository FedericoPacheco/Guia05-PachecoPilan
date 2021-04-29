package clases;

import java.time.LocalDate;

import excepciones.SinTrabajadoresDisponiblesException;
import interfaces.Identificable;

public abstract class Servicio implements Identificable
{
	protected static Integer contadorIds = 1;
	
	protected Integer id;
	protected String nombre;
	protected Oficio oficio;
	protected ReparaFix app;
	
	public Servicio(String nombre, Oficio oficio, ReparaFix app) 
	{
		this.id = contadorIds++;
		this.nombre = nombre;
		this.oficio = oficio;
		this.app = app;
	}
	
	public abstract Double getMonto();
	public abstract Trabajo contratarTrabajo(LocalDate diaDeInicio, Boolean esUrgente) throws SinTrabajadoresDisponiblesException;

	public String getNombre() {	return nombre; }
	public Oficio getOficio() {	return oficio; }

	@Override
	public Integer getId() { return id; }
}
