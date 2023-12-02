class Address
{
	public Address() {
		System.out.println("Address Default Constructor");
	}
}
public class Employee {

	Address address;
	public Employee(Address address) {
		this.address=address;
	}
	public static void main(String[] args) {
		
		Employee e=new Employee(new Address());
	}
}
