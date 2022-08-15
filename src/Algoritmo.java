import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public abstract class Algoritmo {

    ArrayList<Processo> arrayProcessos = new ArrayList<>();

    public void initialArray(ArrayList<Processo> arrayProcessos) {
        this.arrayProcessos = arrayProcessos;
    }


    public  void populaArray(int numeroProcessos) {

        for(int i = 0; i < numeroProcessos; i++) {

            this.arrayProcessos.add(new Processo(i + 1));
        }

    }

    public void tempoAleatorio(Processo processo, boolean flag, Scanner sc) {

        Random rand = new Random();

        if(flag) {

            processo.tempoExecucao = rand.nextInt(1,10);
        } else {

            System.out.println("Informe um valor para o tempo de execucão do processo " + processo.id + ":");
            processo.tempoExecucao = sc.nextInt();
        }

    }

    public void tempoAleatorioChegada(Processo processo, boolean flag, Scanner sc) {

        Random rand = new Random();



            if (flag) {

                processo.tempoChegada = rand.nextInt(1,10);
            } else {

                System.out.println("Informe um valor para o tempo de chegada do processo " + processo.id + ":");
                processo.tempoChegada = sc.nextInt();
            }


    }

    public void prioridadeAleatoria(Processo processo, boolean flag,Scanner sc) {

        Random rand = new Random();

        if(flag) {

            processo.prioridade = rand.nextInt(10);
        } else {

            System.out.println("Informe um valor para a prioridade do processo " + processo.id + ":");
            processo.prioridade = sc.nextInt();
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

    public void populaTempos(boolean flag, Scanner sc) {


        for(int i = 0; i < arrayProcessos.toArray().length; i++) {

            tempoAleatorio(arrayProcessos.get(i), flag, sc);
            tempoAleatorioChegada(arrayProcessos.get(i), flag, sc);
            prioridadeAleatoria(arrayProcessos.get(i), flag, sc);

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

    public void mostraProcesso() {

        for(Processo processo: arrayProcessos) {

            System.out.println("processo: " + processo.id + " - tempo de execução: " + processo.tempoExecucao +
                    " - tempo de chegada: " + processo.tempoChegada + " - Prioridade: " + processo.prioridade);

        }
    }

}
