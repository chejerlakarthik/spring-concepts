/**
 * 
 */
package org.javabrains.spring.jdbc.datasource;

import org.javabrains.spring.jdbc.beans.Contact;
import org.javabrains.spring.jdbc.template.IContactDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

/**
 * @author Yashoda
 *
 */
@Component
public class JdbcContactDao extends JdbcDaoSupport implements IContactDao {

	@Override
	public int insert(Contact contact) {
		String sql = "INSERT INTO \"CK\".\"CONTACT\" (\"contact_id\",\"first_name\",\"last_name\",\"work_company\") VALUES(?,?,?,?)";
		return getJdbcTemplate().update(sql, contact.getContactId(),
				contact.getFirstName(), contact.getLastName(),
				contact.getWorkCompany());
	}

}
