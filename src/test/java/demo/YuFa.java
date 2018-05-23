package demo;

public class YuFa {
	private String s = "abc";
	private static int i =1 ;
	
	public YuFa(){
		//doSomeThing();
	}
	
	static{
		i =1;
		//s ="abc";
	}
	
	public YuFa(int i,String s){
		i=1;
		s="abc";
	}
	
	public static void main(String[] args) {
		YuFa yf = new YuFa();
		YuFa yf2 = new YuFa(1,"abc");
	}
}
