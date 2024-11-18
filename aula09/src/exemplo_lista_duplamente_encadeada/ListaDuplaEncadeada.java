package exemplo_lista_duplamente_encadeada;

public class ListaDuplaEncadeada {
    private NoDuplo inicio;
    private NoDuplo fim;

    // Método construtor sem parâmetros - Objeto vazio
    public ListaDuplaEncadeada() {
    }
    
    // Método construtor com parâmetros - Objeto já com os dados
    public ListaDuplaEncadeada(NoDuplo inicio, NoDuplo fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    // /método de acesso aos atributos com escopo privado
    public NoDuplo getInicio() {
        return inicio;
    }

    public void setInicio(NoDuplo inicio) {
        this.inicio = inicio;
    }

    public NoDuplo getFim() {
        return fim;
    }

    public void setFim(NoDuplo fim) {
        this.fim = fim;
    }
       
    // Método para exibir os dados da Lista Duplamente Encadeada
    public void exibir() throws Exception {
        System.out.println("LISTA -> ");
        // criação de uma variável auxiliar
        NoDuplo aux = inicio;
        // Estrutura de repetição para percorrer a lista
        while (aux != null){
            System.out.print(aux.dado + " -> ");
            aux = aux.proximo;
        }
        System.out.println("NULL\n");
    }
    
    // Método para mostrar o tamanho da Lista
    public int tamanhoLista() throws Exception {
        NoDuplo aux = inicio;
        int tamanho = 0;
        while (aux != null){
            tamanho ++;
            System.out.println(aux.dado + " -> ");
            aux = aux.proximo;
        }
        return tamanho;
    }
    
    // Método para INSERIR os dados na Lista Duplamente Encadeada
    // este método insere os dados na seguencia ou seja no final da lista
    public void adicionar(String s) throws Exception {
        // novo elemento da nossa lista
        NoDuplo novoElemento = new NoDuplo(s);
        // variável auxiliar
        NoDuplo aux = inicio;
        
        // verifica se ele é o primeiro elemento da nossa lista
        if(inicio == null) {
            // sendo o primeiro elemento ele não tem próximo nem anterior
            novoElemento.proximo = null;
            novoElemento.anterior = null;
            // como ele é o primeiro ele vai ser o inicio e o fim da lista
            inicio = novoElemento;
            fim = novoElemento;
        } else {
            // agora quando o elemento não for o primeiro da lista
            // vamos percorrer a lista para achar a posição valida no caso uma posição null
            while (aux.proximo != null){
                // vamos verificar se o elemento não é repetido
                if (aux.dado.equals(s)){
                    throw new Exception("Elemento repetido");
                } else {
                    aux = aux.proximo;
                }
            }
            // o ultimo elemento sempre deve ter o próximo como null
            novoElemento.proximo = null;
            aux.proximo = novoElemento;
            novoElemento.anterior = aux;
            fim = novoElemento;
        }
    }
    
    // Método para INSERIR os dados na Lista Duplamente Encadeada
    // este método insere os dados posição determinada na lista
    public void adicionar(String s, int i) throws Exception {
        // verifica se a posição desejada é valida
        if(i < 0 || i > tamanhoLista()){
            throw new Exception("Posicao Inva1lida!");
        }
        // novo elemento da nossa lista
        NoDuplo novoElemento = new NoDuplo(s);
        // variável auxiliar
        NoDuplo aux = inicio;
        
        // verifica se ele é vai na primeira posição da lista
        if(i == 0) {
            if(tamanhoLista() != 0){
                // caso já tenha um valor na primeira posição devemos mover os dados
                novoElemento.proximo = aux;
                aux.anterior = novoElemento;
                inicio = novoElemento;
                novoElemento.anterior = null;
            } else {
                // caso não ter nenhum elemento na lista ele será o primeiro
                inicio = novoElemento;
            }
        } else {
             // vamos percorrer a lista para achar a posição desejada
            int contador = 1;
            while (contador < i){
                aux.proximo = novoElemento;
                contador ++;
                novoElemento.anterior = aux;
                fim = novoElemento;
            }
            novoElemento.proximo = aux.proximo;
            novoElemento.anterior = aux;
            aux.proximo = novoElemento;
        }
    }
    
    // Método para remover elemento da Lista Encadeada
    public String removeIndex(int i) throws Exception {
        NoDuplo aux = inicio;
        NoDuplo lixo = null;
        // verifica se existe elementos na lista
        
        // verifica se o elemento desejado esta na posição válida
        if (i < 0 || i > tamanhoLista())
            throw new Exception("Indice inválido na Lista!");
        if(tamanhoLista() == 0)
            throw new Exception("A lista está vazia!");
        // verificar se o elemento a ser removido é o primeiro da lista
        if (i == 0){
            lixo = aux;
            aux = aux.proximo;
            inicio = aux;            
        } else {
            // caso o elemento a ser removido não seja o primeiro
            int contador = 0;
            // percorrer a lista até achar a posição desejada
            while (contador < i){
                aux = aux.proximo;
                contador ++;                
            }
            // armazena na variável lixo a informação a ser removida
            lixo = aux;
            aux.anterior.proximo = aux.proximo;
            if(aux != fim)
                aux.proximo.anterior = aux.anterior;
            else // caso ele seja o último elemento
                fim = aux;
        }
        // retorna o valor excluido
        return lixo.dado;
    } 
    
    // Método para remover o elemento de acordo com o conteúdo
    public void removeElemento(String s) throws Exception {
        // Verifica se tem elementos na Lista
        if(tamanhoLista() == 0)
            throw new Exception("A lista está vazia!");

        // criando um objeto auxiliar
        NoDuplo aux = inicio;
        
        // criando uma variável lógica para controlar a exclusão
        boolean excluir = false;
        
        // vamos percorrera lista até achar o elemento
        while(aux != null && aux.dado != s){
            // se o objeto auxilar for igual ao valor passado pelo parâmetro
            if (aux.dado.equals(s)){                
                if(aux == inicio){
                    // verifica se é a primeira posição
                    inicio = inicio.proximo;
                    excluir = true;
                } else {
                    // caso não seja a primeira posição
                    aux.anterior.proximo = aux.proximo;
                    aux.proximo = aux.anterior;
                    excluir = true;
                }                
            }
            aux = aux.proximo;
        }
        if (excluir == false)
            //caso não encontre o elemento
            throw new Exception("O elemento não foi localizado na Lista");
    }
    
    // Método para mostrar o antecessor do elemento
    public String antecessor(String s) throws Exception {
        // verifica se tem elementos na lista
        if(tamanhoLista() == 0)
            throw new Exception("A lista está vazia!");        
        // criando um objeto auxiliar
        NoDuplo aux = inicio;
        
        while(aux != null){
            // verifica se o elemento está na lista
            if(aux.dado.equals(s)){
                // verifica se o elemento é o primeiro da lista
                if(aux == inicio){
                    throw new Exception("Primeiro elemento da Lista não tem Antecessor!");
                } else {
                    return aux.anterior.dado;
                }
            } 
            aux = aux.proximo;
        }
        throw new Exception("O elemento não foi localizado na Lista!");
    } 
    
    // Método para buscar a posição do elemento na Lista
    public int posicao(String s) throws Exception {
        // verifica se tem elementos na lista
        if(tamanhoLista() == 0)
            throw new Exception("A lista está vazia!");
        
        // criando um objeto auxiliar
        NoDuplo aux = inicio;
        
        int contador = 0;
        
        while(aux != null){
            if(aux.dado.equals(s)){
                return contador;
            } else {
                aux = aux.proximo;
                contador ++;
            }
        }
        throw new Exception("O elemento não foi localizado na Lista!");
    }
    
    // Método que retorna o valor do elemento de acordo com a posição
    public String BuscaPosicao(int i) throws Exception {
        // verifica se tem elementos na lista
        if(tamanhoLista() == 0)
            throw new Exception("A lista está vazia!");
        
        // verifica se o parâmetro informado é valido
        if (i < 0 || i > tamanhoLista())
            throw new Exception("Indice inválido na Lista!");
        
        // criando um objeto auxiliar
        NoDuplo aux = inicio;
        int contador = 0;
        
        // percorrer a Lista até a posição informada
        while(contador <= i){
            if (contador == i){
                return aux.dado;
            } else {
                aux = aux.proximo;
                contador ++;
            }
        }
        return aux.dado; 
    }
    
    // Método para retornar o primeiro elemento da Lista
    public String primeiroLista() throws Exception{
        // verifica se tem elementos na lista
        if(tamanhoLista() == 0)
            throw new Exception("A lista está vazia!");
        if(tamanhoLista() != 0) 
            return inicio.dado;            
        return null;
    }
    
    // Método para retornar o último elemento da Lista
    public String ultimoLista() throws Exception{
        // verifica se tem elementos na lista
        if(tamanhoLista() == 0)
            throw new Exception("A lista está vazia!");
        if(tamanhoLista() != 0) 
            return fim.dado;            
        return null;
    }
    
    // Método para retornar o maior valor da Lista
    // Como nosso exemplo é uma lista de String 
    // ele retorna por ordem alfabética decrescente
    public String maior() throws Exception {
        // verifica se tem elementos na lista
        if(tamanhoLista() == 0)
            throw new Exception("A lista está vazia!");
        
        // criando um objeto auxiliar
        NoDuplo aux = inicio;
        
        String maior = aux.dado;
        
        // percorrer a Lista
        while(aux != null){
            if (aux.dado.compareTo(maior) > 0){
                maior = aux.dado;
            } else {
                aux = aux.proximo;
            }
        }
        return maior;
    }
}