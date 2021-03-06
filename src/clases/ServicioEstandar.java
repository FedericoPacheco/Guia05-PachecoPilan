package clases;

import java.time.LocalDate;
import java.util.Optional;

import excepciones.SinTrabajadoresDisponiblesException;

public class ServicioEstandar extends Servicio
{
	private Double monto;
	
	public ServicioEstandar(String nombre, Oficio oficio, ReparaFix reparaFix, Double monto)
	{
		super(nombre, oficio, reparaFix);
		this.monto = monto;
	}

	@Override
	public Double getMonto() { return monto; }
	public Trabajo contratarTrabajo(LocalDate diaDeInicio, Boolean esUrgente) throws SinTrabajadoresDisponiblesException 
	{
		TrabajoEstandar auxTrabajoEstandar;
		Trabajador auxTrabajador;
		
		LocalDate dia = diaDeInicio;
		Optional<Trabajador> auxOptionalTrabajador = reparaFix.buscarTrabajadorConOficio(oficio, dia, esUrgente);
		
		if(!esUrgente)
			while(auxOptionalTrabajador.isEmpty()) // si no es urgente seguir buscando en los sucesivos dias hasta encontrar un trabajador
			{
				dia = dia.plusDays(1);
				auxOptionalTrabajador = reparaFix.buscarTrabajadorConOficio(oficio, dia, esUrgente);
			}
		
		auxTrabajador = auxOptionalTrabajador.get();
		auxTrabajoEstandar = new TrabajoEstandar(esUrgente, dia, this, auxTrabajador, reparaFix);
		reparaFix.agregarTrabajo(auxTrabajoEstandar);
		auxTrabajador.agregarTrabajo(auxTrabajoEstandar);
		
		return auxTrabajoEstandar;
	}
	
	public void setMonto(Double monto) { this.monto = monto; }
}
