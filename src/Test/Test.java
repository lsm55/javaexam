package Test;
import view.LoginFrame;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        new LoginFrame();
    }
//    private static char ch;
//    private static String strToken;
//    private static int index = 0;
//    private static int line = 1;
//    private static boolean noteTag = false;
//    private Map<Integer, String> keywords;
//    private HashMap<String, Integer> punctuations;
//    private static ArrayList<String> p = new ArrayList<String>();
//    private static ArrayList<String> q = new ArrayList<String>();
//
//    // get and set 函数
//    public char getCh() {
//        return ch;
//    }
//
//    public void setCh(char ch) {
//        Test.ch = ch;
//    }
//
//    public String getStrToken() {
//        return strToken;
//    }
//
//    public void setStrToken(String strToken) {
//        Test.strToken = strToken;
//    }
//
//    public void setPunctuations(HashMap<String, Integer> punctuations) {
//        this.punctuations = punctuations;
//    }
//
//    public Map<String, Integer> getPunctuations() {
//        return punctuations;
//    }
//
//    public void setKeywords(Map<Integer, String> keywords) {
//        this.keywords = keywords;
//    }
//
//    public Map<Integer, String> getKeywords() {
//        return keywords;
//    }
//
//    // 构造函数
//    public Test() {
//        this.keywords = new HashMap<Integer, String>();
//        keywords.put(1, "Program");
//        keywords.put(2, "begin");
//        keywords.put(3, "end");
//        keywords.put(4, "var");
//        keywords.put(5, "int");
//        keywords.put(6, "and");
//        keywords.put(7, "or");
//        keywords.put(8, "not");
//        keywords.put(9, "if");
//        keywords.put(10, "then");
//        keywords.put(11, "else");
//        keywords.put(12, "while");
//        keywords.put(13, "do");
//
//        this.punctuations = new HashMap<String, Integer>();
//        punctuations.put("+", 16);
//        punctuations.put("*", 17);
//        punctuations.put("(", 18);
//        punctuations.put(")", 19);
//        punctuations.put(",", 20);
//        punctuations.put(";", 21);
//        punctuations.put(":=", 22);
//        punctuations.put(">", 23);
//        punctuations.put(">=", 24);
//        punctuations.put("<", 25);
//        punctuations.put("<=", 26);
//        punctuations.put(".", 27);
//        punctuations.put("<>", 28);
//        punctuations.put("=", 29);
//
//    }
//
//    // 函数定义（词法分析函数）
//    public boolean Analyse(char[] strArray) {
//        index = 0;// 每次分析一行完成后就将index置0
//        char temp1;
//        int rowLength = strArray.length;
//        outer:
//        while (index < rowLength) {
//            strToken = "";
//            ch = GetChar(strArray);
//            if (ch == ';') {
//                System.out.println("(23,;) ");
//            } else if (ch == ':') {
//                index++;
//                System.out.println("(22,：=)");
//            } else if (ch == '.') {
//                System.out.println("(21,.)");
//            } else if (ch == '>') {
//                if ((temp1 = this.getNextChar(strArray)) == '=')
//                    System.out.println("(27,>=)");
//                else {
//                    index--;
//                    System.out.println("(24,>)");
//                }
//
//            } else if (ch == '<') {
//                if ((temp1 = this.getNextChar(strArray)) == '=')
//                    System.out.println("(28,<=)");
//                else if (temp1 == '>')
//                    System.out.println("(29,<>)");
//                else {
//                    index--;
//                    System.out.println("(25,<)");
//                }
//
//            } else if (ch == '*' && noteTag == false) {
//                System.out.println("(17,*)");
//            } else if (java.lang.Character.isLetter(ch) && noteTag == false) {
//                strToken = contact(strToken, ch);
//                ch = getNextChar(strArray);
//                while ((java.lang.Character.isLetter(ch))
//                        || (java.lang.Character.isDigit(ch))) {
//                    strToken = contact(strToken, ch);
//                    ch = getNextChar(strArray);
//                }
//                index--;
//                // System.err.println("!!!"+strToken);
//                if (findKeyword(strToken)) {
//                    //System.out.println("(15," + strToken.toString() + ")\n");
//                    int i = getKeyWordKey(strToken);
//                    System.out.println("(" + i + ",--)");
//                } else {
//                    if (!exist(p, strToken))
//                        p.add(strToken);
//                    int i = getindex(p, strToken);
//                    //System.out.println("(14," + strToken.toString() + ")\n");
//                    System.out.println("(14," + i + ")");
//                }
//
//            } else if (java.lang.Character.isDigit(ch) && noteTag == false) {
//                strToken = this.contact(strToken, ch);
//                ch = this.getNextChar(strArray);
//                while (java.lang.Character.isDigit(ch)) {
//                    strToken = this.contact(strToken, ch);
//                    ch = this.getNextChar(strArray);
//                }
//                index--;
////                System.out.println("(15," + strToken.toString() + ")\n");
//                if (!exist(q, strToken))
//                    q.add(strToken);
//                int i = getindex(q, strToken);
//                System.out.println("(15," + i + ")");
//                strToken = "";
//
//            } else if (ch == '/' || noteTag == true) {
//                int startj = index; //注释起始位置标记
//                int starti = line;
//                if (noteTag == false) {
//                    System.out.println("该部分是注释注释，从第" + starti + "行第" + startj + "列开始");
//                }
//
//                char temp = this.getNextChar(strArray);
//                if (temp == '*' && noteTag == false) {
//                    temp = this.getNextChar(strArray);
//                    while (index < rowLength) {
//                        temp = this.getNextChar(strArray);
//                        if (temp == '*' && (temp1 = this.getNextChar(strArray)) == '/') {
//                            index--;
//                            break;
//                        }
//                        if (index >= rowLength) {
//                            noteTag = true;
//                            break outer;
//                        }
//                    }
//                } else if (noteTag == true && ch != '*') {
//                    while (index < rowLength) {
//                        temp = this.getNextChar(strArray);
//                        if (temp == '*' && (temp1 = this.getNextChar(strArray)) == '/') {
//                            noteTag = false;
//                            break;
//                        }
//                    }
//                } else if (temp == '/') {
//                    while (true) {
//                        index++;
//                        if (index >= rowLength)
//                            break outer;
//                    }
//                } else
//                    return false;
//            } else {
//                String key = String.valueOf(ch);
//                if (this.findPunctuation(key)) {
//                    System.out.println("(" + this.getPunctuation(key) + ","
//                            + key + ")");
//                } else if (key.equals(" ") || key.equals("        ")) {
//                    break;
//                } else
//                    return false;
////                System.out.println( "[未知符号]  " + key + "\n");
////                strToken = "";
//            }
//
//        }
//        return true;
//    }
//
//    public char GetChar(char[] array) {
//        try {
//            while ((array[index]) == ' ') {
//                index++;
//            }
//            index++;// 提前指向下一个字符
//        } catch (ArrayIndexOutOfBoundsException e) {
//            return ' ';
//        }
//        return array[index - 1];
//    }
//
//    public char getNextChar(char[] strChar) {
//        index++;
//        return strChar[index - 1];
//    }
//
//    public String contact(String token, char ch) {
//        return token + String.valueOf(ch);
//    }
//
//    public boolean findKeyword(String str) {
//        for (int i = 0; i < 13; i++) {
//            if (str.equalsIgnoreCase(this.keywords.get(i)))
//                return true;
//        }
//        return false;
//
//    }
//
//    public boolean findPunctuation(String str) {
//        if (this.punctuations.containsKey(str)) {
//            return true;
//        } else
//            return false;
//    }
//
//    public int getPunctuation(String str) {
//        return this.punctuations.get(str);
//    }
//
//    public boolean Clean() {
//        return true;
//    }
//
//    public void callError(int line) {
//        System.out.println("出现错误，错误位置在第" + line + "行,第" + index + "列");
//    }
//
//
//    public boolean exist(ArrayList<String> p, String strToken) {
//        if (p.contains(getStrToken()))
//            return true;
//        else
//            return false;
//    }
//
//    public int getKeyWordKey(String str) {
//        for (int i = 1; i <= 13; i++) {
//            if (str.equalsIgnoreCase(this.keywords.get(i)))
//                return i;
//        }
//        return 10000;
//    }
//
//    public int getindex(ArrayList<String> p, String Str) {
//        return p.lastIndexOf(Str) + 1;
//	   /*int j=0;
//	   for(int i=0;i<p.size();i++)
//	   {
//		   if(p.get(i).equals(Str))
//			   j++;
//
//	   }
//	   return j;*/
//    }
//
//    public Boolean WriteFile(ArrayList p, ArrayList q) {
//        File file1 = new File("D:\\biaoshifu.txt");
//        Writer writer = null;
//        try {
//            writer = new FileWriter(file1);
//            String data = p.toString();
//            writer.write(data);
//            File file2 = new File("D:\\num.txt");
//            Writer writer1 = new FileWriter(file2);
//            String data1 = q.toString();
//            writer1.write(data1);
//            writer.close();
//            writer1.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return true;
//    }
//
//    public static void main(String args[]) {
//        File file = new File("D:\\sample.txt");
//        Test test = new Test();
//        char[] strChar = new char[100];// 限制每行代码字符数不超过100
//        BufferedReader reader = null;
//        try {
//            //System.out.println("以行为单位读取文件内容，一次读一整行：");
//            reader = new BufferedReader(new FileReader(file));
//            String tempString = null;
//            // int line = 1;
//            // 一次读入一行，直到读入null为文件结束
//            while ((tempString = reader.readLine()) != null) {
//                // 显示行号
//                System.out.println("line " + line + ": " + tempString);
//                strChar = tempString.toCharArray();
//                boolean flag = test.Analyse(strChar);
//                if (flag == true)
//                    line++;
//                else {
//                    test.callError(line);
//                    break;
//                }
//
//            }
//            System.out.println("标示符表");
//            System.out.println(p.toString());
//            System.out.println("常数表");
//            System.out.println(q.toString());
//            if (test.WriteFile(p, q)) {
//                System.out.println("标识符，常数表写入文件成功");
//            }
//            reader.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        } finally {
//            if (reader != null)
//                try {
//                    reader.close();
//                } catch (IOException e1) {
//                    // TODO Auto-generated catch block
//                    e1.printStackTrace();
//                }
//
//        }
//    }
}