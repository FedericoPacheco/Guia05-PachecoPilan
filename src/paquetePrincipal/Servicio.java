package paquetePrincipal;

public abstract class Servicio implements Identificable
{
	protected Integer id;
	protected String nombre;
	protected Oficio oficio;
	
	public Servicio(String nombre, Oficio oficio) 
	{
		this.nombre = nombre;
		this.oficio = oficio;
	}
	
	@Override
	public Integer getId(){
		return id;
	}
}
