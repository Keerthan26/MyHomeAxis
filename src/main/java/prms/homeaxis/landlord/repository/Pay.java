package prms.homeaxis.landlord.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import prms.homeaxis.landlord.entities.Payments;

public class Pay implements RowMapper<Payments> {

	@Override
	public Payments mapRow(ResultSet rs, int rowNum) throws SQLException {

		
		return null;
	}

}
