package test.char2.Concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EncoreableIntroducer {

	@DeclareParents(value = "test.char2.Concert.Performance+",
			defaultImpl = DefaultEncoreable.class)
	public static Encoreable encoreable;
}
