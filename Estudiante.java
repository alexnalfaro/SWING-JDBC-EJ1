package EJERCICIO1_;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Estudiante {
	private String id;
	private String name;
	private String city;
	private String telephone;
	private String fechaNacmto;
	private String degreeCode;
	
	public Estudiante(String i,String n, String c, String t, String f, String d) {
		this.id=i;
		this.name=n;
		this.city=c;
		this.telephone=t;
		this.fechaNacmto=f;
		this.degreeCode=d;
	}
	
//	public Estudiante(String id2, String nombre, String ciudad, String telefono, String fechaNacimiento) {
//		System.out.println("Dame el ID del estudiante.");
//		this.id=Console.readString();
//		System.out.println("Dame el nombre del estudiante.");
//		this.name=Console.readString();
//		System.out.println("Dame la ciudad del estudiante.");
//		this.city=Console.readString();
//		System.out.println("Dame el telefono del estudiante.");
//		this.telephone=Console.readString();
//		System.out.println("Dame la Fecha de nacimiento del estudiante.");
//		this.fechaNacmto =Console.readString();
//		System.out.println("Dame el Degree Code del estudiante.");
//		this.degreeCode=Console.readInt();
//	}
	
	public String getDegreeCode() {
		return degreeCode;
	}

	public void setDegreeCode(String degreeCode) {
		this.degreeCode = degreeCode;
	}

	public String toString() {
		return "El alumno tiene como id: "+this.id+"."+"\n"+"Nombre: "+this.name+"."+"\n"+"Ciudad: "+this.city+"."+"\n"+"Teléfono: "+this.telephone+"."+"\n"+"Fecha nacimiento: "+this.fechaNacmto+".";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFechaNacmto() {
		return fechaNacmto;
	}

	public void setFechaNacmto(String fechaNacmto) {
		this.fechaNacmto = fechaNacmto;
	}

}
