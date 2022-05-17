package EJERCICIO1;

import java.sql.Date;

public class Estudiante 
{
	String id;
	String nombre;
	String ciudad;
	String telefono;
	Date fechanacimiento;
	int codgrado;
	
	public Estudiante(String i, String n, String c, String t, Date fecha, int cg)
	{
		this.id = i;
		this.nombre = n;
		this.ciudad = c;
		this.telefono = t;
		this.fechanacimiento = fecha;
		this.codgrado = cg;
	}
	public Estudiante ()
	{
		System.out.print("Dame un identificador: ");
		this.id = Console.readString();
		System.out.print("Dame el nombre del alumno: ");
		this.nombre = Console.readString();
		System.out.print("Dame la ciudad del alumno: ");
		this.ciudad = Console.readString();
		System.out.println("Dame la fecha de nacimiento del alumno: ");
		//this.fechanacmto = console.readDate();
		System.out.println("Dame el codigo del grado del alumno: ");
		this.codgrado = Console.readInt();
	}
	
	public String toString()
	{
		return this.id+"\t"+this.nombre+"\t"+this.ciudad+"\t"+this.telefono+"\t"+this.fechanacimiento+"\t"+this.codgrado;
	}
}
