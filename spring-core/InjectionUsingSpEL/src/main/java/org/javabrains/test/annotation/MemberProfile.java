/**
 * 
 */
package org.javabrains.test.annotation;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Yashoda
 *
 */
@Service("MemberProfile")
public class MemberProfile implements IProfile {

	@Value("#{injectSimpleConfig.name}")
	private String name;
	@Value("#{injectSimpleConfig.mobileNumber}")
	private BigInteger mobileNumber;
	@Value("#{injectSimpleConfig.age + 15}")
	private int age;
	@Value("#{injectSimpleConfig.profession}")
	private String profession;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
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
	 * @param mobileNumber
	 *            the mobileNumber to set
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
	 * @param age
	 *            the age to set
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
	 * @param profession
	 *            the profession to set
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MemberProfile [name=" + name + ", mobileNumber=" + mobileNumber
				+ ", age=" + age + ", profession=" + profession + "]";
	}
}
