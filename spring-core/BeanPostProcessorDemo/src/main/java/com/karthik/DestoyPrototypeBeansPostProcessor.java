package com.karthik;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class DestoyPrototypeBeansPostProcessor implements BeanPostProcessor, BeanFactoryAware, DisposableBean {

	private BeanFactory beanFactory;
	
	private final List<Object> prototypeBeans = new ArrayList<Object>();
	
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (beanFactory.isPrototype(beanName)) {
			synchronized (prototypeBeans) {
				prototypeBeans.add(bean);
			}
		}
		return bean;
	}

	public void destroy() throws Exception {
		synchronized (prototypeBeans) {
			System.out.println(String.format("Destroying %d prototype beans...", prototypeBeans.size()));
			for(Object obj: prototypeBeans) {
				if(obj instanceof DisposableBean) {
					DisposableBean disposableBean = (DisposableBean) obj;
					try {
						disposableBean.destroy();
					}
					catch(Exception ex) {
						System.err.println("Exception occurred during destruction of prototype beans: " + ex.getMessage());
					}
				}
			}
			prototypeBeans.clear();
			System.out.println(String.format("Remaining prototype beans : %d", prototypeBeans.size()));
		}
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

}
