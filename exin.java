package aBeengers20;
import java.io.*;
import java.util.*;

 
public class exin {
	String ranks;
	 void start() throws IOException {
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
		  // System.out.println(line);
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
		  
		  Collections.sort(list,Collections.reverseOrder()); 
		  // Collections �� ���� �������� �ڵ����� ���ĵȴ� ( ��  int�� )
		  
		
		  // ������ ������ ������ ���� ����
		  for (int i = 0; i <5; i++) {
		   System.out.println(list.get(i));
		   ranks = ranks+Integer.toString(list.get(i))+"\n";
		   // �迭���� �ϳ��� �ҷ��� �ڿ��� �������� �����Ѵ�( ���Ͽ� ������ string���� �־�� �ϱ� ������ )
		  }
		  System.out.println("�������");
		  
		 }
	 String ranks() {
		 return this.ranks;
	 }

}