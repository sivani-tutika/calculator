package com.sivani.calculator;

import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener
{
	int n;
	int  op, result;
	String val1, val2;
	TextField display;
	Frame f=new Frame("Button Example");
	String numberButtonText[] = {"7", "8", "9", "4", "5", "6", "1", "2", "3", ".", "0", "C" };
	String operatorButtonText[] = {"+","-","*","/","="};
	
	Button numberButton[]=new Button[numberButtonText.length];
	Button operatorButton[]=new Button[operatorButtonText.length];
	
	Button btnEql;
	
	Panel p;
	GridLayout g;
	Calculator()
	{
		f = new Frame("My Calculator");
		p = new Panel();
		
		
		for(int i=0; i<12; i++) {
			numberButton[i] = new Button(numberButtonText[i]);
			numberButton[i].addActionListener(this);
			numberButton[i].setBounds((i%3)*100,(i/3 + 1)*100,100,100);
			f.add(numberButton[i]);
		}
		
		for(int i=0; i<4; i++) {
			operatorButton[i] = new Button(operatorButtonText[i]);
			operatorButton[i].addActionListener(this);
			operatorButton[i].setBounds(300,(i+1)*100,100,100);
			f.add(operatorButton[i]);
		}
		
		operatorButton[4] = new Button(operatorButtonText[4]);
		operatorButton[4].addActionListener(this);
		operatorButton[4].setBounds(0,500,400,100);
		f.add(operatorButton[4]);
		


		display = new TextField(100);
		f.add(display);
		
		
		f.setSize(400,600);
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		for(int i=0; i<12; i++) {
		if(e.getSource()==numberButton[i])
		{
			if(i==9) {
				String currentVal = display.getText();
				String updateVal = currentVal+ '.';
				display.setText(updateVal);
			}
			else if(i==11) {
				display.setText("");
			}
			else {
			String currentVal = display.getText();
			String updateVal = currentVal+ numberButton[i].getLabel();
			display.setText(updateVal);
			}
		}
		}
		
		for(int i=0; i<4; i++) {
			if(e.getSource()== operatorButton[i])
			{
				val1 = display.getText();
				op = i;
				display.setText("");
			}
			}
		
		
		
		if(e.getSource() == operatorButton[4])
		{
			val2 = display.getText();
			if(op==0)
			{
				n = Integer.parseInt(val1)+Integer.parseInt(val2);
				display.setText(String.valueOf(n));
			}
			else
			if(op==1)
			{
				n = Integer.parseInt(val1)-Integer.parseInt(val2);
				display.setText(String.valueOf(n));
			}
			else
			if(op==2)
			{
				n = Integer.parseInt(val1)*Integer.parseInt(val2);
				display.setText(String.valueOf(n));
			}
			if(op==3)
			{
			    try
			    {
			        int p=Integer.parseInt(val2);
			        if(p!=0)
                    {
                    n = Integer.parseInt(val1)/Integer.parseInt(val2);
                    display.setText(String.valueOf(n));
                     }
                     else
                        display.setText("infinite");

                }
                catch(Exception i){}
			}
			
		}
		
	}

	public static void main(String[] abc)
	{
		Calculator v = new Calculator();
	}
}