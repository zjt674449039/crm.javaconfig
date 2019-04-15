package test.char2.Concert;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestConcert {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConcertProxy.class);
		InterfaceTest pf = context.getBean(InterfaceTest.class);
		Audience a = context.getBean(Audience.class);
		System.out.println(a.getClass().getSimpleName());
		pf.perform("zzz", 1);
		Encoreable e = (Encoreable) (Object) pf;
		e.performEncore();
		/*
		 * System.out.println(pf.getClass().getSimpleName());
		 * pf.getClass().getMethod("performEncore").invoke(pf);
		 */
		Audience ad = context.getBean(Audience.class);
		//new TestConcert().t();
	}

	void t() {
		Encoreable e = (Encoreable) (Object) new Performance();
		e.performEncore();
	}
}