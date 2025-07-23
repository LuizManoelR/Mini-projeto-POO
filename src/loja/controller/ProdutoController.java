package loja.controller;

import loja.model.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoController {
    // Atributos
    private List<Produto> produtos;

    // Construtores
    public ProdutoController(){
        
        this.produtos = new ArrayList<>();
    }

    public boolean addProduto(Produto produto){
        if (produto == null){
            System.out.println("Erro. Produto não pode ser nulo");
            return false;
        }
        if (buscarProduto(produto.getCodigo()) != null){
            System.out.println("Erro. Já existe produto com o código " + produto.getCodigo());
        }

        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso: " + produto.getNome());
        return true;

    }

    public boolean removeProduto(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            System.out.println("Erro: Código não pode ser nulo ou vazio");
            return false;
        }

        // Percorre a lista procurando o produto
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCodigo().equals(codigo.trim())) {
                Produto produtoRemovido = produtos.get(i);
                produtos.remove(i);
                System.out.println("Produto removido com sucesso: " + produtoRemovido.getNome());
                return true;
            }
        }

        System.out.println("Produto com ID " + codigo + " não encontrado");
        return false;
    }

    public List<Produto> buscarProdutoPorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Erro: Nome não pode ser nulo ou vazio");
            return new ArrayList<>();
        }

        List<Produto> produtosEncontrados = new ArrayList<>();

        // Percorre todos os produtos
        for (Produto produto : produtos) {
            // Verifica se o nome contém o texto procurado (ignora maiúscula/minúscula)
            if (produto.getNome().toLowerCase().contains(nome.toLowerCase().trim())) {
                produtosEncontrados.add(produto);
            }
        }

        return produtosEncontrados;
    }

    public Produto buscarProduto(String codigo){
        if (codigo == null || codigo.trim().isEmpty()){
            System.out.println("Código não pode ser nulo ou vazio");
            return null;
        }

        for (Produto produto : produtos){
            if (produto.getCodigo().equalsIgnoreCase(codigo.trim())){
                return produto; // se encontrar, retorna o produto
            }
        }

        return null;

    }



}
