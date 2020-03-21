/**
Customer class:we use this class for save cargo infos and track no 
*/

public class Customer extends Cargo implements Cargosystem
{
/**
ccount is the counter of the customers
*/
	private static int ccount=0;
	private int trackid;
	private String customername,branchname;
	
	public Customer() {
	

	}

/**
Constructor for the customer class
*/
	public Customer(int id,String custname,String nbranch) {
		trackid =id;
		customername=custname;
		ccount++;
		branchname=nbranch;
	}

	


/**
Constructor for the customer class
*/
	public Customer(int id,String custname,String nbranch,String sname,String rname,String sbranch,String rbranch,String status) {
		
		super(id,sname,rname,sbranch,rbranch,status);
		branchname=nbranch;	
		customername=custname;
		trackid=id;	
		ccount++;
	}
		
	public int getid(){
		return trackid;
	}
	public void setid(int nid){
 		trackid=nid;
	}

	public String getsender(){
		return super.getsender();
	}

	public String getreceiver(){
		return super.getreceiver();
	}

	public String getsenderbranch(){
		return super.getsenderbranch();
	}

	public String getreceiverbranch(){
		return super.getreceiverbranch();
	}

	
	public String getstatus(){
		return  super.getstatus();
	}
	public void setstatus(String status){
		super.setstatus( status);
	}
/**
tostring method for the customer class
we use it for showing cargo infos
and it uses the superclass toString method inside of it
*/
	public String toString(){
		return 	"Customer name -->"+ customername + super.toString();
	}

	public int getcount(){
		return ccount;
	}
	public void setcount(int count){
		ccount=count;
	}
	public String getname(){
		return customername;
	}
	public void setname(String name){
		customername=name;
	}
	public String getbranchname(){
		return branchname;
	}
	public void setbranchname(String nameb){
		branchname=nameb;
	}

/**
adding new cargo method for the customer class
we use it for add new cargo for this customer
and it uses the superclass  method inside of it
*/
	public void addcargo(String sname,String rname,String sbranch,String rbranch,String status){
		System.out.println("cargonun add cargosundayız");
		super.addcargo(trackid,sname,rname,sbranch,rbranch,status);

	}

/**
removing current cargo method for the customer class
we use it for remove current cargo for this customer
and it uses the superclass  method inside of it
*/
	public void removecargo(){
		System.out.println("cargonun add cargosundayız");
		super.removecargo();
		
	}


}

