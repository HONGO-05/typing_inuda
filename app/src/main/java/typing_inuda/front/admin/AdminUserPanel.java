package typing_inuda.front.admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class AdminUserPanel extends JPanel {
    static String userName;
    static Integer userID;

    static Integer ranking = 3;
    String[] column = {"ログ", "スコア"};

    public AdminUserPanel() {
        this.setLayout(null);

        this.prepareComponents();
    }

    public void prepareComponents() {
        JLabel titleLabel = new JLabel("ユーザー検索");
        titleLabel.setBounds(10, 5, 500, 50);
        titleLabel.setFont(new Font("游ゴシック体", Font.BOLD, 30));
        this.add(titleLabel);

        JLabel label = new JLabel("ユーザー名もしくはユーザーIDで検索。");
        label.setBounds(10, 100, 500, 20);
        ;
        label.setFont(new Font("游ゴシック体", Font.PLAIN, 15));
        this.add(label);

        JLabel userNameLabel = new JLabel("ユーザー名");
        userNameLabel.setBounds(10, 150, 130, 20);
        userNameLabel.setFont(new Font("游ゴシック体", Font.PLAIN, 20));
        this.add(userNameLabel);

        JLabel userIDLabel = new JLabel("ユーザーID");
        userIDLabel.setBounds(10, 200, 130, 20);
        userIDLabel.setFont(new Font("游ゴシック体", Font.PLAIN, 20));
        this.add(userIDLabel);

        JTextField userNameText = new JTextField(8);
        userNameText.setBounds(140, 140, 170, 50);
        userNameText.setFont(new Font("ヒラギノ角ゴ ProN", Font.PLAIN, 20));
        this.add(userNameText);

        JTextField userIDText = new JTextField(8);
        userIDText.setBounds(140, 190, 170, 50);
        userIDText.setFont(new Font("ヒラギノ角ゴ ProN", Font.BOLD, 20));
        this.add(userIDText);

        DefaultTableModel tableModel = new DefaultTableModel(null, column);
        JTable table = new JTable(tableModel);
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(350, 100, 350, 300);
        this.add(jScrollPane);

        JLabel rankingLabel = new JLabel("ランキング : ");
        rankingLabel.setBounds(10, 350, 150, 50);
        rankingLabel.setFont(new Font("游ゴシック体", Font.PLAIN, 20));
        this.add(rankingLabel);

        JLabel rankLabel = new JLabel();
        rankLabel.setBounds(160, 350, 100, 50);
        rankLabel.setFont(new Font("游ゴシック体", Font.PLAIN, 20));
        this.add(rankLabel);

        JButton searchButton = new JButton("検索");
        searchButton.setBounds(80, 250, 150, 50);
        searchButton.addActionListener(
                e -> {
                    tableModel.getDataVector().removeAllElements();
                    tableModel.fireTableDataChanged();
                    if (userNameText.getText().equals("")) {
                        userID = Integer.parseInt(userIDText.getText());
                        String[][] list = addList(userID);
                        for (String[] str : list) {
                            tableModel.addRow(str);
                        }
                    } else if (userIDText.getText().equals("")) {
                        userName = userNameText.getText();
                        String[][] list = addList(userName);
                        for (String[] str : list) {
                            tableModel.addRow(str);
                        }
                    }
                    rankLabel.setText(this.ranking + "位");
                }
        );
        this.add(searchButton);
    }

    public String[][] addList(String userName) {
        ArrayList<String[]> list = updateTable(userName);
        String[][] userLogLists = new String[list.size()][];

        int count = 0;
        for (String[] lists : list) {
            userLogLists[count] = lists;
            count++;
        }
        return userLogLists;
    }

    /**
     * コメント
     * @param userID 変数の説明
     * @return
     */
    public String[][] addList(int userID){
        // IDからユーザー検索する内容をかく


        ArrayList<String[]> list = updateTable(this.userName);
        String[][] userLogLists = new String[list.size()][];

        int count = 0;
        for (String[] lists : list) {
            userLogLists[count] = lists;
            count++;
        }
        return userLogLists;
    }

    public ArrayList<String[]> updateTable(String userName) {
        ArrayList<String[]> list = new ArrayList<>();
        String[] contains1 = {"test", "test"};
        String[] contains2 = {"test", "test"};
        String[] contains3 = {"test", "test"};
        String[] contains4 = {"test", "test"};
        String[] contains5 = {"test", "test"};
        String[] contains6 = {"test", "test"};
        list.add(contains1);
        list.add(contains2);
        list.add(contains3);
        list.add(contains4);
        list.add(contains5);
        list.add(contains6);
        return list;
    }
}
