package pack1;

import java.util.ArrayList;


class Symbol // Label + Symbol Table
{
	String name;
	String type;
	String value;
	int offset;
	Symbol(String n,String t,String v,int o)
	{
		name=n;
		type=t;
		value=v;
		offset=o;
	}
}

class Opcode
{
	String op;
	String hex;
	Opcode(String o,String h)
	{
		op=o;
		hex=h;
	}
	
}

class literal
{
	String value;
	int offset;
	
	literal(String s,int a)
	{
		value=s;
		offset=a;
	}
}
class error
{
	int line_no ;
	int type;
	int loc;
	error(int l,int t,int lo)
	{
		line_no=l;
		type=t;
		loc=lo;
	}
}
class Table_P1 {

	
	
	public static ArrayList<Symbol> symTable=new ArrayList<Symbol>();
	public static ArrayList<Opcode> opcodes=new ArrayList<Opcode>();
	public static ArrayList<literal> Literals=new ArrayList<literal>();
	public static ArrayList<error> ff=new ArrayList<error>();
	public static void main(String[] args) {
		
		Table_P1.opcodes.add(new Opcode("CLA","0000"));
	 	Table_P1.opcodes.add(new Opcode("LAC","0001"));
	 	Table_P1.opcodes.add(new Opcode("SAC","0010"));
	 	Table_P1.opcodes.add(new Opcode("ADD","0011"));
	 	Table_P1.opcodes.add(new Opcode("SUB","0100"));
	 	Table_P1.opcodes.add(new Opcode("BRZ","0101"));
	 	Table_P1.opcodes.add(new Opcode("BRN","0110"));
	 	Table_P1.opcodes.add(new Opcode("BRP","0111"));
	 	Table_P1.opcodes.add(new Opcode("INP","1000"));
	 	Table_P1.opcodes.add(new Opcode("DSP","1001"));
	 	Table_P1.opcodes.add(new Opcode("MUL","1010"));
	 	Table_P1.opcodes.add(new Opcode("DIV","1011"));
	 	Table_P1.opcodes.add(new Opcode("STP","1100"));
		
	}

}
