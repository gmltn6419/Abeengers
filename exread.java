package aBeengers20;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;



public class  exread{
	Integer[] rank;
	int myrank;
	exread(int myrank) throws IOException{
		this.myrank = myrank;
		Integer[] rank = new Integer[] {0,0,0,0,0};
		//**************************������ �о��
        FileReader reader = new FileReader("test1.txt");
        // ������ ����� ������ �д´�
        BufferedReader rd = new BufferedReader(reader);
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        String line = null;
        // ���Ϸ� ���� �о���� �������� �����ϴ°�
        String getLine = "";
        // �������� �����ؼ� �ϳ��� String ���� ����°�
        

        // ���پ� �д´�
        while ((line = rd.readLine()) != null) {
        // System.out.println(line);   *************************************<�淯�°� �ӽ÷� ����ϴºκ�
         getLine = getLine + line;
         // �о ���� String�� �����Ų��
        }
        rd.close();
        
        
        // ���Ϸ� ���� �о� ���� ���ڿ��� " "�������� �����ؼ� ©���ش�
        StringTokenizer st = new StringTokenizer(getLine, " ");

        while (st.hasMoreTokens()) {
         list.add(Integer.parseInt(st.nextToken()));
         // ©���� �������� �迭�� ����
        }  
        list.add(myrank);
        
        Collections.sort(list,Collections.reverseOrder()); 
        // Collections �� ���� �������� �ڵ����� ���ĵȴ� ( ��  int�� )
        
        String st_list = "";
        File file = new File("test1.txt");
        FileWriter writer = null;
        writer = new FileWriter(file, false);
        // ������ ������ ������ ���� ����
        for (int i = 0; i < list.size(); i++) {
         st_list = st_list + " " + list.get(i);
         // �迭���� �ϳ��� �ҷ��� �ڿ��� �������� �����Ѵ�( ���Ͽ� ������ string���� �־�� �ϱ� ������ )
        }
       
        writer.write(st_list);
        writer.close();
        System.out.println("�ҷ����� & ���� & ���� �Ϸ�");
        
       }
}