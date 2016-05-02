import javax.swing.JOptionPane;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
/**
 * Project Name : miniature-octo-carnival
 * Created by Mulder on 5/2/2016.
 */
public class CustomDialogBox {
    public static void main(String[] args) {
//        JDialog.setDefaultLookAndFeelDecorated(true);
        int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION) {
            System.out.println("No button clicked");
        } else if (response == JOptionPane.YES_OPTION) {
            System.out.println("Yes button clicked");
        } else if (response == JOptionPane.CLOSED_OPTION) {
            System.out.println("JOptionPane closed");
        }
    }
}
