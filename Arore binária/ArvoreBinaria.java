public class ArvoreBinaria {
    private Node raiz; // valor "principal" da arvore binária

    public void inserir(int valor) {
        raiz = inserir(raiz, valor);
    }

    private Node inserir(Node atual, int valor) {
        if (atual == null) { // verifica se for "vazio" antes de seguir para os proximos ifs
            return new Node(valor);
        }
        if (valor < atual.info) {
            atual.esquerda = inserir(atual.esquerda, valor); // adiciona um valor menor ate a esquerda até achar um menor que ele ou ficar como mais a esquerda
            System.out.println(valor + " " + "inserido a esquerda do atual");
        } else if (valor > atual.info) {
            atual.direita = inserir(atual.direita, valor); // adiciona um valor maior a direita até achar um que seja maior ou fica mais a direita
            System.out.println(valor + " " + "inserido a direita do atual");
        }
        return atual;
    }

    public void removerMaior() {
        raiz = removerMaior(raiz);
    }

    private Node removerMaior(Node atual) {
        if (atual == null) return null;
        if (atual.direita == null) return atual.esquerda; // verifica o valor maximo da direita (maior valor)
        atual.direita = removerMaior(atual.direita); // remove o valor maximo da direita
        return atual; // retorna a arvore sem o valor removido
    }

    public void removerMenor() {
        raiz = removerMenor(raiz);
    }

    private Node removerMenor(Node atual) {
        if (atual == null) return null;
        if (atual.esquerda == null) return atual.direita; // verifica o valor minimo da esquerda (menor valor)
        atual.esquerda = removerMenor(atual.esquerda); // remove o valor minimo da esquerda
        return atual; // retorna a arvore sem esse valor menor
    }

    public void remover(int valor) {
        raiz = remover(raiz, valor);
    }

    private Node remover(Node atual, int valor) {
        if (atual == null) return null;
        if (valor < atual.info) atual.esquerda = remover(atual.esquerda, valor); // remove o valor da esquerda se for menor que a raiz
        else if (valor > atual.info) atual.direita = remover(atual.direita, valor); // remove o valor da direita se for maior que a raiz
        else {
            if (atual.esquerda == null) return atual.direita;
            if (atual.direita == null) return atual.esquerda;

            Node menor = atual.direita;
            while (menor.esquerda != null) menor = menor.esquerda; // se o valor que foi removido ter dois "filhos" coloca o menor da direita como atual
             atual.info = menor.info;
            atual.direita = remover(atual.direita, menor.info);
        }
        return atual; // retorna a fila depois da remocao
    }

    public void imprimirRamosSeparados() {
        System.out.print("Raiz: ");
        if (raiz != null) System.out.println(raiz.info); // printa a raiz
        else System.out.println("vazia");

        System.out.print("Ramo esquerdo: ");
        emOrdem(raiz != null ? raiz.esquerda : null); // printa a parte menor (esquerda)
        System.out.println();

        System.out.print("Ramo direito: ");
        emOrdem(raiz != null ? raiz.direita : null); // printa a parte maior (direita)
        System.out.println();
    }

    private void emOrdem(Node atual) {
        if (atual != null) {
            emOrdem(atual.esquerda);
            System.out.print(atual.info + " ");
            emOrdem(atual.direita);
        }
    }
}
