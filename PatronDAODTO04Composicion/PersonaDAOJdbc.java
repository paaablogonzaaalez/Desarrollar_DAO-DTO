package modelo.ImplDAO;

import java.util.Collection;

import mapper.PersonaMapper;
import modelo.AbstractDAO.PersonaDAO;
import modelo.Entity.Persona;

public class PersonaDAOJdbc implements PersonaDAO {

	private GenericComponentDAOJDBC genericComponentDAOJDBC;

	public PersonaDAOJdbc(GenericComponentDAOJDBC genericComponentDAOJDBC) {
		super();
		this.genericComponentDAOJDBC = genericComponentDAOJDBC;
	}

	@Override
	public void create(Persona entidad) {
		// TODO Auto-generated method stub
	}

	@Override
	public Collection<Persona> findAll() {
		return genericComponentDAOJDBC.findAllGeneric("select * from persona", new PersonaMapper());
	}

	@Override
	public Persona findById(Integer id) {
		String query = "select * from persona where id = " + id;
		Collection<Persona> resultado = genericComponentDAOJDBC.findAllGeneric(query, new PersonaMapper());
		if(resultado != null && !resultado.isEmpty()) {
			return resultado.iterator().next();
		}
		return null;
	}

	@Override
	public Persona findByName(String name) {
		String query = "select * from persona where nombre like '" + name + "'";
		Collection<Persona> resultado = genericComponentDAOJDBC.findAllGeneric(query, new PersonaMapper());
		if(resultado != null && !resultado.isEmpty()) {
			return resultado.iterator().next();
		}
		return null;
	}
}
