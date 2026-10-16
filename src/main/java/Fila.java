public class Fila {
    private int[] arr;
    private int tail;
    private int head;
    private int size;

    // sua fila deve seguir a abordagem circular que vimos em sala de aula.
    // isso implica em dizer quer adições e remoções são O(1).
    public Fila(int capacidade) {
        this.arr = new int[capacidade];
        this.head = -1;
        this.tail = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == this.tail && this.tail == -1;
    }

    public boolean isFull() {
        return ((this.tail+1) % this.arr.length) == this.head;
    }

    // deve lançar exceção caso a fila esteja cheia. 
    public void addLast(int valor) {
        if (isFull()) throw new RuntimeException("Fila cheia!");
        this.arr[(++tail % this.arr.length)] = valor;
        if (this.head == -1) this.head = 0;
        size++;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if (isEmpty()) throw new RuntimeException("Fila vazia!");
        int out = this.arr[head++ % this.arr.length];
        if (this.head > this.tail) {
            this.tail = -1;
            this.head = -1;
        }
        size--;
        return out;
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o primeiro da fila, sem
    // remover;
    public int getFirst() {
        if (isEmpty()) throw new RuntimeException("Fila vazia!");
        return this.arr[this.head % arr.length];
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o último da fila, sem
    // remover;
    public int getLast() {
        if (isEmpty()) throw new RuntimeException("Fila vazia!");
        return this.arr[this.tail % arr.length];
    }

    // deve retornar uma string representando a fila. 
    public String toString() {
        String out = "";

        if(!isEmpty()) {
            int valorNaFila = this.arr[head % this.arr.length];
            out += valorNaFila;

            for (int i = head+1; i <= tail; i++) {
                valorNaFila = this.arr[i % this.arr.length];
                out += ", "+valorNaFila;
            }
        }
        
        return out;
    }
    
    // Deve retornar a posição da primeira ocorrência do elemento passado como parâmetro. 
    public int indexOf(int valor) {
        for (int i = 0; i < size; i++) {
            if (arr[(head+i) % this.arr.length] == valor) return i;
        }
        return -1;
    }

    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        int apontador = head % this.arr.length;
        int indice = 0;
        int i = 0;

        while (apontador <= tail) {
            if (this.arr[apontador % arr.length] == valor) {
                indice = i;
            }
            apontador++;
            i++;
        }

        return indice;
    }
    
    public int size() {
        return this.size;
    }

}
