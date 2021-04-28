package paquetePrincipal;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Usuario implements Identificable
{
	static private Integer contadorIds = 0;
	
	private Integer id;
	private String nombreUsuario;
	private String correoElectronico;
	private String contrasenia;
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
	
	public void contratar(Integer idHerramienta, Integer cantidadDeDias, LocalDate diaDeInicio)
	{
		Alquiler auxAlquiler;
		Herramienta auxHerramienta;
		
		auxHerramienta = app.buscarHerramienta(idHerramienta);
		auxAlquiler = auxHerramienta.contratarAlquiler(cantidadDeDias, diaDeInicio);
		contratables.add(auxAlquiler);
	}
	
	
	
	
	
	
	//public void contratar()
	//{
		
	//}
}
