package paquetePrincipal;

public class ServicioEstandar extends Servicio
{
	private Double monto;
	
	public ServicioEstandar(String nombre, Oficio oficio, ReparaFix app, Double monto)
	{
		super(nombre, oficio, app);
		this.monto = monto;
	}
}
