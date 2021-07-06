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
		//**************************원래꺼 읽어옴
        FileReader reader = new FileReader("test1.txt");
        // 정수가 저장된 파일을 읽는다
        BufferedReader rd = new BufferedReader(reader);
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        String line = null;
        // 파일로 부터 읽어들인 조각들을 저장하는것
        String getLine = "";
        // 조각들을 연결해서 하나의 String 으로 만드는것
        

        // 한줄씩 읽는다
        while ((line = rd.readLine()) != null) {
        // System.out.println(line);   *************************************<뷸러온거 임시로 출력하는부분
         getLine = getLine + line;
         // 읽어서 최종 String에 저장시킨다
        }
        rd.close();
        
        
        // 파일로 부터 읽어 들인 문자열은 " "공백으로 구분해서 짤라준다
        StringTokenizer st = new StringTokenizer(getLine, " ");

        while (st.hasMoreTokens()) {
         list.add(Integer.parseInt(st.nextToken()));
         // 짤라준 조각들을 배열에 저장
        }  
        list.add(myrank);
        
        Collections.sort(list,Collections.reverseOrder()); 
        // Collections 를 쓰면 정수값은 자동으로 정렬된다 ( 단  int만 )
        
        String st_list = "";
        File file = new File("test1.txt");
        FileWriter writer = null;
        writer = new FileWriter(file, false);
        // 정렬한 값들을 저장할 파일 생성
        for (int i = 0; i < list.size(); i++) {
         st_list = st_list + " " + list.get(i);
         // 배열에서 하나씩 불러서 뒤에다 차곡차곡 연결한다( 파일에 넣을땐 string으로 넣어야 하기 떄문에 )
        }
       
        writer.write(st_list);
        writer.close();
        System.out.println("불러오기 & 정렬 & 저장 완료");
        
       }
}