package modelo.ImplDAO;

import java.util.Collection;

import mapper.PersonaMapper;
import modelo.AbstractDAO.PersonaDAO;
import modelo.Entity.Persona;
import modelo.acceso.AccessJdbc;

public class PersonaDAOJdbc implements PersonaDAO {

	private DAOFactoryJDBC daoFactoryJDBC;

	public PersonaDAOJdbc(DAOFactoryJDBC daoFactoryJDBC) {
		super();
		this.daoFactoryJDBC = daoFactoryJDBC;
	}

	@Override
	public void create(Persona entidad) {
		// TODO Auto-generated method stub
	}

	@Override
	public Collection<Persona> findAll() {
		return daoFactoryJDBC.findAllGeneric("select * from persona", new PersonaMapper());
	}

	@Override
	public Persona findById(Integer id) {
		String query = "select * from persona where id = " + id;
		Collection<Persona> resultado = daoFactoryJDBC.findAllGeneric(query, new PersonaMapper());
		if(resultado != null && !resultado.isEmpty()) {
			return resultado.iterator().next();
		}
		return null;
	}

	@Override
	public Persona findByName(String name) {
		String query = "select * from persona where nombre like '" + name + "'";
		Collection<Persona> resultado = daoFactoryJDBC.findAllGeneric(query, new PersonaMapper());
		if(resultado != null && !resultado.isEmpty()) {
			return resultado.iterator().next();
		}
		return null;
	}
}
