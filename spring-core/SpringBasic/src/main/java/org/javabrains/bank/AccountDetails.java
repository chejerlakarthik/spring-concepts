/**
 * 
 */
package org.javabrains.bank;

/**
 * @author Yashoda
 *
 */
public class AccountDetails {

	public enum AccountType {
		Savings, Current;
	}

	private long accountNumber;
	private AccountType accountType;
	private double accountBalance;
	private String lastTransactionDate;

	public AccountDetails() {
		super();
	}

	public AccountDetails(long accountNumber, AccountType accountType,
			double accountBalance, String lastTransactionDate) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.lastTransactionDate = lastTransactionDate;
	}
	
	/**
	 * @return the accountNumber
	 */
	public long getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber
	 *            the accountNumber to set
	 */
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the accountType
	 */
	public AccountType getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType
	 *            the accountType to set
	 */
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	/**
	 * @return the accountBalance
	 */
	public double getAccountBalance() {
		return accountBalance;
	}

	/**
	 * @param accountBalance
	 *            the accountBalance to set
	 */
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	/**
	 * @return the lastTransactionDate
	 */
	public String getLastTransactionDate() {
		return lastTransactionDate;
	}

	/**
	 * @param lastTransactionDate
	 *            the lastTransactionDate to set
	 */
	public void setLastTransactionDate(String lastTransactionDate) {
		this.lastTransactionDate = lastTransactionDate;
	}

}
