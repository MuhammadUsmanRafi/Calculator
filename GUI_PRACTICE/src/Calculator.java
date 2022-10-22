import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    //create a frame
    static JFrame frame;
    //create a text_field
    static JTextField text;
    //store operator and operand
    String s0,s1,s2;
    //default value set
    Calculator()
    {
        s0=s1=s2="";
    }

    //main function
    public static void main(String[] args) {
        //title of frame and memory reserved
        frame=new JFrame("Calculator");


        //creating and object of class
        Calculator cal=new Calculator();

        //creating and text_field
        text=new JTextField(16);
        //for non editable
        text.setEditable(false);

//      creating button on frame for operation
        JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,ba,bs,bm,bd,be,beq,beq1;

        //set button name of 0 to 10
        b0=new JButton("0");
        b1=new JButton("1");
        b2=new JButton("2");
        b3=new JButton("3");
        b4=new JButton("4");
        b5=new JButton("5");
        b6=new JButton("6");
        b7=new JButton("7");
        b8=new JButton("8");
        b9=new JButton("9");
        b10=new JButton("10");
        //set button name of operation
        ba=new JButton("+");
        bs=new JButton("-");
        bm=new JButton("*");
        bd=new JButton("/");
        beq1=new JButton("=");
        //set button name of clear field
        beq=new JButton("C");
        //set button name of floating number
        be=new JButton(".");

        //creating panel object
        JPanel panel=new JPanel();

        //add action_listener
        b0.addActionListener(cal);
        b1.addActionListener(cal);
        b2.addActionListener(cal);
        b3.addActionListener(cal);
        b4.addActionListener(cal);
        b5.addActionListener(cal);
        b6.addActionListener(cal);
        b7.addActionListener(cal);
        b8.addActionListener(cal);
        b9.addActionListener(cal);
        b10.addActionListener(cal);
        ba.addActionListener(cal);
        bs.addActionListener(cal);
        bm.addActionListener(cal);
        bd.addActionListener(cal);
        be.addActionListener(cal);
        beq.addActionListener(cal);
        beq1.addActionListener(cal);

        //add element on panel
        panel.add(text);
        panel.add(ba);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(bs);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(bm);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(bd);
        panel.add(be);
        panel.add(b0);
        panel.add(beq);
        panel.add(beq1);


        panel.setBackground(Color.BLACK);

        frame.add(panel);

        frame.setSize(200,220);

        frame.show();
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        // if the value is a number
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            // if operand is present then add to second no
            if (!s1.equals(""))
                s2 = s2 + s;
            else
                s0 = s0 + s;

            // set the value of text
            text.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == 'C') {
            // clear the one letter
            s0 = s1 = s2 = "";

            // set the value of text
            text.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == '=') {

            double te;

            // store the value in 1st
            if (s1.equals("+"))
                te = (Double.parseDouble(s0) + Double.parseDouble(s2));
            else if (s1.equals("-"))
                te = (Double.parseDouble(s0) - Double.parseDouble(s2));
            else if (s1.equals("/"))
                te = (Double.parseDouble(s0) / Double.parseDouble(s2));
            else
                te = (Double.parseDouble(s0) * Double.parseDouble(s2));

            // set the value of text
            text.setText(s0 + s1 + s2 + "=" + te);

            // convert it to string
            s0 = Double.toString(te);

            s1 = s2 = "";
        }
        else {
            // if there was no operand
            if (s1.equals("") || s2.equals(""))
                s1 = s;
                // else evaluate
            else {
                double ans = switch (s1) {
                    case "+" -> (Double.parseDouble(s0) + Double.parseDouble(s2));
                    case "-" -> (Double.parseDouble(s0) - Double.parseDouble(s2));
                    case "/" -> (Double.parseDouble(s0) / Double.parseDouble(s2));
                    default -> (Double.parseDouble(s0) * Double.parseDouble(s2));
                };

                // store the value in 1st

                // convert it to string
                s0 = Double.toString(ans);

                // place the operator
                s1 = s;

                // make the operand blank
                s2 = "";
            }

            // set the value of text
            text.setText(s0 + s1 + s2);
        }
    }
}