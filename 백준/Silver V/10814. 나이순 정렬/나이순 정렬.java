import java.io.*;
import java.util.*;

class Person implements Comparable{
	int age;
	String name;
	
	Person(){}
	Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return age+" "+name+"\n";
	}
	
	@Override
	public int compareTo(Object o) {
		Person p = (Person) o;
		return this.age - p.age;
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st; StringBuilder sb = new StringBuilder();
		int age; String name; //입력 받을 파라미터 선언
		Person[] arr = new Person[N]; // Person 객체 담을 배열 생성
		
		for (int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			age = Integer.parseInt(st.nextToken());
			name = st.nextToken();
			arr[n] = new Person(age,name); // 객체에 Person 담음
		}
		
		// 나이 오름차순 -> 나이가 같으면 먼저 들어온 순서대로 나이와 이름을 출력
		Arrays.sort(arr);
		
		for (Person p : arr) {
			sb.append(p.toString());
		}
		
		System.out.println(sb.toString());
	}

}
