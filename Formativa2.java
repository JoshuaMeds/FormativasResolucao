public class Formativa2 {
    public class Node {
        int info;
        Node prox;

        public Node(int info) {
            this.info = info;
            this.prox = null;
        }
    }

    public class ListaCircular {
        private Node primeiro;
        private Node ultimo;

        public ListaCircular() {
            primeiro = null;
            ultimo = null;
        }

        public void inserirElemento(int valor) {
            Node novo = new Node(valor);
            if (primeiro == null) {
                primeiro = novo;
                ultimo = novo;
                ultimo.prox = primeiro;
            } else {
                ultimo.prox = novo;
                novo.prox = primeiro;
                ultimo = novo;
            }
        }

        public void removerElemento(int valor) {
            if (primeiro == null) {
                System.out.println("Erro: Lista vazia");
                return;
            }

            Node atual = primeiro;
            Node anterior = ultimo;
            do {
                if (atual.info == valor) {
                    if (atual == primeiro) {
                        primeiro = primeiro.prox;
                        ultimo.prox = primeiro;
                    } else if (atual == ultimo) {
                        ultimo = anterior;
                        ultimo.prox = primeiro;
                    } else {
                        anterior.prox = atual.prox;
                    }
                    return;
                }
                anterior = atual;
                atual = atual.prox;
            } while (atual != primeiro);

            System.out.println("Erro: Elemento não encontrado");
        }

        public void imprimirLista() {
            if (primeiro == null) {
                System.out.println("Lista vazia");
                return;
            }
            Node atual = primeiro;
            do {
                System.out.print(atual.info + " -> ");
                atual = atual.prox;
            } while (atual != primeiro);
            System.out.println("(retorna ao início)");
        }
    }
}
