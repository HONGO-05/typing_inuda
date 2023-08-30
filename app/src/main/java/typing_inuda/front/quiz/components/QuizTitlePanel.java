package typing_inuda.front.quiz.components;

import typing_inuda.front.quiz.QuizPanel;
import typing_inuda.front.screen_mode.QuizScreenMode;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class QuizTitlePanel extends JPanel {
    static String userName;
    static String passWord;
    static String logDate;

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public QuizTitlePanel() {
        this.setLayout(null);
    }

    public void prepareComponents() {
        JLabel userLabel = new JLabel("ユーザー名");
        userLabel.setBounds(50, 335, 130, 50);
        userLabel.setFont(new Font("ヒラギノ角ゴ ProN", Font.BOLD, 20));
        userLabel.setForeground(Color.DARK_GRAY);
        this.add(userLabel);

        JLabel passLabel = new JLabel("パスワード");
        passLabel.setBounds(360, 335, 130, 50);
        passLabel.setFont(new Font("ヒラギノ角ゴ ProN", Font.BOLD, 20));
        passLabel.setForeground(Color.DARK_GRAY);
        this.add(passLabel);

        JTextField userText = new JTextField();
        userText.setBounds(170, 335, 130, 50);
        userText.setFont(new Font("ヒラギノ角ゴ ProN", Font.BOLD, 20));
        this.add(userText);


        JTextField passText = new JTextField();
        passText.setBounds(480, 335, 130, 50);
        passText.setFont(new Font("ヒラギノ角ゴ ProN", Font.BOLD, 20));
        this.add(passText);

        JButton loginButton = new JButton("ログインして開始");
        loginButton.setBounds(270, 400, 200, 45);
        loginButton.addActionListener(
                e -> {
                    QuizPanel.getInstance(QuizScreenMode.QUIZ_GAME);
                    passWord = userText.getText();
                    userName = passText.getText();
                    LocalDateTime log = LocalDateTime.now();
                    logDate = log.format(fmt);
                }
        );
        this.add(loginButton);

        JButton noLoginButton = new JButton("ログインせずに開始");
        noLoginButton.setBounds(270, 450, 200, 45);
        noLoginButton.addActionListener(
                e -> {
                    QuizPanel.getInstance(QuizScreenMode.QUIZ_GAME);
                    userName= "non_name";
                    passWord = "non_pass";
                    LocalDateTime log = LocalDateTime.now();
                    logDate = log.format(fmt);
                });
        this.add(noLoginButton);

        ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + "/src/image/title_background.gif");
        JLabel backGroundLabel = new JLabel(icon);
        backGroundLabel.setBounds(0, 0, 720, 540);
        this.add(backGroundLabel);
    }

}
