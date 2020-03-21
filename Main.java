import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
/**
*@author furkan celen
Note:initial 	Admin name is frkn
		Admin id is 306
Note2: admins names are same but only new id can added for new admin	
*/

 
public class Main {


/** 
general main method
*/
 public static  void main(String args[]){

	generalmenu();
	
}//main curl



/**
general menu of system
*/
  public static void generalmenu(){


	 	int adminid=3,j,sec=0;
		String adminname="f";//defaulted name
	
		ArrayList<Customer>  customers = new ArrayList<Customer>() ;
		ArrayList<Bemployee>  bemployees = new ArrayList<Bemployee>() ;
		ArrayList<Temployee>  temployees = new ArrayList<Temployee>() ;
		ArrayList<Branch>  branches = new ArrayList<Branch>() ;
		ArrayList<Admin>  admins = new ArrayList<Admin>() ;
		Customer c1 = new Customer();
		Bemployee b1 = new Bemployee();
		Temployee t1 = new Temployee();
		Branch br1 = new Branch();
		Admin admn = new Admin();
		Admin a1 = new Admin(adminname,adminid);
		admins.add(a1);
		Scanner input = new Scanner( System.in );
		
		while(true){
			System.out.println("\n-------WELCOME TO THE CARGO SYSTEM------\n");
			System.out.println("1:Enter track number(For customers) \n2:Login system\n3:Exit\n");
			System.out.println("Please select the number of the action you want \n");	
			try{		
			System.out.println("Enter number: ");
			sec=input.nextInt();
			
			}catch(InputMismatchException e){System.out.println("It is not a number we catched "+e+ " please try with integers");
					return;
			}
			if(sec == 1){
				customerenter(customers,c1.getcount());
			}
			else if(sec ==2){//if person want to enter system
				try{
				System.out.println("\nAttention we got "+br1.getcount()+" branches in system \n");
				System.out.println("Select your position \n1)ADMIN\n2)Branch Employee\n3)Transporter \nenter number");
				
				j=input.nextInt();
				}catch(InputMismatchException e){System.out.println("It is not a number we catched "+e+ " please try with integers");
					return;
				}
				if (j!=1 && j!=2 && j!=3){ System.out.println("Invalıd number you must enter (1-2-3) OK!");}
				
				else{	if(j==1){ 
						adminenter(admins,admn.getcount(),temployees,t1.getcount(),bemployees,b1.getcount(),branches,br1.getcount(),customers);
					}
					else if(j==2 && br1.getcount() >0 ){	//if there is less than 1 branches we cant add new cargo
						branchempenter(bemployees,b1.getcount(),customers,c1.getcount(),branches,br1.getcount());
					}
					else if(j==3 && br1.getcount() >0){	tempenter(temployees,t1.getcount(),customers,c1.getcount());
					}
					
				}
			    if(br1.getcount() < 1){
				System.out.println("YOU MUST HAVE 1 BRANCHES AT LEAST FOR THE USING SYSTEM WELL");				
				}			
			}
			

			else if(sec == 3){
				System.out.println("exiting,bye");
				System.exit(0);
			}	
			else System.out.println("You entered wrong number TRY IT AGAIN,select TRUE NUMBER!");
		}//while curl


  }//end of the general menu method





/**
Menu for the customer entrance
@param c is the customers array
*/
 public static void customerenter(ArrayList<Customer> c,int custcount){
	boolean flag=false;
	int i=0,trackno;
	Scanner input = new Scanner( System.in );
	try{
	System.out.println("Enter cargo track number Dear Customer");
			trackno = input.nextInt();
	}catch(InputMismatchException e){System.out.println("It is not a number we catched "+e+ " please try with integers");
					return;
	}
				
				while(i<custcount && flag ==false){
					if(trackno == c.get(i).getid()){//if it is customer----------
						flag = true;
					}
					else{flag = false;
					i++;
					}
				
				}
				
				if(flag == false)
					System.out.println("Your track no is INCORRECT");
				else if(c.get(i).getsender().equals(null))
					System.out.println("Your track no is INCORRECT");
				else
					System.out.println(c.get(i).toString());

}

 
/** 
menu for the branch employee entrance
@param b is b.employee array
@param customer is the customers array
@param br is the branch array
*/
 public static void branchempenter(ArrayList<Bemployee> b,int bcount,ArrayList<Customer> customer,int custcount,ArrayList<Branch> br,int brcount){
	
	boolean flag=false,flag2=false,contain;
	int i=0,systemid,sec2,trackno,j=0;
	String nstatus,sname,rname,bname,sbranch,rbranch,systemname,sec,cname;
	Scanner input = new Scanner( System.in );
	try{
	System.out.println("Enter your Name b.employee");
				systemname=input.nextLine();
	System.out.println("Enter your system id b.employee");
				systemid=input.nextInt();
				}catch(InputMismatchException e){System.out.println("It is not a number we catched "+e+ " please try with integers");
					return;
				}			
		while(i<bcount && flag ==false){
			if(systemid == b.get(i).getid() && systemname.equals(b.get(i).getname())){               //if it is branch employee----------
				try{				
				System.out.println("Welcome BRANCH EMPLOYEE,what do you want\n");
				System.out.println("1:Add customer 2:Remove customer \n");
				System.out.println("3:Add cargo 4:Remove cargo \n");
				System.out.println("5:Update cargo status\n");
				System.out.println("Enter number: ");
				sec2=input.nextInt();
				}catch(InputMismatchException e){System.out.println("It is not a number we catched "+e+ " please try with integers");
					return;
				}
				Scanner line = new Scanner( System.in );
					if(sec2==1){
						try{
						System.out.println("Enter new customer name");
						cname=line.nextLine();
						System.out.println("Enter track no for this customer ");
						trackno=input.nextInt();
						showbranches(br,brcount);//showing branches for the branch employee
						System.out.println("Which branch you want to add ,Enter branch name from list pls");
							bname=line.nextLine();
							while(iscontain(br,brcount,bname) ==false ){
							     showbranches(br,brcount);
								  System.out.println("You entered wrong  branch name,Enter branch name from list pls");
								  bname=line.nextLine();	
							}
						System.out.println("Do you want add new CARGO for this customer enter- yes/no");
						sec=line.nextLine();
						  }catch(InputMismatchException e){System.out.println("It is not a number we catched "+e+ " please try with integers");
							return;
							}
					    if(sec.equals("yes")){
						System.out.println("Enter sender name");
						sname=line.nextLine();
						System.out.println("Enter receiver name");	
						rname=line.nextLine();
						showbranches(br,brcount);//showing branches for the branch employee

						System.out.println("Enter sender branch name of this cargo,select from list");	
						sbranch=line.nextLine();
						System.out.println("Enter receiver branch name of this cargo,select from list");	
						rbranch=line.nextLine();
						  while(iscontain(br,brcount,sbranch) ==false || iscontain(br,brcount,rbranch) ==false ){
						     showbranches(br,brcount);
						     if(iscontain(br,brcount,sbranch) ==false){
							  System.out.println("You entered wrong sender branch name,Enter  true sender branch name from list pls");
							  sbranch=line.nextLine();	

						     }

				           	     else if(iscontain(br,brcount,rbranch) ==false){
							  System.out.println("You entered wrong receiver branch name,Enter true receiver branch name from list pls");
						          rbranch=line.nextLine();
						     }


						   }
							
						System.out.println("Enter current status of cargo");	
						nstatus=line.nextLine();
						
						Customer c2 = new Customer(trackno,cname,bname,sname,rname,sbranch,rbranch,nstatus);
						customer.add(c2);							
						System.out.println("Now you have "+customer.get(custcount).getcount()+" customer");
					     }
				     else if(sec.equals("no")){
					Customer c2 = new Customer(trackno,cname,bname);
					customer.add(c2);	
							
					 System.out.println("Now you have "+customer.get(custcount).getcount()+" customer");
				      }
				   else { System.out.println("You must enter yes or no,try it later"); }
					flag=true;
		            }
			else if(sec2==2 ){
					     if( custcount > 0){
						try{
						System.out.println("Enter track no for remove customer");
						trackno=input.nextInt();
						}catch(InputMismatchException e){System.out.println("It is not a number we catched "+e+ " please try with integers");
								return;
						}
						cremove(customer,trackno,custcount);
						flag=true;
						custcount--;
						Customer c2 = new Customer();
						c2.setcount(custcount);
		 		  	     }else{System.out.println("You CAN'T remove customer because you have "+custcount+"customer");}	
			}	

			else if(sec2==3){
				if( custcount > 0){
						try{
						System.out.println("Enter track no of the customer for add new cargo");
						trackno=input.nextInt();
						}catch(InputMismatchException e){System.out.println("It is not a number we catched "+e+ " please try with integers");
							return;
							}
						for(j=0;j < custcount;j++){//checking if there is customer with entered trackno 
							if(trackno == customer.get(j).getid() ){
								flag2=true;	
							}
							else{
							 flag2= false;
							}			
						}
						if(flag2==true ){//adding new cargo for the customer
							System.out.println("Enter sender name");
							sname=line.nextLine();
							System.out.println("Enter receiver name");	
							rname=line.nextLine();
							showbranches(br,brcount);//showing branches for the branch employee

							System.out.println("Enter sender branch name of this cargo,select from list");	
							sbranch=line.nextLine();
							
							System.out.println("Enter receiver branch name of this cargo,select from list");	
							rbranch=line.nextLine();
						
							  while(iscontain(br,brcount,sbranch) ==false || iscontain(br,brcount,rbranch) ==false ){
							     showbranches(br,brcount);
							     if(iscontain(br,brcount,sbranch) ==false){
								  System.out.println("You entered wrong sender branch name,Enter receiver branch name from list pls");
								  sbranch=line.nextLine();	

							     }

						   	     else if(iscontain(br,brcount,rbranch) ==false){
								  System.out.println("You entered wrong receiver branch name,Enter receiver branch name from list pls");
								  rbranch=line.nextLine();
							     }


							   }
								
							System.out.println("Enter current status of cargo");	
							nstatus=line.nextLine();
						customer.get(j-1).addcargo(sname,rname,sbranch,rbranch,nstatus);
						}
						else{
							System.out.println("You entered wrong trackno");			
						}
		 		}else{System.out.println("You CAN'T add new cargo because you have "+custcount+"customer");}



				flag=true;

			}

			else if(sec2==4 && custcount >0){
				try{
				System.out.println("Enter track no of the cargo for removing");
						trackno=input.nextInt();
						}catch(InputMismatchException e){System.out.println("It is not a number we catched "+e+ " please try with integers");
							return;
						}
						System.out.println("Entered trackno-> "+trackno+" custcount is"+custcount+" ifden once"); 
						for(j=0;j<custcount;j++){//checking if there is customer with entered trackno 
							if(trackno == customer.get(j).getid() ){
								flag2=true;	
								
							}
							else{
							 flag2= false;}
						}
						if(flag2==true ){
						customer.get(j-1).removecargo();

						}
						else{System.out.println("Entered wrong track no,try it again later");}
				flag=true;
				
			}			

			else if(sec2==5){
					try{
					System.out.println("Now Enter track no for update status");
					trackno=input.nextInt();
					}catch(InputMismatchException e){System.out.println("It is not a number we catched "+e+ " please try with integers");
					return;
					}
					j=0;
					while(j<custcount && flag2 ==false){
						if(trackno == customer.get(j).getid()){
							flag2 = true;
						}
						else{flag2 = false;
							j++;
							}
					}
									
						if(flag2 == false){
							System.out.println("Your track no is INCORRECT");}
						else{
							System.out.println("Enter new current status of cargo");	
							nstatus=line.nextLine();
							customer.get(j).setstatus(nstatus);	
						}
							flag=true;					
			}					
			else {System.out.println("You entered wrong number TRY IT AGAIN,select TRUE NUMBER!");}
						
						
		}
		i++;	
	}
				
	if(flag == false)
	System.out.println("\nYour id number or name is INCORRECT branch employee,,contact with the general center for reset your id,or try it again \n");

  }
	
/** 
menu for the transporter employee entrance
@param t is t.employee array
@param customers is the customers array
*/
 public static void tempenter(ArrayList<Temployee> t,int tcount,ArrayList<Customer> customers,int custcount){ // if it is a transport employee------
		int i=0,j=0,systemid,trackno;
		String nstatus,systemname;
		Scanner input = new Scanner( System.in );
		boolean flag=false,flag2=false;
		try{
		System.out.println("Enter your Name");
			systemname=input.nextLine();
		System.out.println("Enter your system id");
			systemid=input.nextInt();
		}catch(InputMismatchException e){System.out.println("It is not a number we catched "+e+ " please try with integers");
					return;
				}
		while(j<tcount && flag2==false){
			if( systemid == t.get(j).getid() && systemname.equals(t.get(i).getname()) ){                     
				Scanner line = new Scanner( System.in );
				try{				
				System.out.println("Enter cargo track number that you want to update");
				trackno = input.nextInt();
				}catch(InputMismatchException e){System.out.println("It is not a number we catched "+e+ " please try with integers");
					return;
				}
				i=0;
				while(i<custcount && flag ==false){
					if(trackno == customers.get(i).getid()){
						flag = true;
						}
					else{flag = false;
						i++;
					     }
				}
				
				if(flag == false){
					System.out.println("Your track no is INCORRECT,TRY IT AGAIN");
				}				
				else {	System.out.println("Welcome TRANSPORT EMPLOYEE,enter new status of cargo\n");
					nstatus=line.nextLine();
					customers.get(i).setstatus(nstatus);
				}
			flag2=true;	
			}
			j++;

		}

		if(flag2 == false)
			System.out.println("\nYour id number or name is INCORRECT transporter,contact with the general center for reset your id,or try it again \n");


}

/** 
menu for the Admin entrance
@param t is t.employee array
@param b is b.employee array
@param br is the branch array
*/
 public static void adminenter(ArrayList<Admin>  admins,int admincount,ArrayList<Temployee> t,int tcount,
				ArrayList<Bemployee> b,int bcount,ArrayList<Branch> br,int brcount,ArrayList<Customer> c){
				int i=0,j=0,systemid,adminid=3,sec2,nid;
				boolean flag=false,flag2=false;
				String bname,tname,systemname,aname,branchname;
				Scanner input = new Scanner( System.in );
								

				try{
				System.out.println("Enter your Name");
				systemname=input.nextLine();
				System.out.println("Enter your system admin id ");
				systemid=input.nextInt();
				}catch(InputMismatchException e){System.out.println("It is not a number we catched "+e+ " please try with integers");
					return;
				}
			while(i < admincount && flag ==false){
				if(systemid == admins.get(i).getid() && systemname.equals(admins.get(i).getname())){                   //-------if it is admin--------
					try{					
					System.out.println("Welcome ADMIN,what do you want king\n");
					System.out.println("1:Add new b.employee 2:Remove b.employee  \n");
					System.out.println("3:Add new branch 4:Remove branch\n");
					System.out.println("5:Add new t.employee 6:Remove t.employee  \n");
					System.out.println("7:Add new admin \n");
					System.out.println("Enter number: ");
					sec2=input.nextInt();
					}catch(InputMismatchException e){System.out.println("It is not a number we catched "+e+ " please try with integers");
							return;
						}
					Scanner line = new Scanner( System.in);
					if(sec2==1 ){
						if( brcount > 0){	
							System.out.println("Enter new b.employee's name");
							bname=line.nextLine();
							System.out.println("Enter new b.employee's id");
							try{		
							nid=input.nextInt();
							}catch(InputMismatchException e){System.out.println("It is not a number we catched "+e+ " please try with integers");
								return;
								}
							showbranches(br,brcount);	
							System.out.println("Which branch you want to add ,Enter branch name from list pls");
							branchname=line.nextLine();
							while(iscontain(br,brcount,branchname) ==false ){
							     showbranches(br,brcount);
								  System.out.println("You entered wrong branch name,Enter branch name from list pls");
								  branchname=line.nextLine();	
							}
						
							Bemployee b2 = new Bemployee(bname,nid,branchname);
							b.add(b2);
							System.out.println("Entered new b.employee with id: "+b.get(bcount).getid());
							bcount++;
							System.out.println("\nnow you have "+b2.getcount()+" b.employees");
						}
												
							flag=true;
							
					}

					else if(sec2==2 && brcount > 0){System.out.println("Enter id no for remove b.emp.");
							if(bcount > 0){							
							try{							
							nid=input.nextInt();
							}catch(InputMismatchException e){System.out.println("It is not a number we catched "+e+ " please try with integers");
								return;
							}
							bremove(b,nid,bcount);
							}
							else{
								System.out.println("You have NO! branchemployee for removing");			
							}
						flag=true;
					}

						
					else if(sec2==3){System.out.println("Enter new branch's name");

							bname=line.nextLine();
							while(iscontain(br,brcount,bname) ==true ){
							     showbranches(br,brcount);
								  System.out.println("There is branch with "+bname+" name,Enter  NEW branch name Please");
								  bname=line.nextLine();	
							}
							Branch br2 = new Branch(bname);
							br.add(br2);
							brcount++;
							flag=true;
						}
					else if(sec2==4 ){
						if(brcount > 0){	
							showbranches(br,brcount);
							System.out.println("Enter branch name from list for remove"); 						
							bname=line.nextLine();
							while(iscontain(br,brcount,bname) ==false ){
							     showbranches(br,brcount);
								  System.out.println("You entered wrong  branch name,Enter  branch name from list pls");
								  bname=line.nextLine();	
							}
							branchremove(br,bname,brcount,c,b,t);
							}
						else{
							System.out.println("You have NO! branch for removing");			
								}	
						flag=true;
						}

					else if(sec2==5 && brcount > 0){
							System.out.println("Enter new t.employee's name");
							tname=line.nextLine();
							System.out.println("Enter new t.employee's id");
							try{							
							nid=input.nextInt();
							}catch(InputMismatchException e){System.out.println("It is not a number we catched "+e+ " please try with integers");
								return;
							}
							showbranches(br,brcount);
							System.out.println("Which branch you want to add ,Enter branch name from list pls");
							branchname=line.nextLine();
							while(iscontain(br,brcount,branchname) ==false ){
							     showbranches(br,brcount);
								  System.out.println("You entered wrong  branch name,Enter branch name from list pls");
								  branchname=line.nextLine();	
							}
							Temployee t2 = new Temployee(tname,nid,branchname);
							t.add(t2);
							System.out.println("Entered new t.employee with id: "+t.get(tcount).getid());
							tcount++;
							System.out.println("\nnow you have "+tcount+" t.employees");
							flag=true;	
						}
					else if(sec2==6 && brcount > 0){System.out.println("Enter id no for remove t.emp.");
							

						if(tcount > 0){	
							try{							
							nid=input.nextInt();
							}catch(InputMismatchException e){System.out.println("It is not a number we catched "+e+ " please try with integers");
								return;
							}
							tremove(t,nid,tcount);
							tcount--;
							Temployee t2 = new Temployee();
							t2.setcount(tcount);
							}
						else{
							System.out.println("You have NO! transporter for removing");			
								}
						flag=true;
					}
					else if(sec2==7){
							System.out.println("Enter new ADMIN'S name");
							aname=line.nextLine();
							System.out.println("Enter new ADMIN'S id ");
							try{							
							nid=input.nextInt();
							}catch(InputMismatchException e){System.out.println("It is not a number we catched "+e+ " please try with integers");
								return;
							}
							Admin a1 = new Admin(aname,nid);
							admins.add(a1);
							System.out.println("Entered new ADMIN now you have got "+admins.size()+" admin");
						
						flag=true;
					}
						
					else {System.out.println("Admin,You Can't do this action, TRY IT AGAIN,");}
			}
			i++;
		}//while curl
			
			if(flag==false){System.out.println("\nYour id number or name is INCORRECT ,contact with the general center for reset your id,or try it again\n");}
		
	}


/**
helper function for the removing customer from array
*/

 public static void cremove(ArrayList<Customer> c,int trackno,int size){
		int i=0,j;
		boolean flag=false;
		System.out.println("Removing customer");
		while(i<size && flag ==false){
			if(trackno == c.get(i).getid()){
			   flag = true;				
				System.out.println("with name "+c.get(i).getname() );
			}
			else{flag = false;
				i++;
			}
		}
				
		if(flag == false){
			System.out.println("Your track no is INCORRECT");}
		else{
			/*for(j=i;j<size-1;j++){
				c.get(j)=c.get(j+1);}
			*/
				c.remove(i);
				Customer  c2 = new Customer();
				i=c2.getcount();
				i--;
				c2.setcount(i);
			System.out.println("Removed customer ,now you have "+i + " customers");
		}
		
				
}




/**
helper function for the removing b.employee from array
@param idno is the id no for the employee
*/

 public static void bremove(ArrayList<Bemployee> c,int idno,int size){
		int i=0,j;
		boolean flag=false;
		
		System.out.println("Removing bemployee ");
		while(i<size && flag ==false){
			if(idno == c.get(i).getid()){
					flag = true;					
				System.out.println("with name "+c.get(i).getname() );
			}
			else{flag = false;
				i++;
			}
		}
				
		if(flag == false){
			System.out.println("Your track no is INCORRECT");}
		else	{

				c.remove(i);				
				Bemployee b2 = new Bemployee();
				i=b2.getcount();
				i--;
				b2.setcount(i);
			System.out.println("Removed b.employee ,now you have "+i + " b.employee");
		}
				
}

/**
helper function for the removing t.employee from array
@param idno is the id no for the employee
*/

 public static void tremove(ArrayList<Temployee> c,int idno,int size){
		int i=0,j;
		boolean flag=false;
		
		System.out.println("Removing temployee");
		while(i<size && flag ==false){
			if(idno == c.get(i).getid()){
				System.out.println("with name "+c.get(i).getname() );
				flag = true;
			}
			else{flag = false;
				i++;
			}
		}
				
		if(flag == false){
			System.out.println("Your track no is INCORRECT");}
		else{	
			c.remove(i);
			Temployee t2 = new Temployee();
				i=t2.getcount();
				i--;
				t2.setcount(i);
			
			System.out.println("Removed t.employee ,now you have "+i + " t.employee");
		}
				
 } 

/**
helper function for the removing branch from array
@param name is the branch name for finding 
@param bc is the branch array
*/

 public static void branchremove(ArrayList<Branch> bc,String name,int size,ArrayList<Customer> c,ArrayList<Bemployee> b,ArrayList<Temployee> t){
		int i=0,j=0;
		boolean flag=false;
		String branchname;
		Customer cust = new Customer();
		Bemployee bemp = new Bemployee();
		Temployee temp = new Temployee();
		Branch br2 = new Branch();
		int bsize = bemp.getcount();	
		int tsize = temp.getcount();		
		int csize = cust.getcount();
		System.out.println("We will try to remove your "+name+" You have currently got = "+size+" branches");
		while(i<size && flag ==false){
			if(name.equals(bc.get(i).getname())){
					flag = true;
			}
			else{flag = false;
			i++;	
			}
			
		}
		System.out.println("While sonrası i= "+i);
				
		if(flag == false){
			System.out.println("Your Branch name is INCORRECT for removing ,select name from the list truely");
		}
		else {	
			//removing all things that belongs to the that branch
			
			branchname=bc.get(i).getname();
			//System.out.println("2)We will remove all things that belongs to the that branch branchname ="+branchname+" bsize= "+bsize+ 							" csize"+csize+" tsize= "+tsize );

			System.out.println("Removing bemployees of "+branchname+" branch");
			while(j<bsize){
				if(bemp.getcount()>j){//preventing index out bound				
					if(branchname.equals(b.get(j).getbranchname())){
						//System.out.println("Removing 2.ifteyiz j= "+j);
						bremove(b,b.get(j).getid(),bsize);
					}
				}
				else{
				
					//System.out.println("Removing elseteyiz j= "+j);	
				j++;
				}
			}
			j=0;
			System.out.println("Removing temployees of "+branchname+" branch");
			while(j<tsize){
				if(temp.getcount()>j){//preventing index out bound
					if(branchname.equals(t.get(j).getbranchname())){
						tremove(t,t.get(j).getid(),tsize);
					}
				}
				else{
					j++;
				}
			}
			j=0;
			System.out.println("Removing customers of "+branchname+" branch");
			while(j<csize){
				if(cust.getcount()>j){//preventing index out bound
					if(branchname.equals(c.get(j).getbranchname())){
						cremove(c,c.get(j).getid(),csize);
					}
				}		
				else{
					j++;
				}
			}
			bc.remove(i);
			i=br2.getcount();
			i--;	
			br2.setcount(i);
			
			System.out.println("Removed branch ,now you have "+i + " branches");
			//System.out.println("3)We removed all things that belongs to the that branch branchname ="+branchname+" bsize= "+bsize+ 							" csize"+csize+" tsize= "+tsize);
		}	
 }
/**
helper function for the showing branches
@param c is the branch array
*/
 public static void showbranches(ArrayList<Branch> c,int size){
	int i,j;	
	System.out.println("You have got "+size+" branches,their names are:");	
	for(i=0;i<size;i++){
		j=i+1;
		System.out.println(j+") "+c.get(i).getname());
	}

 }

/**
helper function for the checking branches
@param c is the branch array
*/
 public static boolean iscontain(ArrayList<Branch> c,int size,String name){
	int i,j;
	boolean flag = false;		
	for(i=0;i<size;i++){
		if(name.equals( c.get(i).getname() )){
			flag = true;	
		}
	}
	return flag;	

 }

}

// end of the main class
