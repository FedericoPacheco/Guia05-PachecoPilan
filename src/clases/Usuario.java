package clases;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import excepciones.AlquilerNoEntregadoException;
import excepciones.HerramientaYaAlquiladaException;
import excepciones.IdentificableNoEncontradoException;
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
	private Integer cantidadDeAlquileresHechos;
	private List<Contratable> contratables;
	private ReparaFix reparaFix;
	
	public Usuario(String nombreUsuario, String correoElectronico, String contrasenia, ReparaFix reparaFix) 
	{
		this.id = contadorIds++;
		this.nombreUsuario = nombreUsuario;
		this.correoElectronico = correoElectronico;
		this.contrasenia = contrasenia;
		this.reparaFix = reparaFix;
		this.contratables = new LinkedList<Contratable>();
		this.cantidadDeAlquileresHechos = 0;
	}
	
	public void contratar(Integer idServicio, LocalDate diaDeInicio, Boolean esUrgente) throws SinTrabajadoresDisponiblesException, IdentificableNoEncontradoException
	{
		Servicio auxServicio;
		Trabajo auxTrabajo;
		
		auxServicio = reparaFix.buscarServicio(idServicio);
		auxTrabajo = auxServicio.contratarTrabajo(diaDeInicio, esUrgente);
		contratables.add(auxTrabajo);
	}
	
	public void contratar(Integer idHerramienta, Integer cantidadDeDias, LocalDate diaDeInicio) throws AlquilerNoEntregadoException, HerramientaYaAlquiladaException, IdentificableNoEncontradoException
	{
		Alquiler auxAlquiler;
		Herramienta auxHerramienta;
		
		if (cantidadDeAlquileresHechos == maximaCantidadAlquileresEnSimultaneo)
			throw new AlquilerNoEntregadoException();
		else
		{
			auxHerramienta = reparaFix.buscarHerramienta(idHerramienta);
			auxAlquiler = auxHerramienta.contratarAlquiler(cantidadDeDias, diaDeInicio);
			contratables.add(auxAlquiler);
			cantidadDeAlquileresHechos++;
		}
	}
	
	public void devolverHerramienta(Integer idAlquiler, LocalDate dia) throws IdentificableNoEncontradoException
	{
		reparaFix.buscarAlquiler(idAlquiler).setDiaDeDevolucion(dia);
		this.cantidadDeAlquileresHechos--;
	}
	
	public Double calcularCostoContratables(Integer mes)
	{
		Double suma = 0.0;
		
		for (Contratable contratable: contratables)
			if (contratable.getMes() == mes)
				suma += contratable.calcularCosto();
		
		return suma;
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