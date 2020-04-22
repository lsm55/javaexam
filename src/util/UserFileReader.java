package util;

import domain.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

//���Ŀ����Ϊ������һ���������
//����������ʱ��User.txt�ļ��е�������Ϣ һ���Զ�����
//�Ժ�����ѯֱ�Ӷ�ȡ�����е�����  ��߶�ȡ������
public class UserFileReader {

    //����һ������--->�䵱һ������
    private static HashMap<String,User> userBox = new HashMap<>();
    public static User getUser(String account){
        return userBox.get(account);
    }

    //�ڵ�ǰ����ص�ʱ����ִ��
    static{
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("src//dbfile//User.txt"));
            String user = reader.readLine();//ÿһ�ζ�ȡ�ļ���һ�м�¼
            while(user!=null){
                String[] values = user.split("-");//һ�м�¼��������Ϣ �˺� ����
                userBox.put(values[0],new User(values[0],values[1]));
                user = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if(reader!=null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
