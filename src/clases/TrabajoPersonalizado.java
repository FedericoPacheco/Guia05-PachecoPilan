package clases;

import java.time.LocalDate;

public class TrabajoPersonalizado extends Trabajo
{	
	private Double valorPresupuestado;
	private Double costoDeMateriales;
	private Double costoDeTransporte;
	
	public TrabajoPersonalizado(Boolean esUrgente, LocalDate diaDeInicio, Servicio servicio, Trabajador trabajador, ReparaFix reparaFix)
	{
		super(esUrgente, diaDeInicio, servicio, trabajador, reparaFix);
		this.valorPresupuestado = 0.0;
		this.costoDeMateriales = 0.0;
		this.costoDeTransporte = 0.0;
	}
	
	public Double getValorPresupuestado() {	return valorPresupuestado; }
	public Double getCostoDeMateriales()  { return costoDeMateriales;  }
	public Double getCostoDeTransporte()  { return costoDeTransporte;  }

	public void setValorPresupuestado(Double valorPresupuestado) { this.valorPresupuestado = valorPresupuestado; }
	public void setCostoDeMateriales (Double costoDeMateriales)  { this.costoDeMateriales = costoDeMateriales;   }
	public void setCostoDeTransporte (Double costoDeTransporte)  { this.costoDeTransporte = costoDeTransporte;   } 

	@Override
	public Double calcularCosto() { return this.multiplicadorPorUrgencia() * (valorPresupuestado + costoDeMateriales + costoDeTransporte); }
}
