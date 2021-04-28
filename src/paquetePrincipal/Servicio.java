package paquetePrincipal;

public abstract class Servicio implements Identificable
{
	protected static Integer contadorIds = 0;
	
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
	public abstract Trabajo contratarTrabajo(Boolean esUrgente);

	@Override
	public Integer getId() { return id; }
}
