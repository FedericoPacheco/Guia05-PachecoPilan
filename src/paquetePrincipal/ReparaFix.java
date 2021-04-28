package paquetePrincipal;

import java.util.LinkedList;
import java.util.List;

public class ReparaFix // App
{
	private List<Contratable> serviciosYAlquileresRealizados;
	private List<Trabajador> trabajadoresRegistrados;
	private List<Usuario> usuariosRegistrados;
	private List<Oficio> oficiosRegistrados;
	private List<Servicio> serviciosDisponibles;
	private List<Herramienta> herramientasDisponibles;
	
	public ReparaFix() 
	{
		serviciosYAlquileresRealizados = new LinkedList<Contratable>();
		trabajadoresRegistrados = new LinkedList<Trabajador>();
		usuariosRegistrados = new LinkedList<Usuario>();
		oficiosRegistrados = new LinkedList<Oficio>();
		serviciosDisponibles = new LinkedList<Servicio>();
		herramientasDisponibles = new LinkedList<Herramienta>();
	}
	
	public void agregarContratable(Contratable contratable)  { serviciosYAlquileresRealizados.add(contratable); }
	public void agregarTrabajador(Trabajador trabajador)	 { trabajadoresRegistrados.add(trabajador); 		}
	public void agregarUsuario(Usuario usuario) 			 { usuariosRegistrados.add(usuario);				}
	public void agregarOficio(Oficio oficio) 				 { oficiosRegistrados.add(oficio); 					}
	public void agregarServicio(Servicio servicio) 			 { serviciosDisponibles.add(servicio); 				}
	public void agregarHerramienta(Herramienta herramienta)  { herramientasDisponibles.add(herramienta); 		}
	
	 public Object buscar(List<Identificable> lista, Integer id)
	{
		for (Identificable i: lista)
			if (i.getId() == id)
				return i;
		
		return null; // ver si usar optional
	}
	
}