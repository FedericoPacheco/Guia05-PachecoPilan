package excepciones;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import clases.Oficio;

@SuppressWarnings("serial")
public class SinTrabajadoresDisponiblesException extends Exception 
{
	public SinTrabajadoresDisponiblesException(Oficio oficio, LocalDate dia)
	{
		// https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
		// Muestra la fecha en formato anglosajon, pero bueno; es mas sencillo.
		super("Error. No hay trabajadores disponibles del oficio: " + oficio.getNombre() + " para el dia: " + DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(dia));
	}
}
