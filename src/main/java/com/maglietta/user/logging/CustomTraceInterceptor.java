package com.maglietta.user.logging;

import org.apache.commons.logging.Log;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author Subha
 * This class uses the AspectJ style to create logs of each entry/exit of a method.
 */
@Component
public class CustomTraceInterceptor extends CustomizableTraceInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The default message used for writing method entry messages.
	 * "Entering method '" + PLACEHOLDER_METHOD_NAME + "' of class [" + PLACEHOLDER_TARGET_CLASS_NAME + "]";
	 * The default message used for writing method exit messages.
	 * "Exiting method '" + PLACEHOLDER_METHOD_NAME + "' of class [" + PLACEHOLDER_TARGET_CLASS_NAME + "]";
	 * The default message used for writing exception messages.
	 * "Exception thrown in method '" + PLACEHOLDER_METHOD_NAME + "' of class [" + PLACEHOLDER_TARGET_CLASS_NAME + "]";
	 */
	@Bean
	public CustomizableTraceInterceptor customizableTraceInterceptor() {
		final CustomizableTraceInterceptor cti = new CustomTraceInterceptor();
		cti.setLoggerName("customer-service-webservice-aop");
		cti.setEnterMessage("Entering method: '" + PLACEHOLDER_METHOD_NAME + "(" + PLACEHOLDER_ARGUMENTS + ")' of class [" + PLACEHOLDER_TARGET_CLASS_NAME + "]");
		cti.setExitMessage("Exiting method: '" + PLACEHOLDER_METHOD_NAME + " = " + PLACEHOLDER_RETURN_VALUE + "' of class [" + PLACEHOLDER_TARGET_CLASS_NAME + "] took " + PLACEHOLDER_INVOCATION_TIME + "ms.");
		cti.setExceptionMessage("Exception thrown in method: '" + PLACEHOLDER_METHOD_NAME + "' of class [" + PLACEHOLDER_TARGET_CLASS_NAME + "] gave: " + PLACEHOLDER_EXCEPTION);
		return cti;
	}

	/**
	 * This method is where to specify what packages should be under the Trace Interceptor.
	 *
	 * @return advisor that mixes pointcut and interceptor
	 */
	@Bean
	public Advisor traceAdvisor() {
		final AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution(* com.maglietta.user.controller..*.*(..)) || execution(* com.maglietta.user.domain..*.*(..)) || execution(* com.maglietta.user.repository..*.*(..)) || execution(* com.maglietta.user.service..*.*(..))");
		return new DefaultPointcutAdvisor(pointcut, customizableTraceInterceptor());
	}

	/*
	 * Write in the console all the Java classes that has been called.
	 * @see org.springframework.aop.interceptor.CustomizableTraceInterceptor#writeToLog(org.apache.commons.logging.Log, java.lang.String, java.lang.Throwable).
	 */
	@Override
	protected void writeToLog(final Log logger, final String message, final Throwable ex) {
		if (ex != null) {
			super.defaultLogger.debug(message, ex);
		} else {
			super.defaultLogger.debug(message);
		}
	}
}
