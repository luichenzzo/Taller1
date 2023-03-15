package co.edu.uniquindio.biblioteca.test;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import co.edu.uniquindio.biblioteca.model.Categoria;
import co.edu.uniquindio.biblioteca.model.Cliente;
import co.edu.uniquindio.biblioteca.model.Directivo;
import co.edu.uniquindio.biblioteca.model.Empleado;
import co.edu.uniquindio.biblioteca.model.Empresa;
import co.edu.uniquindio.biblioteca.model.Persona;

public class Test {

	public static void main(String[] args) {

		Empresa empresa = new Empresa("Uq empresa");
		
		Persona persona = new Empleado("Juan",23,23445);
		
		Cliente cliente = new Cliente("Luz",23,"345678");
		
		
		ArrayList<Empleado>listaSubordinados = new ArrayList<Empleado>();
		
		listaSubordinados.add((Empleado)persona);
		
		empresa.getListaPersonas().add(persona);
		empresa.getListaPersonas().add(cliente);
		
		Directivo directivo = new Directivo("Carlos",19,5000000,Categoria.GERENTE, listaSubordinados);
	
		empresa.getListaPersonas().add(directivo);
		
		
		// hacer un metodo que imprima el salriobruot de los empleado debe manipular la lista personas de la empresa
		String Sueldos = GenerarReporteSueldos (empresa.getListaPersonas());
		JOptionPane.showMessageDialog(null, Sueldos);
		
	}
	public static String GenerarReporteSueldos (List<Persona> listaPersonas) {
	String sueldos = "[ ";
	for (Persona persona : listaPersonas) {
		if (persona instanceof Empleado) {
			sueldos += ((Empleado) persona).getSueldoBruto();
			sueldos += " ; ";
		}	
	}
	sueldos += " ] ";
	return sueldos;
	
	}
	
	
}
