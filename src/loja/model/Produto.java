package loja.model;

import java.math.BigDecimal;
import loja.utils.Operacoes;

public class Produto{

    private String codigo;

    private String nome;

    private int estoque;

    private BigDecimal precoCusto;

    private BigDecimal precoVenda;

    private BigDecimal icms;

    private static int ultimo = 1;

    public Produto(String nome, int estoque, BigDecimal icms,BigDecimal precoCusto, BigDecimal precoVenda){

        this.codigo = String.format("P%04d", ultimo++);

        this.nome = nome;

        this.estoque = estoque;

        this.precoCusto = precoCusto;

        this.precoVenda = precoVenda;
        
        this.icms = icms;
    }

    public void setNome(String nome){

        this.nome = nome;
    }

    public void setEstoque(int estoque){

        this.estoque = estoque;
    }

    public void setPrecoCusto(BigDecimal precoCusto){

        this.precoCusto = precoCusto;
    }

    public void setPrecoVenda(BigDecimal precoVenda){
        
        this.precoVenda = precoVenda;

    }

    public void setIcms(BigDecimal icms){this.icms = icms;}
    
    public String getCodigo(){

        return this.codigo;

    }

    public String getNome(){

        return this.nome;

    }

    public int getEstoque(){

        return this.estoque;

    }

    public BigDecimal getPrecoCusto(){

        return this.precoCusto;

    }

    public BigDecimal getPrecoVenda(){

        return this.precoVenda;

    }

    public BigDecimal getIcms(){

        return icms;

    }

    public BigDecimal calcularMargemLucro(){

        return Operacoes.dividir(Operacoes.subtrair(this.precoVenda , this.precoCusto), this.precoVenda);

    }

    public String toString(){

        return String.format(
            "Produto        : %s\n" +
            "Codigo         : %s\n" +
            "Estoque        : %d unidades\n" +
            "Preco Custo    : R$ %.2f\n" +
            "Preco Venda    : R$ %.2f\n" +
            "Icms           : R$ %.2f\n" +
            "Margem de Lucro: %.1f%%\n",
            nome, codigo, estoque, precoCusto, precoVenda,icms,Operacoes.multiplicar(this.calcularMargemLucro(),100)
            );
    }

    public void exibir(){

        System.out.println(this);
    
    }

}