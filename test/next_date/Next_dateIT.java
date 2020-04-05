/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package next_date;


import java.io.FileInputStream;
import java.io.IOException;

import java.util.Arrays;
import java.util.Collection;


import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author 4star
 */
@RunWith(Parameterized.class)
public class Next_dateIT {
    private String expectedResult;
    //private int expectedResult;
    private  int firstVal;
    private  int secondVal;
    private  int thirdVal;
    Next_date ta;
  
    
    public Next_dateIT(String ep, int fval, int sval, int tval) {
        expectedResult=ep;
        firstVal=fval;
        secondVal=sval;
        thirdVal=tval;
    }
    
   
    
   
    
    @Before
    public void setUp() {
         ta=new Next_date();
    }
    
     @Parameters
   public static Collection<Object[]> Testdata() throws BiffException, IOException, IllegalArgumentException
	{ 
		
			FileInputStream file;
			int j=0;
				file = new FileInputStream("test.xls");
				Workbook wbk = Workbook.getWorkbook(file);
				  Sheet sheet = wbk.getSheet(0);
				  Object Data[][] = new Object[sheet.getRows()][sheet.getColumns()];
				  for(int i=0;i<(sheet.getRows());i++)
				  {
				   String r=sheet.getCell(0,i).getContents();
				   int l=Integer.parseInt(sheet.getCell(1,i).getContents());
				   int ll=Integer.parseInt(sheet.getCell(2,i).getContents());
				   int lll=Integer.parseInt(sheet.getCell(3,i).getContents());
				    Data[i][0] = r;
				    Data[i][1] = l;
				   Data[i][2] = ll;
				  Data[i][3] = lll;
				    
				    
				  }
				    
			
			 return Arrays.asList(Data);
	    
	}

    /**
     * Test of main method, of class Next_date.
     */
    
    @Test
    public void testNext_date() {
     Assert.assertEquals(expectedResult, Next_date.nextDateCheck(firstVal, secondVal, thirdVal));
    
    }
    
}
