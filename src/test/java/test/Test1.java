package test;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import test.char1.ConfigTest;
import test.char1.Knight;

public class Test1 {
	static String localDirectory = "localDirectory";	
	
	public static void main(String[] args) {
		/*System.out.println(localDirectory.getClass().getSimpleName());
		File localDirectory = new File("");
		System.out.println(localDirectory.getClass().getSimpleName());*/
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("knights.xml");
		Knight knight = context.getBean(Knight.class);
		knight.embarkOnQuest();
		ConfigTest configTest = context.getBean(ConfigTest.class);
		configTest.c();
	}
	
}