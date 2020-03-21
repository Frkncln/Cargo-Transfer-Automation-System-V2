/**
transportation personnel class
*/
public class Temployee implements Cargosystem 
{

/**
tname is temployee name
tid is temployee id
*/
	private String tname,branchname;
	private int tid;
	private static int temployeecount=0;
/**
Default Constructor for the temployee class
*/
	public Temployee() {

	}	
/**
Constructor for the temployee class
*/
	public Temployee(String name,int id,String nbranch) {
		tname = name;
		tid=id;
		temployeecount++;
		branchname=nbranch;
	}

	public int getid(){
		return tid;
	}
	public void setid(int id){
		 tid=id;
	}
	public int getcount(){
		return temployeecount;
	}
	public void setcount(int count){
		temployeecount=count;
	}

	public String getname(){
		return tname;
	}
	public void setname(String name){
		tname=name;
	}
	public String getbranchname(){
		return branchname;
	}
	public void setbranchname(String nameb){
		branchname=nameb;
	}

}
