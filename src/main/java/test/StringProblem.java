package test;
import org.testng.Assert;
import org.testng.annotations.*;

public class StringProblem{
	
	
	public String replaceChar(String s,String s1){
		String newString=null;
		try{
		 newString=s.replaceAll(s1, "");}
		catch(Exception e){
			e.printStackTrace();
		}
		return newString;
	}
	
	
	public String replaceCharInLoop(String s, char ch){
		StringBuilder str= new StringBuilder();
		String newString=null;
		try{
		char[] c=s.toCharArray();
		
		for(char i:c){
			if(i!=ch){
				str.append(i);
			}
			
			
		}

		 newString=str.toString();
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		return newString;
		
		
		
		
	}
	
	
	
	@DataProvider(name="StringData")
	public Object[][] stringdata1(){
		
		Object[][]o ={{"abcdcd","abdd"},
				{"ABCDCD","ABCDCD"},
				{null,null}
				,{"",""}};
		return o;
		
	}
//	@DataProvider(name="StringData2")
//	public Object[][] stringdata(){
//		
//
//		Object[][]o ={{"abcdcd","abdd"},
//				{"ABCDCD","ABCDCD"},
//				{null,null}
//				,{"",""}};
//		return o;
//		
//	}
	
	
	@Test(dataProvider="StringData")
	
	public void testStringreplce(String s,String s1){
		
		String newString=replaceChar(s,"c");
		
		Assert.assertEquals(newString,s1);
	}
	
@Test(dataProvider="StringData")
	
	public void testStringreplceCharInLoop(String s,String s1){
		
		String newString= replaceCharInLoop(s,'c');
		
		Assert.assertEquals(newString,s1);
	}
	
	
}