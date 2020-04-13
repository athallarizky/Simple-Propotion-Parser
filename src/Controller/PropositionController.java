/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import FiniteAutomata.InputView;
import Model.StateFA;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class PropositionController {  
    ArrayList<String> stack = new ArrayList<>();    
    FAController fa = new FAController();

    public PropositionController(String Proposition) {
        InputView view = new InputView();
        Proposition = view.readString();
        List<String> token = tokenize(Proposition);
        System.out.print("Token : ");
        for (int i = 0; i < token.size(); i++) {
            System.out.print(tokenRecognizer(token.get(i))+" ");
            if (tokenRecognizer(token.get(i)) == "error") {
                break;
            }
        }
        List<String> tokened = new ArrayList<>(); 
        for (int i = 0; i < token.size(); i++) {
            tokened.add(tokenRecognizer(token.get(i)));
        }
        System.out.print("\nYour Proposition Is : " + getValidation(tokened) + "\n");
    }

    public List<String> tokenize(String proposition) {
        proposition = proposition.toLowerCase();
        int i = 0;
        String temp = "";
        List<String> token = new ArrayList<>();
        while (i < proposition.length()) {
            if (proposition.charAt(i) != ' ') {
                temp += proposition.charAt(i);
            } else if (proposition.charAt(i) == ' ') {
                token.add(temp);
                temp = "";
            }
            i++;
        }
        token.add(temp);
        return token;
    } 

    public String getValidation(List<String> token) {
        String invalid = "Tidak Valid";
        stack.add("#");

        int i = 0;
        while(i < token.size()){
            switch (token.get(i)){
                case "1":
                    i++;
                    if (i != token.size()) {
                        if (token.get(i) == "3" || token.get(i) == "4" || 
                            token.get(i) == "5" || token.get(i) == "8") {
                            i++;
                        } else if (token.get(i) == "9"){
                            stack.add("(");
                            i++;
                        } else if (token.get(i) == "1"){
                            return invalid;
                        }
                    } else if (stack.size()==1 && stack.get(0).equals("#")){
                        stack.clear();
                    } else if(token.get(i) == "1") return invalid;
                    break;
                    
                case "2":
                    i++;
                    if (i!= token.size()) {
                        if ((token.get(i) == "1") &&(token.get(i+1) != "1")) {
                            i++;
                        } else if (token.get(i) == "9") {
                            stack.add("(");
                            i++;
                        }
                    } else return invalid;
                    break;
                    
                case "3":
                    i++;
                    if (token.get(i) == "2") {
                        i++;
                    } else if ((token.get(i) == "1")&&(token.get(i+1) != "1")){
                        i++;
                    } else if (token.get(i) == "9") {
                        stack.add("(");
                        i++;
                    }
                    break;
                    
                case "4":
                    i++;
                    if (token.get(i) == "2") {
                        i++;
                    } else if ((token.get(i) == "1")&&(token.get(i+1) != "1")){
                        i++;
                    } else if (token.get(i) == "9") {
                        stack.add("(");
                        i++;
                    }
                    break;
                    
                case "5":
                    i++;
                    if (token.get(i) == "2") {
                        i++;
                    } else if ((token.get(i) == "1")&&(token.get(i+1) != "1")){
                        i++;
                    } else if (token.get(i) == "9") {
                        stack.add("(");
                        i++;
                    }
                    break;
                    
                case "6":
                    stack.add("if");
                    i++;
                    break;
                    
                case "7":
                    int check = stack.size();
                    for (int j = 0; j < check; j++) {
                        if ((j == (check - 1))&&(stack.get(j)=="if")) {
                            stack.remove(j);
                        } else if ((j == (check - 1))&&(stack.get(j)=="#"))  {
                            stack.clear();
                        }
                    }
                    i++;
                    break;
                    
                case "8":
                    i++;
                    if (token.get(i) == "2") {
                        i++;
                    } else if ((token.get(i) == "1")&&(token.get(i+1) != "1")){
                        i++;
                    } else if (token.get(i) == "9") {
                        stack.add("(");
                        i++;
                    }
                    break;
                    
                case "9":
                    stack.add("(");
                    i++;
                    break;
                    
                case "10":
                    int cek = stack.size();
                    for (int j = 0; j <= stack.size(); j++) {
                        if ( (j == (cek - 1)) && (stack.get(j) == "(") ) {
                            stack.remove(j);
                        } else if ((j == (cek - 1))&&(stack.get(j) == "#")) {
                            stack.clear();
                        }
                    }
                    i++;
                    break;
                    
                default:
                    return invalid;
            }
            if (stack.isEmpty()) invalid = "Valid";
        }
        return invalid;
    }
    
    public String tokenRecognizer(String token) {
        if (isAccepted(token, fa.operand)) {
            return "1";
        } else if (isAccepted(token, fa.not)) {
            return "2";
        } else if (isAccepted(token, fa.and)) {
            return "3";
        } else if (isAccepted(token, fa.or)) {
            return "4";
        } else if (isAccepted(token, fa.xor)) {
            return "5";
        } else if (isAccepted(token, fa.ifjika)) {
            return "6";
        } else if (isAccepted(token, fa.then)) {
            return "7";
        } else if (isAccepted(token, fa.iff)) {
            return "8";
        } else if (isAccepted(token, fa.openbr)) {
            return "9";
        } else if (isAccepted(token, fa.closebr)) {
            return "10";
        } else
            return "error"; 
    }

    public boolean isAccepted(String kata, StateFA initialState) {
        StateFA current = initialState;
        int i = 0;
        while (current != null && i < kata.length()) {
            current = current.getNext(kata.charAt(i));
            i++;
        }
        return current != null ? current.getIsFinal() : false;
    }
}



