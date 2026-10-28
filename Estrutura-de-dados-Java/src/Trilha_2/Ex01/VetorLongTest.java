package Trilha_2.Ex01;

public class VetorLongTest {
    // tempo de execucao = 2946ms -> 100000
    private static final int TAMANHO = 10000000;

    static void main() {


        Produto[] produtos = new Produto[TAMANHO];
        for(int i=0; i<TAMANHO; i++){
            produtos[i] = new Produto(i, "Produto " + 1, i * 20.00 );
        }

        long startTime = System.currentTimeMillis();

        for(int i=0; i<TAMANHO; i++){
            Produto pr = produtos[i];
        }
        long endTime = System.currentTimeMillis();
        System.out.println("tempo de execução: " + (endTime - startTime) + "ms");
    }


    void tst () {
        long[] array = new long[TAMANHO];

        long startTime = System.currentTimeMillis();

        for(int i=0; i < TAMANHO; i++){
            for(int j=0; j<TAMANHO; j++){
                array[i] += j;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("tempo de execução: " + (endTime - startTime) + "ms");
    }
}
