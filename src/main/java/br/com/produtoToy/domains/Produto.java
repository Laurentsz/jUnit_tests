package br.com.produtoToy.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="TB_PRODUTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_PRODUTO")
    private int id;

    @Column(name = "DSC_PRODUTO", nullable = false)
    private String descricao;
}
