public class Formativa3 {
    public class Node {
        int info;
        Node prox;
        Node ant;

        public Node(int info) {
            this.info = info;
            this.prox = null;
            this.ant = null;
        }
    }

    public class ListaDuplamenteEncadeada {
        private Node primeiro;
        private Node ultimo;

        public ListaDuplamenteEncadeada() {
            primeiro = null;
            ultimo = null;
        }

        public void inserirElemento(int valor) {
            Node novo = new Node(valor);
            if (primeiro == null) {
                primeiro = novo;
                ultimo = novo;
            } else {
                ultimo.prox = novo;
                novo.ant = ultimo;
                ultimo = novo;
            }
        }

        public void removerElemento(int valor) {
            if (primeiro == null) {
                System.out.println("Erro: Lista vazia");
                return;
            }

            Node atual = primeiro;
            while (atual != null) {
                if (atual.info == valor) {
                    if (atual == primeiro) {
                        primeiro = primeiro.prox;
                        if (primeiro != null) {
                            primeiro.ant = null;
                        }
                    } else if (atual == ultimo) {
                        ultimo = ultimo.ant;
                        ultimo.prox = null;
                    } else {
                        atual.ant.prox = atual.prox;
                        atual.prox.ant = atual.ant;
                    }
                    return;
                }
                atual = atual.prox;
            }
            System.out.println("Erro: Elemento não encontrado");
        }

        public void imprimirLista() {
            if (primeiro == null) {
                System.out.println("Lista vazia");
                return;
            }
            Node atual = primeiro;
            while (atual != null) {
                System.out.print(atual.info + " <-> ");
                atual = atual.prox;
            }
            System.out.println("null");
        }
    }
}
