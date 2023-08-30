package typing_inuda.front.window;

import front.admin.AdminPanel;
import front.quiz.QuizPanel;

import typing_inuda.front.screen_mode.QuizScreenMode;
import typing_inuda.front.screen_mode.ScreenMode;
import front.title.TitlePanel;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    ScreenMode screenMode = ScreenMode.QUIZ;
    QuizScreenMode quizScreenMode = QuizScreenMode.QUIZ_TITLE;
    final int WIDTH = 720;
    final int HEIGHT = 540;
    CardLayout layout = new CardLayout();
    QuizPanel quizPanel;
    AdminPanel adminPanel;
    TitlePanel titlePanel;
    private static MainWindow mainWindow = new MainWindow();


    private MainWindow() {
        this.setTitle("犬だ");
//        Image icon = new ImageIcon(getClass().getClassLoader().getResource("nikukyu_shirocha.png");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(layout);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public static MainWindow getInstance(ScreenMode s) {
        mainWindow.preparePanels();
        mainWindow.prepareComponents();
        mainWindow.setFrontScreenAndFocus(s);
        mainWindow.setVisible(true);
        return mainWindow;
    }

    public void preparePanels() {
        adminPanel = new AdminPanel();
        this.add(adminPanel, "管理画面");
        titlePanel = new TitlePanel();
        this.add(titlePanel, "タイトル");
        quizPanel = QuizPanel.getInstance();
        this.add(quizPanel, "タイピングゲーム");
        this.pack();
    }

    public void prepareComponents() {
        adminPanel.prepareComponents();
        titlePanel.prepareComponents();
        quizPanel.prepareComponents();
    }

    public void setFrontScreenAndFocus(ScreenMode s) {
        screenMode = s;
        switch (screenMode) {
            case TITLE:
                layout.show(this.getContentPane(), "タイトル");
                titlePanel.requestFocus();
                break;
            case QUIZ:
                layout.show(this.getContentPane(), "タイピングゲーム");
                quizPanel.requestFocus();
                break;
            case ADMIN:
                layout.show(this.getContentPane(), "管理画面");
                adminPanel.requestFocus();
                break;
        }

    }
}


