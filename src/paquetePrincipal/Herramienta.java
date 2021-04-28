package paquetePrincipal;

public class Herramienta implements Identificable
{
	private static Integer contadorIds = 0;
	
	private Integer id;
	private String nombre;
	private Double costoPorDia;
	private ReparaFix app;
	
	public Herramienta(String nombre, Double costoPorDia, ReparaFix app) 
	{
		this.id = contadorIds++;
		this.nombre = nombre;
		this.costoPorDia = costoPorDia;
		this.app = app;
	}

	@Override
	public Integer getId() {
		return id;
	}
	
	
}
