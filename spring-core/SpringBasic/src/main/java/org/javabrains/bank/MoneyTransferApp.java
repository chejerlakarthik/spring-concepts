/**
 * 
 */
package org.javabrains.bank;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Yashoda
 *
 */
public class MoneyTransferApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Logger slf4j = LoggerFactory.getLogger("SpringLogger");

		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");
		context.registerShutdownHook();

		AccountDetails fromAccount = (AccountDetails) context
				.getBean("SourceAccount");
		AccountDetails toAccount = (AccountDetails) context
				.getBean("DestinationAccount");

		if (fromAccount.getAccountBalance() <= 0) {

			slf4j.error("You do not have enough balance to do this Xfer");

		} else {
			System.out.println("Transferring "
					+ fromAccount.getAccountBalance() + " from "
					+ fromAccount.getAccountNumber() + " to "
					+ toAccount.getAccountNumber());

			toAccount.setAccountBalance(toAccount.getAccountBalance()
					+ fromAccount.getAccountBalance());
			fromAccount.setAccountBalance(0);

			toAccount.setLastTransactionDate((new Date()).toString());
			fromAccount.setLastTransactionDate((new Date()).toString());

			System.out
					.println("Money transferred successfully!! New Account Balance for "
							+ toAccount.getAccountNumber()
							+ " is "
							+ toAccount.getAccountBalance());
			System.out.println("Last transaction date: "
					+ toAccount.getLastTransactionDate());
		}

		context.close();
	}
}
