package AddressBook;

import java.util.*;

public class AddressBook {
	private String name;
	private String street;
	private String city;
	private String state;
	private int zip;
	private String phoneNumber;
	
	AddressBook(String name,String street, String city, String state, int zip, String phoneNumber){
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber= phoneNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public String getStreet() {
		return street;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public int getZip() {
		return zip;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	//print the address book info
	public String toString() {
		return name+" "+street+" "+city+" "+state+" "+zip+" "+phoneNumber+" ";
	}
	
}
//this will be used to add the insert, update, display, delete
class CRUDDemo{
	public static void main(String[] args) {
		
		//use list collection to be able to update a record
		List<AddressBook> c = new ArrayList<AddressBook>();
		//to get input from user create an instance of scanner 
		//Scanner instance s is for numbers while Scanner instance s1 will be used for the string 
		Scanner s = new Scanner(System.in);
		Scanner s1 = new Scanner(System.in);
		int ch;
		do {
			//loop will run continuously until user provides an input
			System.out.println("1.INSERT");
			System.out.println("2.DISPLAY");
			System.out.println("3.SEARCH");
			System.out.println("4.DELETE");
			System.out.println("5.UPDATE");
			System.out.println("Enter Your Choice : ");
			ch = s.nextInt();
			
			switch(ch){
			//this case is to take information from user for the address book i.e insert
			case 1:
				System.out.println("Enter Name : ");
				String name = s1.nextLine();
				System.out.print("Enter Street : ");
				String street = s1.nextLine();
				System.out.print("Enter City : ");
				String city = s1.nextLine();
				System.out.print("Enter State : ");
				String state = s1.nextLine();
				System.out.print("Enter Zip : ");
				int zip = s.nextInt();
				System.out.print("Enter Phone Number : ");
				String phoneNumber = s1.nextLine();
				
				//add new object to the collection
				c.add(new AddressBook(name,street,city,state,zip,phoneNumber));
			break;
			
			//this is to display the collection information  
			case 2:
				//to separate out each record
				System.out.println("---------------------------------------------------------------");
				//Iterator is the function that will retract each record one by one 
				Iterator<AddressBook> i = c.iterator();
				//create a loop to see if next next record is available
				while(i.hasNext()) {
					//this will display the records
					AddressBook a = i.next();
					System.out.println(a);
				}
				//draw a line to separate each record
				System.out.println("---------------------------------------------------------------");
			break;
			//Search option 
			case 3:
				//record cannot be found
				boolean found = false;
				System.out.println("Enter Phone Number to Search : ");
				phoneNumber  = s1.nextLine();
				//to separate out each record
				System.out.println("---------------------------------------------------------------");
				//create a loop to see if next next record is available
				i = c.iterator();
				while(i.hasNext()) {
					//this will display the records
					AddressBook a = i.next();
					//create a loop so that phone number searched is equal to the one entered by the users in the record
					if(a.getPhoneNumber().equals(phoneNumber)) {
						System.out.println(a);
						found = true;
					}
				}
							
				if(!found) {
					System.out.println("Record Not Found");
				}
				System.out.println("---------------------------------------------------------------");
			break;
			
			//delete record
			case 4:
				//record cannot be found
				found = false;
				System.out.println("Enter Phone Number to Delete : ");
				phoneNumber  = s1.nextLine();
				//to separate out each record
				System.out.println("---------------------------------------------------------------");
				//create a loop to see if next next record is available
				i = c.iterator();
				while(i.hasNext()) {
					//this will display the records
					AddressBook a = i.next();
					//create a loop so that phone number searched is equal to the one entered by the users in the record
					if(a.getPhoneNumber().equals(phoneNumber)) {
						i.remove();
						found = true;
					}
				}
							
				if(!found) {
					System.out.println("Record Not Found");
				}else{ 
					System.out.println("Record is Deleted Successfuly!");
				}
				System.out.println("---------------------------------------------------------------");
			break;
			
			//update the record
			case 5:
				//record cannot be found
				found = false;
				System.out.println("Enter Phone Number to Update : ");
				phoneNumber  = s1.nextLine();
				//to separate out each record
				System.out.println("---------------------------------------------------------------");
				//call the list iterator to initialize the collection of the list 
				ListIterator<AddressBook>li = c.listIterator();
				while(li.hasNext()) {
					//this will display the records
					AddressBook a = li.next();
					//create a loop so that phone number searched is equal to the one entered by the users in the record
					if(a.getPhoneNumber().equals(phoneNumber)) {
						System.out.println("Enter New Name: ");
						name = s1.nextLine();
						
						System.out.print("Enter New Street : ");
						street = s1.nextLine();
						
						System.out.print("Enter New City : ");
						city = s1.nextLine();
						
						System.out.print("Enter New State : ");
						state = s1.nextLine();
						
						System.out.print("Enter New Zip : ");
						zip = s.nextInt();
						
						System.out.print("Enter New Phone Number : ");
						phoneNumber = s1.nextLine();
						li.set(new AddressBook(name,street,city,state,zip,phoneNumber));
						found = true;
					}
				}
							
				if(!found) {
					System.out.println("Record Not Found");
				}else{ 
					System.out.println("Record is Updated Successfuly!");
				}
				System.out.println("---------------------------------------------------------------");
			break;
			}
		}while(ch!=0);
	}
}
