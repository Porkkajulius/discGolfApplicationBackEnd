package com.DiscGolf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.DiscGolf.model.Disc;

public class DiscRowMapper implements RowMapper<Disc> {
	public Disc mapRow(ResultSet rs, int rowNum) throws SQLException {

		Disc d = new Disc();

		d.setId(rs.getInt("dbkey"));
		d.setBrand(rs.getString("brand"));
		d.setName(rs.getString("dbkey"));
		d.setSpeed(rs.getString("speed"));
		d.setGlide(rs.getString("glide"));
		d.setTurn(rs.getString("turn"));
		d.setFade(rs.getString("fade"));

		return d;
	}
}