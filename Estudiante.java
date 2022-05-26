package EJERCICIO1;

public class Estudiante 
{
	private String id;
	private String nombre;
	private String ciudad;
	private String telefono;
	private String fecha;
	private int codgrado;
	
	public Estudiante(String i,String n, String c, String t, String f, int d) {
		this.id=i;
		this.nombre=n;
		this.ciudad=c;
		this.telefono=t;
		this.fecha=f;
		this.codgrado=d;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getCodgrado() {
		return codgrado;
	}

	public void setCodgrado(int codgrado) {
		this.codgrado = codgrado;
	}
		

}
