package clases;

import interfaces.Identificable;

public class Oficio implements Identificable
{
	private static Integer contadorIds = 0;
	
	private Integer id;
	private String nombre;
	private ReparaFix app;
	
	public Oficio(Integer id, String nombre, ReparaFix app) 
	{
		this.id = contadorIds++;
		this.id = id;
		this.nombre = nombre;
		this.app = app;
	}

	public Boolean equals(Oficio otroOficio) { return this.id == otroOficio.getId(); }
	
	public String getNombre() { return nombre; }

	@Override
	public Integer getId() { return id; }
}
