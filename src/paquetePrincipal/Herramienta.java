package paquetePrincipal;

public class Herramienta implements Identificable
{
	private static Integer contadorIds = 0;
	
	private Integer id;
	private String nombre;
	private Double costoPorDia;
	
	public Herramienta(String nombre, Double costoPorDia) 
	{
		this.id = contadorIds++;
		this.nombre = nombre;
		this.costoPorDia = costoPorDia;
	}

	@Override
	public Integer getId() {
		return id;
	}
	
	
}
