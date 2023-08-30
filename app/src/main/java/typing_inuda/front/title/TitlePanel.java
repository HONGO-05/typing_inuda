package typing_inuda.front.title;

import typing_inuda.front.screen_mode.ScreenMode;
import typing_inuda.front.window.MainWindow;

import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel {
    public TitlePanel() {
        this.setLayout(null);
        this.setBackground(Color.WHITE);

    }

    public void prepareComponents() {
        JButton quizButton = new JButton("GAME");
        quizButton.setBounds(150, 240, 200, 50);
        quizButton.addActionListener(
                e -> {
                    MainWindow.getInstance(ScreenMode.QUIZ);
                }
        );
        this.add(quizButton);

        JButton adminButton = new JButton("ADMIN");
        adminButton.setBounds(350, 240, 200, 50);
        adminButton.addActionListener(
                e -> {
                    MainWindow.getInstance(ScreenMode.ADMIN);
                }
        );
        this.add(adminButton);

    }
}
