package br.com.produtoToy.controllers;

import br.com.produtoToy.domains.Produto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProdutoControllerTest {

    // Classe que ajuda a simular um Postman para testarmos dentro da IDE.

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup(){
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void testaRequisicaoIdSucesso() throws Exception {
        String url = "/produtos/1";
        this.mvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect (jsonPath("descricao", equalTo("Sandália Havaianas")));

    }

    @Test
    public void testaRequisicaoIdFalha() throws Exception{
        String url = "/produtos/4";
        this.mvc.perform(get(url))
                .andExpect(status().isNotFound());
    }

    @Test
    public void TestaRequisicaoDescricaoSucesso() throws Exception {
        String url = "/produtos/search/siu";
        this.mvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("SIUUUUUUUUUU")));

    }

    @Test
    public void TestaRequisicaoDescricaoFalha() throws Exception {
        String url = "/produtos/search/AAAAAAAAAAAAAAAA";
        this.mvc.perform(get(url))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testaDeleteSucesso() throws Exception {
        String url = "/produtos/1";
        this.mvc.perform(delete(url))
                .andExpect(status().isOk())
                .andExpect (content().string(containsString("1")));

    }

    @Test
    public void testaDeleteFalha() throws Exception{
        String url = "/produtos/4";
        this.mvc.perform(delete(url))
                .andExpect(status().isNotFound());
    }

}
