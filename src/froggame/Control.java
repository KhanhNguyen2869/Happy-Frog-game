/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Long 05
package froggame;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.accessibility.AccessibleRelation;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Kero
 */
public class Control {

    private GuiGame f;
    private JButton btn1 = new JButton();
    private JButton btn2 = new JButton();
    private JButton btn3 = new JButton();
    private JButton btn4 = new JButton();
    private JButton btn5 = new JButton();
    private JButton btn6 = new JButton();
    private JButton btn7 = new JButton();
    private JButton btn8 = new JButton();
    private JButton btn9 = new JButton();
    private JButton btn10 = new JButton();
//    private JButton btn11 = new JButton();
//    private JButton btn12 = new JButton();
    private JButton btnf = new JButton();
    private Timer timer;
    private int point = 0;
    private KeyBoard key = new KeyBoard();

    public Control(GuiGame f) {
        this.f = f;
        f.btnPause.addKeyListener(key);
        f.btnSave.addKeyListener(key);
        try {
            
            BufferedImage img = ImageIO.read(getClass().getResource("frog.jpg"));
            ImageIcon icon = new ImageIcon(img.getScaledInstance(50, 50, img.SCALE_SMOOTH));
          
            btnf.setIcon(icon);
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        
    }
    int x1 = 450;
    int x2 = 850;
    int x3 = 1250;
    int x4 = 1650;
    int x5 = 2000;
//    int x6 = 2350;
    int h1 = 380;
    int h2 = 300;
    int h3 = 300;
    int h4 = 380;
    int h5 = 300;
    int h6 = 380;
    int h7 = 380;
    int h8 = 300;
    int h9 = 380;
    int h10 = 300;
//    int h11 = 300;
//    int h12 = 380;
    int yf = 80;

    public void addButton() {
        btn1.setBounds(x1, 0, 80, h1);
        btn2.setBounds(x2, 0, 80, h2);
        btn3.setBounds(x1, f.Flayout.getHeight() - h3, 80, h3);
        btn4.setBounds(x2, f.Flayout.getHeight() - h4, 80, h4);
        btn5.setBounds(x3, 0, 80, h5);
        btn6.setBounds(x3, f.Flayout.getHeight() - h7, 80, h7);
        btn7.setBounds(x4, 0, 80, h6);
        btn8.setBounds(x4, f.Flayout.getHeight() - h8, 80, h8);
        btn9.setBounds(x5, 0, 80, h9);
        btn10.setBounds(x5, f.Flayout.getHeight() - h10, 80, h10);
//        btn11.setBounds(x6, 0, 80, h11);
//        btn12.setBounds(x6, f.Flayout.getHeight() - h12, 80, h12);
        btnf.setBounds(80, yf, 50, 50);
        f.Flayout.add(btn1);
        f.Flayout.add(btn2);
        f.Flayout.add(btn3);
        f.Flayout.add(btn4);
        f.Flayout.add(btn5);
        f.Flayout.add(btn6);
        f.Flayout.add(btn7);
        f.Flayout.add(btn8);
        f.Flayout.add(btn9);
        f.Flayout.add(btn10);
//        f.Flayout.add(btn11);
//        f.Flayout.add(btn12);
        f.Flayout.add(btnf);
    }

    public boolean checkIntersect() {
        if (btnf.getY() <= 0 || btnf.getY() >= f.Flayout.getHeight() - 50) { //tọa độ y của frog <=0, trên khi >=chiều cao layout
            return true;
        }
        //chuyển tất cả button thành hcn để dùng inter
        Rectangle recf = new Rectangle(80, yf, 50, 50);
        Rectangle rec1 = new Rectangle(x1, 0, 80, h1);
        Rectangle rec2 = new Rectangle(x2, 0, 80, h2);
        Rectangle rec3 = new Rectangle(x1, f.Flayout.getHeight() - h3, 80, h3);
        Rectangle rec4 = new Rectangle(x2, f.Flayout.getHeight() - h4, 80, h4);
        Rectangle rec5 = new Rectangle(x3, 0, 80, h5);
        Rectangle rec6 = new Rectangle(x3, f.Flayout.getHeight() - h7, 80, h7);
        Rectangle rec7 = new Rectangle(x4, 0, 80, h6);
        Rectangle rec8 = new Rectangle(x4, f.Flayout.getHeight() - h8, 80, h8);
        Rectangle rec9 = new Rectangle(x5, 0, 80, h9);
        Rectangle rec10 = new Rectangle(x5, f.Flayout.getHeight() - h10, 80, h10);
//        Rectangle rec11 = new Rectangle(x6, 0, 80, h11);
//        Rectangle rec12 = new Rectangle(x6, f.Flayout.getHeight() - h12, 80, h12);
        if (recf.intersects(rec1) || recf.intersects(rec2) || recf.intersects(rec3) || recf.intersects(rec4) || recf.intersects(rec5)
                || recf.intersects(rec6) || recf.intersects(rec7) || recf.intersects(rec8) || recf.intersects(rec9) || recf.intersects(rec10)) {
            return true;
        }
        return false;
    }

    public void getPoints() {
        if (btn1.getX() == btnf.getX() || btn2.getX() == btnf.getX() || btn5.getX() == btnf.getX() || btn7.getX() == btnf.getX() || btn9.getX() == btnf.getX()) {
            point++;
            f.jLabel1.setText("Point: " + point);
        }
    }
    //check btn pauseF
    //nếu stop thì lần click sau  chạy lại
    boolean checkPause = false;

    public void Pause() {
        if (checkPause == false) {
            timer.stop();
            checkPause = true;

        } else {
            timer.restart();
            checkPause = false;
        }
    }

    boolean checkSave = false;
    int yf11, x11, h11, x22, x33, x44, x55, x66, h22, h33, h44, h55, h66, h77, h88, h99, h101, point1;//dùng để gán gt hiện tại vào để có thể tiếp tục

    public void Save() {
        checkSave = true;
        yf11 = yf;
        x11 = x1;
        x22 = x2;
        x33 = x3;
        x44 = x4;
        x55 = x5;
//        x66 = x6;
        h11 = h1;
        h22 = h2;
        h33 = h3;
        h44 = h4;
        h55 = h5;
        h66 = h6;
        h77 = h7;
        h88 = h8;
        h99 = h9;
        h101 = h10;
//        h11 = h1111;
//        h12 = h121;

        point1 = point;
    }

    public void checkStop() {
        if (checkIntersect() == true) {
            timer.stop();
        }

        if (checkSave == false) {
            Object mes[] = {"New Game", "Exit"};

            int option = JOptionPane.showOptionDialog(f, "Do you want to contiune?\n" + "Your point: " + point,
                    "Notice!",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, mes, mes[0]);
            if (option == 0) {
                x1 = 450;
                x2 = 850;
                x3 = 1250;
                x4 = 1650;
                x5 = 2000;
//                x6 = 2350;
                h1 = 380;
                h2 = 300;
                h3 = 300;
                h4 = 380;
                h5 = 300;
                h6 = 380;
                h7 = 380;
                h8 = 300;
                h9 = 380;
                h10 = 300;
//                h11 = 300;
//                h12 = 380;
                yf = 80;
                point = 0;
                f.jLabel1.setText("Point: " + 0);
                timer.restart();
            }
            if (option == 1) {
                System.exit(0);
            }

        } else {
            Object mes[] = {"New Game", "Countinute", "Exit"};
            int option = JOptionPane.showOptionDialog(f, "Do you want to contiune?",
                    "Notice!",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, mes, mes[0]);
            if (option == 0) {
                x1 = 450;
                x2 = 850;
                x3 = 1250;
                x4 = 1650;
                x5 = 2000;
//                x6 = 2350;
                h1 = 380;
                h2 = 300;
                h3 = 300;
                h4 = 380;
                h5 = 300;
                h6 = 380;
                h7 = 380;
                h8 = 300;
                h9 = 380;
                h10 = 300;
//                h11 = 300;
//                h12 = 380;
                yf = 80;
                point = 0;
                f.jLabel1.setText("Point: " + 0);
                timer.restart();
            }
            if (option == 1) {
                yf = yf11;
                x1 = x11;
                x2 = x22;
                x3 = x33;
                x4 = x44;
                x5 = x55;
                h1 = h11;
                h2 = h22;
                h3 = h33;
                h4 = h44;
                h5 = h55;
                h6 = h66;
                h7 = h77;
                h8 = h88;
                h9 = h99;
                h10 = h101;
//                h11 = h1111;
//                h12 = h121;
                point = point1;
                f.jLabel1.setText(point + "");
                timer.start();
            }
            if (option == 2) {
                System.exit(0);
            }
        }
    }

    public void run() {
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (key.isPress() == true) {
                    yf = yf - 50;
                    key.setPress(false);
                }
                addButton();
                x1--;
                x2--;
                x3--;
                x4--;
                x5--;
//                x6--;
                yf++;
                if (x1 == -80) {
                    x1 = f.Flayout.getWidth();
                    Random r = new Random();
                    h1 = r.nextInt(100) + 250;
                    h3 = r.nextInt(100) + 280;
                }
                if (x2 == -80) {
                    x2 = f.Flayout.getWidth();
                    Random r = new Random();
                    h2 = r.nextInt(100) + 250;
                    h4 = r.nextInt(100) + 280;
                }
                if (x3 == -80) {
                    x3 = f.Flayout.getWidth();
                    Random r = new Random();
                    h5 = r.nextInt(100) + 250;
                    h7 = r.nextInt(100) + 280;
                }
                if (x4 == -80) {
                    x4 = f.Flayout.getWidth();
                    Random r = new Random();
                    h6 = r.nextInt(100) + 250;
                    h8 = r.nextInt(100) + 280;
                }
                if (x5 == -80) {
                    x5 = f.Flayout.getWidth();
                    Random r = new Random();
                    h9 = r.nextInt(100) + 250;
                    h10 = r.nextInt(100) + 280;
                }
//                if (x6 == -90) {
//                    x6 = f.Flayout.getWidth();
//                    Random r = new Random();
//                    h11 = r.nextInt(100) + 250;
//                    h12 = r.nextInt(100) + 250;
//                }

                if (checkIntersect() == true) {
                    timer.stop();
                    checkStop();
                }
                getPoints();
            }
        });
        timer.start();
    }

}
