import javax.swing.*;
import java.awt.*;

/**
 * Project Name : miniature-octo-carnival
 * Created by Mulder on 5/3/2016.
 */
public class CreateStudentPanel extends JPanel{
        public CreateStudentPanel(){
            this.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            JLabel labelStdName = new JLabel("Student Name: ");
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;
            gbc.gridy = 0;
            this.add(labelStdName, gbc);

            JLabel labelStdId = new JLabel("Student ID: ");
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;
            gbc.gridy = 1;
            this.add(labelStdId, gbc);

            JLabel labelStdProgram = new JLabel("Student Program ");
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;
            gbc.gridy = 2;
            this.add(labelStdProgram, gbc);

            JTextField textStdName = new JTextField();
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 1;
            gbc.gridy = 0;
            this.add(textStdName, gbc);

            JTextField textStdId = new JTextField();
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 1;
            gbc.gridy = 1;
            this.add(textStdId, gbc);

            JTextField textStdProgram = new JTextField();
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 1;
            gbc.gridy = 2;
            this.add(textStdProgram, gbc);

            JButton btnCreateStd = new JButton("Create");
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;
            gbc.gridy = 3;
            this.add(btnCreateStd, gbc);

            JButton btnCancelStd = new JButton("Cancel");
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 1;
            gbc.gridy = 3;
            this.add(btnCancelStd, gbc);

        }

}
