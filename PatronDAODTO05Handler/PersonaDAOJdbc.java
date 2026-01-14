package modelo.ImplDAO;

import java.util.Collection;
import java.util.Optional;

import handler.CollectionHandler;
import handler.OptionalHandler;
import mapper.PersonaMapper;
import modelo.AbstractDAO.PersonaDAO;
import modelo.Entity.Persona;
import modelo.acceso.AccessJdbc;

public class PersonaDAOJdbc implements PersonaDAO {

	private AccessJdbc accessJdbc;

	public PersonaDAOJdbc(AccessJdbc accessJdbc) {
		super();
		this.accessJdbc = accessJdbc;
	}

	@Override
	public void create(Persona entidad) {
		// TODO Auto-generated method stub
	}

	@Override
	public Collection<Persona> findAll() {
		return accessJdbc.execute("select * from persona", new CollectionHandler<Persona>(new PersonaMapper()));
	}

	@Override
	public Persona findById(Integer id) {
		String query = "Select * from persona where id = " + id;
		Optional<Persona> resultado = accessJdbc.execute(query, new OptionalHandler<Persona>(new PersonaMapper()));
		return resultado.orElse(null);
	}

	@Override
	public Persona findByName(String name) {
		String query = "select * from persona where nombre like '" + name + "'";
		Optional<Persona> resultado = accessJdbc.execute(query, new OptionalHandler<Persona>(new PersonaMapper()));
		return resultado.orElse(null);
	}
}
