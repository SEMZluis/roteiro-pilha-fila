import java.util.Arrays;

public class Pilha {
    private int[] arr;
    private int topo;

    public Pilha(int capacidade) {
        this.arr = new int[capacidade];
        this.topo = -1;
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    public boolean isFull() {
        return this.topo+1 == this.arr.length;
    }

    // deve lançar exceção caso a pilha esteja cheia.
    public void push(int valor) {
        if (isFull()) throw new RuntimeException("Pilha cheia!");
        this.arr[++topo] = valor;
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int pop() {
        if (isEmpty()) throw new RuntimeException("Pilha vazia!");
        return this.arr[topo--];
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int peek() {
        if (isEmpty()) throw new RuntimeException("Pilha vazia! Não tem o que olhar!");
        return this.arr[topo];
    }

    // deve retornar uma string representando a pilha. Veja os testes para a especificação
    // detalhada. Não é permitido iterar diretamente sobre o array ou criar arrays. Crie outra pilha, se preciso. Use as operações push, pop,
    // isEmpty etc. 
    public String toString() {
        String out = "";
        
        if (!isEmpty()) {
            Pilha aux = new Pilha(this.topo+1);

            while (!isEmpty()) {
                aux.push(pop());
            }
            
            int topoAux = aux.pop();
            out = topoAux+"";
            push(topoAux);

            while(!aux.isEmpty()) {
                topoAux = aux.pop();
                out += ", "+topoAux;
                push(topoAux);
            }
        }
        
        return out;
    }
    
    // Deve retornar o índice da primeira ocorrência do elemento passado como parâmetro. 
    // Não é permitido iterar diretamente sobre o array. Use as operações push, pop,
    // isEmpty etc.
    public int indexOf(int valor) {
        int indexEncontrado = -1;

        if (!isEmpty()) {
            Pilha aux = new Pilha(this.topo+1);

            while (!isEmpty()) {
                int topoPilha = pop();
                aux.push(topoPilha);
                if (topoPilha == valor) {
                    indexEncontrado = this.topo+1;
                    break;
                }
            }

            while (!aux.isEmpty()) {
                push(aux.pop());
            }
        }

        return indexEncontrado;
    }

    public int size() {
        return this.topo+1;
    }

    public int lastIndexOf(int i) {
        int indexEncontrado = -1;

        if (!isEmpty()) {
            Pilha aux = new Pilha(this.topo+1);

            while (!isEmpty()) {
                int topoPilha = pop();
                aux.push(topoPilha);
                if (topoPilha == i) {
                    indexEncontrado = this.topo+1;
                    // break;
                }
            }

            while (!aux.isEmpty()) {
                push(aux.pop());
            }
        }

        return indexEncontrado;
    }

}
