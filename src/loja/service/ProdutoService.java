package loja.service;

import loja.model.Produto;
import loja.utils.Operacoes;
import java.math.BigDecimal;

public class ProdutoService {

    //atributos

    private BigDecimal margem;
    private BigDecimal icms;

    //construtor

    public ProdutoService(Object margem , Object icms){
        this.margem = (margem != null) ? Operacoes.toBigDecimal(margem) : new BigDecimal("0.30");
        this.icms = (icms != null) ? Operacoes.toBigDecimal(icms) : new BigDecimal("0.18");
            
    }

    //setters e getters

    public void setMargem(BigDecimal margem){

        this.margem = (margem != null) ? Operacoes.toBigDecimal(margem) : new BigDecimal("0.30");
    }

    public void setIcms(BigDecimal icms){

        this.icms = (icms != null) ? Operacoes.toBigDecimal(icms) : new BigDecimal("0.18");

    }

    public BigDecimal getMargem(){

        return margem;

    }

    public BigDecimal getIcms(){

        return icms;
    }

    /*Cria o produto calculando o preco de venda a partir do custo e da margem de lucro definida,
     *calculando o icms partir da taxa definida e do preço de venda e faz uma validação do estoque
     *caso for passado um valor menor que zero, nesse caso o estoque sera definido como zero automaticamente
     */

    public Produto criarProduto(String nome, int estoque, Object precoCusto){

        BigDecimal precoVenda = Operacoes.dividir(precoCusto, Operacoes.subtrair(1, margem));
        BigDecimal precoCustoAux = Operacoes.toBigDecimal(precoCusto);

        if(estoque >= 0){
            
            return new Produto(nome, estoque,Operacoes.multiplicar(precoVenda, icms) ,precoCustoAux, precoVenda);

        }else return new Produto(nome, 0 , Operacoes.multiplicar(precoVenda, icms) ,precoCustoAux, precoVenda);

    }
            /*O preço venda tambem é passado como parametro, porem é verificado se como esse valor
             * a margem de lucro será maior ou igual a definida, caso não seja sera definido automaticamente
             * a partir da margem de lucro e custo
             */
    public Produto criarProduto(String nome, int estoque, Object precoCusto, Object precoVenda){
        
        BigDecimal precoVendaPadrão = Operacoes.dividir(precoCusto, Operacoes.subtrair(1, margem));
        BigDecimal precoCustoBD = Operacoes.toBigDecimal(precoCusto);
        BigDecimal precoVendaBD = Operacoes.toBigDecimal(precoVenda);

        if(estoque >= 0){

            if(Operacoes.toBigDecimal(precoVenda).compareTo(precoVendaPadrão) > 0){
    
                return new Produto(nome, estoque,Operacoes.multiplicar(precoVenda, icms) ,precoCustoBD, precoVendaBD);
    
             }else return new Produto(nome, estoque,Operacoes.multiplicar(precoVenda, icms) ,precoCustoBD, precoCustoBD);
            

        }else{

            if(Operacoes.toBigDecimal(precoVenda).compareTo(precoVendaPadrão) > 0){
    
                return new Produto(nome, 0,Operacoes.multiplicar(precoVenda, icms) ,precoCustoBD, precoVendaBD);
    
             }else return new Produto(nome, 0,Operacoes.multiplicar(precoVenda, icms) ,precoCustoBD, precoCustoBD);

        }


    }

    public static void main(String[] args){

        ProdutoService ps = new ProdutoService(null, null);

        Produto p1 = ps.criarProduto("cafe", 10, 10.5f);
        Produto p2 = ps.criarProduto("arroz", 10, 25.5f);
        p1.exibir();
        p2.exibir();
    }
}
