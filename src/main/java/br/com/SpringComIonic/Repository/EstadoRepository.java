package br.com.SpringComIonic.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.SpringComIonic.Entity.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
