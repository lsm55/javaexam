package domain;

//domainʵ�����
//�洢�ļ��е�һ�м�¼
//�ļ���------------����
//�ļ���һ�м�¼----��Ķ���
//�ļ�һ���е�ֵ----��������Զ�Ӧ
public class User {

    private String account;//���������洢�˺�
    private String password;//���������洢����

    public User() {}
    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
