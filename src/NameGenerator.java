import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NameGenerator extends Main implements ActionListener {

    static JFrame frame;
    static JLabel label;
    static JButton button;
    static JTextArea nameGenerator;
    private static String characterName;

    NameGenerator() {
        //General Panel
        frame = new JFrame();
        frame.setBounds(0, 0, 800, 600);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        //label with the question
        label = new JLabel();
        label.setText("What is your name?");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.TOP);
        label.setFont(new Font("Book Antiqua", Font.PLAIN, 50));
        label.setBounds(0,0,800,600);
        label.setBorder(BorderFactory.createLineBorder(Color.PINK,2, true));
        label.setForeground(Color.PINK);
        frame.add(label);

        //Submit Button
        button = new JButton("Submit!");
        button.setBounds(550,300,100,50);
        button.setVerticalTextPosition(SwingConstants.CENTER);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
        button.addActionListener(this);
        label.add(button);


        // Name Screen
        nameGenerator = new JTextArea("");
        nameGenerator.setFont(new Font("Arial", Font.BOLD, 25));
        nameGenerator.setEditable(true);
        nameGenerator.setBounds(100, 300, 400, 50);
        nameGenerator.setVisible(true);
        label.add(nameGenerator);

        frame.setVisible(true);
    }
    public static String getCharacterName() {
        return characterName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            characterName = nameGenerator.getText();
            frame.setVisible(false);
            createAndShowGUI(1,null,"Welcome to M-th Making Visual Novel!                           " +
                    " Press Start to Begin!","IMGS/title_screen.png", game);
        }
    }
}



