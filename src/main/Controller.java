package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import static main.Model.*;


public class Controller {
    @FXML
    public Label outLabel,equalLabel;
    private String Number;

    public void processNumbers(ActionEvent e){
        String number = ((Button)e.getSource()).getText();
        Number = Number!=null?Number+number:number;
        outLabel.setText(Number);
        System.out.println(number);
    }

    public void processOperators(ActionEvent e){
        String operator  = ((Button)e.getSource()).getText();
        if(operator.equals("=")){
            holdNumber = calculate(holdNumber,Double.parseDouble(outLabel.getText()),holdOperator);
            outLabel.setText("");
            equalLabel.setText(String.format("= %.2f",holdNumber));
            holdOperator="+";
            Number="";
            holdNumber=0;
        }else if(operator.equals(".")){
            String number = ((Button)e.getSource()).getText();
            Number = Number!=null?Number+number:"0."+number;
            outLabel.setText(Number);

            System.out.println(number);
        }
        else if(operator.equals("AC")){
            holdNumber=0;
            holdOperator="+";
            Number="";
            outLabel.setText(Number);
            equalLabel.setText("");
        }else if(operator.equals("DEL")){
            Number = Number==null?"":Number.substring(0,Number.length()-1);
            outLabel.setText(Number);
        }
        else{

            holdNumber = calculate(holdNumber,Double.parseDouble(outLabel.getText()),holdOperator);
            holdOperator = operator;
            outLabel.setText("");
            Number="";
        }

    }
}
