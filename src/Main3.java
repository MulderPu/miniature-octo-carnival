import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Project Name : miniature-octo-carnival
 * Created by Mulder on 4/30/2016.
 */
public class Main3 extends JFrame {
    JComboBox favoriteShows;
    JButton button1;
    String infoOnComponent = "";

    public static void main(String[] args) {
        new Main3();
    }

    public Main3(){
        this.setSize(400,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("The fourth frame");

        JPanel thePanel = new JPanel();
        String[] shows = {"Breaking ball", "Life on Mars for 365days", "Doctor Who"};
        favoriteShows = new JComboBox(shows);
        favoriteShows.addItem("Lovely Sunflower");
        thePanel.add(favoriteShows);

        //create button
        button1 = new JButton("Get answer");
        ListenForButton lForButton = new ListenForButton();
        button1.addActionListener(lForButton);
        thePanel.add(button1);
        this.add(thePanel);
        this.setVisible(true);

        //add combobox to index 1
        favoriteShows.insertItemAt("Dex",1);

        //only 3 item a time
        favoriteShows.setMaximumRowCount(3);

        // Remove the item named Dexter
        //favoriteShows.removeItem("Dexter");

        // Remove the item at index 1
        //favoriteShows.removeItemAt(1);

        // Remove all items
        // favoriteShows.removeAllItems();

    }

    public class ListenForButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1){


                favoriteShows.setEditable(true);

                // Get item at index 0

                infoOnComponent = "Item at 0: " + favoriteShows.getItemAt(0) + "\n";

                // Get the number of items in the combo box

                infoOnComponent += "Num of Shows: " + favoriteShows.getItemCount() + "\n";

                // Get the index for the selected item

                infoOnComponent += "Selected ID: " + favoriteShows.getSelectedIndex() + "\n";

                // Get the value for the selected item

                infoOnComponent += "Selected Show: " + favoriteShows.getSelectedItem() + "\n";

                // Find out if the values in the combo box are editable

                infoOnComponent += "Combo Box Editable: " + favoriteShows.isEditable() + "\n";

                JOptionPane.showMessageDialog(Main3.this, infoOnComponent, "Information", JOptionPane.INFORMATION_MESSAGE);

                infoOnComponent = "";

            }
        }
    }
}
