package modelo.ImplDAO;

import java.sql.ResultSet;
import java.util.Collection;

import mapper.AlumnoMapper;
import modelo.AbstractDAO.AlumnoDAO;
import modelo.Entity.Alumno;

public class AlumnoDAOJDBC implements AlumnoDAO {
	private final DAOFactoryJDBC daoFactoryJDBC;

	public AlumnoDAOJDBC(DAOFactoryJDBC daoFactoryJDBC) {
		super();
		this.daoFactoryJDBC = daoFactoryJDBC;
	}

	@Override
	public void create(Alumno entidad) {
		// TODO Auto-generated method stub
		
	}
	
	/////////////////////////////////////////////////////////////////////////
	/// Problemon
	///
	/**
	* Guay porque funciona. mal porque rompemos DRY al tener que implementar, casi lo mismo,
	* en todos los DAOS solucion en DRY DAO ALumno
	*/

	@Override
	public Collection<Alumno> findAll() {
		return daoFactoryJDBC.findAllGeneric("Select * from alumnos", new AlumnoMapper());
	}

	@Override
	public Alumno findById(String id) {
		String query = "select * from alumnos where Matricula like '" + id + "'";
		Collection<Alumno> resultado = daoFactoryJDBC.findAllGeneric(query, new AlumnoMapper());
		if(resultado != null && !resultado.isEmpty()) {
			return resultado.iterator().next();
		}
		return null;
	}
}
