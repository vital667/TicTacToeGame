import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame implements ActionListener {

    List<JButton> buttonList = new ArrayList<>();
    public static int counter = 0;
    public boolean flag = false;
    public static String userName1 = "User X";
    public static String userName2 = "User O";

    public static void setUserName1(String a) {
        userName1 = a;
    }

    public static void setUserName2(String b) {
        userName2 = b;
    }

    public Main() {
        setSize(500, 500);
        setTitle("Kółko i Krzyżyk GAME");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);
        setLayout(new GridLayout(4, 3));

        //add 9 buttons
        for (int i = 0; i < 9; i++) {
            JButton button = new JButton("");
            button.setOpaque(true);
            button.setBackground(Color.black);
            Font ft = new Font("Verdana", Font.BOLD, 50);
            button.setFont(ft);
            button.addActionListener(this);
            add(button);
            buttonList.add(button);
        }

        // add EXIT button
        JButton buttonExit = new JButton("EXIT");
        buttonExit.setOpaque(true);
        buttonExit.setBackground(Color.black);
        buttonExit.setForeground(Color.red);
        Font ft = new Font("Verdana", Font.BOLD, 20);
        buttonExit.setFont(ft);
        add(buttonExit);
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonExit.setEnabled(false);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                System.exit(0);
            }
        });

        //add Result button
        JLabel label = new JLabel("Result:");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        Font ft2 = new Font("Verdana", Font.BOLD, 35);
        label.setFont(ft2);
        label.setOpaque(true);
        label.setBackground(Color.black);
        label.setForeground(Color.white);
        add(label);
    }

    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        SwingUtilities.invokeLater(() -> new Main());
        Name name = new Name();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        counter++;
        JButton button = (JButton) e.getSource();
        // if someone wins - ends game
        if (flag == true) {
            button.setEnabled(false);
            return;
        }
        if (counter % 2 == 0) button.setText("O");
        else button.setText("X");
        button.setEnabled(false);

        button.setUI(new MetalButtonUI() {
            protected Color getDisabledTextColor() {
                return Color.WHITE;
            }
        });

        JLabel label = new JLabel("");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        Font ft = new Font("Verdana", Font.BOLD, 15);
        label.setFont(ft);
        label.setOpaque(true);
        label.setBackground(Color.black);
        label.setForeground(Color.white);
        if (buttonList.get(0).getText().equals("X") && buttonList.get(4).getText().equals("X")
                && buttonList.get(8).getText().equals("X") ||
                buttonList.get(2).getText().equals("X") && buttonList.get(4).getText().equals("X")
                        && buttonList.get(6).getText().equals("X") ||
                buttonList.get(0).getText().equals("X") && buttonList.get(1).getText().equals("X")
                        && buttonList.get(2).getText().equals("X") ||
                buttonList.get(0).getText().equals("X") && buttonList.get(3).getText().equals("X")
                        && buttonList.get(6).getText().equals("X") ||
                buttonList.get(2).getText().equals("X") && buttonList.get(5).getText().equals("X")
                        && buttonList.get(8).getText().equals("X") ||
                buttonList.get(6).getText().equals("X") && buttonList.get(7).getText().equals("X")
                        && buttonList.get(8).getText().equals("X") ||
                buttonList.get(1).getText().equals("X") && buttonList.get(4).getText().equals("X")
                        && buttonList.get(7).getText().equals("X") ||
                buttonList.get(3).getText().equals("X") && buttonList.get(4).getText().equals("X")
                        && buttonList.get(5).getText().equals("X")) {
            label.setText(userName1 + " wins!!!");
            add(label);
            flag = true;
            JOptionPane.showMessageDialog(this, userName1 + " wins!!!");
        } else if (buttonList.get(0).getText().equals("O") && buttonList.get(4).getText().equals("O")
                && buttonList.get(8).getText().equals("O") ||
                buttonList.get(2).getText().equals("O") && buttonList.get(4).getText().equals("O")
                        && buttonList.get(6).getText().equals("O") ||
                buttonList.get(0).getText().equals("O") && buttonList.get(1).getText().equals("O")
                        && buttonList.get(2).getText().equals("O") ||
                buttonList.get(0).getText().equals("O") && buttonList.get(3).getText().equals("O")
                        && buttonList.get(6).getText().equals("O") ||
                buttonList.get(2).getText().equals("O") && buttonList.get(5).getText().equals("O")
                        && buttonList.get(8).getText().equals("O") ||
                buttonList.get(6).getText().equals("O") && buttonList.get(7).getText().equals("O")
                        && buttonList.get(8).getText().equals("O") ||
                buttonList.get(1).getText().equals("O") && buttonList.get(4).getText().equals("O")
                        && buttonList.get(7).getText().equals("O") ||
                buttonList.get(3).getText().equals("O") && buttonList.get(4).getText().equals("O")
                        && buttonList.get(5).getText().equals("O")) {
            label.setText(userName2 + " wins!!!");
            add(label);
            flag = true;
            JOptionPane.showMessageDialog(this, userName2 + " wins!!!");
        }
        if (counter == 9 && flag == false) {
            label.setText("draw!!!");
            add(label);
            JOptionPane.showMessageDialog(this, "Draw!");
        }
    }
}