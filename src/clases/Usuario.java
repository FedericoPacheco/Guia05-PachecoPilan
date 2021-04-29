package clases;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import excepciones.AlquilerNoEntregadoException;
import excepciones.HerramientaYaAlquiladaException;
import excepciones.SinTrabajadoresDisponiblesException;
import interfaces.Contratable;
import interfaces.Identificable;

public class Usuario implements Identificable
{
	static private Integer contadorIds = 1;
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
	
	public void contratar(Integer idServicio, LocalDate diaDeInicio, Boolean esUrgente) throws SinTrabajadoresDisponiblesException
	{
		Servicio auxServicio;
		Trabajo auxTrabajo;
		
		auxServicio = app.buscarServicio(idServicio);
		auxTrabajo = auxServicio.contratarTrabajo(diaDeInicio, esUrgente);
		contratables.add(auxTrabajo);
	}
	
	public void contratar(Integer idHerramienta, Integer cantidadDeDias, LocalDate diaDeInicio) throws AlquilerNoEntregadoException, HerramientaYaAlquiladaException
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
	
	public String getNombreUsuario() 	 { return nombreUsuario; 	 }
	public String getCorreoElectronico() { return correoElectronico; }
	public String getContrasenia() 		 { return contrasenia; 		 }
	
	public void setNombreUsuario(String nombreUsuario) 		   { this.nombreUsuario = nombreUsuario; 		 }
	public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }
	public void setContrasenia(String contrasenia) 			   { this.contrasenia = contrasenia; 			 }

	@Override
	public Integer getId() { return id; }
}