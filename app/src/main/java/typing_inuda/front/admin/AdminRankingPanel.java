package typing_inuda.front.admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class AdminRankingPanel extends JPanel {
    String[] column = {"順位", "ID", "ユーザー名", "点数"};
    public AdminRankingPanel(){
        this.setLayout(null);
        this.prepareComponents();
    }

    public void prepareComponents(){
        JLabel titleLabel = new JLabel("ランキング");
        titleLabel.setBounds(10, 5, 500, 50);
        titleLabel.setFont(new Font("游ゴシック体", Font.BOLD, 30));
        this.add(titleLabel);

        DefaultTableModel tableModel = new DefaultTableModel(tableOperator(), column);
        JTable table = new JTable(tableModel);
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(60, 70, 600, 350);
        this.add(jScrollPane);

    }

    public String[][] tableOperator() {
        ArrayList<String[]> list = updateTable();
        String[][] questionList = new String[list.size()][];

        int count = 0;
        for (String[] lists : list) {
            questionList[count] = lists;
            count++;
        }
        return questionList;
    }

    public ArrayList<String[]> updateTable() {
        ArrayList<String[]> list = new ArrayList<>();
        String[] contains1 = {"test", "test","test", "test"};
        String[] contains2 = {"test", "test","test", "test"};
        String[] contains3 = {"test", "test","test", "test"};
        String[] contains4 = {"test", "test","test", "test"};
        String[] contains5 = {"test", "test","test", "test"};
        String[] contains6 = {"test", "test","test", "test"};
        list.add(contains1);
        list.add(contains2);
        list.add(contains3);
        list.add(contains4);
        list.add(contains5);
        list.add(contains6);
        return list;
    }
}
