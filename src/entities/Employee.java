package entities;

public class Employee {

	private String name;
	private String email;
	private Double salary;
	
	//constructor
	public Employee() {
		
	}
	
	public Employee(String nome, String email, Double salario) {
		this.name = nome;
		this.email = email;
		this.salary = salario;
	}
	
	//Getter's and Setter's
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	//Method
	@Override
	public String toString() {
		return "Employee [name=" + name + ", email=" + email + ", salary=" + salary + "]";
	}
			
	
}
