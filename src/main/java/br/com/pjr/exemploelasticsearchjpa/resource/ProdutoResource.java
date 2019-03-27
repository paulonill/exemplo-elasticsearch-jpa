package br.com.pjr.exemploelasticsearchjpa.resource;

import br.com.pjr.exemploelasticsearchjpa.entidade.Produto;
import br.com.pjr.exemploelasticsearchjpa.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto inserir(@RequestBody Produto produto, HttpServletResponse response) {

        final Produto produtoSalvo = service.incluir(produto);

        final URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produtoSalvo.getId())
                .toUri();

        response.setHeader(HttpHeaders.LOCATION, uri.toString());

        return produtoSalvo;
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produto alterar(@RequestBody Produto produto,
                           @PathVariable(value = "id") Long id) {

        return service.alterar(produto, id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable("id") Long id) {

        service.excluir(id);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Produto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produto pesquisarPorId(@PathVariable("id") Long id) {

        return service.pesquisarPorId(id);

    }
}
