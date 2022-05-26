package EJERCICIO1_;
import java.sql.Connection;
import java . sql . DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestorEstudiantes_g {
	private Connection conexion;
	private Statement command;
	private ResultSet rs;
	ArrayList<Estudiante> lista;
	
	
	public GestorEstudiantes_g() {
	
	}
	
	public ArrayList<Estudiante> listaEstudiantes() {
		try {
			
			String query = "SELECT * FROM students;";
			PreparedStatement stmt = conexion.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			String id;
			String nombre;
			String ciudad;
			String telefono;
			String fechaNacimiento;
			String degreeCode;
			while (rs.next()) {
				id = rs.getString("Id");
				nombre = rs.getString("Name");
				ciudad = rs.getString("City");
				telefono = rs.getString("Telephone");
				fechaNacimiento = rs.getString("FechaNacmto");
				degreeCode = rs.getString("DegreeCode");
				lista = new ArrayList<Estudiante>();
				lista.add(new Estudiante(id,nombre,ciudad,telefono,fechaNacimiento,degreeCode));
				return lista;
				}
			conexion.close();
			} catch (Exception e1) {
			
		}
		return lista;
	}
	
	public Estudiante buscarEstudiante(String id) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/JDBC_ALEX_EJERCICIO1", "root", "root");
			String query = "SELECT * FROM estudiante WHERE id='"+id+"';";
			this.command = con.createStatement();
			this.command.executeQuery("show databases;");
			rs = command.executeQuery(query);
			PreparedStatement stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			String iD="";
			String nombre="";
			String ciudad="";
			String telefono="";
			String fechaNacimiento="";
			String degreeCode="";
			while (rs.next()) {
				iD = rs.getString("Id");
				nombre = rs.getString("nombre");
				ciudad = rs.getString("ciudad");
				telefono = rs.getString("telefono");
				fechaNacimiento = rs.getString("fechanacimiento");
				degreeCode = rs.getString("codgrado");	
			}
			return new Estudiante(iD, nombre, ciudad, telefono, fechaNacimiento, degreeCode);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void borrarEstudiante(String id) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pruebajdbceclipse", "root", "root");
			String query = "DELETE FROM students where id='"+id+"';";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.execute();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void insertarEstudiante(Estudiante a) {
		try {
		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pruebajdbceclipse", "root", "root");
			String query = "INSERT students values('"+a.getId()+"','"+a.getName()+"','"+a.getCity()+"','"+a.getTelephone()+"','"+a.getFechaNacmto()+"','"+a.getDegreeCode()+"');";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.execute();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void modificarEstudiante(String id, Estudiante a) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pruebajdbceclipse", "root", "root");
			String query = "UPDATE  students set Name='"+a.getName()+"', City='"+a.getCity()+"', Telephone='"+a.getTelephone()+"', FechaNacmto='"+a.getFechaNacmto()+"', DegreeCode='"+a.getDegreeCode()+"' WHERE id='"+id+"';";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.execute();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
