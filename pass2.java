package pack1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class pass2 {
	
	
	static String convbin(int n)
	{
		String x=""; 
		while(n > 0)
	        {
	            int a = n % 2;
	            x =  String.valueOf(a)+x;
	            n = n / 2;
	        }
		for(int i=x.length();i<8;i++)
		{
			x="0"+x;
		}
		return x;
	}

	static ArrayList<String> arr=new ArrayList<String>();
	static void writeTofile()
	{
		try {
 			File myFile = new File("D:\\eclipse-workspace\\caos\\src\\pack1\\out.txt");
			if (!myFile.exists()) {
				myFile.createNewFile();
			}
 			BufferedWriter writer = new BufferedWriter(new FileWriter(myFile));
 			for(int i=0;i<arr.size();i++)
 			{
 				writer.write(arr.get(i));
 				writer.newLine();
 			}
 			
			
			writer.close();
 		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File_input.main(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int lc=0;
		String str="";
		int min=File_input.finput.size();
		for(int i=0;i<Table_P1.ff.size();i++)
		{
			if(Table_P1.ff.get(i).loc<min)
			{
				min=Table_P1.ff.get(i).loc;
			}
		}
		for(int i=0;i<min;i++)
		{
			String s;
			str=convbin(lc)+" ";
//			str=str+s+"  ";
			s=File_input.finput.get(i).substring(7, 10);
			if(s.equals("DC "))
			{
				String temp=File_input.finput.get(i).substring(12, 17);
				int val=0;
				for(int j=0;j<5;j++)
				{
					if(temp.charAt(j)==' ')
					{
						val=j;
						break;
					}
					val=val+1;
				}
				str=str+temp.substring(0,val);
				
			}
			else
			{
				int val=0;

				
				String d=s;
				for(int j=0;j<Table_P1.opcodes.size();j++)
				{
					if(d.equals(Table_P1.opcodes.get(j).op))
					{
						str=str+Table_P1.opcodes.get(j).hex+" ";
						break;
					}
				}
				
				if(!( d.equals("CLA") || d.equals("STP")) )
				{
					String opnd=File_input.finput.get(i).substring(12, 17);
					val=0;
					for(int j=0;j<5;j++)
					{
						if(opnd.charAt(j)==' ')
						{
							val=j;
							break;
						}
						val=val+1;
					}
					
					opnd=opnd.substring(0,val);
					int flag=0;
					for(int j=0;j<Table_P1.symTable.size();j++)
					{
						if(opnd.equals(Table_P1.symTable.get(j).name))
						{
							String ofval=convbin(Table_P1.symTable.get(j).offset);
							str=str+ofval;
							flag=1;
							break;
						}

					}
					if(flag==0)
					{
						for(int k=0;k<Table_P1.Literals.size();k++)
						{
							if(opnd.substring(1,opnd.length()).equals(Table_P1.Literals.get(k).value))
							{
								str=str+convbin(Integer.parseInt(opnd.substring(1,opnd.length())));
								flag=1;
								break;
							}
						}
					}
					
					if(flag==0)
					{
						
						System.out.println("Label undeclared");
						break;
						//System.exit(0);
					}
				}
				
				
			}
			arr.add(str);
			lc=lc+1;
		}
		
		writeTofile();

		for(int j=0;j<Table_P1.ff.size();j++)
		{
			if(Table_P1.ff.get(j).type==1)
				{
				System.out.println("line no. " +Table_P1.ff.get(j).line_no+": "+"Invalid Opcode");
				}
			else if(Table_P1.ff.get(j).type==2)
			{
			System.out.println("line no. " +Table_P1.ff.get(j).line_no+": "+"Duplicate Label");
			}
			else if(Table_P1.ff.get(j).type==3)
			{
			System.out.println("line no. " +Table_P1.ff.get(j).line_no+": "+"Invalid no of operand");
			}
		}
	}

}
