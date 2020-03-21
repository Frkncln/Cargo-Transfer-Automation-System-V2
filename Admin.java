/**
branch personnel class
*/
public class Admin implements Cargosystem{

	private String adminname;
	private int adminid;
	private static int admincount=0;
/**
Default Constructor for the bemployee class
*/
	public Admin() {

	}	
/**
Constructor for the bemployee class
*/
	public Admin(String name,int id) {
		adminid=id;
		admincount++;
		adminname = name;
	}

	public int getid(){
		return adminid;
	}

	public void setid(int id){
		 adminid=id;
	}
	public int getcount(){
		return admincount;
	}
	public void setcount(int count){
		admincount=count;
	}
	public String getname(){
		return adminname;
	}
	public void setname(String name){
		adminname=name;
	}

}
