package dao;

import domain.Question;
import util.MySpring;
import util.QuestionFileReader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class QuestionDao {

    //��ȡ�������
    private QuestionFileReader reader = MySpring.getBean("util.QuestionFileReader");
    //�������еļ�����ʱ��Ϊlist���� �����ѰԪ�ص�ʱ�����λ��
    private ArrayList<Question> questionBank = new ArrayList(reader.getQuestionBox());

    //������ļ� �������һ���Ծ�
    //���10����Ŀ
    //�����Ծ���5��
    //  �Ƿ���Ҫ����?----5��
    //  �Ƿ���Ҫ����ֵ?----ArrayList<Question>
    public ArrayList<Question> getPaper(int count){
        HashSet<Question> paper = new HashSet<>();//�����洢���յ��Ծ���Ŀ
        while(paper.size()!=count){
            Random r = new Random();//���������   0-9
            int index = r.nextInt(this.questionBank.size());//���������һ����Ŀ����λ��
            paper.add(this.questionBank.get(index));
        }
        return new ArrayList<Question>(paper);
    }

}
