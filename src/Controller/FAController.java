/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.StateFA;

/**
 *
 * @author ASUS
 */
public class FAController {
    StateFA operand;
    StateFA not;
    StateFA and;
    StateFA or;
    StateFA xor;
    StateFA ifjika;
    StateFA then;
    StateFA iff;
    StateFA openbr;
    StateFA closebr;
    
    public FAController() {
        CreateOperand();
        CreateNot();
        CreateAnd();
        CreateOr();
        CreateXor();
        CreateIf();
        CreateThen();
        CreateIff();
        CreateOpenBracket();
        CreateCloseBracket();
    }

    public void CreateOperand() {
        StateFA q0 = new StateFA("I.S");
        StateFA q1 = new StateFA("PQRS", true);
        q0.addTransition('p', q1);
        q0.addTransition('q', q1);
        q0.addTransition('r', q1);
        q0.addTransition('s', q1);
        operand = q0;
    }
    public void CreateNot(){
        StateFA q0 = new StateFA("I.S");
        StateFA q1 = new StateFA("N");
        StateFA q2 = new StateFA("O");
        StateFA q3 = new StateFA("T", true);
        q0.addTransition('n', q1);
        q1.addTransition('o', q2);
        q2.addTransition('t', q3);
        not = q0; 
    }
    public void CreateAnd(){
        StateFA q0 = new StateFA("I.S");
        StateFA q1 = new StateFA("A");
        StateFA q2 = new StateFA("N");
        StateFA q3 = new StateFA("D", true);
        q0.addTransition('a', q1);
        q1.addTransition('n', q2);
        q2.addTransition('d', q3);
        and = q0;  
    }
    public void CreateOr(){
        StateFA q0 = new StateFA("I.S");
        StateFA q1 = new StateFA("O");
        StateFA q2 = new StateFA("R", true);
        q0.addTransition('o', q1);
        q1.addTransition('r', q2);
        or = q0;   
    }
    public void CreateXor(){
        StateFA q0 = new StateFA("I.S");
        StateFA q1 = new StateFA("X");
        StateFA q2 = new StateFA("O");
        StateFA q3 = new StateFA("R", true);
        q0.addTransition('x', q1);
        q1.addTransition('o', q2);
        q2.addTransition('r', q3);
        xor = q0;   
    }
    public void CreateIf(){
        StateFA q0 = new StateFA("I.S");
        StateFA q1 = new StateFA("I");
        StateFA q2 = new StateFA("F", true);
        q0.addTransition('i', q1);
        q1.addTransition('f', q2);
        ifjika = q0;   
    }
    public void CreateThen(){
        StateFA q0 = new StateFA("I.S");
        StateFA q1 = new StateFA("T");
        StateFA q2 = new StateFA("H");
        StateFA q3 = new StateFA("E");
        StateFA q4 = new StateFA("N", true);
        q0.addTransition('t', q1);
        q1.addTransition('h', q2);
        q2.addTransition('e', q3);
        q3.addTransition('n', q4);
        then = q0;  
    }
    public void CreateIff(){
        StateFA q0 = new StateFA("I.S");
        StateFA q1 = new StateFA("I");
        StateFA q2 = new StateFA("F");
        StateFA q3 = new StateFA("F",true);
        q0.addTransition('i', q1);
        q1.addTransition('f', q2);
        q2.addTransition('f', q3);
        iff = q0;  
    }
    public void CreateOpenBracket(){
        StateFA q0 = new StateFA("I.S");
        StateFA q1 = new StateFA("(", true);
        q0.addTransition('(', q1);
        openbr = q0;   
    }
    public void CreateCloseBracket(){
        StateFA q0 = new StateFA("I.S");
        StateFA q1 = new StateFA(")", true);
        q0.addTransition(')', q1);
        closebr = q0;   
    }
}
