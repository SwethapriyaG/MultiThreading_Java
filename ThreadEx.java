//program to demonstrate multithreading in java

import java.io.*;
//Step-1: Creat subclass of thread class or runnable interface
class MyThread extends Thread
{
	String tname;
	MyThread(String s)
	{
		tname = s;
	}	
	//step-2: write run method
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println(tname+": "+i);
			
			try{
			Thread.sleep(1000);
			}
			catch(Exception e){}
			
		}
	}
}
	
class ThreadEx
{
	public static void main(String ar[])
	{
		System.out.println("Main thread starts");
		Thread t = Thread.currentThread(); //Main thread
		
		System.out.println(t);
		
		ThreadGroup tg = new ThreadGroup("Java");
		
		//step-3: create an object for above class
		//first child thread
		MyThread th = new MyThread("first"); 
		
		//step-4: create an objectfor thread class and link it with above object
		Thread tr = new Thread(tg,th);
		tr.setName("first");
		tr.setPriority(7);
		
		//set a user thread as daemon
		tr.setDaemon(true);
		
		System.out.println(tr);
		//step-5: run the thread using start() method
		tr.start();
		try{
		tr.join(); 
		}
		catch(Exception e){}
		
		
		//second child thread
		MyThread th1 = new MyThread("second");
		Thread tr1 = new Thread(tg,th1);
		tr1.setName("second");
		tr1.setPriority(Thread.MIN_PRIORITY);
		System.out.println(tr1);
		tr1.start();
		
		// try{
		// t.sleep(10000);
		// }
		// catch(Exception e){}
		try{
		tr1.join(); 
		}
		catch(Exception e){}
		
		System.out.println("Is Main thread daemon: "+t.isDaemon());
		
		System.out.println("Is first thread daemon: "+tr.isDaemon());
		
		System.out.println("Is second thread daemon: "+tr1.isDaemon());
	}
}	
		