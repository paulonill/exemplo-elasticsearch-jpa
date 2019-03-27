package br.com.pjr.exemploelasticsearchjpa.elasticsearchrepository;

import br.com.pjr.exemploelasticsearchjpa.entidade.Produto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProdutoElasticRepository extends ElasticsearchRepository<Produto, Long> {

}
