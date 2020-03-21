/**
branch personnel class
*/
public class Bemployee implements Cargosystem
{
/**
bname is temployee name
bid is temployee id
*/
	private String bname,branchname;
	private int bid;
	private static int bemployeecount=0;
/**
Default Constructor for the bemployee class
*/
	public Bemployee() {


	}	
/**
Constructor for the bemployee class
*/
	public Bemployee(String name,int id,String nbranch) {
		bid=id;
		bemployeecount++;
		bname = name;
		branchname=nbranch;
	}

	public int getid(){
		return bid;
	}

	public void setid(int id){
		 bid=id;
	}
	public int getcount(){
		return bemployeecount;
	}
	public void setcount(int count){
		bemployeecount=count;
	}
	public String getname(){
		return bname;
	}
	public void setname(String name){
		bname=name;
	}
	public String getbranchname(){
		return branchname;
	}
	public void setbranchname(String nameb){
		branchname=nameb;
	}

}
