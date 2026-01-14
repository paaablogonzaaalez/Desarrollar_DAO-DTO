package modelo.ImplDAO;

import java.util.Collection;

import mapper.PersonaMapper;
import modelo.AbstractDAO.PersonaDAO;
import modelo.Entity.Persona;
import modelo.acceso.AccessJdbc;

public class PersonaDAOJdbc extends GenericDAOJDBC implements PersonaDAO {

	public PersonaDAOJdbc(AccessJdbc accessJdbc) {
		super(accessJdbc);
	}

	@Override
	public void create(Persona entidad) {
		// TODO Auto-generated method stub
	}

	@Override
	public Collection<Persona> findAll() {
		return findAllGeneric("select * from persona", new PersonaMapper());
	}

	@Override
	public Persona findById(Integer id) {
		String query = "select * from persona WHERE id = " + id;
		Collection<Persona> resultado = findAllGeneric(query, new PersonaMapper());
		if(resultado != null && !resultado.isEmpty()) {
			return resultado.iterator().next();
		}
		return null;
	}

	@Override
	public Persona findByName(String name) {
		String query = "select * from persona where nombre like '" + name + "'";
		Collection<Persona> resultado = findAllGeneric(query, new PersonaMapper());
		if(resultado != null && !resultado.isEmpty()) {
			return resultado.iterator().next();
		}
		return null;
	}
}
