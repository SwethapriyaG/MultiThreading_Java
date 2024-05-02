//program to demonstrate thread synchronization
class ticketbooking
{
	boolean booked = false;
	public void bookTicket(String name)
	{
		synchronized(this){
		if(booked==false){
		System.out.println(name+" selected the seat");
		System.out.println(name+" completed the payment");
		System.out.println(name+" get the ticket");
		
		booked = true;
		}
		else
		{ 
			System.out.println("Sorry " +name+", This seat is already booked");
		}
		}
		System.out.println(name+" booked bus ticket");	
		
	}
}

class threadclass extends Thread
{
	ticketbooking tkt;
	String name;
	threadclass(ticketbooking obj, String s)
	{
		tkt=obj;
		name=s;
	}	
	public void run()
	{
		tkt.bookTicket(name);
	}
}

class SyncEx
{
	public static void main(String ar[])
	{
		ticketbooking seat7 = new ticketbooking();
		
		threadclass santosh = new threadclass(seat7, "santosh");
		Thread san = new Thread(santosh);
		san.start();
		
		
		
		
		threadclass suresh = new threadclass(seat7, "suresh");
		Thread sur = new Thread(suresh);
		sur.start();
	}
}	