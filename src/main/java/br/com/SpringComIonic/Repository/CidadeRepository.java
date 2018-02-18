package br.com.SpringComIonic.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.SpringComIonic.Entity.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
