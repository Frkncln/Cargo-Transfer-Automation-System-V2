/**
Customer class:we use this class for save branch infos
*/
public class Branch{

	private String branchname;
	private static int branchcount =0;

	public Branch() {
	
	}

/**
Constructor for the branch class
*/
	public Branch(String bname) {
	
		branchname=bname;
		branchcount++;
	}

	public String getname(){
		return branchname;
	}
	public void setname(String name){
		branchname=name;
	}

	public int getcount(){
		return branchcount;
	}

	public void setcount(int ncount){
		branchcount=ncount;
	}	

}

