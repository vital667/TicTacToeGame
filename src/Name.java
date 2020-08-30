import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Name implements ActionListener {
    JTextField textField1, textField2;
    JLabel label1, label2;
    JButton button;
    JFrame frame;

    public Name() {
        frame = new JFrame();
        try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("/Users/vitaliyarkhanhelski/Desktop/image.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        label1 = new JLabel("Enter 'X user' name:");
        label1.setBounds(54, 25, 150, 20);
        textField1 = new JTextField("User X");
        textField1.setBounds(50, 50, 150, 20);
        label2 = new JLabel("Enter 'O user' name:");
        label2.setBounds(54, 95, 150, 20);
        textField2 = new JTextField("User O");
        textField2.setBounds(50, 120, 150, 20);
        button = new JButton("Play");
        button.setBounds(100, 180, 50, 20);
        button.addActionListener(this);
        frame.add(textField1);
        frame.add(label1);
        frame.add(textField2);
        frame.add(label2);
        frame.add(button);
        frame.setSize(250, 250);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("Enter 2 names");
        frame.getContentPane().setBackground(Color.BLACK);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        Main.setUserName1(textField1.getText());
        Main.setUserName2(textField2.getText());
    }
}
