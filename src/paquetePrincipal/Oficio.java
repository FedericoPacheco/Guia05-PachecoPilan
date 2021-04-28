package paquetePrincipal;

public class Oficio implements Identificable
{
	private static Integer contadorIds = 0;
	
	private Integer id;
	private String nombre;
	
	public Oficio(Integer id, String nombre) 
	{
		this.id = contadorIds++;
		this.id = id;
		this.nombre = nombre;
	}

	@Override
	public Integer getId() {
		return id;
	}

	
}
