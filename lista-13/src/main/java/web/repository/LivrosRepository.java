package web.repository;
import org.springframework.data.repository.CrudRepository;
import web.model.Livros;
public interface LivrosRepository extends CrudRepository<Livros, String>{
	
	Livros findById(long id);
}
