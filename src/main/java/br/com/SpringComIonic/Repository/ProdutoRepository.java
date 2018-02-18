package br.com.SpringComIonic.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.SpringComIonic.Entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
