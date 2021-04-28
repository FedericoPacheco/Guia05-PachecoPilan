package paquetePrincipal;

import java.util.LinkedList;
import java.util.List;

public class Trabajador implements Identificable
{
	private static Integer contadorIds = 0;
	
	private Integer id;
	private String nombre;
	private String correoElectronico;
	private Double costoPorHora;
	private Double porcentajeDeComision;
	private Oficio oficio;
	private List<Trabajo> trabajosARealizar;
	private ReparaFix app;
	
	public Trabajador(String nombre, String correoElectronico, Double costoPorHora, Double porcentajeDeComision, Oficio oficio, ReparaFix app) 
	{
		this.id = contadorIds++;
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.costoPorHora = costoPorHora;
		this.porcentajeDeComision = porcentajeDeComision;
		this.oficio = oficio;
		trabajosARealizar = new LinkedList<Trabajo>();
		this.app = app;
	}

	public void agregarTrabajo(Trabajo trabajo)	{ trabajosARealizar.add(trabajo); }

	@Override
	public Integer getId() { return id; }
	public Oficio getOficio() {return oficio; }
}
