package view;
import util.BaseFrame;
import javax.swing.*;
import java.awt.*;
public class finallyGade extends BaseFrame {
    private float grade;
    //����һ�����
    private JPanel mainPanel = new JPanel();
    //����title��ʾ����

    private JTextArea field = new JTextArea();
    public finallyGade(String title,float grade){
        super(title);
        this.grade = grade;
        this.init();
    }
    @Override
    protected void setFontAndSoOn() {
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.LIGHT_GRAY);
        field.append("������ճɼ�Ϊ"+grade);
        field.setBounds(100,134,500,200);
        field.setFont(new Font("����",Font.BOLD,50));
    }
    @Override
    protected void addElement() {
        mainPanel.add(field);
        this.add(mainPanel);
    }

    @Override
    protected void addListener() {

    }

    @Override
    protected void setFrameSelf() {
        this.setBounds(260,130,1000,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

    }
}
