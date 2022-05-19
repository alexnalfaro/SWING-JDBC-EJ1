package EJERCICIO1;

import java.sql.Connection;
//import java.sql.Date;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestorEstudiantes 
{
	static Connection con;
	static Statement st;
	static ResultSet rs;
	
	public GestorEstudiantes () throws SQLException
	{
		String url = "jdbc:mysql://localhost/JDBC_ALEX_EJERCICIO1";
		String user = "root";
		String psswd = "root";
		GestorEstudiantes.con = DriverManager.getConnection(url,user,psswd);
		System.out.println("Conectado");
	}
	
	public ArrayList<Estudiante> listaEstudiantes() throws Exception
	{
		ArrayList<Estudiante> a = new ArrayList<Estudiante>();
		st = con.createStatement();
		String query = "SELECT * FROM estudiante";
		rs = st.executeQuery(query);
		
		String id;
		String nombre;
		String ciudad;
		String telefono;
		Date fechanacimiento;
		int codgrado;
		
		while (rs.next())
		{
			id = rs.getString("id");
			nombre = rs.getString("nombre");
			ciudad = rs.getString("ciudad");
			telefono = rs.getString("telefono");
			fechanacimiento = rs.getDate("fecha");
			codgrado = rs.getInt("codgrado");
			Estudiante E1 = new Estudiante (id,nombre,ciudad,telefono,fechanacimiento,codgrado);
			a.add(E1);
		}
		return a;
	}
	
	public static Estudiante buscarEstudiante (int idestudiante) throws Exception
	{
		st = con.createStatement();
		String query = "SELECT * FROM estudiante WHERE id = '"+idestudiante+"'";
		rs = st.executeQuery(query);
		String id;
		String nombre;
		String ciudad;
		String telefono;
		Date fechanacimiento;
		int codgrado;
		
		id = rs.getString("id");
		nombre = rs.getString("nombre");
		ciudad = rs.getString("ciudad");
		telefono = rs.getString("telefono");
		fechanacimiento = rs.getDate("fecha");
		codgrado = rs.getInt("codgrado");
		Estudiante E1 = new Estudiante (id,nombre,ciudad,telefono,fechanacimiento,codgrado);
		
		return E1;
	}
	
	public void borrarEstudiante(int idestudiante) throws SQLException
	{
		st = con.createStatement();
		String query = "SELECT * FROM estudiante WHERE id = '"+idestudiante+"'";
		rs = st.executeQuery(query);
		if (rs != null)
		{
			st = con.createStatement();
			String query2 = "DELETE FROM estudiante WHERE id = '"+idestudiante+"'";
			rs = st.executeQuery(query2);
		}
		else
		{
			System.err.print("No existe el alumno");
		}
	}
	
	public void insertarEstudiante (Estudiante E1) throws SQLException
	{
		String id = E1.id;
		String nombre = E1.nombre;
		String ciudad = E1.ciudad;
		String telefono = E1.telefono;
		Date fechanacimiento = E1.fechanacimiento;
		int codgrado = E1.codgrado;
		
		st = con.createStatement();
		String query = "INSERT INTO estudiante VALUES ('"+id+"','"+nombre+"','"+ciudad+"','"+telefono+"','"+fechanacimiento+"','"+codgrado+"')";
		rs = st.executeQuery(query);
	}
	
	public void modificarEstudiante (int idestudiante, Estudiante E1) throws SQLException
	{
		String id = E1.id;
		String nombre = E1.nombre;
		String ciudad = E1.ciudad;
		String telefono = E1.telefono;
		Date fechanacimiento = E1.fechanacimiento;
		int codgrado = E1.codgrado;
		
		st = con.createStatement();
		String query = "UPDATE students SET id = '"+id+"', nombre = '"+nombre+"', ciudad = '"+ciudad+"', telefono = '"+telefono+"', fechanacimiento = '"+fechanacimiento+"', codgrado = '"+codgrado+"' WHERE id = '"+idestudiante+"'";
		rs = st.executeQuery(query);
	}
	
	public Grado buscarGrado(int idgrado) throws SQLException
	{
		
		st = con.createStatement();
		String query = "SELECT * FROM grado WHERE codgrado = '"+idgrado+"'";
		rs = st.executeQuery(query);
		
		int codgrado = rs.getInt("codgrado");
		String nombre = rs.getString("nombre");
		int horas = rs.getInt("horas");
		
		Grado G1 = new Grado (codgrado,nombre,horas);
		return G1;		
	}
	
	public ArrayList<Grado> listaGrados() throws Exception
	{
		ArrayList<Grado> a = new ArrayList<Grado>();
		st = con.createStatement();
		String query = "SELECT * FROM grado";
		rs = st.executeQuery(query);
		
		int codgrado;
		String nombre;
		int horas;
		
		while (rs.next())
		{
			codgrado = rs.getInt("codgrado");
			nombre = rs.getString("nombre");
			horas = rs.getInt("horas");
			Grado G1 = new Grado (codgrado,nombre,horas);
			a.add(G1);
		}
		return a;
	}
	
	public void cerrarConexion() throws SQLException
	{
		con.close();
	}
	
	public static void main (String [] args) throws SQLException
	{
		GestorEstudiantes G1 = new GestorEstudiantes();
	}
	
}