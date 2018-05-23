package fix;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		double d = 1/100;
		System.out.println(d);
		d = (double)1/(double)100;
		System.out.println(d);
		d = 1/(double)100;
		System.out.println(d);
	}
	
	/*public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("e23sdf");
		list.add("123321");
		list.add("21321fdgdfg");
		list.add("哈利");
		System.out.println(list);
		System.out.println(list.get(0));
	}*/
	
	/*public static void main(String[] args) {
		int i =5;
		if(i<5){
			System.out.println("i<5");
		}else if(i<6){
			System.out.println("i<6");
		}else if(i<7){
			System.out.println("i<7");
		}else{
			System.out.println("else");
		}
	}*/

	/*public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			try {

				int k = 10 / i;
				System.out.println(k);

			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			System.out.println("123---"+(i+1));
		}

	}*/
}
