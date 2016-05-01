import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

/**
 * Project Name : miniature-octo-carnival
 * Created by Mulder on 4/30/2016.
 */
public class Main5 extends JFrame{
    JButton button1;
    JSpinner spinner1, spinner2 , spinner3, spinner4;
    String outputString = "";

    public static void main(String[] args) {
        new Main5();

    }

    public Main5(){
        this.setTitle("The sixth frame");
        this.setSize(400,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel thePanel = new JPanel();

        //create a button
        button1 = new JButton("Get Answer");
        ListenForButton lForButton = new ListenForButton();
        button1.addActionListener(lForButton);
        thePanel.add(button1);

        //create a bsic 1-9 number spinner
        spinner1 = new JSpinner();
        thePanel.add(spinner1);

        //create a spinner with initial number , starting number, max num, increment with click
        spinner2 = new JSpinner(new SpinnerNumberModel(1,1,100,1));
        thePanel.add(spinner2);

        //create a spinner using default values
        String[] weekDays = {"Mon" ,
                "Tues" ,
                "Weds" ,
                "Thurs" ,
                "Fri"};
        spinner3 = new JSpinner(new SpinnerListModel(weekDays));

        //set size for spinner so everything fit
        Dimension d = spinner3.getPreferredSize();
        d.width = 80;
        spinner3.setPreferredSize(d);
        thePanel.add(spinner3);

        //Get today Date
        Date todayDate = new Date();
        //Create a date spinner & set today , no minimum/max
        //increment days by click
        //can add increment year.month/day of month
        spinner4 = new JSpinner(new SpinnerDateModel(todayDate, null, null, Calendar.DAY_OF_MONTH));

        //DateEditor is an editor that handles displaying & editing the dates
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner4, "dd/MM/yy");
        spinner4.setEditor(dateEditor);
        thePanel.add(spinner4);

        //You can also change listener with spinner
//        ListenForSpinner lForSpinner = new ListenForSpinner();
//        spinner4.addChangeListener(lForSpinner);
//        Tell Java that you want to alet when an event occur on spinner

        this.add(thePanel);
        this.setVisible(true);
    }

    public class ListenForButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1){
                outputString += "Spinner 1 Value: " + spinner1.getValue() + "\n";
                outputString += "Spinner 2 Value: " + spinner2.getValue() + "\n";
                outputString += "Spinner 3 Value: " + spinner3.getValue() + "\n";
                outputString += "Spinner 4 Value: " + spinner4.getValue() + "\n";

                JOptionPane.showMessageDialog(Main5.this, outputString, "Infomation", JOptionPane.INFORMATION_MESSAGE);
                outputString = "";
            }
        }
    }
}
