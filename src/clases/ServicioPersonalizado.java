package clases;

import java.time.LocalDate;
import java.util.Optional;

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
		TrabajoPersonalizado auxTrabajoPersonalizado;
		Trabajador auxTrabajador;
		
		LocalDate dia = diaDeInicio;
		Optional<Trabajador> auxOptionalTrabajador = app.buscarTrabajadorConOficio(oficio, dia, esUrgente);
		
		if(!esUrgente)
			while(auxOptionalTrabajador.isEmpty()) // si no es urgente seguir buscando en los sucesivos dias hasta encontrar un trabajador
			{
				dia = dia.plusDays(1);
				auxOptionalTrabajador = app.buscarTrabajadorConOficio(oficio, dia, esUrgente);
			}
		
		auxTrabajador = auxOptionalTrabajador.get();
		auxTrabajoPersonalizado = new TrabajoPersonalizado(esUrgente, diaDeInicio, this, auxTrabajador, app);
		app.agregarContratable(auxTrabajoPersonalizado);
		auxTrabajador.agregarTrabajo(auxTrabajoPersonalizado);
		
		return auxTrabajoPersonalizado;
	}
}
