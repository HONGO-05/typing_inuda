package typing_inuda.front.quiz.components;

import typing_inuda.front.quiz.QuizPanel;
import typing_inuda.front.screen_mode.QuizScreenMode;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuizGamePanel extends JPanel {
    ArrayList<String> answer = new ArrayList<>();
    ArrayList<String> question = questionList();
    static int result = 0;
    static int count = 0;
    private Timer timer = null;
    JLabel trueLabel;
    JLabel falseLabel;

    public QuizGamePanel() {
        this.setLayout(null);
    }

    public void prepareComponents() {
        JTextField answerText = new JTextField();

        JLabel questionLabel = new JLabel();

        JButton button = new JButton("スタート");

        ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + "/src/image/game_background.gif");
        JLabel backGroundLabel = new JLabel(icon);
        backGroundLabel.setBounds(0, 0, 720, 540);

        ImageIcon iconTrue = new ImageIcon(System.getProperty("user.dir") + "/src/image/true_image.png");
        trueLabel = new JLabel(iconTrue);
        trueLabel.setBounds(0, 0, 720, 540);
        trueLabel.setVisible(false);

        ImageIcon iconFalse = new ImageIcon(System.getProperty("user.dir") + "/src/image/false_image.png");
        falseLabel = new JLabel(iconFalse);
        falseLabel.setBounds(0, 0, 720, 540);
        falseLabel.setVisible(false);

        button.setBounds(150, 170, 410, 200);
        button.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 20));
        button.setForeground(Color.red);
        button.setBackground(Color.BLUE);
        button.addActionListener(
                e -> {
                    timer.start();
                    button.setVisible(false);
                }
        );

        Timer showResult = new Timer(300, new AddTimer());
        timer = new Timer(5000, e -> {
            if (count == 9) {
                falseLabel.setVisible(true);
                showResult.start();
                QuizPanel.getInstance(QuizScreenMode.QUIZ_RESULT);
            } else {
                answer.add(answerText.getText());
                answerText.setText("");
                count++;
                questionLabel.setText(question.get(count));
                falseLabel.setVisible(true);
                showResult.start();
                repaint();
            }
        }
        );

        answerText.setBounds(160, 300, 400, 70);
        answerText.setFont(new Font("ヒラギノ角ゴ ProN", Font.BOLD, 20));
        answerText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (count == 9) {
                    answer.add(answerText.getText());
                    if (answer.get(count).equals(question.get(count))) {
                        trueLabel.setVisible(true);
                        showResult.start();
                        result++;
                    } else {
                        falseLabel.setVisible(true);
                        showResult.start();
                    }
                    QuizPanel.getInstance(QuizScreenMode.QUIZ_RESULT);
                } else {
                    answer.add(answerText.getText());
                    if (answer.get(count).equals(question.get(count))) {
                        trueLabel.setVisible(true);
                        showResult.start();
                        result++;
                    } else {
                        falseLabel.setVisible(true);
                        showResult.start();
                    }
                    answerText.setText("");
                    count++;
                    questionLabel.setText(question.get(count));
                    repaint();
                    timer.stop();
                    timer.start();
                }

            }
        });

        questionLabel.setBounds(160, 200, 400, 70);
        questionLabel.setFont(new Font("昔々ふぉんと", Font.BOLD, 20));
        questionLabel.setText(question.get(count));

        this.add(button);
        this.add(trueLabel);
        this.add(falseLabel);
        this.add(answerText);
        this.add(questionLabel);
        this.add(backGroundLabel);
    }

    public ArrayList<String> questionList() {
        ArrayList<String> questions = new ArrayList<>();
        questions.add("サモエド");
        questions.add("ボルゾイ");
        questions.add("柴犬");
        questions.add("ジャックラッセルテリア");
        questions.add("ポメラニアン");
        questions.add("秋田犬");
        questions.add("チワワ");
        questions.add("パグ");
        questions.add("パピヨン");
        questions.add("ハスキー");
        return questions;
    }


    public class AddTimer implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            trueLabel.setVisible(false);
            falseLabel.setVisible(false);
        }
    }
}
