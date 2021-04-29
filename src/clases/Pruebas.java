package clases;

import java.time.LocalDate;
import excepciones.AlquilerNoEntregadoException;
import excepciones.HerramientaYaAlquiladaException;
import excepciones.IdentificableNoEncontradoException;
import excepciones.SinTrabajadoresDisponiblesException;

public class Pruebas 
{
	static ReparaFix reparaFix;
	static Trabajador trabajador1, trabajador2, trabajador3;
	static Usuario usuario1;
	static Oficio oficio1, oficio2, oficio3;
	static Servicio servicio1, servicio2, servicio3;
	static Herramienta herramienta1, herramienta2, herramienta3;
	
	public static void main (String args[])
	{
		LocalDate hoy = LocalDate.now();
		TrabajoPersonalizado trabajoPersonalizado1;
		
		cargarDatos();
		
		try
		{
			usuario1.contratar(1, hoy, false);
			usuario1.contratar(2, hoy, true);
			usuario1.contratar(3, hoy, false);
			
			trabajoPersonalizado1 = (TrabajoPersonalizado) reparaFix.buscarTrabajo(3);
			trabajoPersonalizado1.setValorPresupuestado(50000.0);
			trabajoPersonalizado1.setCostoDeMateriales(100000.0);
			trabajoPersonalizado1.setCostoDeTransporte(5000.0);
		}
		catch (SinTrabajadoresDisponiblesException e1) { System.out.println(e1.getMessage()); }
		catch (IdentificableNoEncontradoException e2)  { System.out.println(e2.getMessage()); }
		
		try
		{
			usuario1.contratar(1, 2, hoy.minusDays(2));
			usuario1.contratar(2, 3, hoy.minusDays(3));
			usuario1.contratar(3, 4, hoy);
		}
		catch (AlquilerNoEntregadoException e3) 	  { System.out.println(e3.getMessage()); }
		catch (HerramientaYaAlquiladaException e4)    { System.out.println(e4.getMessage()); }
		catch (IdentificableNoEncontradoException e5) { System.out.println(e5.getMessage()); }
		
		System.out.println("Costo contratables: $ " + usuario1.calcularCostoContratables(hoy.getMonthValue()));
	}
	
	private static void cargarDatos()
	{
		reparaFix = new ReparaFix();
		
		oficio1 = new Oficio("Reparador de aire acondicionado", reparaFix);
		oficio2 = new Oficio("Cerrajeria", reparaFix);
		oficio3 = new Oficio("Gasista", reparaFix);
		
		reparaFix.agregarOficio(oficio1);
		reparaFix.agregarOficio(oficio2);
		reparaFix.agregarOficio(oficio3);
		
		trabajador1 = new Trabajador("Juan Perez", "juanperez@gmail.com", 500.0, 0.1, oficio1, reparaFix);
		trabajador2 = new Trabajador("Hernan Hernandez", "hhernandez@gmail.com", 600.0, 0.075, oficio2, reparaFix);
		trabajador3 = new Trabajador("Rodrigo Rodriguez", "rodrirodriguez@gmail.com", 450.0, 0.15, oficio3, reparaFix);
		
		reparaFix.agregarTrabajador(trabajador1);
		reparaFix.agregarTrabajador(trabajador2);
		reparaFix.agregarTrabajador(trabajador3);
		
		usuario1 = new Usuario("Federico Pacheco", "fedepacheco2112@gmail.com", "TDAmeritrade137", reparaFix);
		
		reparaFix.agregarUsuario(usuario1);
		
		servicio1 = new ServicioEstandar("Colocacion de gas", oficio1, reparaFix, 2718.281828);
		servicio2 = new ServicioEstandar("Cambio de cerradura", oficio2, reparaFix, 3141.592);
		servicio3 = new ServicioPersonalizado("Realizacion de instalacion de gas", oficio3, reparaFix);
		
		reparaFix.agregarServicio(servicio1);
		reparaFix.agregarServicio(servicio2);
		reparaFix.agregarServicio(servicio3);
		
		herramienta1 = new Herramienta("Escalera RX5700XT", 500.0, reparaFix);
		herramienta2 = new Herramienta("Bomba de vacio", 1000.0, reparaFix);
		herramienta3 = new Herramienta("Sierra", 300.0, reparaFix);
		
		reparaFix.agregarHerramienta(herramienta1);
		reparaFix.agregarHerramienta(herramienta2);
		reparaFix.agregarHerramienta(herramienta3);
	}
}
