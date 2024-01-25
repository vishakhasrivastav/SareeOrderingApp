package com.saree.ui;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.saree.entity.Saree;
import com.saree.service.SareeServiceImpl;

public class SareeUI {

	public static void main(String[] args) {
		 String sareeId;
		 String sareeName;
		 String type; //Reguarl ,Partywear,wedding,GirlsWear
		 String category; //Banarasi,mysore silk,kanchipuram,maduvaniprint...
		 Double price;
		 Integer quantityInstock;
		 String color;//red b
		 Boolean flag;

		 Saree s=null;
		 SareeServiceImpl simpl=new SareeServiceImpl();
		 List<Saree> slist=null;
		 
		 Scanner sc=new Scanner(System.in);
		 
		 System.out.println("*****Saree page******");
		 while(true) {
		 	
		 	System.out.println("Enter the numbers as given in menu:-");
		 	
		 	System.out.println("Enter 1--->Add Saree item");
		 	System.out.println("Enter 2--->Update Saree item");
		 	
		 	System.out.println("Enter 3--->Delete Saree item");
		 	
		     System.out.println("Enter 4--->Show all Saree item");

		 	System.out.println("Enter 5--->Serach Saree item on the basis of type");
		 	
		     System.out.println("Enter 6--->  Serach Saree item basis of category");

		     
		 Integer option=sc.nextInt();
		 sc.nextLine();

		 switch(option) {

		 case 1:
		 	
		 	int min = 100;

		 	int max = 400; 				
		 	int b = (int)(Math.random()*(max-min+1)+min);
		 	
		 	sareeId="S"+b;
		 	
		 	System.out.println("Enter the Saree name: ");
		 	sareeName=sc.nextLine();
		 	
		 	System.out.println("Provide type of this Saree item: ");
		 	System.out.println("Enter r for regular,p for partywear,w for wedding and g for girlswear");
		 	String t=sc.nextLine();
		 	
		 	if(t.equalsIgnoreCase("r")) {

		 		type="regular";

		 	}
		 	else if(t.equalsIgnoreCase("p")) {
		 		
		 		type="partywear";
		 	}
		 	else if(t.equalsIgnoreCase("w")) {
		
		 		type="weddingwear";
	}
		 	
		 	else if(t.equalsIgnoreCase("g")) {
		 		
		 		type="girlswear";
		 	}
		 	else {
		 		
		 		System.out.println("Please enter as per the type");
		 		type=" data unavailable";
		 	}
		 	
		 	System.out.println("Enter category: \n1:Banarasi(kanchipuram) \n2: cotton saree(maduvaniprint)"
		 	                     +" \n3: Georgette \n4:silkSaree \n5: main course ");
		 	Integer choice=sc.nextInt();
		 	sc.nextLine();
		 	
		 	switch(choice) {
		 	
		 	case 1: category="Banarasi(kanchipuram)";
		 	break;
		 	
		 	case 2: category="cotton saree(maduvaniprint)";
		 	break;
		 	
		 	case 3: category="Georgette";
		 	break;
		 	
		 	case 4: category="silkSaree";
		 	break;
		 	
		 	case 5: category="main course";
		 	break;
		 	
		 	default: System.out.println("Please enter only those numbers as given in"
		 	                                +"category menu");
		 				category="data unavailable";
		 	}
		 	
		 	System.out.println("Enter price: ");
		 	price=sc.nextDouble();
		 	sc.nextLine();
		 	
		 	System.out.println("Quantity in stock: ");
		 	quantityInstock=sc.nextInt();
		 	sc.nextLine();
		 	
		 	System.out.println("Enter the color of saree: ");
		 	color=sc.nextLine();
		 	
		 	s=new Saree(sareeId, sareeName, type, category,price, quantityInstock, color);
		 	
		 	flag=simpl.addSaree(s);
		 	if(flag)
		 		System.out.println("Saree details addes to database....");
		 	else
		 		System.out.println("Error while adding Saree deatails...");
		 	
		 	break;
		 	
		 case 2:
		 	System.out.println(" Enter the id of Saree you want to update:");
		 	sareeId=sc.nextLine();
		 	
		 	s=simpl.getSareeById(sareeId);
		 	
		 	if(s!=null) {
		 		
		 		System.out.println(s);
		 		System.out.println("Are you sure you want to update this Saree item?"+"\nAnwer in yes or no"
		 		
		 				);
		 		
		 		String ans=sc.next();
		 		sc.nextLine();
		 		
		 		if(ans.equalsIgnoreCase("yes")) {
		 			System.out.println("what you want to update?");
		 			System.out.println("Enter a--> update name");
		 			System.out.println("Enter b--> update  type");
		             System.out.println("Enter c--> update category");
		             System.out.println("Enter d--> update  price");
		             System.out.println("Enter e--> update  Quantity");
		             
		             
		             char choice2=sc.next().toLowerCase().charAt(0);
		             sc.nextLine();
		             switch(choice2) {
		             case'a':
		             	System.out.println("Enter name: ");
		             	sareeName=sc.nextLine();
		             	s.setSareeName(sareeName);
		             	flag=simpl.updateDetails(s);
		             	if (flag)
		             		
		             		System.out.println("Saree name update sucessfully!!");
		             	
		             	else 
		             		System.out.println(" Error while updating Saree name!!");
		             	break;
		             	
		             case'b':
		             	
		             	System.out.println("Provide type of this Saree item: ");
		             	
		    		 	System.out.println("Enter r for regular,p for partywear,w for wedding and g for girlswear");
		    		 	 t=sc.nextLine();
		    		 	
		    		 	if(t.equalsIgnoreCase("r")) {

		    		 		type="regular";

		    		 	}
		    		 	else if(t.equalsIgnoreCase("p")) {
		    		 		
		    		 		type="partywear";
		    		 	}
		    		 	else if(t.equalsIgnoreCase("w")) {
		    		
		    		 		type="weddingwear";
		    	}
		    		 	
		    		 	else if(t.equalsIgnoreCase("g")) {
		    		 		
		    		 		type="girlswear";
		    		 	}
		    		 	else {
		    		 		
		    		 		System.out.println("Please enter as per the type");
		    		 		type=" data unavailable";
		    		 	}

		            	s.setType(type);
		            	
		            	flag=simpl.updateDetails(s);
		            	
		    		 	
		             	if(flag)
		                        System.out.println("Saree name update sucessfully!!");
		             	
		             	else 
		             		System.out.println(" Error while updating Saree name!!");
		             	
		       
		             	
		             	break;
		             	
		             case'c':
		             	

		     		 	System.out.println("Enter category: \n1:Banarasi(kanchipuram) \n2: cotton saree(maduvaniprint)"
		     		 	                     +" \n3: Georgette \n4:silkSaree \n5: main course ");
		     		 	 choice=sc.nextInt();
		     		 	sc.nextLine();
		     		 	
		     		 	switch(choice) {
		     		 	
		     		 	case 1: category="Banarasi(kanchipuram)";
		     		 	break;
		     		 	
		     		 	case 2: category="cotton saree(maduvaniprint)";
		     		 	break;
		     		 	
		     		 	case 3: category="Georgette";
		     		 	break;
		     		 	
		     		 	case 4: category="silkSaree";
		     		 	break;
		     		 	
		     		 	case 5: category="main course";
		     		 	break;
		     		 	
		     		 	default: System.out.println("Please enter only those numbers as given in"
		     		 	                                +"category menu");
		     		 				category="data unavailable";
		     		 	}
		     		 	
		 				
		 				s.setCategory(category);
		             flag=simpl.updateDetails(s);
		             	
		             	if(flag)
		                        System.out.println("Saree name update sucessfully!!");
		             	
		             	else 
		             		System.out.println(" Error while updating Saree name!!");
		             	
		       
		 				
		 	
		             	break;
		             	
		             case'd':
		             	System.out.println("Enter price: ");
		             	price=sc.nextDouble();
		             	sc.nextLine();
		             	s.setPrice(price);
		             	
		             	 flag=simpl.updateDetails(s);
		              	
		              	if(flag)
		                         System.out.println("Saree name update sucessfully!!");
		              	
		              	else 
		              		System.out.println(" Error while updating Saree name!!");
		              	
		             	break;
		             	
		             case'e':
		             	System.out.println("Quantity in stock: ");
		             	quantityInstock=sc.nextInt();
		             	sc.nextLine();
		             	
		             	s.setQuantityInstock(quantityInstock);
		                 flag=simpl.updateDetails(s);
		              	
		              	if(flag)
		                         System.out.println("Saree name update sucessfully!!");
		              	
		              	else 
		              		System.out.println(" Error while updating Saree name!!");
		              	
		             	break;
		             	
		             	default: System.out.println("plz enter the  character in mentioned in update menu");
		             }
		             
		 		}
		 		else if(ans.equalsIgnoreCase("no")) {}
		 		
		 		else 
		 		System.out.println("please answer in yes or no only going back to main menu");
		 	}
		 	else
		 		System.out.println("no Saree item with this id is found.please check id given...");
		 	break;
		 	
		 case 3:
		 	System.out.println("Enter the SareeId , the items  you want to delete");
		     sareeId=sc.nextLine();
		 	
		 	s=simpl.getSareeById(sareeId);
		 	
		 	if(s!=null) {
		 		System.out.println("**** Saree details****");
		 		System.out.println(s);
		 		System.out.println("Are you sure you want to delete this Saree item?"+"\nAnwer in yes or no");
		 	
		 	
		 		String ans=sc.next();
		 		sc.nextLine();
		 		
		 	if(ans.equalsIgnoreCase("yes"))
		 	{
		 		flag=simpl.deleteSaree(sareeId);
		 	
		 		
		 		if(flag)
		             System.out.println("Saree name deleted sucessfully!!");
		  	
		  	else 
		  		System.out.println(" Error while deleting Saree name!!");
		 	}
		 	
		 	else if(ans.equalsIgnoreCase("no")) 
		 		System.out.println("thnaku you continue browsing...");
		 		else 
		 			System.out.println("please answer in yes or no only going back to main menu");
		 		
		 	}		

		 	else 
		 	System.out.println("no Saree item with this id found!!!");
		 		

		 	
		  	
		 	
		 	break;
		 	
		 case 4:
		 	slist=  simpl.showAllSaree();
		 	if(slist!=null && slist.isEmpty()!=true) {
		 		
		 		Iterator<Saree> it=slist.iterator();
		 		
		 		while(it.hasNext())
		 			System.out.println(it.next());
		 		System.out.println("---------------------------\n");
		 	}
		 	
		 	else
		 		System.out.println("no data available for Saree at this moment..");
		 	break;
		 	
		 case 6:
		 	System.out.println("Enter the category of Saree: ");

		 	System.out.println("Enter category: \n1:Banarasi(kanchipuram) \n2: cotton saree(maduvaniprint)"
		 	                     +" \n3: Georgette \n4:silkSaree \n5: main course ");
		 	 choice=sc.nextInt();
		 	sc.nextLine();
		 	
		 	switch(choice) {
		 	
		 	case 1: category="Banarasi(kanchipuram)";
		 	break;
		 	
		 	case 2: category="cotton saree(maduvaniprint)";
		 	break;
		 	
		 	case 3: category="Georgette";
		 	break;
		 	
		 	case 4: category="silkSaree";
		 	break;
		 	
		 	case 5: category="main course";
		 	break;
		 	
		 	default: System.out.println("Please enter only those numbers as given in"
		 	                                +"category menu");
		 				category="data unavailable";
		 	}
		 	
		 
		 	slist=simpl.getSareeByCategory(category);
		 if(slist!=null && slist.isEmpty()!=true) {
		 		
		 		Iterator<Saree> it=slist.iterator();
		 		
		 		while(it.hasNext())
		 			System.out.println(it.next());
		 		System.out.println("---------------------------\n");
		 	}
		 	
		 	else
		 		System.out.println("no data available for Saree at this moment..");
		 	break;
		 	
		 case 5:

         	System.out.println("Provide type of this Saree item: ");
         	
		 	System.out.println("Enter r for regular,p for partywear,w for wedding and g for girlswear");
		 	 t=sc.nextLine();
		 	
		 	if(t.equalsIgnoreCase("r")) {

		 		type="regular";

		 	}
		 	else if(t.equalsIgnoreCase("p")) {
		 		
		 		type="partywear";
		 	}
		 	else if(t.equalsIgnoreCase("w")) {
		
		 		type="weddingwear";
	}
		 	
		 	else if(t.equalsIgnoreCase("g")) {
		 		
		 		type="girlswear";
		 	}
		 	else {
		 		
		 		System.out.println("Please enter as per the type");
		 		type=" data unavailable";
		 	}

		 	slist=simpl.getSareetByType(type);
		 	if(slist!=null && slist.isEmpty()!=true) {
		 			
		 			Iterator<Saree> it=slist.iterator();
		 			
		 			while(it.hasNext())
		 				System.out.println(it.next());
		 			System.out.println("---------------------------\n");
		 		}
		 		
		 		else
		 			System.out.println("no data available for Saree at this moment..");
		 	break;
		 	
		 default : System.out.println("Please enter only those numbers as mentioned in start");
		 	}

		 	}
		 
	}

}
