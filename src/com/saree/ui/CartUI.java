package com.saree.ui;

import java.util.List;
import java.util.Scanner;

import com.saree.entity.Saree;
import com.saree.service.SareeServiceImpl;
import com.saree.ui.OrderUI;
import com.saree.entity.Cart;
import com.saree.entity.Customer;
import com.saree.service.CartServiceImpl;
import com.saree.service.CustomerServiceImpl;
import com.saree.ui.LoginUI;


public class CartUI {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		 String cartId;
		 String sareeId;
		 String   emailId;
		 Integer quantity;
		 String customerId;
		 Double subTotal;//price * quantity
		 Double price;//saree price
		Saree s;
		Integer option;
		boolean flag;
		String ans;

		Cart c=null;
		CartServiceImpl cimpl=new CartServiceImpl();
		List<Cart> clist=null;
		
		
		System.out.println("****||for user name and password ||*****");
		System.out.println("  Enter one by one  ");
		while(true) {
			
			System.out.println("Enter the AdminId if you are  Admin/ Your are  customer then enter customerid: :-");
			String username=sc.nextLine().trim();
			
			
			System.out.println("Enter password: -");
			String password=sc.nextLine();
			String login=new LoginUI().login(username, password);
			
			if(login==null) {
				System.out.println("UserName or password given is wrong. please login again");
			}
		
			else if(login.equals("customer")) {
				/*
				 * Fetching the customer object from the database by using the
				 * showCustomerById/getDetailsById method of CustomerServiceImpl
				 */
				Customer cust = new CustomerServiceImpl().getCustomerById(username);
				System.out.println("You have logged in as customer");
				
				System.out.println("****Welcome to our website***@"+cust.getCustomerName());
				boolean logout=false;
				
				
				
				
				while(logout==false) {
					System.out.println("\nEnter the number as given in options...");
					System.out.println("Enter 1---> Add to cart");
					System.out.println("Enter 2---> Show my cart");
					System.out.println("Enter 3---> Update quantity of sareeitem");
					System.out.println("Enter 4---> Delete sareeitem from cart");
					System.out.println("Enter 5---> Clear my cart");
					System.out.println("Enter 6---> See order menu");
					System.out.println("Enter 7---> Logout");
					
					
					option=sc.nextInt();
					sc.nextLine();
switch(option) {
					
					case 1:
						int min = 100;

						int max = 1000; 				
						int b = (int)(Math.random()*(max-min+1)+min);
						
						cartId="CA"+b;
						
						List<Saree> slist=new SareeServiceImpl().showAllSaree();
						System.out.println("\nsareename and sareeid shown below...");
						
						for(Saree s1:slist) {
							
							System.out.println(s1.getSareeName()+" : "+s1.getSareeId());
						}
						System.out.println("\nEnter the saree id: ");
						sareeId=sc.nextLine();
						
						
						customerId = username;
						flag=cimpl.checkFoodItem(customerId, sareeId);
						
						if(flag) {
							System.out.println("Item was already present in your cart."
									+ "\n Quantity has been increased by 1");
						}
						else {
						
						quantity=1;
						
						price=new SareeServiceImpl().getSareeById(sareeId).getPrice();
						
						subTotal=quantity*price;
						
						c=new Cart(cartId, sareeId,  quantity, customerId, subTotal, price);
						
						flag=cimpl.addToCart(c);
						if(flag)
						System.out.println(" Saree added successfully!!");
						else
							
						System.out.println("error while adding saree item to cart !!");
						}
						break;
						
					case 2:
						customerId=username;
					clist=cimpl.showMyCart(customerId);
					
					if(clist!=null && clist.isEmpty()!=true) {
						System.out.println("**********Your cart details***********");
						
						Double grandTotal=0.0;
						
						for(Cart cart: clist)		
								{
								System.out.println("Cart id: "+cart.getCartId());
								System.out.println("Item added: "+cart.getS().getSareeName());
								System.out.println("Price of single item: "+cart.getPrice());
								System.out.println("Quantity in cart: "+cart.getQuantity());
								System.out.println("SubTotal: "+cart.getSubTotal());
								
								grandTotal+=cart.getSubTotal();
								System.out.println("_______________________________");
								}
							System.out.println("Grand total= "+grandTotal);	
							System.out.println("Do you want to go to order page? \n Answer in yes or no...");
							ans=sc.nextLine();
							
							if(ans.equalsIgnoreCase("yes")) {
								
								new OrderUI().orderMenu(customerId, clist);
							}
							else if(ans.equalsIgnoreCase("no"))
								System.out.println("Thank you for your response...\nContinue browsing.....");
							else
								System.out.println("Please answer in yes or no only!! Going back to main menu...");
					}
					else
						System.out.println("Your cart is empty. Please add to cart first....");
					
						break;
						
					case 3:
						System.out.println("Enter the cart id: ");
						cartId=sc.nextLine();
						
						c=cimpl.getCartById(cartId);
						if(c!=null) {
							
							System.out.println("Cart id: "+c.getCartId());
							System.out.println("Item added: "+c.getS().getSareeName());
							System.out.println("Price of single item: "+c.getPrice());
							System.out.println("Quantity in cart: "+c.getQuantity());
							System.out.println("SubTotal: "+c.getSubTotal());
							
							System.out.println("Enter new quantity: ");
							quantity=sc.nextInt();
							sc.nextLine();
							if(quantity>0) {
								flag=cimpl.updateQuantity(cartId, quantity);
								if(flag)
									System.out.println("Quantity updated successfully!!!");
								else
									System.out.println("Error while changing quantity!!!");
							}
							else
								System.out.println("Please give a number greater than 0 for quantity...");
						}
									
							
							
			
							
						
						break;
						
					case 4:
						
						System.out.println("Enter cartId of item to be deleted: ");
						cartId=sc.nextLine();
						
						System.out.println("Are you sure you want to delete this item?"
								+ "\nAnswer in yes or no: ");
						ans=sc.nextLine();
						if(ans.equalsIgnoreCase("yes")) {
							
							flag=cimpl.deleteFoodItemCart(cartId);
							if(flag)
								System.out.println("Item deleted from cart successfully!!!");
							else
								System.out.println("Error while deleting item!!!");
							
						}
						else if(ans.equalsIgnoreCase("no")){
							System.out.println("Thank you for input. please continue browsing....");
						}
						else
							System.out.println("Answer in yes or no only. Going back to main menu...");
						
						
						
						break;
						
					case 5:
						customerId=username;
						
						System.out.println("Are you sure you want to clear your cart?"
								+ "\nAnswer in yes or no: ");
						ans=sc.nextLine();
						if(ans.equalsIgnoreCase("yes")) {
							
							flag=cimpl.clearMyCart(customerId);
							if(flag)
								System.out.println("Your cart is now empty!!!");
							else
								System.out.println("Error while clearing cart!!!");
							
						}
						else if(ans.equalsIgnoreCase("no")){
							System.out.println("Thank you for input. please continue browsing....");
						}
						else
							System.out.println("Answer in yes or no only. Going back to main menu...");
						
						break;
				
						
					case 6:
						customerId=username;
						clist=cimpl.showMyCart(customerId);
						
						new OrderUI().orderMenu(customerId, clist);
						
						break;
						
					case 7:
						
						logout=true;
						System.out.println("Thank you for using our services. Visit again soon!!!");
						
						break;
						
						default: System.out.println("Please give inputs as per the options given...");
					
					}
				}
			}
			else if(login.equals("admin")) {
				System.out.println("You have logged in as admin");
				
				boolean logout=false;
				
				while(logout==false) {
				System.out.println("\nEnter the number as given in option...");
				System.out.println("Enter 1--> Show all cart items");
				System.out.println("Enter 2---> Show cart by id");
				System.out.println("Enter 3---> Logout");
				
				option=sc.nextInt();
				sc.nextLine();
						
						
		
				switch(option) {
				
				case 1:
					
					clist=cimpl.showAllCart();
					if(clist!=null && clist.isEmpty()!=true) {
						
						for(Cart cart: clist)		
						{
							System.out.println("Cart id: "+cart.getCartId());
							System.out.println("Customer id: "+cart.getCustomerId());
							System.out.println("Item added: "+cart.getS().getSareeName());
							System.out.println("Price of single item: "+cart.getPrice());
							System.out.println("Quantity in cart: "+cart.getQuantity());
							System.out.println("SubTotal: "+cart.getSubTotal());
							
							System.out.println("_______________________________");
						}
						
					}
					else
						System.out.println("The cart is empty. No data available at this moment!!!");
					
					break;
					
				case 2:
					
					System.out.println("Enter the cart id: ");
					cartId=sc.nextLine();
					
					c=cimpl.getCartById(cartId);
					if(c!=null) {
						
						System.out.println("Cart id: "+c.getCartId());
						System.out.println("Customer id: "+c.getCustomerId());
						System.out.println("Item added: "+c.getS().getSareeName());
						System.out.println("Price of single item: "+c.getPrice());
						System.out.println("Quantity in cart: "+c.getQuantity());
						System.out.println("SubTotal: "+c.getSubTotal());
						
					}
					else
						System.out.println("No cart with this id found...");
					
					break;
					
				case 3:
					
					logout = true;
					System.out.println("Thank you for using our services. Visit again soon!!!");
					
					break;
					
				default:System.out.println("Please enter the valid option!!!");

}
}
			}
		}
	}
}

	


