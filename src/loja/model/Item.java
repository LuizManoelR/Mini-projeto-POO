package loja.model;

import java.math.BigDecimal;

import loja.utils.Operacoes;

public class Item{
    //atributos 

    private Produto Produto;

    private int qtd;

    //construtor
    public Item(Produto Produto, int qtd){

        this.Produto = Produto;
        this.qtd = qtd;
            
    }
    //setters e gettres
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
    // calcula o subtotal de um item
    public BigDecimal subTotal(){

        return Operacoes.multiplicar(this.Produto.getPrecoVenda(), this.qtd);

    }
    //calcula o imposto de um item
    public BigDecimal icmsTotal(){

        return Operacoes.multiplicar(this.Produto.getIcms(), this.qtd);

    }
    //calcula o valor total somando o subtotal com o imposto
    public BigDecimal valorTotal(){

        return Operacoes.somar(subTotal(), icmsTotal());

    }
    //metodo especifico de comparação de itens
    @Override
    public boolean equals(Object obj){

        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Item outro = (Item) obj;

        return this.getProduto().getCodigo().equals(outro.getProduto().getCodigo());

    }
    //transforma os dados do objeto em string
    public String toString(){

        return String.format(
            "Produto    : %s\n" +
            "Codigo     : %s\n" +
            "Quantidade : %d unidades\n" +
            "Valor      : R$ %.2f\n" +
            "Icms       : R$ %.2f\n" +
            "Valor Total: R$ %.2f\n",
            this.Produto.getNome(), this.Produto.getCodigo(), qtd, 
            this.subTotal(),this.icmsTotal(), this.valorTotal()
            ); 
    }
    //exibi os dados do objeto
    public void exibir(){

        System.out.println(this);
    
    }


}