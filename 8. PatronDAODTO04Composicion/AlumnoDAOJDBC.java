package modelo.ImplDAO;

import java.util.Collection;

import mapper.AlumnoMapper;
import modelo.AbstractDAO.AlumnoDAO;
import modelo.Entity.Alumno;

public class AlumnoDAOJDBC implements AlumnoDAO {

	private GenericComponentDAOJDBC genericComponentDAOJDBC;

	public AlumnoDAOJDBC(GenericComponentDAOJDBC genericComponentDAOJDBC) {
		super();
		this.genericComponentDAOJDBC = genericComponentDAOJDBC;
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
		return genericComponentDAOJDBC.findAllGeneric("select * from alumnos", new AlumnoMapper());
	}

	@Override
	public Alumno findById(String id) {
		String query = "select * from alumnos where Matricula like '" + id + "'";
		Collection<Alumno> resultado = genericComponentDAOJDBC.findAllGeneric(query, new AlumnoMapper());
		if(resultado != null && !resultado.isEmpty()) {
			return resultado.iterator().next();
		}
		return null;
	}
}
