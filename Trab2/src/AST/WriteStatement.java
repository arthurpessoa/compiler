package AST;

public class WriteStatement extends Statement {
    
    public WriteStatement( ExprList expr ) {
        this.expr = expr;
    }
 
    public void genC( PW pw ) {
       
        int size = expr.getSize();
        int i;
        Expr e = null;
       
        for(i=0;i<size;i++){
            e = expr.getElement(i);
            if ( e.getType() == Type.charType ) {
                pw.print("printf(\"%c\", ");
            }else{
                if(e.getType() == Type.stringType){
                    pw.print("printf(\"%s\", ");
                }else{
                    if(e.getType() == Type.integerType)
                        pw.print("printf(\"%d\", ");
                    else
                        pw.print("printf(\"%f\", ");
                }   
            }
            e.genC(pw, false);
        }
        pw.out.println(" );");
    }
    
    
    private ExprList expr;
}