package Trilha_3.exPilha;

public class PilhaArray {

    private String[] dados;
    private int topo; // vai ser definido como zero por padrão

    public PilhaArray(int capacidade){
        this.dados = new String[capacidade];
        topo = -1;
    }

    public void push(String valor) {
        if(topo == dados.length -1){
            throw new RuntimeException("Overflow");
        }
        dados[++topo] = valor; // primeira operação o topo vai de -1 para 0
    }

    public String pop(){
        if(topo ==-1){
            throw new RuntimeException("Underflow");
        }
        return dados[topo--];
    }

    public String peek(){
        return dados[topo];
    }

    public boolean isEmpty(){
        return topo == -1;
    }

}
