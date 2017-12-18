package a2;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.core.RowMapper;



import java.sql.ResultSet;
import java.sql.SQLException;

public class AlbaranesDaoImpl extends JdbcDaoSupport implements AlbaranesDao{

	public Albaranes getItem(int alba) {

		StringBuffer sql = new StringBuffer();

		sql
		.append(" SELECT albaran, cliente, estado,formpago")
		.append(" FROM ").append("albaranes")
		.append(" WHERE albaran = ?");

		Object[] params = new Object[] { alba };

		Albaranes it = (Albaranes) getJdbcTemplate().queryForObject( sql.toString(), params, new ItemRowMapper());


		return it;

	}


	public void updateItem(Albaranes alba) {

		StringBuffer sql = new StringBuffer();
		sql
		.append("UPDATE ").append("albaranes")
		.append(" SET estado = ? ,formpago = ?")
		.append(" WHERE albaran = ?");

		Object[] params = new Object[] {
				alba.getAlbaran(),
				alba.getEstado(),
				alba.getCliente(),
				alba.getPago()
		};

		getJdbcTemplate().update(sql.toString(), params);

	}

	public void insertItem(Albaranes alba) {
		StringBuffer sql = new StringBuffer();

		sql
		.append("INSERT INTO ").append("albaranes")
		.append(" (albaran, cliente, estado, formpago) ")
		.append("VALUES(?,?,?,?)");

		Object[] params = new Object[] {
				alba.getAlbaran(),
				alba.getCliente(),
				alba.getEstado(),
				alba.getPago()
		};

		getJdbcTemplate().update(sql.toString(), params);

	}

	public void deleteItem(int alba) {
		StringBuffer sql = new StringBuffer();

		sql
		.append("DELETE FROM ").append("albaranes")
		.append(" WHERE albaran = ? ");

		Object[] params = new Object[] {alba};

		getJdbcTemplate().update(sql.toString(), params);


	}
	class ItemRowMapper implements RowMapper {

		public Object mapRow(ResultSet rs, int index) throws SQLException {

			Albaranes it = new Albaranes();

			it.setAlbaran(rs.getInt("albaran"));
			it.setCliente(new Integer(rs.getInt("cliente")));
			it.setEstado(rs.getString("estado"));
			it.setPago(rs.getString("formpago"));




			return it;
		}
	}
}