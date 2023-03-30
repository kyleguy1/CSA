import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import static java.awt.SystemColor.text;


public class Main {
    public static JTextArea messageTextWalter;
    public static JTextArea messageTextMe;
    public static JTextArea nameBox;
    public static JPanel[] background;
    public static JButton b1;
    public static JFrame game;


    public static void createAndShowGUI(int bgNumber, String dialogueWalter, String dialogueMe, String image, JFrame game){
        // Text Box Area for Walter
        messageTextWalter = new JTextArea(dialogueWalter);
        messageTextWalter.setBounds(50, 425, 700, 150);
        messageTextWalter.setMargin(new Insets(10,10,10,10));
        messageTextWalter.setBackground(Color.BLACK);
        messageTextWalter.setForeground(Color.CYAN);
        messageTextWalter.setOpaque(false);
        messageTextWalter.setEditable(false);
        messageTextWalter.setLineWrap(true);
        messageTextWalter.setWrapStyleWord(true);
        messageTextWalter.setFont(new Font("Book Antiqua", Font.PLAIN, 26));
        game.add(messageTextWalter);

        //Text Box Area for Main Character
        messageTextMe = new JTextArea(dialogueMe);
        messageTextMe.setBounds(50, 425, 700, 150);
        messageTextMe.setMargin(new Insets(10,10,10,10));
        messageTextMe.setBackground(Color.BLACK);
        messageTextMe.setForeground(Color.PINK);
        messageTextMe.setOpaque(false);
        messageTextMe.setEditable(false);
        messageTextMe.setLineWrap(true);
        messageTextMe.setWrapStyleWord(true);
        messageTextMe.setFont(new Font("Book Antiqua", Font.PLAIN, 26));
        game.add(messageTextMe);

        //Text Box Area for Name Plate
        nameBox = new JTextArea();
        nameBox.setText("");
        nameBox.setForeground(Color.ORANGE);
        nameBox.setBackground(Color.BLACK);
        //nameBox.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
        //nameBox.setMargin(new Insets(5,5,5,5));
        //nameBox.setLineWrap(true);
        nameBox.setLayout(null);
        nameBox.setEditable(false);
        nameBox.setFont(new Font("Book Antiqua", Font.BOLD, 25));
        nameBox.setBounds(60,400,100,20);
        game.add(nameBox);

        // Text Box Border
        Border border = BorderFactory.createLineBorder(Color.WHITE, 4, true);
        messageTextWalter.setBorder(border);

        // Text Box Border
        Border border1 = BorderFactory.createLineBorder(Color.WHITE, 4, true);
        messageTextMe.setBorder(border1);

        // Background Area
        background = new JPanel[20];
        background[1] = new JPanel();
        background[1].setBounds(50, 50, 700, 350);
        background[1].setLayout(null);

        // Background Images
        JLabel[] bg = new JLabel[10];
        ImageIcon bgImage1 = new ImageIcon(image);
        bg[1] = new JLabel(resizeImageIcon(bgImage1, 700, 350));
        bg[1].setBounds(0, 0, 700, 350);
        bg[1].setIcon(resizeImageIcon(bgImage1, 700, 350));
        bg[1].setBorder(BorderFactory.createLineBorder(Color.WHITE,2, true));
        background[1].add(bg[1]);
        game.add(background[1]);

        // Button
        b1 = new JButton();
        b1.setText("Start >");
        b1.setBounds(650,400,100,25);
        b1.setFont(new Font("Book Antiqua", Font.BOLD, 20));
        /*b1.setOpaque(false);
        b1.setContentAreaFilled(false);
        b1.setBorderPainted(false);*/
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (bgNumber == 2) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException d) {
                        throw new RuntimeException(d);
                    }
                } else
                if (bgNumber == 7)
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException d) {
                        throw new RuntimeException(d);
                    }
                game.remove(messageTextWalter);
                game.remove(messageTextMe);
                bg[1].setVisible(false);
                // bg[1].setIcon(null);
                // bg[1].revalidate();
                // bg[1].repaint();
                // background[1].remove(bg[1]);
                // background[1].revalidate();
                // background[1].repaint();
                // game.remove(background[1]);
                game.remove(b1);
                scenes(bgNumber+1, game);
                bg[1].setVisible(true);
            }
        });
        game.add(b1);
        game.setVisible(true);
    }

    public static void main(String[] args) {
        NameGenerator generator = new NameGenerator();

        // Game Area
        game = new JFrame("Making M-th Game");
        game.setLayout(null);
        game.setSize(800, 600);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.getContentPane().setBackground(Color.BLACK);

    }
    public static void scenes(int bgNumber, JFrame game){
        if (bgNumber == 2){
            createAndShowGUI(bgNumber,null,"........................................................." +
                    "............................................................................." +
                    "............................................................................." +
                    "...........", "IMGS/black_screen.jpg", game);
        }
        if (bgNumber == 3) {
            createAndShowGUI(bgNumber,null," Who am I????","IMGS/black_screen.jpg", game);
        }
        if (bgNumber == 4) {
            createAndShowGUI(bgNumber,null," Where am I????","IMGS/black_screen.jpg", game);
        }
        if (bgNumber == 5){
            createAndShowGUI(bgNumber,null, " !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!", "IMGS/Blurry_Distant_RV.png", game);
        }
        if (bgNumber == 6){
            createAndShowGUI(bgNumber,null, " What is that in the distance!", "IMGS/Blurry_Distant_RV.png", game);
        }
        if (bgNumber == 7){
            createAndShowGUI(bgNumber,null, " I'm hungry.....", "IMGS/Blurry_Distant_RV.PNG", game);
        }
        if (bgNumber == 8){
            createAndShowGUI(bgNumber,null, " I should probably go towards there ", "IMGS/Blurry_Distant_RV.png", game);
        }
        if (bgNumber == 9){
            createAndShowGUI(bgNumber,null, " ...", "IMGS/RV_Close.png", game);
        }
        if (bgNumber == 10){
            createAndShowGUI(bgNumber,null, " ...", "IMGS/RV_Door.PNG", game);
        }
        if (bgNumber == 11){
            createAndShowGUI(bgNumber,null, " ...!", "IMGS/WalterWhiteInRV.png", game);
        }
        if (bgNumber == 12){
            createAndShowGUI(bgNumber, " Jesse! We need to cook.",null, "IMGS/WalterWhiteInRV.png", game);
        }
        if (bgNumber == 13){
            createAndShowGUI(bgNumber, " What?!?!?!?!",null, "IMGS/WalterWhiteInRV.png", game);
        }
        if (bgNumber == 14){
            createAndShowGUI(bgNumber, " Who are you??",null, "IMGS/WalterWhiteInRV.png", game);
        }
        if (bgNumber == 15){
            createAndShowGUI(bgNumber,null, " I'm " + "Walter White " + "of course!", "IMGS/WalterWhiteInRV.png", game);
        }
        if (bgNumber == 16){
            createAndShowGUI(bgNumber,null, "I need your help to make the MATH!", "IMGS/WalterWhiteInRV.png", game);
        }
        if (bgNumber == 17){
            createAndShowGUI(bgNumber, "Um....",null,"IMGS/WalterWhiteInRV.png", game);
        }
        if (bgNumber == 18){
            createAndShowGUI(bgNumber, "Ok I guess",null, "IMGS/WalterWhiteInRV.png", game);
        }
    }
    public static javax.swing.ImageIcon resizeImageIcon(javax.swing.ImageIcon icon, int resizedWidth, int resizedHeight) {
        java.awt.Image img = icon.getImage();
        java.awt.Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
        return new javax.swing.ImageIcon(resizedImage);
    }
}