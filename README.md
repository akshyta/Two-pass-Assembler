## ASSEMBLER PROJECT DOCUMENTATION

We have defined our input file format in the following manner-

[LABEL(max len=5)] (2 spaces) [OPCODE(max len=3)] (2 spaces) [OPERAND(max len=5)]

// → Notifies the start of comment

We have made 3 java files (Table_P1.java, File_input.java and pass2.java).


In Table_P1.java, we have defined an opcode table, symbol table and literal table (in the form of classes) .


In symbol table we have defined the following attributes-
Symbol name, Type (variable or label), value (data value in case of
a variable and null in case of a label), offset (virtual address of the
symbol).


In Opcode table we have stored opcode name and its corresponding binary value.


In literal table we have stored the literal value and virtual address of the instruction in which it is used.


File_input.java contains the code for Pass1 of the assembler. 

We read the input file line by line and store the labels and variables in symbol table along with their virtual addresses
(obtained by the value of location counter).

In pass2.java, we again read the input file and generate the corresponding machine language code by searching
the labels in symbol table and opcodes in opcode table (Second pass).


Once the symbol is found in the symbol table and the opcode is found in the opcode table, the corresponding machine code is
generated in the form of a string which contains the virtualaddress, the binary equivalent of the opcode and the virtual
address of the operand (Symbol).


Errors encountered during Pass1 like duplicate label/symbol, use
of wrong opcode,invalid number of operands and error
encountered during Pass2(label undeclared) is printed on the
console along with the line numbers in which these errors appear


Hence the translation of assembly language code to machine
language code is done upto the point the error is encountered
and is then stored in the output file.
