/**
 * 
 */
package org.javabrains.spring.jdbc.datasource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.javabrains.spring.jdbc.beans.Contact;
import org.javabrains.spring.jdbc.template.IContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 * @author Yashoda
 *
 */
@Component
public class JdbcContactDao implements IContactDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	private static final class ContactMapper implements RowMapper<Contact> {

		@Override
		public Contact mapRow(ResultSet result, int rowNum) throws SQLException {
			Contact contact = new Contact();
			contact.setId(result.getLong(1));
			contact.setFirstName(result.getString(2));
			contact.setLastName(result.getString(3));
			contact.setDateOfBirth(result.getDate(4));
			return contact;
		}

	}

	

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
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int insert(Contact contact) {
		String sql = "INSERT INTO \"CK\".\"CONTACT\" (\"ID\",\"FIRST_NAME\",\"LAST_NAME\",\"BIRTH_DATE\") VALUES(?,?,?,?)";

		return jdbcTemplate.update(sql, contact.getId(),
				contact.getFirstName(), contact.getLastName(),
				contact.getDateOfBirth());
	}

	@Override
	public int update(Contact contact) {
		String sql = "UPDATE \"CK\".\"CONTACT\" SET \"LAST_NAME\"=? WHERE \"ID\"=?";
		return jdbcTemplate.update(sql, contact.getLastName(), contact.getId());
	}

	@Override
	public int delete(Contact contact) {
		String sql = "DELETE FROM \"CK\" WHERE \"ID\" > ?";
		return jdbcTemplate.update(sql, contact.getId());
	}

	@Override
	public List<Contact> displayAll() {
		String sql = "SELECT * FROM \"CK\".\"CONTACT\" ORDER BY \"ID\"";
		return jdbcTemplate.query(sql, new ContactMapper());
	}

	@Override
	public Contact displayByName(String name) {
		String sql = "SELECT * FROM \"CK\".\"CONTACT\" WHERE \"FIRST_NAME\"=?";
		return jdbcTemplate.queryForObject(sql, Contact.class, name);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@SuppressWarnings("deprecation")
	@Override
	public int recordCount() {

		String sql = "SELECT COUNT(*) FROM \"CK\".\"CONTACT\"";
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.queryForInt(sql);
	}

}
