package typing_inuda.front.quiz.components;

import javax.swing.*;
import java.awt.*;

public class QuizResultPanel extends JPanel {
    public QuizResultPanel() {
        this.setLayout(null);
    }
    public void prepareComponents() {
        JLabel textLabel = new JLabel("最終結果");
        textLabel.setBounds(250, 100, 500, 50);
        textLabel.setFont(new Font("凸版文久見出しゴシック", Font.BOLD, 50));
        textLabel.setForeground(Color.RED);
        this.add(textLabel);

        JLabel resisterLabel = new JLabel("ユーザー登録しますか？");
        resisterLabel.setBounds(50, 280, 400, 50);
        resisterLabel.setFont(new Font("ヒラギノ角ゴ ProN", Font.BOLD, 20));
        resisterLabel.setForeground(Color.DARK_GRAY);
        this.add(resisterLabel);

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

        JTextField userText = new JTextField(8);
        userText.setBounds(170, 335, 130, 50);
        userText.setFont(new Font("ヒラギノ角ゴ ProN", Font.BOLD, 20));
        this.add(userText);

        JTextField passText = new JTextField(8);
        passText.setBounds(480, 335, 130, 50);
        passText.setFont(new Font("ヒラギノ角ゴ ProN", Font.BOLD, 20));
        this.add(passText);

        JButton resisterButton = new JButton("ユーザー登録");
        resisterButton.setBounds(270, 400, 200, 45);
        resisterButton.addActionListener(
                e -> {
                    QuizTitlePanel.userName = userText.getText();
                    QuizTitlePanel.passWord = passText.getText();
                }
        );
        this.add(resisterButton);

        JLabel resultLabel = new JLabel(QuizGamePanel.result + "点");
        resultLabel.setBounds(250, 200, 500, 50);
        resultLabel.setFont(new Font("凸版文久見出しゴシック", Font.BOLD, 50));
        resultLabel.setForeground(Color.BLUE);
        this.add(resultLabel);

        ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + "/src/image/back_ground.png");
        JLabel backGroundLabel = new JLabel(icon);
        backGroundLabel.setBounds(0, 0, 720, 540);
        this.add(backGroundLabel);

        if (QuizTitlePanel.userName.equals("non_name")) {
            resisterLabel.setVisible(true);
            userLabel.setVisible(true);
            passLabel.setVisible(true);
            userText.setVisible(true);
            passText.setVisible(true);
            resisterButton.setVisible(true);
        } else {
            resisterLabel.setVisible(false);
            userLabel.setVisible(false);
            passLabel.setVisible(false);
            userText.setVisible(false);
            passText.setVisible(false);
            resisterButton.setVisible(false);
        }
    }
}
