package paquetePrincipal;

public class TrabajoPersonalizado extends Trabajo
{	
	private Double valorPresupuestado;
	private Double costoDeMateriales;
	private Double costoDeTransporte;
	
	public TrabajoPersonalizado(Boolean esUrgente, Servicio servicio, Trabajador trabajador, ReparaFix app)
	{
		super(esUrgente, servicio, trabajador, app);
	}
	
	public Double getValorPresupuestado() {	return valorPresupuestado; }
	public Double getCostoDeMateriales()  { return costoDeMateriales;  }
	public Double getCostoDeTransporte()  { return costoDeTransporte;  }

	public void setValorPresupuestado(Double valorPresupuestado) { this.valorPresupuestado = valorPresupuestado; }
	public void setCostoDeMateriales (Double costoDeMateriales)  { this.costoDeMateriales = costoDeMateriales;   }
	public void setCostoDeTransporte (Double costoDeTransporte)  { this.costoDeTransporte = costoDeTransporte;   } 


	@Override
	public Boolean fueFinalizado() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Double calcularCosto() { return this.multiplicadorPorUrgencia() * (valorPresupuestado + costoDeMateriales + costoDeTransporte); }
}
