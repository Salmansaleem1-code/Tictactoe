package ticandtoe;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.*;
import java.awt.Color;
import java.io.IOException;
import javax.swing.border.Border;

class BackgroundImage extends JPanel {
    Image image;
    static int imgv = 0;
    public BackgroundImage() {
        try {
            if (imgv == 0)
                image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("ticandtoe.jpg"), "ticandtoe.jpg"));
            else {
                image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("ticandtoe2.jpg"), "ticandtoe2.jpg"));
            }
            imgv++;
        } catch (IOException e) { /*handled in paintComponent()*/ }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null)
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
public class ticandtoe {

    Player player;
    Computer computer;
    JButton[] jButton = new JButton[16];
     static int k=0;
 
    ticandtoe() {
        player = new Player();

        computer = new Computer();
        player.playerSymbolChoose = "-"; //initiall set
        player.playerName = "-a";





        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame f = new JFrame("");
        JFrame frame2 = new JFrame("ticandtoe");



        JPanel panel = new BackgroundImage();

        JPanel panel2 = new JPanel();
        Font font = new Font("Telegraphico", Font.BOLD, 20);
        JButton startgame = new JButton();
        JLabel Title = new JLabel();
        Title.setText("Tic Tac and Toe");
        Title.setFont(font);
        Title.setLocation(480, 40);
        Title.setForeground(Color.WHITE);
        Title.setSize(250, 70);
        font = new Font("Arial", Font.BOLD, 14);
        JLabel username = new JLabel();
        username.setText("Enter your username:");
        username.setLocation(440, 100);
        username.setSize(150, 60);
        username.setForeground(Color.white);
        username.setFont(font);
        JLabel symbol = new JLabel();
        symbol.setText("ChooseYourSymbol:");
        symbol.setLocation(440, 150);
        symbol.setSize(150, 60);
        symbol.setForeground(Color.white);
        symbol.setFont(font);

        TextField enterusername = new TextField("");
        enterusername.setText("");
        enterusername.setLocation(600, 120);
        enterusername.setSize(100, 20);

        enterusername.setBackground(Color.BLACK);
        enterusername.setForeground(Color.white);

        //startgame.setOpaque(false);
        startgame.setLocation(470, 250);
        startgame.setSize(200, 40);
        startgame.setForeground(Color.WHITE);
        startgame.setBackground(Color.black);
        Border bored = BorderFactory.createRaisedSoftBevelBorder();

        /////
        JMenuBar mb = new JMenuBar();
        JMenu menu = new JMenu("Click me");

        JMenuItem i1 = new JMenuItem("X");

        JMenuItem i2 = new JMenuItem("O");
        i1.setForeground(Color.WHITE);
        i2.setForeground(Color.WHITE);
        i1.setBackground(Color.black);
        i2.setBackground(Color.black);

        menu.add(i1);
        menu.add(i2);

        mb.add(menu);
        mb.setLocation(600, 170);
        mb.setSize(100, 20);
        mb.setBackground(Color.black);
        mb.setForeground(Color.white);

        startgame.setBorder(bored);
        i1.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldActionPerformed(evt);
            }

            private void jTextFieldActionPerformed(ActionEvent evt) {
                menu.setText("X");
                player.playerSymbolChoose = "X";
                computer.computerSymbol = "0";

            }
        });
        i2.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldActionPerformed(evt);
            }

            private void jTextFieldActionPerformed(ActionEvent evt) {
                menu.setText("0");
                player.playerSymbolChoose = "0";
                computer.computerSymbol = "X";
            }
        });


        startgame.setText("start");

        panel.setLayout(null);
        panel.add(username);
        panel.add(symbol);
        panel.add(startgame);
        panel.add(Title);
        panel.add(enterusername);
        panel.add(mb);

        frame2.setSize(400, 400);
        frame2.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        panel2.setSize(400, 400);

        startgame.setFocusable(false);
        Color c = new Color(0, 0, 0, 65);

        startgame.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }

            private void jButton1ActionPerformed(ActionEvent evt) {

                player.playerName = enterusername.getText();

                if (player.playerName.length() <= 2) {
                    JOptionPane.showMessageDialog(null, "Please Enter username of least length 3");
                    return;

                } else if (!player.playerSymbolChoose.equals("X") && !player.playerSymbolChoose.equals("0")) {
                    JOptionPane.showMessageDialog(null, "Please choose your symbol first ");
                    return;
                }
                frame2.setTitle(player.playerName + " VS " + computer.computerName);






                for (int i = 0; i < 16; i++) {
                    jButton[i] = new JButton();
                    jButton[i].setText("-");


                    jButton[i].setFocusable(false);
                    jButton[i].setBackground(Color.white);
                    jButton[i].setForeground(Color.black);
                    //jButton[i].setOpaque(false);
                    jButton[i].addActionListener(new java.awt.event.ActionListener() {

                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton1ActionPerformed(evt);
                        }

                        private void jButton1ActionPerformed(ActionEvent evt) {
                            JButton buttonClicked = (JButton) evt.getSource();
                            //get the particular button that was clicked
                            if (buttonClicked.getText().equals("-")) {
                                buttonClicked.setText(player.playerSymbolChoose);
                                 if(player.playerSymbolChoose.equals("0"))
                                buttonClicked.setForeground(Color.darkGray);
                                 else{
                                     buttonClicked.setForeground(Color.red);
                                 }
                                player.checkForPlayerWin(jButton);

                                if (player.checkForDraw(jButton) == true) {
                                    JOptionPane.showMessageDialog(null, "Draw");
                                    frame2.setVisible(false);
                                     frame2.dispose();

                                }
                                turnExchange(frame2);
                            } else {
                                JOptionPane.showMessageDialog(null, "Warning!! cell is already fill");
                            }

                        }
                    });
                    panel2.add(jButton[i]);
                }
                //player condition f one is equal to x then attack
                  
                 panel2.setLayout(new GridLayout(4, 4));
                frame2.add(panel2);
                frame2.setSize((int) width - 200, (int) height - 200);
                frame2.setLocationRelativeTo(null);
                frame2.setVisible(true);
               
                JOptionPane.showMessageDialog(null,"computer taking his first turn");
                Random random = new Random();
                int rand = random.nextInt(15 - 0 + 1) + 0;
                     
                turnExchange(frame2);
                //first turn
               


                f.dispose();

            }
        });
        /**/






        f.add(panel);

        f.setSize((int) width - 200, (int) height - 200);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

    }
    void turnExchange(JFrame frame2) {
        
        int index=computer.Computerturn(jButton, player.playerSymbolChoose);
        jButton[index].setText(computer.computerSymbol);
        if(computer.computerSymbol.equals("0"))
           jButton[index].setForeground(Color.darkGray);
        else{
           jButton[index].setForeground(Color.red);
            }
        

        if (computer.checkforComputerWin(jButton) == true) {
            frame2.setVisible(false);
             frame2.dispose();
        }


    }
    public static void main(String args[]) {




        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ticandtoe t = new ticandtoe();
            }
        });

    }


}