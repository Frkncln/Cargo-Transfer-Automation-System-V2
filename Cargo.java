/**
Customer class:we use this class for save cargo infos and track no 
*/

abstract class Cargo 
{

	private static int cargocount=0;
	private int trackid;
	private String sendername,receivername,currentstatus,senderbranch,receiverbranch;
	
	public Cargo() {

	}

	


/**
Constructor for the customer class
*/
	public Cargo(int id,String sname,String rname,String sbranch,String rbranch,String status) {
		trackid=id;
		sendername=sname;
		receivername=rname;
		currentstatus =status;
		senderbranch=sbranch;
		receiverbranch=rbranch;		
		cargocount++;
	}
		
	public int getid(){
		return trackid;
	}
	public void setid(int nid){
 		trackid=nid;
	}

	public String getsender(){
		return sendername;
	}

	public String getreceiver(){
		return receivername;
	}

	public String getsenderbranch(){
		return senderbranch;
	}

	public String getreceiverbranch(){
		return receiverbranch;
	}

	public void setsender(String sender){
		sendername = sender;
	}

	public void setreceiver(String receiver){
		receivername = receiver;
	}

	public void setsenderbranch(String senderb){
		senderbranch = senderb;
	}

	public void setreceiverbranch(String receiverb){
		receiverbranch = receiverb;
	}	
	
	public String getstatus(){
		return  currentstatus;
	}
	public void setstatus(String status){
		currentstatus = status;
	}
/**
tostring method for the cargo class
we use it for showing cargo infos
*/
	public String toString(){
		return 	"\n------CARGO INFO------\n"+
			"Sender name--> "+sendername+
			 "\nReceiver name--> "+receivername +
			"\nSender Branch name--> "+senderbranch+ 
			"\nReceiver Branch name--> "+receiverbranch +
			"\nCurrent status is--> "+currentstatus;
	}

	public int getcount(){
		return cargocount;
	}
	public void setcount(int count){
		cargocount=count;
	}
/**
using this method for adding new cargo for customer 
*/
	public void addcargo(int id,String sname,String rname,String sbranch,String rbranch,String status){
		trackid=id;
		sendername=sname;
		receivername=rname;
		currentstatus =status;
		senderbranch=sbranch;
		receiverbranch=rbranch;		
		cargocount++;
	}
	public void removecargo(){
		trackid= 0;
		currentstatus ="this cargo is removed";	
	}
/**
abstract method of the cargo class
*/
	public abstract String getname();

	public abstract void setname(String name);

}

