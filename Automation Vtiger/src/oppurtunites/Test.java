package oppurtunites;

import org.testng.Assert;

import com.vtiger.genericlib.BaseClass;

public class Test extends BaseClass {

	@org.testng.annotations.Test
	public  void Test1() throws Throwable 
	{
		String output11= fLib.getExcelData("Sheet1", 4, 12);
		String output12= fLib.getExcelData("Sheet1", 4, 13);
		 String expoppPage1 ="hi";
		String actoppPage2 = "hello";
	/*	 try 
		 {  Assert.assertEquals(expoppPage1, actoppPage2);
			 System.out.println(output11);
		 }
		 catch(AssertionError e)
		 {
			 System.out.println(output12);
		 }*/
	//	Assert.assertEquals(expoppPage1, actoppPage2, output12); 
	//	System.out.println(output11);
		Assert.assertTrue(actoppPage2.contains(expoppPage1),output12 );
		System.out.println(output11);

	}

}
