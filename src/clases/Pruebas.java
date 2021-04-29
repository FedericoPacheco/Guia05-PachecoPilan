package clases;

import java.time.LocalDate;

import excepciones.AlquilerNoEntregadoException;
import excepciones.HerramientaYaAlquiladaException;
import excepciones.SinTrabajadoresDisponiblesException;

public class Pruebas 
{
	ReparaFix reparaFix;
	Trabajador trabajador1, trabajador2, trabajador3;
	Usuario usuario1;
	Oficio oficio1, oficio2, oficio3;
	Servicio servicio1, servicio2, servicio3;
	Herramienta herramienta1, herramienta2, herramienta3;
	
	public void main (String args[])
	{
		this.cargarDatos();
		
		try
		{
			usuario1.contratar(1, LocalDate.now(), false);
			usuario1.contratar(2, LocalDate.now(), true);
			usuario1.contratar(3, LocalDate.now(), false);
		}
		catch (SinTrabajadoresDisponiblesException e1) { System.out.println(e1.getMessage()); }
		
		try
		{
			// ver si agregar un excepcion para cuando la herramienta no esta disponible
			
			usuario1.contratar(1, 2, LocalDate.now());
			usuario1.contratar(2, 3, LocalDate.now());
			usuario1.contratar(3, 4, LocalDate.now());
		}
		catch (AlquilerNoEntregadoException e2) { System.out.println(e2.getMessage()); }
		catch (HerramientaYaAlquiladaException e3) { System.out.println(e2.getMessage()); }
	}
	
	private void cargarDatos()
	{
		reparaFix = new ReparaFix();
		
		oficio1 = new Oficio("Reparador de aire acondicionado", reparaFix);
		oficio2 = new Oficio("Cerrajeria", reparaFix);
		oficio3 = new Oficio("Gasista", reparaFix);
		
		trabajador1 = new Trabajador("Juan Perez", "juanperez@gmail.com", 500.0, 0.1, oficio1, reparaFix);
		trabajador2 = new Trabajador("Hernan Hernandez", "hhernandez@gmail.com", 600.0, 0.075, oficio2, reparaFix);
		trabajador3 = new Trabajador("Rodrigo Rodriguez", "rodrirodriguez@gmail.com", 450.0, 0.15, oficio3, reparaFix);
		
		usuario1 = new Usuario("Federico Pacheco", "fedepacheco2112@gmail.com", "TDAmeritrade137", reparaFix);
		
		servicio1 = new ServicioEstandar("Colocacion de gas", oficio1, reparaFix, 2718.281828);
		servicio2 = new ServicioEstandar("Cambio de cerradura", oficio2, reparaFix, 3141.592);
		servicio3 = new ServicioPersonalizado("Realizacion de instalacion de gas", oficio3, reparaFix);
		
		herramienta1 = new Herramienta("Escalera RX5700XT", 500.0, reparaFix);
		herramienta2 = new Herramienta("Bomba de vacio", 1000.0, reparaFix);
		herramienta3 = new Herramienta("Sierra", 300.0, reparaFix);
	}
}
