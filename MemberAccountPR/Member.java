package IT210120;

public class Member { //ȸ�� Ŭ���� ����
	
	//1. ����
	String id;
	String pw;
	String name;
	int point;
	
	//2. ������: ��ü�� �ʱⰪ => ��ü ���� �� ����Ǵ� �޼���
	public Member() { //����
		
	}
	
	public Member(String id, String pw, String name) { //
		this.id = id; //this.������ //���� Ŭ���� �� ���� ȣ��
		this.pw = pw;
		this.name = name;
	}
	//3. �޼��� = �Լ� [��(����) ��(����)] => �̸� ���ǵ� �ڵ�
	//���� ������ ��ȯ�� �޼����(�μ�, �μ�2 ~~) { ���� �ڵ� return }
	
	//id ��ȯ �޼���
	public String getid() { //��ȯ Ÿ��: String
		return this.id;     //return ��ȯ��;
	}
	//pw ��ȯ �޼���
	public String getpw() {
		return this.pw;
	}
	//name ��ȯ �޼���
	public String getname() {
		return this.name;
	}
	//id ���� �޼���       //��ȯ Ÿ�� X, //�μ� = id
	public void setid(String id) {
		this.id = id;
	}
	//pw ���� �޼���       //��ȯ Ÿ�� X, //�μ� = pw 
	public void setpw(String pw) {
		this.pw = pw;
	}
	//name ���� �޼���     //��ȯ Ÿ�� X, //�μ� = name
	public void setname(String name) {
		this.name = name;
	}	
}