package modelo.ImplDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

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
		ResultSet conjuntoResultados = accessJdbc.execute("SELECT * FROM persona");
		Collection<Persona> personas = new ArrayList<>();
		PersonaMapper personaMapper = new PersonaMapper();
		try {
			while (conjuntoResultados.next()) {
				personas.add(personaMapper.map(conjuntoResultados));
			} 
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return personas;
	}

	@Override
	public Optional<Persona> findById(Integer id) {
		String query = "select * from persona where id = " + id;
		ResultSet conjuntoResultados = accessJdbc.execute(query);
		PersonaMapper personaMapper = new PersonaMapper();
		try {
			if(conjuntoResultados.next()) {
				return Optional.ofNullable(personaMapper.map(conjuntoResultados));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	@Override
	public Persona findByName(String name) {
		String query = "select * from persona where nombre like '" + name + "'";
		ResultSet conjuntoResultados = accessJdbc.execute(query);
		PersonaMapper personaMapper = new PersonaMapper();
		try {
			if(conjuntoResultados.next()) {
				return personaMapper.map(conjuntoResultados);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
