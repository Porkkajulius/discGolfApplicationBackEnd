package com.DiscGolf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.DiscGolf.model.User;

public class UserRowMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

		User u = new User();

		u.setId(rs.getInt("dbkey"));
		u.setFirstName(rs.getString("firstname"));
		u.setLastName(rs.getString("lastname"));
		u.setNickName(rs.getString("nickname"));
		return u;
	}
}