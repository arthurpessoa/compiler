/*
    Universidade Federal de São Carlos - Campus Sorocaba
    Compiladores: Trabalho 2
    Professora: Tiemi Christine Sakata

    Alunos:
        Arthur Pessoa de Souza
        João Eduardo Brandes Luiz
*/

package AST;

import java.io.*;

public class Function extends Subdcls {
    
    public Function( String name ) {
        this.name = name;
    }
    
    public Type getReturnType() {
        return returnType;
    }
    
    public void setReturnType( Type returnType ) {
        this.returnType = returnType;
    }
    
    public void genC( PW pw ) {
        
       pw.out.print(returnType.getCname() + " " + name + "(");
        if ( dcls != null ) 
          dcls.genC(pw, true);
        pw.out.println(") {");
        pw.add();
        if ( localVarList != null ) 
          localVarList.genC(pw);
        pw.out.println();
        body.genC(pw);
        pw.sub();
        pw.out.println("}");
        
    }
    
    private Type returnType;
}
    