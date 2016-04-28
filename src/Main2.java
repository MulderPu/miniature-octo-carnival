import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

/**
 * Project Name : miniature-octo-carnival
 * Created by Mulder on 4/28/2016.
 */
public class Main2 extends JFrame {

    JButton button1;
    JLabel label1, label2, label3;
    JTextField textField1, textField2;
    JCheckBox dollarSign, commaSeparator;
    JRadioButton add, sub, mul, div;
    JSlider howManyTimes;
    double number1, number2,totalCalc;

    public static void main(String[] args) {
        new Main2();
    }

    public Main2(){
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My another frame");
        JPanel thePanel = new JPanel();

        button1 = new JButton("Calcualate");
        ListenForButton lForButton = new ListenForButton();
        button1.addActionListener(lForButton);
        thePanel.add(button1);

        label1 = new JLabel("Number 1");
        thePanel.add(label1);
        textField1 = new JTextField("", 5);
        thePanel.add(textField1);

        label2 = new JLabel("Number 2");
        thePanel.add(label2);
        textField2 = new JTextField("", 5);
        thePanel.add(textField2);

        dollarSign = new JCheckBox("Dollars");
        commaSeparator = new JCheckBox("Commas");

        thePanel.add(dollarSign);
        thePanel.add(commaSeparator, true); //true, check by default

        add = new JRadioButton("Add");
        sub = new JRadioButton("Subtract");
        mul = new JRadioButton("Multiply");
        div = new JRadioButton("Divide");

        ButtonGroup operation = new ButtonGroup();
        operation.add(add);
        operation.add(sub);
        operation.add(mul);
        operation.add(div);

        JPanel operPanel = new JPanel();
        Border operBorder = BorderFactory.createTitledBorder("Operation");
        operPanel.setBorder(operBorder);
        operPanel.add(add);
        operPanel.add(sub);
        operPanel.add(mul);
        operPanel.add(div);

        add.setSelected(true);
        thePanel.add(operPanel);
        label3 = new JLabel("Perform how Many Times");
        thePanel.add(label3);

        howManyTimes=new JSlider(0, 99, 1);
        howManyTimes.setMinorTickSpacing(1);
        howManyTimes.setMajorTickSpacing(10);
        howManyTimes.setPaintTicks(true); // draw tick on screen
        howManyTimes.setPaintLabels(true);

        ListenForSlider lForSlider = new ListenForSlider();
        howManyTimes.addChangeListener(lForSlider);

        thePanel.add(howManyTimes);
        this.add(thePanel);
        this.setVisible(true);

        textField1.requestFocus();
    }

    private class ListenForButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1){

                try{
                    number1 = Double.parseDouble(textField1.getText());
                    number2 = Double.parseDouble(textField2.getText());
                }
                catch(NumberFormatException excep){
                    JOptionPane.showMessageDialog(Main2.this, "Please enter the Right info.");
                    System.exit(0); // close java app
                }

                if(add.isSelected()){
                    totalCalc = addNumbers(number1, number2,howManyTimes.getValue());
                }
                else if(sub.isSelected()){
                    totalCalc = subNumbers(number1, number2, howManyTimes.getValue());
                }
                else if(mul.isSelected()){
                    totalCalc = mulNumbers(number1, number2, howManyTimes.getValue());
                }
                else{
                    totalCalc = divNumbers(number1, number2, howManyTimes.getValue());
                }

                if(dollarSign.isSelected()){
                    NumberFormat numFormat = NumberFormat.getCurrencyInstance();
                    JOptionPane.showMessageDialog(Main2.this, numFormat.format(totalCalc), "solution", JOptionPane.INFORMATION_MESSAGE);
                }
                else if (commaSeparator.isSelected()){
                    NumberFormat numFormat = NumberFormat.getNumberInstance();
                    JOptionPane.showMessageDialog(Main2.this, numFormat.format(totalCalc), "solution", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(Main2.this,totalCalc, "solution", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    private class ListenForSlider implements ChangeListener{

        @Override
        public void stateChanged(ChangeEvent e) {
            if(e.getSource()==howManyTimes){
                label3.setText("Perform How many Times? "+howManyTimes.getValue());
            }
        }
    }

    public static double addNumbers(double number1, double number2 , int howMany){
        double total =0;
        int i = 0;

        while(i<=howMany){
            total=total + (number1 + number2);
            i++;
        }

        return total;
    }

    public static double subNumbers(double number1, double number2 , int howMany){
        double total =0;
        int i = 0;

        while(i<=howMany){
            total=total + (number1 - number2);
            i++;
        }

        return total;
    }

    public static double mulNumbers(double number1, double number2 , int howMany){
        double total =0;
        int i = 0;

        while(i<=howMany){
            total=total + (number1 * number2);
            i++;
        }

        return total;
    }

    public static double divNumbers(double number1, double number2 , int howMany){
        double total =0;
        int i = 0;

        while(i<=howMany){
            total=total + (number1 / number2);
            i++;
        }

        return total;
    }

}
