package service;

import dao.UserDao;
import domain.User;
import util.MySpring;

//Serviceҵ���
//���������������
//������ҵ���߼�������������
public class UserService {

    //����һ��dao������Ϊ����
    private UserDao dao = MySpring.getBean("dao.UserDao");

    //���һ������---�����¼
    public String login(String account,String password){
        User user = dao.selectOne(account);
        if(user!=null){
            if(user.getPassword().equals(password)){
                return "��¼�ɹ�";
            }
        }
        return "�û������������";
    }
}
