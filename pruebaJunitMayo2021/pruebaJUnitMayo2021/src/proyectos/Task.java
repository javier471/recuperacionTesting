package proyectos;

import java.time.LocalDate;

public class Task 
{
	private String concept;
	private int days;
	private LocalDate iniDate;
	private boolean end;
	
	
	public Task() {
		this.end= false;
	}
	
	public String getConcept() {
		return concept;
	}
	public void setConcept(String concept) {
		this.concept = concept;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public LocalDate getIniDate() {
		return iniDate;
	}
	public void setIniDate(LocalDate iniDate) {
		this.iniDate = iniDate;
	}
	
	/*
	 * Da por terminada la tarea
	 */
	public void ended() {
		this.end= true;
	}

	@Override
	public String toString() {
		return "Task " + concept + ", Fecha inicio=" + iniDate 
				+ ", duración=" + days + ((this.end)?".Terminado":".En proceso") ;
	}
	
	

	
}