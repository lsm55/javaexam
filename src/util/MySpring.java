package util;

import java.util.HashMap;

//Ŀ����Ϊ�˹������Ĳ���
//����Ŀ���Ȩ������ǰ��������    IOC���Ʒ�ת
//���������йܵķ�ʽʵ���˶���ĵ���
public class MySpring {

    //���� Ϊ�˴洢���б�����Ķ���
    private static HashMap<String,Object> beanBox = new HashMap<>();

    //���һ������ ��ȡ�κ�һ����Ķ���
    //  ����ֵ(����)   ����String ����
    public static <T>T getBean(String className){//����һ����ȫ��
        T obj = null;
        try {
            //1.ֱ��ȡbeanBox�����ȡ
            obj = (T)beanBox.get(className);
            //2.���obj��null ֤��֮ǰû�д������������
            if(obj==null){
                //3.ͨ�������ֻ�ȡClass
                Class clazz = Class.forName(className);
                //4.ͨ���������һ������
                obj = (T)clazz.newInstance();
                //5.�µĶ�����뼯��
                beanBox.put(className,obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
