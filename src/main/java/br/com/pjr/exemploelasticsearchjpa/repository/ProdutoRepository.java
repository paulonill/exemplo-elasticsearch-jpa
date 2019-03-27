package br.com.pjr.exemploelasticsearchjpa.repository;

import br.com.pjr.exemploelasticsearchjpa.entidade.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<Produto> findByNome(String nome);

    Optional<Produto> findByCodigo(String codigo);
}
