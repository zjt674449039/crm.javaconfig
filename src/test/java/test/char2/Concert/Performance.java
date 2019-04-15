package test.char2.Concert;

import org.springframework.stereotype.Component;

@Component
public class Performance implements InterfaceTest{
	public void perform(String t,int a){
		System.out.println("performing..."+t+a);
	}
}
