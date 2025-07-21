public class ProdutoController {
    private Produto[] produtos;
    private int indiceAtual = 0;  // Controla a próxima posição disponível

    // Construtor para definir o tamanho máximo do array
    public ProdutoController(int tamanhoMaximo) {
        produtos = new Produto[tamanhoMaximo];
    }

    // Método para adicionar produto
    public void addProduto(int codigo, String nome, int estoque, double preco) {
        if (indiceAtual < produtos.length) {
            produtos[indiceAtual] = new Produto(codigo, nome, estoque, preco);
            indiceAtual++;
        } else {
            System.out.println("Erro: limite de produtos atingido.");
        }
    }

    // Método para listar os produtos
    public void listarProdutos() {
        for (int i = 0; i < indiceAtual; i++) {
            Produto p = produtos[i];
            System.out.println("Código: " + p.getCodigo() +
                    ", Nome: " + p.getNome() +
                    ", Estoque: " + p.getEstoque() +
                    ", Preço: R$ " + p.getPreco());
        }
    }





    static class Produto{
        // Atributos
        private int codigo;
        private String nome;
        private int estoque;
        private double preco;

        // Construtores de classe
        public Produto(int codigo, String nome, int estoque, double preco){
            this.codigo = codigo;
            this.nome = nome;
            this.estoque = estoque;
            this.preco = preco;
        }
        // Getters e Setters
        public int getCodigo(){
            return this.codigo;
        }

        public String getNome(){
            return this.nome;
        }

        public int getEstoque(){
            return this.estoque;
        }

        public double getPreco(){
            return this.preco;
        }

        public void setCodigo(int codigo){
            this.codigo = codigo;
        }

        public void setNome(String nome){
            this.nome = nome;
        }

        public void setEstoque(int estoque){
            this.estoque = estoque;
        }

        public void setPreco(double preco){
            this.preco = preco;
        }

    }
}
