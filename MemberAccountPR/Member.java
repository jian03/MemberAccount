package IT210120;

public class Member { //회원 클래스 선언
	
	//1. 변수
	String id;
	String pw;
	String name;
	int point;
	
	//2. 생성자: 객체의 초기값 => 객체 생성 시 실행되는 메서드
	public Member() { //깡통
		
	}
	
	public Member(String id, String pw, String name) { //
		this.id = id; //this.변수명 //현재 클래스 내 변수 호출
		this.pw = pw;
		this.name = name;
	}
	//3. 메서드 = 함수 [함(상자) 수(숫자)] => 미리 정의된 코드
	//접근 제한자 반환값 메서드명(인수, 인수2 ~~) { 실행 코드 return }
	
	//id 반환 메서드
	public String getid() { //반환 타입: String
		return this.id;     //return 반환값;
	}
	//pw 반환 메서드
	public String getpw() {
		return this.pw;
	}
	//name 반환 메서드
	public String getname() {
		return this.name;
	}
	//id 저장 메서드       //반환 타입 X, //인수 = id
	public void setid(String id) {
		this.id = id;
	}
	//pw 저장 메서드       //반환 타입 X, //인수 = pw 
	public void setpw(String pw) {
		this.pw = pw;
	}
	//name 저장 메서드     //반환 타입 X, //인수 = name
	public void setname(String name) {
		this.name = name;
	}	
}