package util;

import domain.Question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

public class QuestionFileReader {

    //����ִ��ʱ ���ļ��е�������Ŀ һ���Զ���ȡ����
    private HashSet<Question> questionBox = new HashSet<>();

    {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src//dbfile//Question.txt"));
            String message = reader.readLine();//ÿһ�ζ�ȡһ��  title#answer
            while(message!=null){
                String[] values = message.split("#");
                if(values.length==2){//û��ͼƬ��Ϣ ֻ����ɺʹ�
                    questionBox.add(new Question(values[0],values[1]));
                }else if(values.length==3){//����ͼƬ��Ϣ
                    questionBox.add(new Question(values[0],values[1],values[2]));
                }
                message = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HashSet<Question> getQuestionBox(){
        return questionBox;
    }


}
