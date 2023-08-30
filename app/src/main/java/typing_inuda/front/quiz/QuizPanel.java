package typing_inuda.front.quiz;

import front.quiz.components.QuizGamePanel;
import front.quiz.components.QuizResultPanel;
import front.quiz.components.QuizTitlePanel;
import typing_inuda.front.screen_mode.QuizScreenMode;

import javax.swing.*;
import java.awt.*;


public class QuizPanel extends JPanel {
    QuizScreenMode quizScreenMode;
    QuizTitlePanel quizTitlePanel;
    QuizResultPanel quizResultPanel;
    QuizGamePanel quizGamePanel;
    CardLayout layout = new CardLayout();

    private static QuizPanel quizPanel = new QuizPanel();

    private QuizPanel() {
        this.setLayout(layout);
        quizTitlePanel = new QuizTitlePanel();
        this.add(quizTitlePanel, "クイズタイトル");

        quizGamePanel = new QuizGamePanel();
        this.add(quizGamePanel, "クイズゲーム");

        quizResultPanel = new QuizResultPanel();
        this.add(quizResultPanel, "クイズリザルト");
    }

    public static QuizPanel getInstance() {
        return quizPanel;
    }

    public static QuizPanel getInstance(QuizScreenMode s) {
        quizPanel.setFrontScreenAndFocus(s);
        return quizPanel;
    }


    public void prepareComponents() {
        quizTitlePanel.prepareComponents();
    }

    public void setFrontScreenAndFocus(QuizScreenMode s) {
        quizScreenMode = s;
        switch (quizScreenMode) {
            case QUIZ_TITLE:
                layout.show(this, "クイズタイトル");
                quizTitlePanel.requestFocusInWindow();
                break;
            case QUIZ_RESULT:
                layout.show(this, "クイズリザルト");
                quizResultPanel.requestFocusInWindow();
                quizResultPanel.prepareComponents();
                break;
            case QUIZ_GAME:
                layout.show(this, "クイズゲーム");
                quizGamePanel.requestFocusInWindow();
                quizGamePanel.prepareComponents();
                break;
        }

    }
}
