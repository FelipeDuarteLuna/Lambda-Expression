package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {
	public static void main(String[]args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter full file path: ");
		String file = sc.next(); //‪C:\\temp\\employee.txt
		
		System.out.println("Enter Salary: ");
		Double salario = sc.nextDouble();
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			List<Employee> worker = new ArrayList<>();
			
			String line = br.readLine();
			while(line != null) {
				
				String [] fields =  line.split(",");
				worker.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = br.readLine();
			}
			
			System.out.println("Email of people whose salary is more than 2000.00");
			
			Comparator<Employee> comp1 = (p1,p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());

			List <Employee> names  = worker.stream()
					.filter(w -> w.getSalary() > salario)
					.sorted(comp1)
					.collect(Collectors.toList());
			
			names.forEach(System.out::println);
			
			System.out.println();
			
			double avg = worker.stream()
					.filter(w -> w.getName().charAt(0) == 'M')
					.map(w -> w.getSalary())
					.reduce(0.0, (subtotal, w) -> subtotal + w);
			
			System.out.println("Sum of Salary of people whose name starts with 'M': " + avg);
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println("Error reading file: " + e.getMessage());
		}finally {
			sc.close();
		}
		
	}

}
