package service;

import dao.QuestionDao;
import domain.Question;
import util.MySpring;

import java.util.ArrayList;

public class QuestionService {

    //在Service层里需要一个底层dao的支持
    private QuestionDao dao = MySpring.getBean("dao.QuestionDao");

    //设计一个方法获取随机产生的试卷---参数
    public ArrayList<Question> getPaper(int count){
        return dao.getPaper(count);
    }
}
