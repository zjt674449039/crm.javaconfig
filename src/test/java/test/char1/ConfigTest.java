package test.char1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("/test/char1/ccc.properties")
public class ConfigTest {
	@Autowired
	Environment environment;
	
	public void c(){
		String property = environment.getProperty("c");
		System.out.println(property);
	}
}
