/**
 * 
 */
package org.javabrains.karthik;

/**
 * @author Yashoda
 *
 */
public class Address {

	private String doorNumber;
	private String buildingName;
	private String streetName;
	private String locality;
	private String pincode;

	/**
	 * @return the doorNumber
	 */
	public String getDoorNumber() {
		return doorNumber;
	}

	/**
	 * @param doorNumber
	 *            the doorNumber to set
	 */
	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}

	/**
	 * @return the buildingName
	 */
	public String getBuildingName() {
		return buildingName;
	}

	/**
	 * @param buildingName
	 *            the buildingName to set
	 */
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * @param streetName
	 *            the streetName to set
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * @return the locality
	 */
	public String getLocality() {
		return locality;
	}

	/**
	 * @param locality
	 *            the locality to set
	 */
	public void setLocality(String locality) {
		this.locality = locality;
	}

	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}

	/**
	 * @param pincode
	 *            the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[doorNumber=" + doorNumber + ", buildingName="
				+ buildingName + ", streetName=" + streetName + ", locality="
				+ locality + ", pincode=" + pincode + "]";
	}

	
}
