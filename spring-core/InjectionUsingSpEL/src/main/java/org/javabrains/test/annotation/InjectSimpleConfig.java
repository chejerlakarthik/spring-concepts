/**
 * 
 */
package org.javabrains.test.annotation;

import java.math.BigInteger;

import org.springframework.stereotype.Component;

/**
 * @author Yashoda
 *
 */
@Component("InjectSimpleConfig")
public class InjectSimpleConfig {

	private String name = "Karthik";
	private BigInteger mobileNumber = new BigInteger("8688829689");
	private int age = 25;
	private String profession = "Software Engineer";
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the mobileNumber
	 */
	public BigInteger getMobileNumber() {
		return mobileNumber;
	}
	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(BigInteger mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the profession
	 */
	public String getProfession() {
		return profession;
	}
	/**
	 * @param profession the profession to set
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}

}
