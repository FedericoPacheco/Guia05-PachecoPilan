package excepciones;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import clases.Oficio;

@SuppressWarnings("serial")
public class SinTrabajadoresDisponiblesException extends Exception 
{
	// https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
	static private final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public SinTrabajadoresDisponiblesException(Oficio oficio, LocalDate dia)
	{
		super("Error. No hay trabajadores disponibles del oficio: " + oficio.getNombre() + "; para el dia: " + dia.format(formato) + ".");
	}
}
