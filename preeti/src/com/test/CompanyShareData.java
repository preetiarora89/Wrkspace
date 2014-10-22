/**
 * 
 */
package com.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author preeti
 *
 */
 class CompanyShareData {

	
	/**
	 * @param csv absolute filePath
	 * @param startIndex of sharePrice
	 */
	/*Read file and get max rate*/
	public static List<CompanyShare> readAndFindMaxShare(String filePath,int startDataIndex)
	{
		List<CompanyShare> companyData=new LinkedList<CompanyShare>();
		BufferedReader br=null;
		try
		{
			Reader fileReader=new FileReader(filePath);
			br=new BufferedReader(fileReader);
			String line=null;
			String[] strArr=null;
			CompanyShare cs=null;
			int counter=0;
			if((line=br.readLine())!=null)
			{
				counter++;
				strArr=line.split(",");
				if(strArr.length>=startDataIndex)
					for(int ind=startDataIndex;ind<strArr.length;ind++)
						companyData.add(new CompanyShare(strArr[ind], "0", "0", 0.0));
			}
			while((line=br.readLine())!=null)
			{
				counter++;
				strArr=line.split(",");
				if(strArr.length<startDataIndex)
				{
					System.out.println("Provide data in correct csv format");
					System.exit(1);
				}
				if(strArr.length>=startDataIndex)
					for(int ind=startDataIndex;ind<strArr.length;ind++)
					{
						
						if((ind-startDataIndex)>=companyData.size())
							continue;
						if(!Util.isNumeric(strArr[ind]))
						{
							System.out.println("Please provide numeric price for company "+(ind-startDataIndex+1)+" in line "+counter);
							System.exit(1);
						}
						cs=companyData.get(ind-startDataIndex);
						if(cs.getSharePrice()<Double.parseDouble(strArr[ind]))
						{
							cs.setMonth(strArr[1]);
							cs.setYear(strArr[0]);
							cs.setPrice(Double.parseDouble(strArr[ind]));
						}
					}
				
			}
			
		}
		catch(FileNotFoundException fe)
		{
			System.err.println("File not found, please provide the correct path and file name");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
			br.close();
			}catch(Exception e)
			{e.printStackTrace();}
		}
		if(companyData.size()>0)
		{
			return companyData;
		}
		return null;
	}
}
 class Util
 {
	 public static boolean isNumeric(String data)
	 {
		 Pattern pattern=null;
		 if(data.contains("."))
			 pattern=Pattern.compile("^[0-9]*\\.[0-9]++$");
		 else
			 pattern=Pattern.compile("^[0-9]++$");
		 Matcher matcher=pattern.matcher(data);
		 return matcher.matches();
	 }
 }
