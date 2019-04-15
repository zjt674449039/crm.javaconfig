package test.char2.Concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audience {
	@Around("execution(** test.char2.Concert.Performance.perform(String,int)) && args(f,a)")
	public void watchPerformance(ProceedingJoinPoint jp,String f,int a){
		try {
			System.out.println("before");
			Object[] obs = {f,a};
			jp.proceed(obs);
			System.out.println("after");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}