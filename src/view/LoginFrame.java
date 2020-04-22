package view;

import service.UserService;
import util.BaseFrame;
import util.MySpring;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("all")
public class LoginFrame extends BaseFrame {

    public LoginFrame(){
        this.init();
    }
    public LoginFrame(String title){
        super(title);
        this.init();
    }
    //����һ�����
    private JPanel mainPanel = new JPanel();
    //����title��ʾ����
    private JLabel titleLabel = new JLabel("�� �� �� �� ϵ ͳ");
    //�����˺ź�����ı���
    private JLabel accountLabel = new JLabel("�� ����");
    private JLabel passwordLabel = new JLabel("�� �룺");
    //���������˺ź�������ı���/�����
    private JTextField accountField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    //����������ť
    private JButton loginButton = new JButton("�� ¼");
    private JButton exitButton = new JButton("�� ��");

    //����ÿһ�������λ�� ��С ���� ���ֵȵ�
    protected void setFontAndSoOn(){
        //���������λ��----���ֹ���
        // �߽�ʽBorderLayout(JFrame) ��ʽFlowLayout(JPanel)
        // ����ʽGridLayout �Զ���(null)
        //����panel�Ĳ��ֹ���Ϊ�Զ��巽ʽ
        mainPanel.setLayout(null);
        //mainPanel.setBackground(Color.WHITE);
        //���ñ��������λ�ú������С
        titleLabel.setBounds(120,40,340,35);
        titleLabel.setFont(new Font("����",Font.BOLD,34));
        //�����û���labelλ�ú������С
        accountLabel.setBounds(94,124,90,30);
        accountLabel.setFont(new Font("����",Font.BOLD,24));
        //�����û���filedλ�ú������С
        accountField.setBounds(204,124,260,30);
        accountField.setFont(new Font("����",Font.BOLD,24));
        //��������labelλ�ú������С
        passwordLabel.setBounds(94,174,90,30);
        passwordLabel.setFont(new Font("����",Font.BOLD,24));
        //��������fieldλ�ú������С
        passwordField.setBounds(204,174,260,30);
        passwordField.setFont(new Font("����",Font.BOLD,24));
        //���õ�¼��ť��λ�ú����ִ�С
        loginButton.setBounds(154,232,100,30);
        loginButton.setFont(new Font("����",Font.BOLD,22));
        //�����˳���ť��λ�ú����ִ�С
        exitButton.setBounds(304,232,100,30);
        exitButton.setFont(new Font("����",Font.BOLD,22));
    }

    //�����е��������ڴ�����
    protected void addElement(){
        //�����е���������������
        mainPanel.add(titleLabel);
        mainPanel.add(accountLabel);
        mainPanel.add(accountField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(loginButton);
        mainPanel.add(exitButton);
        this.add(mainPanel);
    }

    //���¼�����
    protected void addListener(){
        //���¼�������
        //  ���췽��˽�е�  ���췽�����еĵ���û���޲�����  �������ӿ�
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //1.��ȡ�û�������˺ź�����
                //  �ӵ�¼�����ϵ�����ڻ�ȡ   �ı���  �����
                String account = accountField.getText();
                String password = new String(passwordField.getPassword());
                //2.����֮ǰService��ĵ�¼����
                UserService service = MySpring.getBean("service.UserService");
                String result = service.login(account,password);
                //3.�ж����յĽ��
                if(result.equals("��¼�ɹ�")){
                    LoginFrame.this.setVisible(false);//����¼��������
                    //�����µĿ��Խ���
                    new ExamFrame(account+"�Ŀ���ҳ��");
                }else{
                    //����һ������� ���ߵ�¼ʧ����
                    JOptionPane.showMessageDialog(LoginFrame.this,result);
                    //�����ı����������ֵΪ��
                    accountField.setText("");
                    passwordField.setText("");
                }
            }
        };
        loginButton.addActionListener(listener);//�۲���ģʽ
    }

    protected void setFrameSelf(){
        //���ô�����ʼλ�úʹ�С
        this.setBounds(600,280,560,340);
        //���õ���ر��˳�����
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //���ô����С������ק
        this.setResizable(false);
        //���ô�����ʾ״̬
        this.setVisible(true);
    }

}
