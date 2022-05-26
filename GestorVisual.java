package EJERCICIO1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class GestorVisual extends JFrame
{
	private JPanel contentPane;
	private JTextField texto_id;
	private JTextField texto_nombre;
	private JTextField texto_ciudad;
	private JTextField texto_telefono;
	private JTextField texto_fecha;
	JLabel label_mensaje;
	String [] a = {"Administracion de Sistemas Informaticos en Red","Desarrollo Web"};
	public GestorVisual() {
		setTitle("EJERCICIO1_ALEX");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Titulo = new JLabel("STUDENTS MANAGER");
		Titulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		Titulo.setBounds(182, 44, 216, 25);
		contentPane.add(Titulo);
		
		JLabel label_id = new JLabel("ID:");
		label_id.setBounds(10, 95, 46, 14);
		contentPane.add(label_id);
		
		JLabel label_nombre = new JLabel("Nombre:");
		label_nombre.setBounds(10, 120, 67, 14);
		contentPane.add(label_nombre);
		
		JLabel label_ciudad = new JLabel("Ciudad:");
		label_ciudad.setBounds(10, 145, 67, 14);
		contentPane.add(label_ciudad);
		
		JLabel label_telefono = new JLabel("Telefono:");
		label_telefono.setBounds(10, 170, 85, 14);
		contentPane.add(label_telefono);
		
		JLabel label_fecha = new JLabel("Fecha de nacimiento:");
		label_fecha.setBounds(10, 195, 120, 14);
		contentPane.add(label_fecha);
		
		JLabel label_grado = new JLabel("Grado:");
		label_grado.setBounds(84, 244, 58, 14);
		contentPane.add(label_grado);
		
		JComboBox comboBox = new JComboBox();
		for (int i=0;i<a.length;i++)
		{
			comboBox.addItem(a[i]);
		}
		comboBox.setBounds(126, 240, 336, 22);
		contentPane.add(comboBox);
		
		JButton boton_buscar = new JButton("Buscar");
		boton_buscar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				GestorEstudiantes G1 = new GestorEstudiantes();
				Estudiante E1 = G1.buscarEstudiante(texto_id.getText());
				texto_nombre.setText(E1.getNombre());
				texto_ciudad.setText(E1.getCiudad());
				texto_telefono.setText(E1.getTelefono());
				texto_fecha.setText(E1.getFecha());
				comboBox.setSelectedItem(E1.getCodgrado());
				label_mensaje.setText("Alumno buscado correctamente");
			}
		});
		boton_buscar.setBounds(84, 269, 85, 23);
		contentPane.add(boton_buscar);
		
		JButton boton_insertar = new JButton("Insertar");
		boton_insertar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				GestorEstudiantes G1 = new GestorEstudiantes();
				String id_estudiante = texto_id.getText();
				String nombre_estudiante = texto_nombre.getText();
				String ciudad_estudiante = texto_ciudad.getText();
				String telefono_estudiante = texto_telefono.getText();
				String fecha_estudiante = texto_fecha.getText();
				int index = comboBox.getSelectedIndex();
				index++;
				Estudiante E1 = new Estudiante (id_estudiante,nombre_estudiante,ciudad_estudiante,telefono_estudiante,fecha_estudiante,index);
				G1.insertarEstudiante(E1);
				label_mensaje.setText("Alumno insertado correctamente");
			}
		});
		boton_insertar.setBounds(179, 269, 87, 23);
		contentPane.add(boton_insertar);
		
		JButton boton_modificar = new JButton("Modificar");
		boton_modificar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				GestorEstudiantes G1 = new GestorEstudiantes ();
				String id_estudiante = texto_id.getText();
				String nombre_estudiante = texto_nombre.getText();
				String ciudad_estudiante = texto_ciudad.getText();
				String telefono_estudiante = texto_telefono.getText();
				String fecha_estudiante = texto_fecha.getText();
				int index = comboBox.getSelectedIndex();
				index++;
				Estudiante E1 = new Estudiante (id_estudiante,nombre_estudiante,ciudad_estudiante,telefono_estudiante,fecha_estudiante,index);
				G1.modificarEstudiante(texto_id.getText(), E1);
				label_mensaje.setText("Alumno modificado correctamente");
			}
		});
		boton_modificar.setBounds(276, 269, 88, 23);
		contentPane.add(boton_modificar);
		
		JButton boton_eliminar = new JButton("Eliminar");
		boton_eliminar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				GestorEstudiantes G1 = new GestorEstudiantes();
				G1.borrarEstudiante(texto_id.getText());
				label_mensaje.setText("Alumno eliminado");
			}
		});
		boton_eliminar.setBounds(374, 269, 88, 23);
		contentPane.add(boton_eliminar);
		
		label_mensaje = new JLabel("");
		label_mensaje.setBounds(99, 303, 308, 35);
		contentPane.add(label_mensaje);
		
		texto_id = new JTextField();
		texto_id.setBounds(269, 92, 303, 20);
		contentPane.add(texto_id);
		texto_id.setColumns(10);
		
		texto_nombre = new JTextField();
		texto_nombre.setBounds(269, 117, 303, 20);
		contentPane.add(texto_nombre);
		texto_nombre.setColumns(10);
		
		texto_ciudad = new JTextField();
		texto_ciudad.setBounds(269, 142, 303, 20);
		contentPane.add(texto_ciudad);
		texto_ciudad.setColumns(10);
		
		texto_telefono = new JTextField();
		texto_telefono.setBounds(269, 167, 303, 20);
		contentPane.add(texto_telefono);
		texto_telefono.setColumns(10);
		
		texto_fecha = new JTextField();
		texto_fecha.setBounds(269, 192, 303, 20);
		contentPane.add(texto_fecha);
		texto_fecha.setColumns(10);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestorVisual G1 = new GestorVisual();
					G1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
