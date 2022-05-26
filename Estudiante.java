package EJERCICIO1;

public class Estudiante 
{
	private String id;
	private String nombre;
	private String ciudad;
	private String telefono;
	private String fecha;
	private String codgrado;
	
	public Estudiante(String i,String n, String c, String t, String f, String d) {
		this.id=i;
		this.nombre=n;
		this.ciudad=c;
		this.telefono=t;
		this.fecha=f;
		this.codgrado=d;
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

	public String getCodgrado() {
		return codgrado;
	}

	public void setCodgrado(String codgrado) {
		this.codgrado = codgrado;
	}
		

}
