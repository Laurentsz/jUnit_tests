package br.com.produtoToy.repositories;

import br.com.produtoToy.domains.Produto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProdutoRepositoryTest {

    @Autowired
    private ProdutoRepository rep;

    @Test
    public void testaProdutoHavaianas(){
        List<Produto> produtos = rep.findByDescricaoContainingIgnoreCase("Havai");
        assertThat(produtos.size()).isEqualTo(1);

    }

    @Test
    public void testaIdHavaiana(){
        Optional<Produto> produtos = rep.findById(1);
        assertThat(produtos.get().getDescricao().equals("Ipanema"));

    }

}
