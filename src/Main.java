import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Project Name : miniature-octo-carnival
 * Created by Mulder on 4/27/2016.
 */

//Extends JFrame so it can create frames
public class Main extends JFrame {

    JButton button1;
    JTextField textField1;
    JTextArea textArea1;
    int buttonClicked;

    public static void main(String[] args) {
        new Main();
    }

    public Main(){
        //define screen size
        this.setSize(400,400);

        //close application completely
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Toolkit is a super class for abstract window toolkit
        Toolkit tk = Toolkit.getDefaultToolkit();
        //dimension help to hold and return width and height of a component
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width / 2) - (this.getWidth()/2);
        int yPos = (dim.height / 2) - (this.getHeight()/2);
        this.setLocation(xPos,yPos); //set appear on middle of the screen
        this.setResizable(false); //disable resize of application

        //title
        this.setTitle("My First Screen");

        //create a panel
        JPanel thePanel = new JPanel();

        //create label
        JLabel label1 = new JLabel("Student Name");
        //add label to panel
        thePanel.add(label1);

        //create button
        button1 = new JButton("Click Me");
//        button1.setBorderPainted(false); //hide button
//        button1.setContentAreaFilled(false); //make it don't look like a button

        //create an instance of listenforevent to handle events
        ListenForButton lForButton = new ListenForButton();
        button1.addActionListener(lForButton);
        thePanel.add(button1); //add button to panel and to frame

        //create a textField
        textField1 = new JTextField("Type here", 15);
        ListenForKeys lForKeys = new ListenForKeys();
        textField1.addKeyListener(lForKeys);
        thePanel.add(textField1);

        //create a textArea
        textArea1 = new JTextArea(15,20);
        textArea1.setText("Tracking events\n");
        textArea1.setLineWrap(true); //end then wrap to next line
        textArea1.setWrapStyleWord(true); //not split words

        int numOfLines = textArea1.getLineCount();
        textArea1.append("Number of lines: " + numOfLines);
        thePanel.add(textArea1);

        JScrollPane scrollbar1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        thePanel.add(scrollbar1);

        //add Panel to Frame
        this.add(thePanel);

        ListenForWindow lForWindow = new ListenForWindow();
        this.addWindowListener(lForWindow);

        this.setVisible(true);

        ListenForMouse lForMouse = new ListenForMouse();
        thePanel.addMouseListener(lForMouse);

        //pack frame to component preferred sizes
//        this.pack();

        //set focus on text field
        textField1.requestFocus();
    }

    //Implement ActionListener so it can react to events on component
    private class ListenForButton implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button1){
                buttonClicked++;
                textArea1.append("Button clicked"  + buttonClicked + "times\n");

//                e.getSource().toString();
            }
        }
    }

    //keylistener can track keys on keyboard
    private class ListenForKeys implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            textArea1.append("Key Hit: " + e.getKeyChar() + "\n");
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    private class ListenForWindow implements WindowListener{

        //when window is created
        @Override
        public void windowOpened(WindowEvent e) {
            textArea1.append("Window is created");
        }

        //whenever is close from the main
        @Override
        public void windowClosing(WindowEvent e) {

        }

        //this.displose();
        //class whenever the window is closed
        @Override
        public void windowClosed(WindowEvent e) {

        }

        //minimize
        @Override
        public void windowIconified(WindowEvent e) {
            textArea1.append("Window is minimized");
        }

        //window not in a normal state
        @Override
        public void windowDeiconified(WindowEvent e) {
            textArea1.append("Window is normal state");
        }

        @Override
        public void windowActivated(WindowEvent e) {
            textArea1.append("Window is active");
        }


        @Override
        public void windowDeactivated(WindowEvent e) {
            textArea1.append("Window is not active");
        }
    }

    private class ListenForMouse implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            textArea1.append("Mouse Panel pos: " + e.getX() + "" + e.getY()+"\n");
            textArea1.append("Mouse Screen pos: " + e.getXOnScreen() + "" + e.getYOnScreen()+"\n");
            textArea1.append("Mouse Button: " + e.getButton() +"\n");
            textArea1.append("Mouse Clicked: " + e.getClickCount() +"\n");
        }

        //mouse button had been pressed
        @Override
        public void mousePressed(MouseEvent e) {

        }

        //mouse button had been released
        @Override
        public void mouseReleased(MouseEvent e) {

        }

        //mouse entered
        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}



