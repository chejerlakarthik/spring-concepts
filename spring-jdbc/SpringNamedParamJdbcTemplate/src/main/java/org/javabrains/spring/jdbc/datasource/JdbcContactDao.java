/**
 * 
 */
package org.javabrains.spring.jdbc.datasource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.javabrains.spring.jdbc.beans.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

/**
 * @author Yashoda
 *
 */
@Component
public class JdbcContactDao implements IContactDao {

	private DataSource dataSource;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

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
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
	}

	@Override
	public int insert(Contact contact) {
		String sql = "INSERT INTO \"CK\".\"CONTACT\" (\"ID\",\"FIRST_NAME\",\"LAST_NAME\",\"BIRTH_DATE\") VALUES(:id,:first,:last,:birth_date)";

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("id", contact.getId());
		map.put("first", contact.getFirstName());
		map.put("last", contact.getLastName());
		map.put("birth_date", contact.getDateOfBirth());

		SqlParameterSource namedParams = new MapSqlParameterSource(map);
		return namedParameterJdbcTemplate.update(sql, namedParams);
	}

	@Override
	public int update(Contact contact) {
		String sql = "UPDATE \"CK\".\"CONTACT\" SET \"FIRST_NAME\"=:first,\"LAST_NAME\"=:last WHERE \"ID\"=:id";
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("id", contact.getId());
		map.put("first", contact.getFirstName());
		map.put("last", contact.getLastName());

		SqlParameterSource namedParam = new MapSqlParameterSource(map);
		return namedParameterJdbcTemplate.update(sql, namedParam);
	}

	@Override
	public int delete(Contact contact) {
		String sql = "DELETE FROM \"CK\".\"CONTACT\" WHERE \"ID\" > :id";
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("id", contact.getId());

		SqlParameterSource namedParam = new MapSqlParameterSource(map);
		return namedParameterJdbcTemplate.update(sql, namedParam);
	}

	@Override
	public List<Contact> displayAll() {
		String sql = "SELECT * FROM \"CK\".\"CONTACT\" ORDER BY \"ID\"";
		return namedParameterJdbcTemplate.query(sql, new ContactMapper());
	}

	@Override
	public Contact displayByFirstName(String name) {

		String sql = "SELECT * FROM \"CK\".\"CONTACT\" WHERE \"FIRST_NAME\"=:first_name";

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("first_name", name);

		SqlParameterSource namedParam = new MapSqlParameterSource(map);
		return namedParameterJdbcTemplate.queryForObject(sql, namedParam,
				new ContactMapper());
	}

	/**
	 * @return the namedParameterJdbcTemplate
	 */
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	/**
	 * @param namedParameterJdbcTemplate
	 *            the namedParameterJdbcTemplate to set
	 */
	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public int recordCount() {

		return 0;
	}

	@Override
	public List<Contact> displayContactwithDetail() {
		
		return null;
	}
}
