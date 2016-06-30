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

public class Terminal_Launch extends NewTest
{	
	File file;
	String file_name="code.sh";
	public String File_create(String url) throws IOException
	{
		String first = StringUtils.substringBefore(url, ".git");
		String final_word = StringUtils.substringAfter(first, "anshul1005/");
		String url_clone="git clone git@github.com:anshul1005/"+final_word+".git";
		file = new File(file_name);
		FileWriter fileWritter = new FileWriter(file.getName(),true);
		file.setExecutable(true);
        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        String comment="added by script";
        bufferWritter.write("#!/bin/sh");
        bufferWritter.newLine();
        bufferWritter.write("cd");
        bufferWritter.newLine();
        bufferWritter.write(url_clone);
        bufferWritter.newLine();
        bufferWritter.write("cp /home/anshulgarg/workspace/github/code.sh /home/anshulgarg/"+final_word);
        bufferWritter.newLine();
        bufferWritter.write("cd "+final_word+"/");
        bufferWritter.newLine();
        bufferWritter.write("git add -A");
        bufferWritter.newLine();
        bufferWritter.write("git commit -m \""+comment+"\"");
        bufferWritter.newLine();
        bufferWritter.write("git push origin master");
        bufferWritter.newLine();
        bufferWritter.close();
        return final_word;
     }
	public List<String> executeCommand()
	{
		String line1 = null;
		String line2 = null;
		String text=null;
		 List<String> list = new ArrayList<String>();
		try
		{
			ProcessBuilder builder = new ProcessBuilder("/home/anshulgarg/workspace/github/code.sh");
			builder.redirectErrorStream(true);
			Process process = builder.start();
			InputStream is = process.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			while ((line1 = reader.readLine()) != null) 
			{
				break;
			}
			while ((line2 = reader.readLine()) != null) 
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
			list.add(line1);
			list.add(text);
			file.delete();
			return list;
		}
	}
}

