import javax.swing.*;

/**
 * Project Name : miniature-octo-carnival
 * Created by Mulder on 5/3/2016.
 */
public class DialogBox{
    public static void main(String[] args) {
        JTextField stdName = new JTextField();
        JTextField stdId = new JTextField();
        JTextField stdProgram = new JTextField();
        final JComponent[] inputs = new JComponent[] {
                new JLabel("Enter Student Name: "),
                stdName,
                new JLabel("Enter Student ID: "),
                stdId,
                new JLabel("Enter Student Program: "),
                stdProgram
        };

        int response = JOptionPane.showConfirmDialog(null, inputs , "Create Student",
                JOptionPane.OK_CANCEL_OPTION);
        if (response == JOptionPane.CANCEL_OPTION) {
            System.out.println("Cancel button clicked");
        } else if (response == JOptionPane.OK_OPTION) {
            System.out.println("Ok button clicked");
            System.out.println("You entered " +
                    stdName.getText() + ", " +
                    stdId.getText() + ", " +
                    stdProgram.getText());
        } else if (response == JOptionPane.CLOSED_OPTION) {
            System.out.println("JOptionPane closed");
        }
    }
}
