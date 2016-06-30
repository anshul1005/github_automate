package com.qait.automation.github;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class Pull_readme_and_validate extends NewTest
{
	File file;
	public void File_create(String url) throws IOException
	{
		String first = StringUtils.substringBefore(url, ".git");
		String final_word = StringUtils.substringAfter(first, "anshul1005/");
		file = new File("code.sh");
		FileWriter fileWritter = new FileWriter(file.getName(),true);
		file.setExecutable(true);
        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        bufferWritter.write("cd");
        bufferWritter.newLine();
        bufferWritter.write("cd "+final_word+"/");
        bufferWritter.newLine();
        bufferWritter.write("git pull origin master");
        bufferWritter.newLine();
        bufferWritter.close();
     }
	public String executeCommand()
	{
		String line=null;
		String text=null;
		try
		{
			
			ProcessBuilder builder = new ProcessBuilder("/home/anshulgarg/workspace/github/code.sh");
			builder.redirectErrorStream(true);
			Process process = builder.start();
			InputStream is = process.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			while ((line= reader.readLine()) != null) 
			{
				
				text=reader.readLine();
		
			}
		
		}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
			finally 
			{
				System.out.println("text is"+text);
				file.delete();
				return text;
			}
	}
}
