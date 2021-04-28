package paquetePrincipal;

public class ServicioEstandar extends Servicio
{
	private Double monto;
	
	public ServicioEstandar(String nombre, Oficio oficio, ReparaFix app, Double monto)
	{
		super(nombre, oficio, app);
		this.monto = monto;
	}

	@Override
	public Trabajo contratarTrabajo(Boolean esUrgente) 
	{
		TrabajoEstandar auxTrabajo;
		Trabajador auxTrabajador;
		
		auxTrabajador = app.buscarTrabajadorConOficio(oficio);
		auxTrabajo = new TrabajoEstandar(esUrgente, this, auxTrabajador, app);
		app.agregarContratable(auxTrabajo);
		
		return auxTrabajo;
	}
	
	@Override
	public Double getMonto() { return monto; }
}
