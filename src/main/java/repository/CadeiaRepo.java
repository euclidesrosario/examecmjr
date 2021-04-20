package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Cadeia;

public interface CadeiaRepo extends JpaRepository<Cadeia, Long> {

	Cadeia findByNome(String nome);

}
