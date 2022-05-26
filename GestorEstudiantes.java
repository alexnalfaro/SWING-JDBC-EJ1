package EJERCICIO1;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestorEstudiantes 
{
	Connection con;
	Statement st;
	ResultSet rs;
	
	public GestorEstudiantes () 
	{
		
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
		String fechanacimiento;
		int codgrado;
		
		while (rs.next())
		{
			id = rs.getString("id");
			nombre = rs.getString("nombre");
			ciudad = rs.getString("ciudad");
			telefono = rs.getString("telefono");
			fechanacimiento = rs.getString("fecha");
			codgrado = rs.getInt("codgrado");
			Estudiante E1 = new Estudiante (id,nombre,ciudad,telefono,fechanacimiento,codgrado);
			a.add(E1);
		}
		return a;
	}
	
	public Estudiante buscarEstudiante (String idestudiante)
	{
		String url = "jdbc:mysql://localhost/ejercicio1";
		String user = "root";
		String psswd = "root";
		try {
			con = DriverManager.getConnection(url,user,psswd);
			System.out.println("Conectado");
			st = con.createStatement();
			String query = "SELECT * FROM estudiante WHERE id='"+idestudiante+"';";
			rs = st.executeQuery(query);
			String id = "";
			String nombre = "";
			String ciudad = "";
			String telefono = "";
			String fechanacimiento = "";
			int codgrado = 0;	
			while (rs.next())
			{
				id = rs.getString("id");
				nombre = rs.getString("nombre");
				ciudad = rs.getString("ciudad");
				telefono = rs.getString("telefono");
				fechanacimiento = rs.getString("fechanacimiento");
				codgrado = rs.getInt("codgrado");
			}
			Estudiante E1 = new Estudiante (id,nombre,ciudad,telefono,fechanacimiento,codgrado);
			con.close();
			return E1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void borrarEstudiante(String idestudiante)
	{
		String url = "jdbc:mysql://localhost/ejercicio1";
		String user = "root";
		String psswd = "root";
		try {
			Connection con = DriverManager.getConnection(url,user,psswd);
			String query = "DELETE FROM estudiante where id='"+idestudiante+"';";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.execute();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertarEstudiante (Estudiante E1)
	{
		String url = "jdbc:mysql://localhost/ejercicio1";
		String user = "root";
		String password = "root";
		try {
			con = DriverManager.getConnection(url, user, password);
			String id = E1.getId();
			String nombre = E1.getNombre();
			String ciudad = E1.getCiudad();
			String telefono = E1.getTelefono();
			String fecha = E1.getFecha();
			int cod = E1.getCodgrado();
			String query = "INSERT INTO estudiante VALUES ('"+id+"','"+nombre+"','"+ciudad+"','"+telefono+"','"+fecha+"','"+cod+"');";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.execute();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void modificarEstudiante (String idestudiante, Estudiante E1)
	{
		String url = "jdbc:mysql://localhost/ejercicio1";
		String user = "root";
		String password = "root";
		try {
			con = DriverManager.getConnection(url,user,password);
			String nombre = E1.getNombre();
			String ciudad = E1.getCiudad();
			String telefono = E1.getTelefono();
			String fecha = E1.getFecha();
			int cod = E1.getCodgrado();
			String query = "UPDATE estudiante SET nombre = '"+nombre+"', ciudad = '"+ciudad+"', telefono = '"+telefono+"', fechanacimiento = '"+fecha+"', codgrado = '"+cod+"' WHERE id = '"+idestudiante+"';";		
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.execute();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main (String [] args) throws SQLException
	{
		GestorEstudiantes G1 = new GestorEstudiantes();
	}
	
}