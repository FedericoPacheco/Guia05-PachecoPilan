package paquetePrincipal;

public class ServicioPersonalizado extends Servicio
{
	public ServicioPersonalizado(String nombre, Oficio oficio, ReparaFix app) 
	{
		super(nombre, oficio, app);
	}

	@Override
	public Trabajo contratarTrabajo(Boolean esUrgente) 
	{
		TrabajoPersonalizado auxTrabajo;
		Trabajador auxTrabajador;
		
		auxTrabajador = app.buscarTrabajadorConOficio(oficio);
		auxTrabajo = new TrabajoPersonalizado(esUrgente, this, auxTrabajador, app);
		app.agregarContratable(auxTrabajo);
		
		return auxTrabajo;
	}
}
