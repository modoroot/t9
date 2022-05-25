package actividades.uno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase para manejar los registros de la DB planetas
 * 
 * @author amna
 * @version 1.0
 */
public class OperacionesDb {
	private DbConn dbconn;
	private Planeta planeta;
	private Connection conn;
	private PreparedStatement ps;
	private String sql;
	private ResultSet rs;

	/**
	 * Constructor que conecta con la DB y recoge los parámetros de Planeta
	 * a través de instancias de la clase
	 */
	public OperacionesDb() {
		dbconn = new DbConn();
		planeta = new Planeta();
	}
	/**
	 * método que inserta registros en la DB
	 * @param id identificador único del nuevo registro
	 * @param nombre nombre del nuevo planeta
	 * @param radio radio del nuevo planeta (km)
	 * @param densidad densidad del nuevo planeta (g/cm^3)
	 * @param velocidad velocidad de escape del nuevo planeta (km/s)
	 */
	public void insertar(int id, String nombre, double radio, double densidad, double velocidad) {
		planeta.setId(id);
		planeta.setNombre(nombre);
		planeta.setRadio(radio);
		planeta.setDensidad(densidad);
		planeta.setVelocidad(velocidad);
		try {
			conn = dbconn.getConexion();
			sql = "INSERT INTO planetas (id,nombre, radio, densidad, velocidad) VALUES(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, planeta.getId());
			ps.setString(2, planeta.getNombre());
			ps.setDouble(3, planeta.getRadio());
			ps.setDouble(4, planeta.getDensidad());
			ps.setDouble(5, planeta.getVelocidad());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * método que elimina un registro según el id introducido
	 * @param id identificador del registro a eliminar
	 */
	public void eliminar(int id) {
		try {
			conn = dbconn.getConexion();
			sql = "DELETE FROM planetas WHERE planetas.id = "+id;
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Método que modifica un registro existente pasándole el id
	 * @param id identificador único ya existente
	 * @param modNombre nuevo nombre
	 * @param modRadio nuevo radio
	 * @param modDensidad nueva densidad
	 * @param modVelocidad nueva velocidad
	 */
	public void modificar(int id, String modNombre, double modRadio, double modDensidad, double modVelocidad) {
		try {
			conn = dbconn.getConexion();
			sql ="UPDATE planetas SET nombre = "+"'"+modNombre+"'"+", radio = "+"'"+modRadio+"'"+", densidad = "
					+"'"+modDensidad+"'"+", velocidad = "+"'"+modVelocidad+"'"+" WHERE planetas.id = "+id;
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método que filtra los registros de la DB por un String
	 * determinado de una columna tipo VARCHAR
	 * @param columnNameTypeString nombre de la columna donde se quiere buscar el string
	 * @param filteredWord palabra exacta que será buscada en la tabla
	 * @param columnOrder columna la cual será ordenada de manera asc. o desc.
	 * @param orderByX introducir "ASC" para ascendente y "DESC" para descendente 
	 */
	public void filtrarString(String columnNameTypeString, String filteredWord, String columnOrder, String orderByX) {
		planeta.setNombre(filteredWord);
		try {
			conn = dbconn.getConexion();
			sql = "SELECT * FROM planetas WHERE planetas."+columnNameTypeString+" = ? ORDER BY planetas."+columnOrder+" "+orderByX;
			ps = conn.prepareStatement(sql);
			ps.setString(1, filteredWord);
			rs = ps.executeQuery();
			System.out.print("ID-Nombre-Radio-Densidad-Velocidad de escape"+"\n");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+", "+rs.getString(2)+", "+rs.getDouble(3)+", "+rs.getDouble(4)+", "
						+rs.getDouble(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método que filtra los registros de la DB por un rango de int
	 * determinado de una columna tipo INT
	 * @param columnNameTypeInt nombre de la columna donde se quiere buscar el 
	 * rango de int
	 * @param filteredMinInt int mínimo que mostrará (inclusive)
	 * @param filteredMaxInt int máximo que mostrará (inclusive)
	 * @param columnOrder columna la cual será ordenada de manera asc. o desc.
	 * @param orderByX introducir "ASC" para ascendente y "DESC" para descendente
	 */
	public void filtrarInt(String columnNameTypeInt, int filteredMinInt, 
			int filteredMaxInt, String columnOrder, String orderByX) {
		try {
			conn = dbconn.getConexion();
			sql = "SELECT * FROM planetas WHERE planetas."+columnNameTypeInt+">="+filteredMinInt
					+" AND "+"planetas."+columnNameTypeInt+"<="+filteredMaxInt+" ORDER BY planetas."+columnOrder+" "+orderByX;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.print("ID-Nombre-Radio-Densidad-Velocidad de escape"+"\n");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+", "+rs.getString(2)+", "+rs.getDouble(3)+", "+rs.getDouble(4)+", "
						+rs.getDouble(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método que filtra los registros de una DB por un 
	 * rango de dos números tipo double
	 * @param columnNameTypeDouble nombre de la columna tipo double donde se quiere
	 * buscar el rango de double
	 * @param filteredMinDouble double mínimo que mostrará si existe (inclusive)
	 * @param filteredMaxDouble double máximo que mostrará si existe (inclusive)
	 * @param columnOrder columna la cual será ordenada de manera asc. o desc.
	 * @param orderByX "ASC" para ascendente y "DESC" para descendente
	 */
	public void filtrarDouble(String columnNameTypeDouble, double filteredMinDouble,
			double filteredMaxDouble, String columnOrder, String orderByX) {
		try {
			conn = dbconn.getConexion();
			sql = "SELECT * FROM planetas WHERE planetas."+columnNameTypeDouble+">="+filteredMinDouble
					+" AND "+"planetas."+columnNameTypeDouble+"<="+filteredMaxDouble+" ORDER BY planetas."+columnOrder+" "+orderByX;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.print("ID-Nombre-Radio-Densidad-Velocidad de escape"+"\n");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+", "+rs.getString(2)+", "+rs.getDouble(3)+", "+rs.getDouble(4)+", "
						+rs.getDouble(5));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
