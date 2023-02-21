package aplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entities.Employee;

public class Main {

	public static void main(String[] args) {
		String path = "C:\\temp\\in.txt";
		List<Employee> employes = new ArrayList<Employee>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			String list = br.readLine();
			
			while (list != null) {
				String[] fields = list.split(",");
				employes.add(new Employee(fields[0], Double.parseDouble(fields[1])));
				
				list = br.readLine();
			}
			
			Collections.sort(employes);
			
			for (Employee employee : employes) {
				System.out.println(employee.getName() + ", " + employee.getSalary());
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
