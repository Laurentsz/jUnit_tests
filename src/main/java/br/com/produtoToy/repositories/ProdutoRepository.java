package br.com.produtoToy.repositories;

import br.com.produtoToy.domains.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository <Produto, Integer>{

    public List<Produto> findByDescricaoContainingIgnoreCase(@Param("descricao")String descricao);
}
