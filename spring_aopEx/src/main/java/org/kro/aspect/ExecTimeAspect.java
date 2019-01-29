package org.kro.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecTimeAspect {

	@Pointcut("execution(public * org.kro.calculator..*(..))")
	private void publicTarget(){}
	
	@Around("publicTarget()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable{
		long start = System.nanoTime();
		
		try {
			Object result = joinPoint.proceed();
			return result;
		} finally {
			long end = System.nanoTime();
			Signature sig = joinPoint.getSignature();
			System.out.printf("%s.%s(%s) 실행시간 : %d ns \n", joinPoint.getTarget().getClass().getSimpleName()
					,sig.getName(), Arrays.toString(joinPoint.getArgs()), (end - start));
		}
	}
}
