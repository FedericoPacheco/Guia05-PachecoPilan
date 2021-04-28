package paquetePrincipal;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Usuario implements Identificable
{
	static private Integer contadorIds = 0;
	static public final Integer maximaCantidadAlquileresEnSimultaneo = 2;
	
	private Integer id;
	private String nombreUsuario;
	private String correoElectronico;
	private String contrasenia;
	private Integer cantidadAlquileresHechos;
	private List<Contratable> contratables;
	private ReparaFix app;
	
	public Usuario(String nombreUsuario, String correoElectronico, String contrasenia, ReparaFix app) 
	{
		this.id = contadorIds++;
		this.nombreUsuario = nombreUsuario;
		this.correoElectronico = correoElectronico;
		this.contrasenia = contrasenia;
		this.app = app;
		this.contratables = new LinkedList<Contratable>();
		this.cantidadAlquileresHechos = 0;
	}

	@Override
	public Integer getId() {
		return id;
	}
	
	public void contratar(Integer idServicio, Boolean esUrgente)
	{
		Servicio auxServicio;
		Trabajo auxTrabajo;
		
		auxServicio = app.buscarServicio(idServicio);
		auxTrabajo = auxServicio.contratarTrabajo(esUrgente);
		contratables.add(auxTrabajo);
	}
	
	public void contratar(Integer idHerramienta, Integer cantidadDeDias, LocalDate diaDeInicio) throws AlquilerNoEntregadoException
	{
		Alquiler auxAlquiler;
		Herramienta auxHerramienta;
		
		if (cantidadAlquileresHechos == maximaCantidadAlquileresEnSimultaneo)
			throw new AlquilerNoEntregadoException();
		else
		{
			auxHerramienta = app.buscarHerramienta(idHerramienta);
			auxAlquiler = auxHerramienta.contratarAlquiler(cantidadDeDias, diaDeInicio);
			contratables.add(auxAlquiler);
		}
	}
}