package typing_inuda.front.admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class AdminEditorPanel extends JPanel {
    static String deleteQuestion;
    static String addQuestion;
    static String filePass;
    String[] column = {"ID", "テキスト"};
    public AdminEditorPanel(){
        this.setLayout(null);
        this.prepareComponents();
    }

    public void prepareComponents() {

        JLabel titleLabel = new JLabel("問題編集");
        titleLabel.setBounds(10, 5, 500, 50);
        titleLabel.setFont(new Font("游ゴシック体", Font.BOLD, 30));
        this.add(titleLabel);

        DefaultTableModel tableModel = new DefaultTableModel(null, column);
        JTable table = new JTable(tableModel);
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(350, 120, 350, 300);
        this.add(jScrollPane);

        JLabel label = new JLabel("テキストを入力し、操作を選択。");
        label.setBounds(10, 100, 500, 20);
        label.setFont(new Font("游ゴシック体", Font.PLAIN, 15));
        this.add(label);

        JTextField questionText = new JTextField();
        questionText.setBounds(10, 120, 330, 50);
        questionText.setFont(new Font("ヒラギノ角ゴ ProN", Font.BOLD, 20));
        this.add(questionText);

        ButtonGroup operationGroup = new ButtonGroup();

        JRadioButton addRadio = new JRadioButton("追加");
        addRadio.setBounds(80, 180, 70, 30);
        operationGroup.add(addRadio);
        this.add(addRadio);

        JRadioButton deleteRadio = new JRadioButton("削除");
        deleteRadio.setBounds(170, 180, 70, 30);
        operationGroup.add(deleteRadio);
        this.add(deleteRadio);

        JButton oKButton = new JButton("確定");
        oKButton.setBounds(80, 215, 150, 50);
        oKButton.addActionListener(
                e -> {
                    tableModel.getDataVector().removeAllElements();
                    tableModel.fireTableDataChanged();
                    if (!(questionText.getText().equals(""))){
                        if (addRadio.isSelected()){
                            addQuestion = questionText.getText();
                            String[][] list = addQuestionOperator(addQuestion);
                            for (String[] str : list) {
                                tableModel.addRow(str);
                            }
                        }else if (deleteRadio.isSelected()){
                            deleteQuestion = questionText.getText();
                            String[][] list = deleteQuestionOperator(deleteQuestion);
                            for (String[] str : list) {
                                tableModel.addRow(str);
                            }
                        }
                    }
                    questionText.setText("");
                    operationGroup.clearSelection();
                }
        );
        this.add(oKButton);

        JLabel csvLabel = new JLabel("csvでの一括登録は下記にファイルパスを入力。");
        csvLabel.setBounds(10, 300, 500, 20);
        csvLabel.setFont(new Font("游ゴシック体", Font.PLAIN, 15));
        this.add(csvLabel);

        JTextField csvPass = new JTextField();
        csvPass.setBounds(10, 330, 330, 50);
        csvPass.setFont(new Font("ヒラギノ角ゴ ProN", Font.BOLD, 20));
        this.add(csvPass);

        JButton csvButton = new JButton("確定");
        csvButton.setBounds(80, 385, 150, 50);
        csvButton.addActionListener(
                e -> {
                    filePass = csvPass.getText();
                }
        );
        this.add(csvButton);
    }

    public String[][] addQuestionOperator(String addQuestion) {
            ArrayList<String[]> list = updateTable();
            String[][] questionList = new String[list.size()][];

            int count = 0;
            for (String[] lists : list) {
                questionList[count] = lists;
                count++;
            }
            return questionList;
    }

    public String[][] deleteQuestionOperator(String deleteQuestion) {
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
