package com.karthik.data.hibernate.finder.impl;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;

import com.karthik.data.hibernate.finder.FinderExecutor;

public class FinderIntroductionInterceptor implements IntroductionInterceptor{

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		
        FinderExecutor executor = (FinderExecutor) methodInvocation.getThis();

        String methodName = methodInvocation.getMethod().getName();
        if(methodName.startsWith("find") || methodName.startsWith("list"))
        {
            Object[] arguments = methodInvocation.getArguments();
            return executor.executeFinder(methodInvocation.getMethod(), arguments);
        }
        else if(methodName.startsWith("iterate"))
        {
            Object[] arguments = methodInvocation.getArguments();
            return executor.iterateFinder(methodInvocation.getMethod(), arguments);
        }
        else
        {
            return methodInvocation.proceed();
        }
    }

	@Override
	public boolean implementsInterface(Class<?> intf) {
		return intf.isInterface() && FinderExecutor.class.isAssignableFrom(intf);
	}

}
