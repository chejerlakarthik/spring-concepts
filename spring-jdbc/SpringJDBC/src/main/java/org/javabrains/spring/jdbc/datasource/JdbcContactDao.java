/**
 * 
 */
package org.javabrains.spring.jdbc.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.javabrains.spring.jdbc.beans.Contact;
import org.javabrains.spring.jdbc.template.IContactDao;

/**
 * @author Yashoda
 *
 */
public class JdbcContactDao implements IContactDao {

	private DataSource dataSource;

	/**
	 * @return the dataSource
	 */
	public DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * 
	 * 
	 * @param dataSource
	 *            the dataSource to set
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void insert(Contact contact) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Contact contact) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Contact contact) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Contact> displayAll() {
		String sql = "SELECT * FROM \"CK\".\"CONTACT\" ORDER BY \"ID\"";

		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				Contact contact = new Contact();
				contact.setId(result.getLong(1));
				contact.setFirstName(result.getString(2));
				contact.setLastName(result.getString(3));
				contact.setDateOfBirth(result.getDate(4));
				System.out.println(contact);
			}
		} catch (SQLException e) {
			System.err.println("SQL Exception caught");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Contact> displayByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
