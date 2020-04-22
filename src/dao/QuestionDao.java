package dao;

import domain.Question;
import util.MySpring;
import util.QuestionFileReader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class QuestionDao {

    //获取缓存对象
    private QuestionFileReader reader = MySpring.getBean("util.QuestionFileReader");
    //将缓存中的集合临时改为list集合 随机找寻元素的时候存在位置
    private ArrayList<Question> questionBank = new ArrayList(reader.getQuestionBox());

    //负责读文件 随机生成一套试卷
    //题库10道题目
    //生成试卷是5道
    //  是否需要参数?----5道
    //  是否需要返回值?----ArrayList<Question>
    public ArrayList<Question> getPaper(int count){
        HashSet<Question> paper = new HashSet<>();//用来存储最终的试卷题目
        while(paper.size()!=count){
            Random r = new Random();//随机数对象   0-9
            int index = r.nextInt(this.questionBank.size());//随机产生的一个题目索引位置
            paper.add(this.questionBank.get(index));
        }
        return new ArrayList<Question>(paper);
    }

}
