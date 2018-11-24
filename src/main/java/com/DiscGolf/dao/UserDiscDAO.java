package com.DiscGolf.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.DiscGolf.model.Disc;
import com.DiscGolf.model.User;

@Repository
public class UserDiscDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	/*
	 * Returns all users from MariaDB database as list
	 */
	public List<User> getAllUsers() {
		final String selectAllFromUser = "select * from user";
		RowMapper<User> mapper = new UserRowMapper();
		List<User> userList = jdbcTemplate.query(selectAllFromUser, mapper);
		return userList;

	}

	/*
	 * Returns all discs from MariaDB database as list
	 */
	public List<Disc> getAllDiscs() {
		final String selectAllFromDisc = "select * from disc";
		RowMapper<Disc> mapper = new DiscRowMapper();
		List<Disc> discList = jdbcTemplate.query(selectAllFromDisc, mapper);
		return discList;

	}

	/*
	 * Returns all discs of certain user from MariaDB database as list
	 */
	public List<Disc> getAllDiscsByUserId(int id) {
		final String selectAllFromDiscsByUserId = "select * from disc d where exists ( "
				+ "select ud.disc_id from user_discs ud where d.dbkey=ud.disc_id and ud.user_id=" + id + ")";

		RowMapper<Disc> mapper = new DiscRowMapper();
		List<Disc> discList = jdbcTemplate.query(selectAllFromDiscsByUserId, mapper);
		return discList;

	}

}
