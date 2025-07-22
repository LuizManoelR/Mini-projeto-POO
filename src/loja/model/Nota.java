package loja.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import loja.service.ItemService;
import loja.service.ProdutoService;
import loja.utils.Operacoes;

public class Nota{

    //atributos

    private Cliente cliente;

    private String codigo;

    private LocalDateTime data;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private String dataformatada;

    private static int ultimo = 1;

    private int tamanho;
   
    private Item[] carrinho;
    //construtor
    public Nota(Cliente cliente){

        this.cliente = cliente;

        data = LocalDateTime.now();

        dataformatada = data.format(formatter);

        this.codigo = String.format("NF%04d", ultimo++);

        tamanho = 0;

        carrinho = new Item[100];

    }

    //getters e setters

    public Cliente getCliente(){return cliente;}

    public String getCodigo(){return codigo;}

    public int getTamanho(){return tamanho;}
    
    public Item[] getCarrinho(){return carrinho;}

    public LocalDateTime getData(){return data;}

    public void setCliente(Cliente cliente){this.cliente = cliente;}

    public  void setTamanho(int tamanho){this.tamanho = tamanho;}
    
    public  void setCarrinho(Item[] carrinho){this.carrinho = carrinho;}
    public  void setCarrinho(int i, Item carrinho){this.carrinho[i] = carrinho;}

    //calcula o valor total de todos os itens somando o subtotal com o imposto
    public BigDecimal valorTotal(){

        BigDecimal n = new BigDecimal("0");

        for(int i = 0; i < tamanho; i++){

            n = Operacoes.somar(n, carrinho[i].valorTotal());
            
        }
        return n;

    }

    //calcula o subtotal de todos itens
    public BigDecimal subTotal(){

        BigDecimal n = new BigDecimal("0");

        for(int i = 0; i < tamanho; i++){

            n = Operacoes.somar(n, carrinho[i].subTotal());
            
        }
        return n;

    }

    //calcula o icms de todos os itens
    public BigDecimal icmsTotal(){

        BigDecimal n = new BigDecimal("0");

        for(int i = 0; i < tamanho; i++){

            n = Operacoes.somar(n, carrinho[i].icmsTotal());
            
        }
        return n;

    }
    //exibi a nota fiscal com os dados do cliente, a data e os itens
    public void exibir(){
        System.out.printf("-------------------------------- NOTA FISCAL --------------------------------\n\n");
        System.out.printf("%-11s: %-30s | %-7s: %-20s\n" + 
                           "%-11s: %-30s | %-7s: %-20s\n\n",
                            "Cliente",cliente.getNome(),"CPF",cliente.getCpf(), 
                            "TEL",cliente.getTelefone(),"E-MAIL",cliente.getEmail());

        System.out.printf("Data       : %s\n",dataformatada);
        System.out.printf("Codigo     : %s\n\n",codigo);

        for(int i = 0; i < tamanho; i++){

            carrinho[i].exibir();
        }
        System.out.printf("SubTotal   :   R$ %.2f\n",this.subTotal());
        System.out.printf("Icms Total : + R$ %.2f\n\n",this.icmsTotal());
        System.out.printf("Valor Total: = R$ %.2f\n\n",this.valorTotal());
    }
  
    

   public static void main(String [] args){


        ProdutoService ps = new ProdutoService(null, null);

        Produto p1 = ps.criarProduto("cafe", 10, 10.5f);
        Produto p2 = ps.criarProduto("arroz", 10, 25.5f);
        
        Cliente c1 = new Cliente(  
                                "07252974502", 
                                "Luiz Meneses", 
                                "luiznmeneses@gmail.com", 
                                "79996383001");

        p1.exibir();
        p2.exibir();

        Item i1 = ItemService.criarItem(p1,2);
        Item i2 = ItemService.criarItem(p2,2);

        i1.exibir();
        i2.exibir();

        Nota n1 = new Nota(c1);

       

        n1.exibir();
        




}
}


