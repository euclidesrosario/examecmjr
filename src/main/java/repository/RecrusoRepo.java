package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Recruso;

public interface RecrusoRepo extends JpaRepository<Recruso, Long> {
	Recruso findById( long id);

	Recruso findByNome(String nome);

}
