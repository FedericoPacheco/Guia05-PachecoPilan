package paquetePrincipal;

public class ServicioEstandar extends Servicio
{
	private static Integer contadorIds = 0;
	private Double monto;
	
	public ServicioEstandar(String nombre, Oficio oficio, Double monto)
	{
		super(nombre, oficio);
		this.monto = monto;
		this.id = contadorIds++;
	}
}
