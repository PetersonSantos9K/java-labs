package Trilha_3.exPilha;

public class Program {

    static void main(String[] args) {
        String entrada = "{[()]}";
        PilhaArray pilha = new PilhaArray(entrada.length());

        for(int i=0; i<entrada.length(); i++) {
            char cr = entrada.charAt(i);

            if(cr == '(' || cr == '[' || cr == '{'){
                pilha.push(String.valueOf(cr));
            } else if(cr == ')' || cr == ']' || cr == '}') {
                if(pilha.isEmpty()){
                    return;
                }

                char topo = pilha.peek().charAt(0);
            }
        }
    }
}
