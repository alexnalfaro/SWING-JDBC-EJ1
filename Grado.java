package EJERCICIO1;

public class Grado 
{
	int codgrado;
	String nombre;
	int horas;
	
	public Grado (int id, String t, int h)
	{
		this.codgrado = id;
		this.nombre = t;
		this.horas = h;
	}
	
	public String toString ()
	{
		return this.codgrado+"\t"+this.nombre+"\t"+this.horas;
	}
}
