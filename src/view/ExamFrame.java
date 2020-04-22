package view;


import domain.Question;
import service.QuestionService;
import util.BaseFrame;
import util.MySpring;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ExamFrame extends BaseFrame {

    //��ȡQuestionService����
    private QuestionService service = MySpring.getBean("service.QuestionService");
    //ͨ��service����getPaper������ȡһ��������ɵ��Ծ�  �������ǿ����Լ�����
    private ArrayList<Question> paper = service.getPaper(10);
    //����һ�����ڴ洢ѧ��ѡ��Ĵ𰸵�����  String[] ������paperһ��
    private String[] answers = new String[paper.size()];

    //������������ �ֱ�����Ҳ�message����
    private int nowNum = 0;//��¼��ǰ��Ŀ���
    private int totalCount = paper.size();//��¼��������
    private int answerCount = 0;//��¼�Ѿ��ش���ϵ���Ŀ����
    private int unanswerCount = totalCount;//��¼��û�лش����Ŀ����

    //����һ���̶߳��� ����ʱ��仯
    private TimeControlThread timeControlThread = new TimeControlThread();
    //����һ������ ������¼ʱ�� (����Ϊ��λ)
    private int time = 61;

    //==============================================================================
    //��ӹ��췽��
    public ExamFrame(){
        this.init();
    }
    public ExamFrame(String title){
        super(title);
        this.init();
    }

    //�������panel ����ķָ�
    private JPanel mainPanel = new JPanel();//���������ҳ��չʾ
    private JPanel messagePanel = new JPanel();//�����Ҳ���Ϣչʾ
    private JPanel buttonPanel = new JPanel();//�����·���ť��չʾ
    //�����Ҫ��������
    private JTextArea examArea = new JTextArea();//�����ı��� չʾ��Ŀ
    private JScrollPane scrollPane = new JScrollPane(examArea);//������
    //����Ҳ���Ϣ�����
    private JLabel pictureLabel = new JLabel();//չʾͼƬ��Ϣ
    private JLabel nowNumLabel = new JLabel("��ǰ��ţ�");//��ʾ��ǰ�����
    private JLabel totalCountLabel = new JLabel("��Ŀ������");//��ʾ��Ŀ������
    private JLabel answerCountLabel = new JLabel("�Ѵ�������");//��ʾ�Ѿ��������Ŀ����
    private JLabel unanswerCountLabel = new JLabel("δ��������");//��ʾδ��������
    private JTextField nowNumField = new JTextField();//չʾ���
    private JTextField totalCountField = new JTextField();//չʾ����
    private JTextField answerCountField = new JTextField();//չʾ�Ѵ���
    private JTextField unanswerCountField = new JTextField();//չʾδ����
    private JLabel timeLabel = new JLabel("ʣ�����ʱ��");//��ʾʣ��ʱ��
    private JLabel realTimeLabel = new JLabel("00:00:00");//����ʱ��ʵʱ��
    //����·���ť�����
    private JButton aButton = new JButton("A");//a��ť
    private JButton bButton = new JButton("B");//b��ť
    private JButton cButton = new JButton("C");//c��ť
    private JButton dButton = new JButton("D");//d��ť
    private JButton prevButton = new JButton("��һ��");//previous��
    private JButton nextButton = new JButton("��һ��");//next��
    private JButton submitButton = new JButton("�ύ�Ծ�");//�ύ��ť

    @Override
    protected void setFontAndSoOn() {
        //����panel���ֹ���---->�Զ���
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.LIGHT_GRAY);
        //����message�����λ��
        messagePanel.setLayout(null);
        messagePanel.setBounds(680,10,300,550);
        messagePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        //����button�����λ��
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(16,470,650,90);
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        //�ֶ�����ÿһ�������λ�� ���� ����
        scrollPane.setBounds(16,10,650,450);
        examArea.setFont(new Font("����",Font.BOLD,34));
        examArea.setEnabled(false);//�ı����е����ֲ��ܱ༭
        //����message�����е�ÿһ�����λ�� ��С ��ɫ
        pictureLabel.setBounds(10,10,280,230);
        pictureLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        //pictureLabel.setIcon(null);//չʾͼƬ��Ϣ
        nowNumLabel.setBounds(40,270,100,30);
        nowNumLabel.setFont(new Font("����",Font.PLAIN,20));
        nowNumField.setBounds(150,270,100,30);
        nowNumField.setFont(new Font("����",Font.BOLD,20));
        nowNumField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        nowNumField.setEnabled(false);
        nowNumField.setHorizontalAlignment(JTextField.CENTER);

        totalCountLabel.setBounds(40,310,100,30);
        totalCountLabel.setFont(new Font("����",Font.PLAIN,20));
        totalCountField.setBounds(150,310,100,30);
        totalCountField.setFont(new Font("����",Font.BOLD,20));
        totalCountField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        totalCountField.setEnabled(false);
        totalCountField.setHorizontalAlignment(JTextField.CENTER);

        answerCountLabel.setBounds(40,350,100,30);
        answerCountLabel.setFont(new Font("����",Font.PLAIN,20));
        answerCountField.setBounds(150,350,100,30);
        answerCountField.setFont(new Font("����",Font.BOLD,20));
        answerCountField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        answerCountField.setEnabled(false);
        answerCountField.setHorizontalAlignment(JTextField.CENTER);

        unanswerCountLabel.setBounds(40,390,100,30);
        unanswerCountLabel.setFont(new Font("����",Font.PLAIN,20));
        unanswerCountField.setBounds(150,390,100,30);
        unanswerCountField.setFont(new Font("����",Font.BOLD,20));
        unanswerCountField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        unanswerCountField.setEnabled(false);
        unanswerCountField.setHorizontalAlignment(JTextField.CENTER);

        timeLabel.setBounds(90,460,150,30);
        timeLabel.setFont(new Font("����",Font.PLAIN,20));
        timeLabel.setForeground(Color.BLUE);
        realTimeLabel.setBounds(108,490,150,30);
        realTimeLabel.setFont(new Font("����",Font.BOLD,20));
        realTimeLabel.setForeground(Color.BLUE);

        aButton.setBounds(40,10,120,30);
        aButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bButton.setBounds(190,10,120,30);
        bButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cButton.setBounds(340,10,120,30);
        cButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        dButton.setBounds(490,10,120,30);
        dButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        prevButton.setBounds(40,50,100,30);
        prevButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        nextButton.setBounds(510,50,100,30);
        nextButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        submitButton.setBounds(276,50,100,30);
        submitButton.setForeground(Color.RED);
        submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //---------------------------------------------------
        //չʾ������Ŀ(��һ��)
        this.showQuestionAndPicture();
        //���������Ҳ�message�е����ֵ--�ñ�������
        nowNumField.setText(nowNum+1+"");
        totalCountField.setText(totalCount+"");
        answerCountField.setText(answerCount+"");
        unanswerCountField.setText(unanswerCount+"");

        realTimeLabel.setText(time+"");
        //---------------------------------------------------
    }

    @Override
    protected void addElement() {
        messagePanel.add(pictureLabel);
        messagePanel.add(nowNumLabel);
        messagePanel.add(nowNumField);
        messagePanel.add(totalCountLabel);
        messagePanel.add(totalCountField);
        messagePanel.add(answerCountLabel);
        messagePanel.add(answerCountField);
        messagePanel.add(unanswerCountLabel);
        messagePanel.add(unanswerCountField);
        messagePanel.add(timeLabel);
        messagePanel.add(realTimeLabel);
        buttonPanel.add(aButton);
        buttonPanel.add(bButton);
        buttonPanel.add(cButton);
        buttonPanel.add(dButton);
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(submitButton);
        mainPanel.add(scrollPane);
        mainPanel.add(messagePanel);
        mainPanel.add(buttonPanel);
        this.add(mainPanel);
    }

    @Override
    protected void addListener() {

        //����һ������������ �����ύ��ť
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //0.����һ��ȷ�Ͽ�  ��-0 ��-1 ȡ��-2
                int value = JOptionPane.showConfirmDialog(ExamFrame.this,"�Ƿ�ȷ���ύ�Ծ�?");
                if(value==0) {
                    //1.����ʱʱ��ֹͣ---�̴߳���
                    //timeControlThread.stop();//������
                    timeControlThread.stopTimeThread();//�л����̵߳�״̬
                    //2.���а�ťʧЧ
                    ExamFrame.this.setOptionButtonEnabled(false);//����ѡ�ťʧЧ
                    prevButton.setEnabled(false);
                    nextButton.setEnabled(false);
                    //3.�ð�ť��ɫ�ع鱾ɫ
                    ExamFrame.this.clearOptionButtonColor();
                    //4.���ճɼ��ļ��� չʾ���м���ı�����
                    float score = ExamFrame.this.checkPaper();
                    ExamFrame.this.setVisible(false);
                    new finallyGade("���ճɼ�",score);
                  //  examArea.setText("�����Ѿ�����\n�����յĳɼ�Ϊ:" + score);
                }
            }
        });

        //����һ������������ ������һ�ⰴť
        prevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //������а�ť����ɫ
                ExamFrame.this.clearOptionButtonColor();
                //��ԭ�ĸ�ѡ�ť��״̬ ��ɿ���
                ExamFrame.this.setOptionButtonEnabled(true);//����
                //������һ�ⰴť ��ɿ���
                nextButton.setEnabled(true);//����
                //��ǰ��Ŀ��ż���һ��
                nowNum--;
                //�����ǰ���Ϊ0 �Ѿ������һ�� ����һ�ⰴť����
                if(nowNum==0){
                    prevButton.setEnabled(false);//����
                }
                //��ԭ֮ǰ�����ѡ�������һ��ѡ��
                ExamFrame.this.restoreButton();
                //��ʾ��Ŀ
                ExamFrame.this.showQuestionAndPicture();
                //�޸��Ҳ���� �Ѵ��� δ����
                nowNumField.setText(nowNum+1+"");
                answerCountField.setText(--answerCount+"");
                unanswerCountField.setText(++unanswerCount+"");
            }
        });

        //����һ������������ ������һ�ⰴť
        nextButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                //���������ѡ�ť����ɫ
                ExamFrame.this.clearOptionButtonColor();
                //��ǰ��Ŀ�������һ��
                nowNum++;
                //��ǰ��Ŀ�Ƿ񵽴����
                if(nowNum==totalCount){//�������һ������
                    examArea.setText("ȫ����Ŀ�Ѿ��ش����\n�����·���ɫ�ύ��ť");
                    //ȫ����Ŀ���ش���� ����һ����Ŀ��ťʧЧ
                    nextButton.setEnabled(false);//������
                    //��ȫ��ѡ�ťʧЧ
                    ExamFrame.this.setOptionButtonEnabled(false);
                }else{//��û�е����һ�� ���滹����Ŀ
                    //�����Լ���װ�ķ�����ʾ��һ����Ŀ��ͼƬ
                    ExamFrame.this.showQuestionAndPicture();
                    //�޸��Ҳ�ĵ�ǰ���
                    nowNumField.setText(nowNum+1+"");
                }
                //�޸��Ҳ� �Ѵ����δ��������
                answerCountField.setText(++answerCount+"");
                unanswerCountField.setText(--unanswerCount+"");
            }
        });


        //����һ������������ �����ĸ�ѡ�ť
        ActionListener optionListener = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                //���֮ǰ����ѡ�ť����ɫ
                ExamFrame.this.clearOptionButtonColor();
                //��ȡ����һ����ť�����
                JButton button = (JButton) e.getSource();
                //�õ�ǰ�İ�ť��ɫ�仯һ��
                button.setBackground(Color.YELLOW);
                //����ǰ��ť��ѡ��洢��answers������
                answers[nowNum] = button.getText();
            }
        };
        //�������������������ĸ�ѡ�ť����
        aButton.addActionListener(optionListener);
        bButton.addActionListener(optionListener);
        cButton.addActionListener(optionListener);
        dButton.addActionListener(optionListener);
    }

    @Override
    protected void setFrameSelf() {
        this.setBounds(260,130,1000,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);//�����ô�����ק��С
        this.setVisible(true);//����չʾ��������
        timeControlThread.start();//�����Լ�������̶߳��� �������״̬ ʱ�䴦��
    }

    //=====================================================================================
    //���һ���ڲ��� ����ʱ�䵹��ʱ����
    private class TimeControlThread extends Thread{

        private boolean flag = true;//��ʱ����ִ���̴߳���
        public void stopTimeThread(){
            this.flag = false;
        }

        public void run(){
            //time����һ��ת��  Сʱ:����:��
            int hour = time/60;
            int minute = time%60;
            int second = 0;
            while(flag){
                //�� Сʱ ���� �� ���������ڴ洢�����ֽ���ƴ��������
                StringBuilder timeString = new StringBuilder();
                //����Сʱ
                if(hour>=0 && hour<10){
                    timeString.append("0");
                }
                timeString.append(hour);
                timeString.append(":");
                //�������
                if(minute>=0 && minute<10){
                    timeString.append("0");
                }
                timeString.append(minute);
                timeString.append(":");
                //������
                if(second>=0 && second<10){
                    timeString.append("0");
                }
                timeString.append(second);
                //չʾһ��ƴ���Ժ��ʱ���ַ���
                //SwingUtilities.invokeLater(new Runnable(){
                //      public void run(){
                //          realTimeLabel.setText(timeString.toString());
                //      }
                //});
                realTimeLabel.setText(timeString.toString());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //�ı�
                if(second>0){//����������
                    second--;
                }else{//�����Ѿ�Ϊ0
                    if(minute>0){//���ӻ�����
                        minute--;
                        second=59;
                    }else{//����Ϊ0
                        if(hour>0){//Сʱ������
                            hour--;
                            minute=59;
                            second=59;
                        }else{
                            System.out.println("ʱ���ֹ");
                            //ʱ����ʾΪ��ɫ
                            realTimeLabel.setForeground(Color.RED);
                            ExamFrame.this.setOptionButtonEnabled(false);//�Լ�д�ķ������а�ťʧЧ
                            prevButton.setEnabled(false);
                            nextButton.setEnabled(false);
                            //����һ����Ϣ�� ���߿��Խ��� ���ύ
                            JOptionPane.showMessageDialog(ExamFrame.this,"���Խ���,���ύ�Ծ�");
                            break;
                        }
                    }
                }
            }
        }
    }

    //���һ������ ����������յĳɼ�
    private float checkPaper(){
        float score = 100;
        int size = paper.size();
        for(int i=0;i<size;i++){//paper��һ��ArrayList<Question>  title answer picture
            Question question = paper.get(i);
            String realAnswer = question.getAnswer();
            if(!realAnswer.equals(answers[i])){
                score-=(100/size);
            }
        }
        return score;
    }

    //���һ������ ����ԭ��һ���ѡ��
    private void restoreButton(){
        //��ȡ��ǰ��Ŀ�Ĵ�(ѧ��ѡ����Ǹ�)
        String answer = answers[nowNum];
        if(answer==null){
            return ;
        }
        switch(answer){
            case "A":
                aButton.setBackground(Color.YELLOW);
                break;
            case "B":
                bButton.setBackground(Color.YELLOW);
                break;
            case "C":
                cButton.setBackground(Color.YELLOW);
                break;
            case "D":
                dButton.setBackground(Color.YELLOW);
                break;
            default:
                this.clearOptionButtonColor();
                break;
        }
    }
    //���һ������ ������ѡ�ťʧЧ
    private void setOptionButtonEnabled(boolean key){
        aButton.setEnabled(key);
        bButton.setEnabled(key);
        cButton.setEnabled(key);
        dButton.setEnabled(key);
    }
    //���һ������ ������е�ѡ�ť��ɫ
    private void clearOptionButtonColor(){
        aButton.setBackground(null);
        bButton.setBackground(null);
        cButton.setBackground(null);
        dButton.setBackground(null);
    }
    //���һ������ ��������ͼƬչʾ
    private ImageIcon drawImage(String path){
        //ͨ��������·������һ��icon����
        ImageIcon imageIcon = new ImageIcon(path);
        //����imageIcon�����ڵ�image����
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(280,230,Image.SCALE_DEFAULT));
        //�����úõ�imageIcon���󷵻�
        return imageIcon;
    }
    //���һ������ ����չʾһ����Ŀ
    private void showQuestionAndPicture(){
        //��paper�л�ȡ��ǰ��һ����Ŀ
        Question question = paper.get(nowNum);//�������� ��� �� ͼƬ·��(�п�����null)
        //��ȡ��ǰqustion�е�ͼƬ·��
        String picture = question.getPicture();//ͼƬ·��
        if(picture!=null){//��ͼƬ·����Ϣ
            pictureLabel.setIcon(this.drawImage("src//img//"+picture));
        }else{//û��ͼƬ��Ϣ
            pictureLabel.setIcon(null);
        }
        //����һ����Ŀ�еı�� <br>��ʾ����
        examArea.setText((nowNum+1)+"."+question.getTitle().replace("<br>","\n   "));
    }

}
