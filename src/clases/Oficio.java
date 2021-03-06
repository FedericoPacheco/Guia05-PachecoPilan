package clases;

import interfaces.Identificable;

public class Oficio implements Identificable
{
	private static Integer contadorIds = 1;
	
	private Integer id;
	private String nombre;
	@SuppressWarnings("unused")
	private ReparaFix reparaFix;
	
	public Oficio(String nombre, ReparaFix reparaFix) 
	{
		this.id = contadorIds++;
		this.nombre = nombre;
		this.reparaFix = reparaFix;
	}

	public Boolean equals(Oficio otroOficio) { return this.id == otroOficio.getId(); }
	
	public String getNombre() { return nombre; }

	@Override
	public Integer getId() { return id; }
}
