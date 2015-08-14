/**
 * 
 */
package org.javabrains.spring.jdbc.datasource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.javabrains.spring.jdbc.beans.Contact;
import org.javabrains.spring.jdbc.beans.ContactDetail;
import org.javabrains.spring.jdbc.template.IContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

/**
 * @author Yashoda
 *
 */
@Component
public class JdbcContactDao implements IContactDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	private static final class ContactResultSetExtractor implements
			ResultSetExtractor<List<Contact>> {

		@Override
		public List<Contact> extractData(ResultSet result) throws SQLException,
				DataAccessException {

			Map<Long, Contact> map = new HashMap<Long, Contact>();

			Contact contact = null;
			while (result.next()) {
				Long id = result.getLong("CONTACT_ID");
				contact = map.get(id);
				if (contact == null) {
					contact = new Contact();
					contact.setContactId(result.getLong("CONTACT_ID"));
					contact.setFirstName(result.getString("FIRST_NAME"));
					contact.setLastName(result.getString("LAST_NAME"));
					contact.setWorkCompany(result.getString("WORK_COMPANY"));
					contact.setContactDetails(new ArrayList<ContactDetail>());
					map.put(id, contact);
				}
				Long contactDetailId = result.getLong("CONTACT_TEL_ID");
				if (contactDetailId > 0) {
					ContactDetail contactDetail = new ContactDetail();
					contactDetail.setId(contactDetailId);
					contactDetail.setContactId(id);
					contactDetail.setTelType(result.getString("TEL_TYPE"));
					contactDetail.setTelNumber(result.getString("TEL_NUMBER"));
					contact.getContactDetails().add(contactDetail);
				}
			}
			return new ArrayList<Contact>(map.values());
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
	public List<Contact> displayContactWithDetail() {
		String sql = "Select * from \"CK\".\"CONTACT\" c JOIN \"CK\".\"CONTACT_TEL_INFO\" t on c.CONTACT_TEL_ID = t.CONTACT_TEL_ID";
		return jdbcTemplate.query(sql, new ContactResultSetExtractor());
	}
}
