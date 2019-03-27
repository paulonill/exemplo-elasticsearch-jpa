package br.com.pjr.exemploelasticsearchjpa.service;

import br.com.pjr.exemploelasticsearchjpa.elasticsearchrepository.ProdutoElasticRepository;
import br.com.pjr.exemploelasticsearchjpa.entidade.Produto;
import br.com.pjr.exemploelasticsearchjpa.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ProdutoElasticRepository elasticRepository;

    @Transactional
    public Produto incluir(final Produto produto) {

        produto.setId(null);

        Produto produtoSalvo = repository.save(produto);

        elasticRepository.save(produtoSalvo);

        return repository.save(produtoSalvo);
    }

    @Transactional
    public Produto alterar(final Produto produto, Long id) {

        Produto produtoPesquisado = pesquisarPorId(id);

        BeanUtils.copyProperties(produto, produtoPesquisado);

        final Produto produtoAlterado = repository.save(produtoPesquisado);

        elasticRepository.save(produtoAlterado);

        return produtoAlterado;

    }

    @Transactional
    public void excluir(final Long id) {

        repository.deleteById(id);

        elasticRepository.existsById(id);
    }

    public Produto pesquisarPorId(final Long id) {

        //System.out.println("Produto: " + elasticRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1)));

        System.out.println("Produto: " + repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1)));

        return elasticRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    public Iterable<Produto> listar() {

         repository.findAll().forEach(p -> System.out.println(p));

        return elasticRepository.findAll();
    }

}
