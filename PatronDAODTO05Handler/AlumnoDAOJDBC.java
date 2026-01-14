package modelo.ImplDAO;

import java.util.Collection;
import java.util.Optional;

import handler.CollectionHandler;
import handler.OptionalHandler;
import mapper.AlumnoMapper;
import modelo.AbstractDAO.AlumnoDAO;
import modelo.Entity.Alumno;
import modelo.acceso.AccessJdbc;

public class AlumnoDAOJDBC implements AlumnoDAO {

	private AccessJdbc accessJdbc;

	public AlumnoDAOJDBC(AccessJdbc accessJdbc) {
		super();
		this.accessJdbc = accessJdbc;
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
		return accessJdbc.execute("select * from alumnos", new CollectionHandler<Alumno>(new AlumnoMapper()));
	}

	@Override
	public Alumno findById(String id) {
		String query = "select * from alumnos where Matricula like '" + id + "'";
		Optional<Alumno> resultado = accessJdbc.execute(query, new OptionalHandler<Alumno>(new AlumnoMapper()));
		return resultado.orElse(null);
	}
}
