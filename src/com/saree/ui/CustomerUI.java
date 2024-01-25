package com.saree.ui;

import java.util.List;
import java.util.Scanner;

import com.saree.entity.Customer;
import com.saree.service.CustomerServiceImpl;

public class CustomerUI {

	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		 String customerId;
		 String customerName;
		 String  emailId; //
		 String address; //
		  String dropingAddress;
		  long contactNumber;
		String password;
		Boolean flag ;
		  String ans;
		  
		  Customer c =null;
			CustomerServiceImpl cimpl = new CustomerServiceImpl();
			List<Customer> clist=null;
			                 
	System.out.println("*****||Customer Details page||******");
	System.out.println("*****_______________________________********");
	
	while(true) {
		
		System.out.println("*****Enter the numbers as given in menu:-*****");
		System.out.println("                                              ");
		
		System.out.println("Enter 1--->Add customer ");
		System.out.println("Enter 2--->Update customer Details");
		
		System.out.println("Enter 3--->Delete customer Details");
		
	    System.out.println("Enter 4---> To see your details");

		
	    
		
	
    

    
Integer option=sc.nextInt();
sc.nextLine();
switch(option) {

case 1:
	
	System.out.println("Enter email id: ");
	 emailId=sc.nextLine();
	String letter=emailId.substring(0, 2);
	
	Integer i=emailId.length();
	customerId="CUST"+letter+i;
	
	System.out.println("Enter the Customer name: ");
	customerName=sc.nextLine();
	
	System.out.println("Enter the address: ");
	address=sc.nextLine();

	System.out.println("Enter dropping address: ");
	dropingAddress=sc.nextLine();

	System.out.println("Enter contactNumber or phone number: ");
	contactNumber=sc.nextLong();
	sc.nextLine();


	
	
	System.out.println("Enter a password: ");
	password=sc.nextLine();

	c=new Customer(customerId, customerName, emailId, address,  dropingAddress, contactNumber, password);
	 flag=cimpl.addCustomer(c);
	if(flag)
			System.out.println("Customer details added to database....");
		else
			System.out.println("Error while adding Customer deatails...");
		

	
	break;
case 2:
	System.out.print("Enter the id of customer you want to update: ");
	customerId=sc.nextLine();
	
	c=cimpl.getCustomerById(customerId);
	
	if(c!=null) {
		
		System.out.println(c);
		System.out.println("Are you sure you want to update this customer details?"+"\nAnswer in yes or no");
		
		String answer=sc.next();
		sc.nextLine();
		
		if(answer.equalsIgnoreCase("yes")) {
			System.out.println("What do you want to update?");
			System.out.println("Enter a---> update name");
			System.out.println("Enter b---> update password");
			System.out.println("Enter c---> update email-Id");
			System.out.println("Enter d---> update contact");
			System.out.println("Enter e---> update address");
			
			char choice2=sc.next().toLowerCase().charAt(0);
			sc.nextLine();

			
			
			switch(choice2) {
			case 'a':
				System.out.print("Enter customer name: ");
				customerName=sc.nextLine();
				c.setCustomerName(customerName);
				
				flag=cimpl.updateCustomer(c);
				if(flag)
					System.out.println("Customer name updated successfully!!");
				else
					System.out.println("Error while updating customer name!!");
				break;
				
			case 'b':
				System.out.print("Enter the customer password: ");
				password=sc.nextLine();
			    c.setPassword(password);
			
			    flag=cimpl.updateCustomer(c);
			    if(flag)
				    System.out.println("Customer password updated successfully!!");
			    else
				    System.out.println("Error while updating customer password!!");
				break;
				
			case 'c':
				System.out.println("Enter the customer email:  ");
				emailId=sc.nextLine();
				c.setEmailId(emailId);
				
				flag=cimpl.updateCustomer(c);
				
				if(flag)
					System.out.print("Customer email updated successfully!!");
				else
					System.out.print("Error while updating customer email-Id!!");

				break;
				
			case 'd':
				System.out.print("Enter the customer contactNumber: ");
				contactNumber=sc.nextLong();
				sc.nextLine();
				
				
				c.setContactNumber(contactNumber);
                flag=cimpl.updateCustomer(c);
				
				if(flag)
					System.out.println("Customer contact updated successfully!!");
				else
					System.out.println("Error while updating customer contact!!");

				break;
			
			case 'e':
				System.out.print("Enter the customer address: ");
				address=sc.nextLine();
				
				c.setAddress(address);
				flag=cimpl.updateCustomer(c);
					
					if(flag)
						System.out.println("Customer address updated successfully!!");
					else
						System.out.println("Error while updating customer address!!");

				break;
			
				
				
				default:System.out.println("Please enter characters as mentioned in update list");
			}
		}
		else if(answer.equalsIgnoreCase("no")) {}
		else
			System.out.println("Please answer in yes or no only. Going back to main list");
		
	}
	else
		System.out.println("No customer with this id found. Please check id given....");
	break;
	


	
case 3:
	System.out.println("Are you sure ? you want to delete your id from the website... \nAnswer in yes or no: ");
	ans=sc.nextLine();
	
	if(ans.equalsIgnoreCase("yes")) {
		System.out.println("Enter your customer id: ");
		customerId=sc.nextLine();
		
		flag=cimpl.deleteCustomerDetails(customerId);
		if(flag) 
			System.out.println("Your Id is deleted...");
		else
			System.out.println("Error while deleting the id...");
		
	}
	else if(ans.equalsIgnoreCase("No")) {
		System.out.println("Thank you for your response!!!");
	}
	else
		System.out.println("Please give answer in yes or no!!!");
	
	break;
	
case 4:
	System.out.println("Enter the customer id: ");
	customerId=sc.nextLine();
	
	c=cimpl.getCustomerById(customerId);
	if(c!=null) {
	System.out.println(" ");
	System.out.println(c);
	}
	else
		System.out.println("No details available!!!");
	
	
break;

	


default : System.out.println("Please enter only those numbers as mentione in starting");
}
	}
	}
}

