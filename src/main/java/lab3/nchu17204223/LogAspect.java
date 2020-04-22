package lab3.nchu17204223;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;

@Aspect
@Configuration
public class LogAspect {
	private Logger logger = LoggerFactory.getLogger(LogAspect.class);

	@Before("execution(public * lab3.nchu17204223.HomeController.login(..)) && args(user,result,..)")
	public void loginBefore(User user, BindingResult result) throws Throwable {
		logger.info(String.format("Account:%s, login %s.", user.getAccount(), result.hasErrors() ? "failed" : "succeeded"));
	}
	
	@Before("execution(public * lab3.nchu17204223.HomeController.register(..)) && args(user,result,..)")
	public void registerBefore(User user, BindingResult result) throws Throwable {
		logger.info(String.format("Account:%s, register and login %s.", user.getAccount(), result.hasErrors() ? "failed" : "succeeded"));
	}
}
