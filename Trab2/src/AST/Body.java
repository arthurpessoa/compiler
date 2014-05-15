/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AST;

/**
 *
 * @author JoaoEduardo
 */
public class Body {
    
    public Body (Dclpart dclpart, CompositeStatement compstmt){
        this.dclpart = dclpart;
        this.compstmt = compstmt;
    }
    
    public void genC( PW pw ) {
        dclpart.genC(pw);
        compstmt.genC(pw);
    }
    
    private Dclpart dclpart;
    private CompositeStatement compstmt;
      
}