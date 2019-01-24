package pack1;
//import pack1.Symbol;
//import java.math.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

//class DuplicateLabelException extends Exception
//{
//	DuplicateLabelException()
//	{
//	super("Duplicate Label");
//
//	}
//}
//class InvalidOpcodeException extends Exception
//{
//	InvalidOpcodeException()
//	{
//		super("Invalid Opcode");
//	}
//}


public class File_input {
	
	static ArrayList<String> finput=new ArrayList<String>();

	 public static void main(String[] args) throws Exception{
		 
		File file = new File("D:\\eclipse-workspace\\caos\\src\\pack1\\inp.txt"); 
		Table_P1.main(args);  
		BufferedReader br = new BufferedReader(new FileReader(file)); 
	  
		String st; 
		int lc=0;
		int line=0;
		while ((st = br.readLine()) != null) 
		{
			line++;
			if(st.isEmpty()==false)
			{
				
				if(!st.substring(0,2).equals("//"))
				{
					finput.add(st);
					if(!(st.substring(0,5).equals("     ")))
					{
						String str=st.substring(0,5);
						int temp=0;
						for(int i=0;i<5;i++)
						{
							if(str.charAt(i)==' ')
							{
								temp=i;
								break;
							}
							temp=temp+1;
						}
						int flag=0;
						
						for(int j=0;j<Table_P1.symTable.size();j++)
						{
							//System.out.print(Table_P1.symTable.get(j).name+" ");
							if(Table_P1.symTable.get(j).name.compareTo(str.substring(0,temp))==0)
							{
								flag=1;
								break;
							}
						}
						//System.out.println();
						if(flag==0)
						{
							
							
							if(st.substring(7,10).equals("DC "))
							{
								String s=st.substring(12,17);
								int save=0;
								for(int i=0;i<5;i++)
								{
									if(s.charAt(i)==' ')
									{
										save=i;
										break;
									}
									save=save+1;
								}
						//int n=Integer.parseInt(s.substring(0, save));
								Table_P1.symTable.add(new Symbol(str.substring(0,temp),"variable",s.substring(0, save),lc));
							}
						
							else
						
							{
								int check=0;
								for(int j=0;j<Table_P1.opcodes.size();j++)
								{
									//System.out.println(Table_P1.opcodes.get(j).op+" "+st.substring(7,10));
									if(Table_P1.opcodes.get(j).op.compareTo(st.substring(7,10))==0)
									{
										check=1;
									}
								}
								//error
								
								if(check==0)
								{
									Table_P1.ff.add(new error(line,1,lc));
									//System.out.println("Invalid opcode");
								}
								else
								{
								Table_P1.symTable.add(new Symbol(str.substring(0,temp),"label",null,lc));
								
								}
								
							}
						}
					
						else
						{
							//error 
							Table_P1.ff.add(new error(line,2,lc));
						    // System.out.println("Duplicate label");
							//throw(new DuplicateLabelException());
							
							
						}
					}
					else
					{
						int check=0;
						//System.out.println(Table_P1.opcodes.size());
						for(int j=0;j<Table_P1.opcodes.size();j++)
						{
							//System.out.println(Table_P1.opcodes.get(j).op+" "+st.substring(7,10));
							if(Table_P1.opcodes.get(j).op.compareTo(st.substring(7,10))==0)
							{
								check=1;
								break;
							}
						}
						//error
						
						if(check==0)
						{
							Table_P1.ff.add(new error(line,1,lc));
							//System.out.println("Invalid opcode");
						}
					}
					//System.out.println(st+" "+st.length());
					String a=st.substring(12,17);
					int val=0;
					for(int b=0;b<5;b++)
					{
						if(a.charAt(b)==' ')
						{
							break;
						}
						val=val+1;
					}
					int f=0;
					if(st.substring(7,10).equalsIgnoreCase("STP"))
					{
						for(int x=12;x<st.length();x++)
						{
							if(st.charAt(x)=='/')
							{
								break;
							}
							else if(st.charAt(x)!=' ')
							{
								Table_P1.ff.add(new error(line,3,lc));
								f=1;
								break;
							}
						}
					}
					else
					{
						
					if(val==0 )
					{
						f=1;
						Table_P1.ff.add(new error(line,3,lc));
					}
					for(int x=12+val+1;x<st.length();x++)
					{
						if(st.charAt(x)=='/')
						{
							break;
						}
						else if(st.charAt(x)!=' ')
						{
							Table_P1.ff.add(new error(line,3,lc));
							f=1;
							break;
						}
					}
					if(f==0)
					{
						
					a=a.substring(0,val);
					if(a.charAt(0)=='=')
					{
						
						Table_P1.Literals.add(new literal(a.substring(1,a.length()),lc));
					}
					}
					
					}
					
					
					lc++;
				}
				
			}
		}
		br.close();
//		for(int i=0;i<Table_P1.symTable.size();i++)
//		{
//			System.out.println(Table_P1.symTable.get(i).name+" "+Table_P1.symTable.get(i).type+" "+Table_P1.symTable.get(i).value+" "+Table_P1.symTable.get(i).offset);
//		}
//	    
	  

	}

}

