package typing_inuda.front.admin;

import javax.swing.*;
import java.awt.*;

public class AdminPanel extends JPanel {

    public AdminPanel() {
        this.setLayout(new BorderLayout());
    }

    public void prepareComponents() {
        JPanel switchWindow = new JPanel();
        switchWindow.setPreferredSize(new Dimension(720, 400));
        CardLayout cardLayout = new CardLayout();
        switchWindow.setLayout(cardLayout);

        JPanel test = new JPanel();
        JLabel label = new JLabel("下のボタンからメニューを選択");
        label.setFont(new Font("游ゴシック体", Font.PLAIN, 30));
        label.setBounds(150, 200, 500, 50);
        test.add(label);
        test.setLayout(null);
        test.setBackground(Color.WHITE);
        switchWindow.add(test);

        AdminUserPanel userPanel = new AdminUserPanel();
        switchWindow.add(userPanel, "ユーザーパネル");

        AdminEditorPanel editorPanel = new AdminEditorPanel();
        switchWindow.add(editorPanel, "エディターパネル");

        AdminRankingPanel rankingPanel = new AdminRankingPanel();
        switchWindow.add(rankingPanel, "ランキングパネル");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.GRAY);
        buttonPanel.setPreferredSize(new Dimension(720, 50));

        Button userButton = new Button("ユーザー検索");
        userButton.setBounds(0, 0, 100, 100);
        userButton.addActionListener(e -> {
            cardLayout.show(switchWindow, "ユーザーパネル");
            userPanel.requestFocusInWindow();
        });

        JButton rankingButton = new JButton("ランキング");
        rankingButton.setBounds(100, 0, 100, 100);
        rankingButton.addActionListener(e -> {
            cardLayout.show(switchWindow, "ランキングパネル");
            rankingPanel.requestFocusInWindow();
        });

        JButton editorButton = new JButton("問題編集");
        editorButton.setBounds(200, 0, 100, 100);
        editorButton.addActionListener(e -> {
            cardLayout.show(switchWindow, "エディターパネル");
            editorPanel.requestFocusInWindow();
        });

        buttonPanel.add(userButton);
        buttonPanel.add(rankingButton);
        buttonPanel.add(editorButton);


        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(switchWindow, BorderLayout.CENTER);


    }
}