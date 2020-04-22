package domain;
public class Question {
    //domainʵ�� �洢�ļ��е���Ŀ ��ǿ�ɶ���
    private String title;//�洢���(��Ŀ+ѡ��)
    private String answer;//�洢��
    private String picture;//�洢ͼƬ·��

    public Question(){}
    public Question(String title, String answer) {
        this.title = title;
        this.answer = answer;
    }
    public Question(String title, String answer,String picture) {
        this.title = title;
        this.answer = answer;
        this.picture = picture;
    }

    //��дQuestion���е���������  equals  hashCode
    //��Ҫ��Question�������HashSet������ ��set���ϰ�����ȥ���ظ�Ԫ��
    @Override
    public int hashCode(){
        String thisTitle = this.title.substring(0,this.title.indexOf("<br>"));
        return thisTitle.hashCode();//31*h
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj instanceof Question){
            Question anotherQuestion = (Question)obj;
            String thisTitle = this.title.substring(0,this.title.indexOf("<br>"));
            String anotherTitle = anotherQuestion.title.substring(0,anotherQuestion.title.indexOf("<br>"));
            if(thisTitle.equals(anotherTitle)){
                return true;
            }
        }
        return false;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
}
