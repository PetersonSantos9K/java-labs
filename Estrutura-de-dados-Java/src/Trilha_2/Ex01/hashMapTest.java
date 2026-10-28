package Trilha_2.Ex01;

import java.util.HashMap;

public class hashMapTest {

    private static final int TAMANHO = 1000000;

    static void main(String[] args) {

        HashMap<Integer, Produto> mapa = new HashMap<>();

        for(int i=1; i<=TAMANHO; i++){
            mapa.put(i, new Produto(i, "Produto: " +i, i*20.00 ));
        }

        long startTime = System.currentTimeMillis();
        int codigoSerEncontrado = TAMANHO;
        Produto p = null;
        for(int qtd=0; qtd < TAMANHO;qtd++){
            p = mapa.get(codigoSerEncontrado);
        }

        System.out.println(p.getNome() + p.getId() + p.getPreco());

        long endTime = System.currentTimeMillis();

        System.out.println("Tempo de execução: " + (endTime -startTime) + "ms");


    }


}
