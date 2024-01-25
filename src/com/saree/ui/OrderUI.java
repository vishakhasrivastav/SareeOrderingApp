package com.saree.ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.saree.entity.Cart;
import com.saree.entity.Customer;
import com.saree.entity.Order;
import com.saree.service.CustomerServiceImpl;
import com.saree.service.OrderServiceImpl;

public class OrderUI {

	private String orderId;
	private LocalDate orderDate;
	private String dropAddress;
	private LocalDateTime expectedDelivery;
	private String customerId;
	private Double billingAmount;
	private String status;
	Boolean flag;
	String ans;
	Order o=null;
	OrderServiceImpl oimpl=new OrderServiceImpl();
	List<Order> olist=null;
	
	public void orderMenu(String customerId, List<Cart> clist) {
		
		Customer cust=new CustomerServiceImpl().getCustomerById(customerId);
		System.out.println("Welcome to the Order page "+cust.getCustomerName()+" !!!");
		
		int option;
		Scanner sc=new Scanner(System.in);
		
		
		Double grandTotal=0.0;
		
		if(clist!=null && clist.isEmpty()!=true) {
		for(Cart cart: clist)
				{
				System.out.println("Cart id: "+cart.getCartId());
				System.out.println("Item added: "+cart.getS().getSareeName());
				System.out.println("Price of single item: "+cart.getPrice());
				System.out.println("Quantity in cart: "+cart.getQuantity());
				System.out.println("Subtotal: "+cart.getSubTotal());
				
				grandTotal+=cart.getSubTotal();
				System.out.println("__________________________________");
				}
		
		System.out.println("Grand total= "+grandTotal);
		}
		else
		{
			System.out.println("Your cart is empty and so you will not be able to place order.");
			System.out.println("Do you want to continue with the order menu??");
			
			ans=sc.nextLine();
			
			if(ans.equals("no"))
				return;
			
			else if(ans.equals("yes"))
				System.out.println("Thankyou for input. Please do not place order.\nYou can check other options");
			else
			{
				System.out.println("Please enter yes or no only....Returning to main menu");
			}
				
		}
		while(true) {
			
			System.out.println("Enter 1----> Place Order");
			System.out.println("Enter 2----> Cancel my order");
			System.out.println("Enter 3----> Show my order history");
			System.out.println("Enter 4----> Show order by id");
			System.out.println("Enter 5---> Go Back to the main menu ");
			option=sc.nextInt();
			sc.nextLine();
			
			String ans;
			switch(option) {
			case 1:

				 Random random=new Random();//for producing random number
				 Integer randomInt=random.nextInt(10000);
				 
				 
				 orderId="OR"+randomInt;
				 
				orderDate=LocalDate.now();
				
				System.out.println("Do you want to deliver at the below given address??");
				System.out.println(cust.getAddress());
				System.out.println("\nAnswer in yes or no");
				
				ans=sc.nextLine();
				if(ans.equalsIgnoreCase("yes")) {
					
					dropAddress=cust.getAddress();
				}
				else if(ans.equalsIgnoreCase("no"))
				{
					System.out.println("Enter your drop location:- ");
					dropAddress=sc.nextLine();
				}
				else
					System.out.println("Please answer in yes or no only!!Going back to main menu");
					
				expectedDelivery=LocalDateTime.now().plusHours(1);
				
				billingAmount=grandTotal;
				
				status="Processing...";
				
				o=new Order( orderId , orderDate, dropAddress, expectedDelivery, customerId, billingAmount, status);
				
				Order order=oimpl.placeOrder(o);
				if(order!=null) {
					System.out.println("Your order has been placed. Details given below...");
					System.out.println("Order number: "+order.getOrderId());
					System.out.println("Drop location: "+order.getdropAddress());
					
					DateTimeFormatter pattern=DateTimeFormatter.ofPattern("dd-LLL-yyyy HH:mm");
					LocalDateTime delivery=order.getExpectedDelivery();
					
					System.out.println("Delivered by: "+delivery.format(pattern));
					
					System.out.println("Billing amount: "+order.getBillingAmount());
					
					return;
				}
				
				else
					System.out.println("Error while placing order");
				break;
			
			case 2:

				System.out.println("Enter the order id to be cancelled: ");
				orderId=sc.nextLine();
				
				flag=oimpl.cancelOrder(orderId);
				
				if(flag) {
					System.out.println("Your order has been cancelled!!!");
				}
				else {
					System.out.println("Error while cancelling your order. Try again later....");
				}
				break;
			
			case 3:
				olist=oimpl.showMyOrderHistory(customerId);
				if(olist!=null && olist.isEmpty()!=true) {
					
					for(Order o1:olist) {
						
						
				 		System.out.println("Order number: "+o1.getOrderId());
				 		System.out.println("Drop Location: "+o1.getdropAddress());
				 		
				 		DateTimeFormatter pattern=DateTimeFormatter.ofPattern("dd-LLL-yyyy  HH:mm");
				 		LocalDateTime delivery=o1.getExpectedDelivery();
				 		
				 		System.out.println("Delivered by: "+delivery.format(pattern));
				 		System.out.println("Billing amount: "+o1.getBillingAmount());
				 		System.out.println("Status: "+o1.getStatus());
				 		
				 		System.out.println("_______________________________________________");
				 		
					}
					
				}
				
				
				break;
			
			case 4:
				System.out.println("Enter the order id: ");
				orderId=sc.nextLine();
				o=oimpl.showOrderById(orderId);
				if(o!=null) {
					
					
			 		System.out.println("Order number: "+o.getOrderId());
			 		System.out.println("Drop Location: "+o.getdropAddress());
			 		
			 		DateTimeFormatter pattern=DateTimeFormatter.ofPattern("dd-LLL-yyyy  HH:mm");
			 		LocalDateTime delivery=o.getExpectedDelivery();
			 		
			 		System.out.println("Delivered by: "+delivery.format(pattern));
			 		System.out.println("Billing amount: "+o.getBillingAmount());
			 		System.out.println("Status: "+o.getStatus());	
					
				}
				else {
					System.out.println("No order found with this id.");
				}
				
				break;
			case 5:
				System.out.println("\nGoing back to main menu.....");
				return;
				
				default:System.out.println("Please enter the number as given in menu...");
			}
		}

	}

}
