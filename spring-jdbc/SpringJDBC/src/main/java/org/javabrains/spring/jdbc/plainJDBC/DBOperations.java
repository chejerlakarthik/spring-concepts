/**
 * 
 */
package org.javabrains.spring.jdbc.plainJDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.javabrains.spring.jdbc.beans.Contact;
import org.javabrains.spring.jdbc.beans.ContactDetail;
import org.javabrains.spring.jdbc.template.IContactDao;

/**
 * @author Yashoda
 *
 */
public class DBOperations implements IContactDao {

	Connection conn = null;
	PreparedStatement ps = null;

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public void doOperations() {

		try {
			Class.forName("org.postgresql.Driver");

			conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/postgres", "postgres",
					"password");
			if (conn != null)
				System.out.println("Connected to database");

			Contact contact = new Contact();
			ContactDetail detail = new ContactDetail();

			contact.setFirstName("Karthik");
			contact.setLastName("Chejerla");
			contact.setDateOfBirth(new Date(89, 06, 29));

			detail.setContactId(contact.getId());
			detail.setTelType("Mobile");
			detail.setTelNumber("8688829689");

			insert(contact);
			update(contact);

			contact.setLastName("Khan");
			delete(contact);

			List<Contact> contacts = displayAll();
			Iterator<Contact> iterator = contacts.iterator();

			while (iterator.hasNext()) {
				System.out.println(iterator.next().toString());
			}
			
			List<Contact> contactInfo = displayByName("Abhishek");

			Iterator<Contact> iter = contactInfo.iterator();

			while (iter.hasNext()) {
				System.out.println(iter.next().toString());
			}
			
		} catch (ClassNotFoundException exception) {
			System.err.println("Missing jdbc driver");
		} catch (SQLException e) {
			System.err.println("Could not establish connection to database");
			e.printStackTrace();
		} finally {

			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {

				System.out.println("Error when releasing resources");
				e.printStackTrace();
			}
		}

	}

	@Override
	public void insert(Contact contact) {

		String query = "insert into \"CK\".\"CONTACT\" values (?,?,?,?)";
		try {
			ps = conn.prepareStatement(query);
			ps.setLong(1, 1);
			ps.setString(2, contact.getFirstName());
			ps.setString(3, contact.getLastName());
			ps.setDate(4, contact.getDateOfBirth());
			int isInserted = ps.executeUpdate();
			if (isInserted > 0)
				System.out.println("Record Inserted in table CONTACT "
						+ isInserted + "." + contact.toString());

		} catch (SQLException e) {
			System.out.println("Insert failed");
			e.printStackTrace();
		}

	}

	@Override
	public void update(Contact contact) {
		String query = "UPDATE \"CK\".\"CONTACT\" SET \"FIRST_NAME\"=? WHERE \"LAST_NAME\"=?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, "UDAY SHANKAR");
			ps.setString(2, contact.getLastName());
			int isUpdated = ps.executeUpdate();
			if (isUpdated > 0)
				System.out.println("Record updated in table CONTACT "
						+ isUpdated);

		} catch (SQLException e) {
			System.out.println("Update failed");
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Contact contact) {
		String query = "DELETE FROM \"CK\".\"CONTACT\" WHERE \"LAST_NAME\"=?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, contact.getLastName());
			
			System.out.println("Deleting Record from table: " + contact.toString());
			
			int isDeleted = ps.executeUpdate();
			if (isDeleted > 0)
				System.out.println("Record deleted in table CONTACT "
						+ isDeleted);

		} catch (SQLException e) {
			System.out.println("Delete failed");
			e.printStackTrace();
		}

	}

	@Override
	public List<Contact> displayAll() {
		String query = "SELECT * FROM \"CK\".\"CONTACT\"";
		List<Contact> list = new ArrayList<Contact>();

		try {
			ps = conn.prepareStatement(query);
			ResultSet result = ps.executeQuery();

			while (result.next()) {
				Contact contact = new Contact();
				contact.setId(result.getLong(1));
				contact.setFirstName(result.getString(2));
				contact.setLastName(result.getString(3));
				contact.setDateOfBirth(result.getDate(4));
				list.add(contact);
			}

		} catch (SQLException e) {
			System.out.println("Display All failed");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Contact> displayByName(String name) {
		
		String query = "SELECT * FROM \"CK\".\"CONTACT\" WHERE \"FIRST_NAME\"=?";
		List<Contact> list = new ArrayList<Contact>();

		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ResultSet result = ps.executeQuery();

			while (result.next()) {
				Contact contact = new Contact();
				contact.setId(result.getLong(1));
				contact.setFirstName(result.getString(2));
				contact.setLastName(result.getString(3));
				contact.setDateOfBirth(result.getDate(4));
				list.add(contact);
			}

		} catch (SQLException e) {
			System.out.println("Display failed");
			e.printStackTrace();
		}
		return list;
	}

}
