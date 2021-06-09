package proyectos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;

public class Proyecto 
{
	// Variable estática para asingar los códigos de forma automática
	private static int NextCod=0;
	// Código que identifica de forma única al proyecto
	private int cod;
	// Nombre del proyecto
	private String name;
	// Fecha de inicio del proyecto
	private LocalDate iniDate;
	// Fecha de finalización del proyecto
	private LocalDate endDate;
	// Conjunto de tareas que forman un proyecto
	private ArrayList<Task> tasklist;

	/* Constructor que asigna el código de forma automática
	 * un valor siguiente al último que se creó. 
	 * Si la fechaIni es anterior a la fecha de hoy lanzará una exception.
	 * Si la fichaFin es anterior a la fechaIni lanzará una exeption 
	 */
	
	public Proyecto(String nombre, LocalDate fechaIni, LocalDate fechaFin) throws FechaInicialFinalNoValidaException, FechaInicialProyectoNoValidaException
	{
		if (fechaIni.isBefore(LocalDate.now()))
			throw new FechaInicialProyectoNoValidaException("La fecha de inicio debe ser posterior a hoy");
		if (fechaFin.isBefore(fechaIni))
			throw new FechaInicialFinalNoValidaException("La fecha final debe ser posterior a la fecha inicial");

		this.cod = NextCod;
		this.endDate = fechaFin;
		this.iniDate = fechaIni;
		this.name = nombre;
		this.tasklist = new ArrayList<Task>();
			
	}
	/* Añade una tarea al proyecto.
	 * Si la duración es negativa, lanzará una exception
	 * Si la fecha es anterior a la fecha de inicio del proyecto lanzará una exception
	 * Si la fecha es posterir a la fecha de finalizaciónd el proyecto lanzará una exception
	 */
	
	public void addTarea(String concept, LocalDate fechaIni, int dias) throws FechaInicialTareaNoValidaException,DuracionTareaNoValidoException
	{
		if (dias<=0)
			throw new DuracionTareaNoValidoException("No se puede añadir una tarea con tiempo negativo");
		if (fechaIni.isBefore(this.iniDate) || fechaIni.isAfter(this.endDate))
			throw new FechaInicialTareaNoValidaException("No se puede añadir una tarea fuera de los límites del proyecto");

		Task t=new Task();
		t.setConcept(concept);
		t.setDays(dias);
		t.setIniDate(fechaIni);
		this.tasklist.add(t);
	}
	/*
	 * Borra la tarea que tiene el concepto que se la pasa por argumento.
	 * Si la tarea no existe y no se puede borrar devuelve false
	 * Si la tarea existe y es borrada devuelve true
	 */
	
	public boolean delTask(String concepto) 
	{
		Task t=new Task();
		t.setConcept(concepto);
		return this.tasklist.remove(t);
	}	
	
	/*
	 * Funcion que da por finalizada una tarea
	 * Si la tarea no existe y no se puede dar por finalizada devuelve false
	 * Si la tarea se da por finalizada devuelve true
	 */
	
	public boolean endTask(String concepto) 
	{
		Task t=new Task();
		t.setConcept(concepto);
		try {
			this.tasklist.get(this.tasklist.indexOf(t)).ended();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/*
	 * toString del proyecto
	 */
	@Override
	public String toString() {
		
		StringBuilder resul = new StringBuilder("Proyecto " + name + " con código " + cod + 
				       ". Fecha de comienzo "+ iniDate + ". Fecha final:" + endDate + "\n");
		
		for (Task t: this.tasklist) {
			resul.append(t +"\n");
		}

		return resul.toString();
	}
	
	
	
}