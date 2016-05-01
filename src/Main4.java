import javax.swing.*;
import javax.swing.text.html.ObjectView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Project Name : miniature-octo-carnival
 * Created by Mulder on 4/30/2016.
 */
public class Main4 extends JFrame {

    JButton button1;
    String infoOnComponent = "";
    JList favoriteMovies,favoriteColors;
    DefaultListModel deListModel = new DefaultListModel();
    JScrollPane scroller;

    public static void main(String[] args) {
        new Main4();
    }

    public Main4(){
        this.setTitle("The fifth frame");
        this.setSize(400,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel thePanel = new JPanel();
        button1 = new JButton("Get Answer");
        ListenForButton lForButton = new ListenForButton();
        button1.addActionListener(lForButton);
        thePanel.add(button1);

        String[] movies = {"Matrix", "X-men", "Minion"};
        favoriteMovies = new JList(movies);
        favoriteMovies.setFixedCellHeight(30);
        favoriteMovies.setFixedCellWidth(150);
        //allow one item
        favoriteMovies.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        String[] colors = {"Red", "Black", "White", "Green"};

        for(String color:colors){
            deListModel.addElement(color);
        }

        deListModel.add(2,"Purple");
        favoriteColors = new JList(deListModel);
        favoriteColors.setVisibleRowCount(4);
        scroller = new JScrollPane(favoriteColors,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        favoriteColors.setFixedCellHeight(30);
        favoriteColors.setFixedCellWidth(150);
        thePanel.add(favoriteMovies);
        thePanel.add(scroller);
        this.add(thePanel);
        this.setVisible(true);
    }

    public class ListenForButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1){
                if(deListModel.contains("Black")) infoOnComponent += "Black is here\n";
                if(deListModel.isEmpty()) infoOnComponent += "is empty\n";
                infoOnComponent += "Elemensts in list =" + deListModel.size() + "\n";
                infoOnComponent += "Last Element =" + deListModel.firstElement()+ "\n";
                infoOnComponent += "Last Element =" + deListModel.lastElement() + "\n";
                infoOnComponent += "Element in index 1 " + deListModel.get(1)  + "\n";
                deListModel.remove(0);
                deListModel.removeElement("Red");
                Object[] arrayOfList = deListModel.toArray();

                for (Object color : arrayOfList){
                    infoOnComponent += color + "\n";
                }

                JOptionPane.showMessageDialog(Main4.this, infoOnComponent, "Information", JOptionPane.INFORMATION_MESSAGE);
                infoOnComponent = "";
            }
        }
    }
}
