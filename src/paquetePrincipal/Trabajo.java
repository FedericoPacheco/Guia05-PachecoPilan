package paquetePrincipal;

import java.time.LocalDate;

public abstract class Trabajo implements Contratable
{
	private LocalDate diaDeFinalizacion;
	private Boolean esUrgente;
}
