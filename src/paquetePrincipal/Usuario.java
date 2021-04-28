package paquetePrincipal;

import java.util.List;

public class Usuario implements Identificable
{
	static private Integer contadorIds = 0;
	
	private Integer id;
	private String nombreUsuario;
	private String correoElectronico;
	private String contrasenia;
	private List<Contratable> trabajosYAlquileresContratados;
	private ReparaFix app;
	
	public Usuario(String nombreUsuario, String correoElectronico, String contrasenia, ReparaFix app) 
	{
		this.id = contadorIds++;
		this.nombreUsuario = nombreUsuario;
		this.correoElectronico = correoElectronico;
		this.contrasenia = contrasenia;
		this.app = app;
	}

	@Override
	public Integer getId() {
		return id;
	}
	
	
	
	//public void contratar()
	//{
		
	//}
}
