package clases;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import excepciones.SinTrabajadoresDisponiblesException;
import interfaces.Contratable;
import interfaces.Identificable;

public class ReparaFix // App
{
	private List<Identificable> contratablesRealizados;
	private List<Identificable> trabajadoresRegistrados;
	private List<Identificable> usuariosRegistrados;
	private List<Identificable> oficiosRegistrados;
	private List<Identificable> serviciosDisponibles;
	private List<Identificable> herramientasDisponibles;
	
	public ReparaFix() 
	{
		contratablesRealizados  = new LinkedList<Identificable>();
		trabajadoresRegistrados = new LinkedList<Identificable>();
		usuariosRegistrados 	= new LinkedList<Identificable>();
		oficiosRegistrados 		= new LinkedList<Identificable>();
		serviciosDisponibles 	= new LinkedList<Identificable>();
		herramientasDisponibles = new LinkedList<Identificable>();
	}
	
	public void agregarContratable(Contratable contratable)  { contratablesRealizados.add((Identificable) contratable); }
	public void agregarTrabajador(Trabajador trabajador)	 { trabajadoresRegistrados.add(trabajador); 			    }
	public void agregarUsuario(Usuario usuario) 			 { usuariosRegistrados.add(usuario);			   		    }
	public void agregarOficio(Oficio oficio) 				 { oficiosRegistrados.add(oficio); 						    }
	public void agregarServicio(Servicio servicio) 			 { serviciosDisponibles.add(servicio); 					    }
	public void agregarHerramienta(Herramienta herramienta)  { herramientasDisponibles.add(herramienta); 			    }
	
	public Contratable buscarContratable(Integer id) { return (Contratable) this.buscar(contratablesRealizados, id);  }
	public Trabajador buscarTrabajador(Integer id)   { return (Trabajador) this.buscar(trabajadoresRegistrados, id);  }
	public Usuario buscarUsuario(Integer id) 		 { return (Usuario) this.buscar(usuariosRegistrados, id); 		  }
	public Oficio buscarOficio(Integer id) 			 { return (Oficio) this.buscar(oficiosRegistrados, id); 		  }
	public Servicio buscarServicio(Integer id) 		 { return (Servicio) this.buscar(serviciosDisponibles, id); 	  }
	public Herramienta buscarHerramienta(Integer id) { return (Herramienta) this.buscar(herramientasDisponibles, id); }
	
	private Identificable buscar(List<Identificable> lista, Integer id)  
	{
		for (Identificable i: lista)
			if (i.getId() == id)
				return i;
		return null; // perdoneme profesor
	}
	
	public Optional<Trabajador> buscarTrabajadorConOficio(Oficio oficio, LocalDate diaDeInicio, Boolean esUrgente) throws SinTrabajadoresDisponiblesException
	{
		Trabajador auxTrabajador = null;
		Integer i = 0;
		Boolean trabajadorEncontrado = false;
		
		while (i < trabajadoresRegistrados.size() && !trabajadorEncontrado)
		{
			auxTrabajador = (Trabajador) trabajadoresRegistrados.get(i);
			if (auxTrabajador.getOficio().equals(oficio) && !auxTrabajador.agendaOcupada(diaDeInicio))
				trabajadorEncontrado = true;
			else
				i++;
		}
		
		if (!esUrgente)
			return Optional.of(auxTrabajador);
		else
			if (auxTrabajador == null)
				throw new SinTrabajadoresDisponiblesException(oficio, diaDeInicio);
			else
				return Optional.of(auxTrabajador);
	}
			
	
	
	
}