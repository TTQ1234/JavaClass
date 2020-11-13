package con.ttq.student;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//	public Student(int id, String name, int age, String sex) {
		Student s1 = new Student(1, "陈舒怡", 16, Gender.WOMAN);
		Student s2 = new Student(2, "风风", 8, Gender.MAN);
		Student s3 = new Student(3, "亮亮", 8, Gender.MAN);
		String s1Sex = s1.getSex() == Gender.MAN ? "男" : "女";
		String s2Sex = s2.getSex() == Gender.MAN ? "男" : "女";
		String s3Sex = s3.getSex() == Gender.MAN ? "男" : "女";
		System.out.println(s1.getName() + s1.getAge() + s1.getId() + s1Sex);
		System.out.println(s2.getName() + s2.getAge() + s2.getId() + s2Sex);
		System.out.println(s3.getName() + s3.getAge() + s3.getId() + s3Sex);
	}

}
