import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Main {
    public static JTextArea messageTextWalter;
    public static JTextArea messageTextMe;
    public static JTextArea nameBox = new JTextArea();
    public static JPanel[] background;
    public static JButton b1;
    public static JFrame game;


    public static void createAndShowGUI(int bgNumber, String dialogueWalter, String dialogueMe, String image, JFrame game){

        // Text Box Area for Walter
        messageTextWalter = new JTextArea(dialogueWalter);
        messageTextWalter.setBounds(50, 435, 700, 140);
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
        messageTextMe.setBounds(50, 435, 700, 140);
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
        nameBox.setForeground(Color.ORANGE);
        nameBox.setBackground(Color.BLACK);
        //nameBox.setAlignmentY(Component.CENTER_ALIGNMENT);
        //nameBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        //nameBox.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
        nameBox.setMargin(new Insets(5,5,5,5));
        nameBox.setLineWrap(true);
        nameBox.setLayout(null);
        nameBox.setEditable(false);
        nameBox.setFont(new Font("Book Antiqua", Font.BOLD, 32));
        nameBox.setBounds(60,390,500,40);
        game.add(nameBox);

        // Text Box Border
        Border border = BorderFactory.createLineBorder(Color.WHITE, 4, true);
        messageTextWalter.setBorder(border);

        // Text Box Border
        Border border1 = BorderFactory.createLineBorder(Color.WHITE, 4, true);
        messageTextMe.setBorder(border1);

        // Background Area
        background = new JPanel[50];
        background[1] = new JPanel();
        background[1].setBounds(50, 50, 700, 340);
        background[1].setLayout(null);

        // Background Images
        JLabel[] bg = new JLabel[10];
        ImageIcon bgImage1 = new ImageIcon(image);
        bg[1] = new JLabel(resizeImageIcon(bgImage1, 700, 340));
        bg[1].setBounds(0, 0, 700, 340);
        bg[1].setIcon(resizeImageIcon(bgImage1, 700, 340));
        bg[1].setBorder(BorderFactory.createLineBorder(Color.WHITE,2, true));
        background[1].add(bg[1]);
        game.add(background[1]);

        // Button
        b1 = new JButton();
        if (bgNumber == 1){
            b1.setText("Start >");
        }
        b1.setText("Next >");
        b1.setBounds(650,400,100,25);
        b1.setFont(new Font("Book Antiqua", Font.BOLD, 20));
        /*b1.setOpaque(false);
        b1.setContentAreaFilled(false);
        b1.setBorderPainted(false);*/
        b1.addActionListener(e -> {

            if (bgNumber == 2) {
                nameBox.setText(NameGenerator.getCharacterName());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException d) {
                    throw new RuntimeException(d);
                }
            } else
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException d) {
                    throw new RuntimeException(d);
                }
            //Name Box Tester
            if (((bgNumber > 2) && (bgNumber < 11)) || (bgNumber == 13 || bgNumber == 14 || bgNumber == 17 || bgNumber == 18 ||
                    bgNumber == 22 || bgNumber == 23)){
                nameBox.setText(NameGenerator.getCharacterName());
            }
            //Change text to WW
            if (bgNumber == 15 || bgNumber == 16 || bgNumber == 19 || bgNumber == 20 || bgNumber == 21
            || bgNumber == 24 || bgNumber == 25){
                nameBox.setText("Walter White");
            }
            //Change text to null
            if (bgNumber == 26 || bgNumber == 28){
                nameBox.setText("");
            }
            if (bgNumber == 12){
                nameBox.setText("?????");
            }

            //Actual Math Game Creation
            if (bgNumber > 29){
                JLabel screen = new JLabel();
                screen.setBounds(50, 435, 700, 140);
                screen.setOpaque(false);
                screen.setBackground(Color.WHITE);
                screen.setVisible(true);
                game.add(screen);

            }


            game.remove(messageTextWalter);
            game.remove(messageTextMe);
            bg[1].setVisible(false);
            game.remove(b1);
            scenes(bgNumber+1, game);
            bg[1].setVisible(true);
        });
        game.add(b1);
        game.setVisible(true);
    }

    public static void scenes(int bgNumber, JFrame game){
        ArrayList<String> questions = new ArrayList<>(List.of("IMGS/QUESTIONS/d1.PNG"));

        if (bgNumber == 2){
            createAndShowGUI(bgNumber, null, "Starting..", "IMGS/black_screen.jpg", game);
        }
        if (bgNumber == 3){
            createAndShowGUI(bgNumber,null,"........................................................." +
                    "............................................................................." +
                    "............................................................................." +
                    "...........", "IMGS/black_screen.jpg", game);
        }
        if (bgNumber == 4) {
            createAndShowGUI(bgNumber,null," Who am I????","IMGS/black_screen.jpg", game);
        }
        if (bgNumber == 5) {
            createAndShowGUI(bgNumber,null," Where am I????","IMGS/Blurry_Distant_RV.png", game);
        }
        if (bgNumber == 6){
            createAndShowGUI(bgNumber,null, " !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!", "IMGS/Blurry_Distant_RV.png", game);
        }
        if (bgNumber == 7){
            createAndShowGUI(bgNumber,null, " What is that in the distance!", "IMGS/Blurry_Distant_RV.png", game);
        }
        if (bgNumber == 8){
            createAndShowGUI(bgNumber,null, " I'm hungry.....", "IMGS/Blurry_Distant_RV.PNG", game);
        }
        if (bgNumber == 9){
            createAndShowGUI(bgNumber,null, " I should probably go towards there ", "IMGS/RV_Close.png", game);
        }
        if (bgNumber == 10){
            createAndShowGUI(bgNumber,null, " ...", "IMGS/RV_Door.PNG", game);
        }
        if (bgNumber == 11){
            createAndShowGUI(bgNumber,null, " ...", "IMGS/WalterWhiteInRV.png", game);
        }
        if (bgNumber == 12){
            createAndShowGUI(bgNumber,null, " ...!", "IMGS/WalterWhiteInRV.png", game);
        }
        if (bgNumber == 13){
            createAndShowGUI(bgNumber, " Jesse! We need to cook.",null, "IMGS/WalterWhiteInRV.png", game);
        }
        if (bgNumber == 14){
            createAndShowGUI(bgNumber,null ," What?!?!?!?!", "IMGS/WalterWhiteInRV.png", game);
        }
        if (bgNumber == 15){
            createAndShowGUI(bgNumber,null, " Who are you??", "IMGS/WalterWhiteInRV.png", game);
        }
        if (bgNumber == 16){
            createAndShowGUI(bgNumber," I'm " + "Walter White" + " of course!",null , "IMGS/WalterWhiteInRV.png", game);
        }
        if (bgNumber == 17){
            createAndShowGUI(bgNumber," I need your help to make the MATH!",null , "IMGS/WalterWhiteInRV.png", game);
        }
        if (bgNumber == 18){
            createAndShowGUI(bgNumber, null," Um....","IMGS/WalterWhiteInRV.png", game);
        }
        if (bgNumber == 19){
            createAndShowGUI(bgNumber, null," Ok I guess", "IMGS/WalterWhiteInRV.png", game);
        }
        if (bgNumber == 20){
            createAndShowGUI(bgNumber, " To make the math, YOU have to help me solve math problems to " +
                    "develop a serum.",null, "IMGS/WalterWhiteInRV.png", game);
        }
        if (bgNumber == 21) {
            createAndShowGUI(bgNumber, " We need to make this serum to help people around the world" +
                    " solve math problems!", null ,"IMGS/WalterWhiteInRV.png",game);
        }
        if (bgNumber == 22) {
            createAndShowGUI(bgNumber, " Got it???", null,"IMGS/WalterWhiteInRV.png",game);
        }
        if (bgNumber == 23) {
            createAndShowGUI(bgNumber, null, " Yeah I guess","IMGS/WalterWhiteInRV.png",game);
        }
        if (bgNumber == 24) {
            createAndShowGUI(bgNumber, null, " I hope that we can save everyone from the lack of math epidemic.....","IMGS/WalterWhiteInRV.png",game);
        }
        if (bgNumber == 25) {
            createAndShowGUI(bgNumber, " Let's get started.", null,"IMGS/WalterWhiteInRV.png",game);
        }
        if (bgNumber == 26) {
            createAndShowGUI(bgNumber, " Aha! Here's my secret MATH formula sheet!", null,"IMGS/WalterWhiteInRV.png",game);
        }
        if (bgNumber == 27) {
            createAndShowGUI(bgNumber, " ....", null,"IMGS/WalterWhiteInRVPaper.png",game);
        }
        if (bgNumber == 28){
            createAndShowGUI(bgNumber, " ....",null, "IMGS/WalterWhiteInRVPaper.png",game);
        }
        if (bgNumber == 29){
            createAndShowGUI(bgNumber, null,null, "IMGS/blurry_math.jpg",game);
        }
        if (bgNumber == 30){
            createAndShowGUI(bgNumber, null ,null, questions.get(0),game);
        }
        if (bgNumber == 31){
            createAndShowGUI(bgNumber, null ,null, questions.get(0),game);
        }
        if (bgNumber == 31){
            createAndShowGUI(bgNumber, null ,null, null,game);
        }

    }

    public static void main(String[] args) {
        new NameGenerator();
        // Game Area
        game = new JFrame("Making M-th Game");
        game.setLayout(null);
        game.setSize(800, 600);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.getContentPane().setBackground(Color.BLACK);

        //Math Game
    }
    public static javax.swing.ImageIcon resizeImageIcon(javax.swing.ImageIcon icon, int resizedWidth, int resizedHeight) {
        java.awt.Image img = icon.getImage();
        java.awt.Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
        return new javax.swing.ImageIcon(resizedImage);
    }
}
