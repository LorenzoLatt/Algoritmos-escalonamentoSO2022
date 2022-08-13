import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public abstract class Algoritmo {

    ArrayList<Processo> arrayProcessos = new ArrayList<>();


    public void populaArray(int numeroProcessos) {

        for(int i = 0; i < numeroProcessos; i++) {

            this.arrayProcessos.add(new Processo(i + 1));
        }

    }

    public void tempoAleatorio(Processo processo, boolean flag, int index) {

        Random rand = new Random();

        if(flag) {

            processo.tempoExecucao = rand.nextInt(10);
        } else {

            processo.tempoExecucao = index + 5;
        }

    }

    public void tempoAleatorioChegada(Processo processo, boolean flag, int index) {

        Random rand = new Random();



            if (flag) {

                processo.tempoChegada = rand.nextInt(10);
            } else {

                processo.tempoChegada = index + 5;
            }


    }

    public void prioridadeAleatoria(Processo processo, boolean flag, int index) {

        Random rand = new Random();

        if(flag) {

            processo.prioridade = rand.nextInt(10);
        } else {

            processo.prioridade = index + 5;
        }

    }



    public int perguntaProcessos(Scanner scanner) {

        System.out.println("Quantos processos voce deseja criar");


        return scanner.nextInt();
    }

    public boolean perguntaPopulaRandom(Scanner scanner) {


        System.out.println("Voce deseja popular aleatoriamente os tempos de execucoes do processo? Y/N");
        String resposta = scanner.nextLine();

        return resposta.equalsIgnoreCase("y");
    }

    public int somaTemposExecucao() {
        int somaTemposExecucao = 0;
        for(Processo processo: arrayProcessos) {

            somaTemposExecucao += processo.tempoExecucao;
        }
        return somaTemposExecucao;
    }

    public void populaTemposAleatorio(boolean flag) {


        for(int i = 0; i < arrayProcessos.toArray().length; i++) {

            tempoAleatorio(arrayProcessos.get(i), flag, i);
            tempoAleatorioChegada(arrayProcessos.get(i), flag, i);
            prioridadeAleatoria(arrayProcessos.get(i), flag, i);

        }

    }

    public float calculaTempoEsperaMedio() {
        int somaTempos = 0;
        for(int i = 0; i < arrayProcessos.toArray().length; i++) {

            somaTempos += arrayProcessos.get(i).tempoExecucao;
        }

        return (float)somaTempos/arrayProcessos.toArray().length;
    }

    public void mostraTempoEsperaMedio(float media) {

        System.out.printf("A media do tempo de espera eh: %.2f ", media);

    }

}
