package test;

public class ProFileTest {

	public static void main(String[] args) {
		ProFile<String> p1 = new ProFile<String>("Dominica", "°ü¸®ÀÚ");
		ProFile<Integer> p2 = new ProFile<Integer>("Dominico",1111);
		
		System.out.println(p1.getName() + " " + p1.getDept());
		System.out.println(p2.getName() + " " + p2.getDept());
	}

}
