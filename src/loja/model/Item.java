package loja.model;

import java.math.BigDecimal;

import loja.utils.Operacoes;

public class Item{

    private Produto Produto;

    private int qtd;


    public Item(Produto Produto, int qtd){

        this.Produto = Produto;
        this.qtd = qtd;
            
    }

    public void setProduto(Produto Produto){

        this.Produto = Produto;
    }

    public void setQuantidade(int qtd){
           
        this.qtd = qtd;
        
    }

    public Produto getProduto(){

        return this.Produto;

    }

    public int getQuantidade(){
        
        return this.qtd;

    }

    public BigDecimal valorTotal(){

        return Operacoes.multiplicar(this.Produto.getPrecoVenda(), this.qtd);

    }

    @Override
    public boolean equals(Object obj){

        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Item outro = (Item) obj;

        return this.getProduto().getCodigo().equals(outro.getProduto().getCodigo());

    }

    public String toString(){

        return String.format(
            "Produto    : %s\n" +
            "Codigo     : %s\n" +
            "Quantidade : %d unidades\n" +
            "Valor      : R$ %.2f\n",
            this.Produto.getNome(), this.Produto.getCodigo(), qtd, this.valorTotal()
            );
    }

    public void exibir(){

        System.out.println(this);
    
    }


}