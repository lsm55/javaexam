package service;

import dao.QuestionDao;
import domain.Question;
import util.MySpring;

import java.util.ArrayList;

public class QuestionService {

    //��Service������Ҫһ���ײ�dao��֧��
    private QuestionDao dao = MySpring.getBean("dao.QuestionDao");

    //���һ��������ȡ����������Ծ�---����
    public ArrayList<Question> getPaper(int count){
        return dao.getPaper(count);
    }
}
