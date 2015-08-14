/**
 * 
 */
package org.javabrains.test.xml;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author Yashoda
 *
 */
public class CollectionBean {

	private Map<Integer, String> employeeNamesByEmployeeId;
	private Properties studentNamesByRollNumber;
	private Set<String> setOfStateCapitalCities;
	private List<String> listOfIplTeams;

	/**
	 * @return the employeeNamesByEmployeeId
	 */
	public Map<Integer, String> getEmployeeNamesByEmployeeId() {
		return employeeNamesByEmployeeId;
	}

	/**
	 * @param employeeNamesByEmployeeId
	 *            the employeeNamesByEmployeeId to set
	 */
	public void setEmployeeNamesByEmployeeId(
			Map<Integer, String> employeeNamesByEmployeeId) {
		this.employeeNamesByEmployeeId = employeeNamesByEmployeeId;
	}

	/**
	 * @return the studentNamesByRollNumber
	 */
	public Properties getStudentNamesByRollNumber() {
		return studentNamesByRollNumber;
	}

	/**
	 * @param studentNamesByRollNumber
	 *            the studentNamesByRollNumber to set
	 */
	public void setStudentNamesByRollNumber(Properties studentNamesByRollNumber) {
		this.studentNamesByRollNumber = studentNamesByRollNumber;
	}

	/**
	 * @return the setOfStateCapitalCities
	 */
	public Set<String> getSetOfStateCapitalCities() {
		return setOfStateCapitalCities;
	}

	/**
	 * @param setOfStateCapitalCities
	 *            the setOfStateCapitalCities to set
	 */
	public void setSetOfStateCapitalCities(Set<String> setOfStateCapitalCities) {
		this.setOfStateCapitalCities = setOfStateCapitalCities;
	}

	/**
	 * @return the listOfIplTeams
	 */
	public List<String> getListOfIplTeams() {
		return listOfIplTeams;
	}

	/**
	 * @param listOfIplTeams
	 *            the listOfIplTeams to set
	 */
	public void setListOfIplTeams(List<String> listOfIplTeams) {
		this.listOfIplTeams = listOfIplTeams;
	}

	public void displayInfo() {

		// display the map
		System.out.println("-------------Map Values--------------");
		for (Map.Entry<Integer, String> mapEntry : employeeNamesByEmployeeId
				.entrySet()) {
			System.out.println(mapEntry.getKey() + "-" + mapEntry.getValue());
		}

		// display the Properties
		System.out.println("-------------Properties Values-------");
		for (Map.Entry<Object, Object> property : studentNamesByRollNumber
				.entrySet()) {
			System.out.println(property.getKey() + "-" + property.getValue());
		}
		
		// display the Set values
		System.out.println("-------------Set Values-------");
		for (String entry : setOfStateCapitalCities) {
			System.out.println(entry);
		}

		// display the List values
		System.out.println("-------------List Values-------");
		for (String iplTeam : listOfIplTeams )
			System.out.println(iplTeam);
	}
}
