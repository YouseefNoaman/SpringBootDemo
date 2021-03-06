package com.example.demo.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.util.StopWatch;

import lombok.SneakyThrows;

@Aspect
@Component
public class LoggingAspect {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

//	/**
//	 * Pointcut that matches all repositories, services and Web REST endpoints.
//	 */
//	@Pointcut("within(@org.springframework.stereotype.Repository *)"
//			+ " || within(@org.springframework.stereotype.Service *)"
//			+ " || within(@org.springframework.web.bind.annotation.RestController *)")
//	public void springBeanPointcut() {
//		// Method is empty as this is just a Pointcut, the implementations are in the
//		// advices.
//	}
//
//	/**
//	 * Pointcut that matches all Spring beans in the application's main packages.
//	 */
//	@Pointcut("within(com.example.demo.controller..*)" + " || within(com.example.demo.service..*)"
//			+ " || within(com.example.demo.repository..*)")
//	public void applicationPackagePointcut() {
//		// Method is empty as this is just a Pointcut, the implementations are in the
//		// advices.
//	}
//
//	/**
//	 * Advice that logs methods throwing exceptions.
//	 *
//	 * @param joinPoint join point for advice
//	 * @param e         exception
//	 */
//	@AfterThrowing(pointcut = "applicationPackagePointcut() && springBeanPointcut()", throwing = "e")
//	public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
//		log.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
//				joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL");
//	}
//
//	/**
//	 * Advice that logs when a method is entered and exited.
//	 *
//	 * @param joinPoint join point for advice
//	 * @return result
//	 * @throws Throwable throws IllegalArgumentException
//	 */
//	@Around("applicationPackagePointcut() && springBeanPointcut()")
//	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
//
//		log.info("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
//				joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
//		try {
//			Object result = joinPoint.proceed();
//			log.info("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
//					joinPoint.getSignature().getName(), result);
//			return result;
//		} catch (IllegalArgumentException e) {
//			log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
//					joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
//			throw e;
//		}
//	}
//
	// AOP expression for which methods shall be intercepted
	@Around("execution(* com.example.demo.service..*(..)))")
	public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

		// Get intercepted method details
		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();

		final StopWatch stopWatch = new StopWatch();

		// Measure method execution time
		stopWatch.start();
		Object result = proceedingJoinPoint.proceed();
		stopWatch.stop();

		// Log method execution time
		log.info("Execution time of " + className + "." + methodName + " :: " + stopWatch.getTotalTimeMillis() + " ms");

		return result;
	}
	
	
    private static final String POINTCUT = "within(com.example.demo.controller..*)";

    @Around(POINTCUT)
    @SneakyThrows
    public Object logArroundExec(ProceedingJoinPoint pjp) {
        log.info("before {}", constructLogMsg(pjp));
        var proceed = pjp.proceed();
        log.info("after {} with result: {}",constructLogMsg(pjp), proceed.toString());
        return proceed;
    }

    @AfterThrowing(pointcut = POINTCUT, throwing = "e")
    public void logAfterException(JoinPoint jp, Exception e) {
        log.error("Exception during: {} with ex: {}", constructLogMsg(jp),  e.toString());
    }

    private String constructLogMsg(JoinPoint jp) {
        var args = Arrays.asList(jp.getArgs()).stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        Method method = ((MethodSignature) jp.getSignature()).getMethod();
        var sb = new StringBuilder("@");
        sb.append(method.getName());
        sb.append(":");
        sb.append(args);
        return sb.toString();
    }
	
}
