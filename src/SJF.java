import java.util.Comparator;
import java.util.ArrayList;

public class SJF extends Algoritmo {


    public  void executaProcesso(Processo processo) {

        int counter = 0;

        for (int i = 0; i < processo.tempoExecucao; i++) {

            if (i == 0) {

                System.out.println("");
            }

            if (counter < processo.tempoExecucao) {

                System.out.println("Executando processo " + processo.id + " com " + processo.tempoExecucao +
                        " unidadess de tempo." + " Tempo restante: " + (processo.tempoExecucao - i));
                counter++;
            }
        }
    }

    public void ordenaElementos() {

            arrayProcessos.sort(Comparator.comparingInt(Processo::getTempoChegada));

    }
    public void executaAlgoritmo() {

        for(int i = 0; i < arrayProcessos.toArray().length; i++) {

            System.out.println("Tempo de chegada do processo: " + arrayProcessos.get(i).id +
                    " " +  arrayProcessos.get(i).tempoChegada);
        }

        for(int i = 0; i < this.arrayProcessos.toArray().length; i++) {

            executaProcesso(this.arrayProcessos.get(i));
        }
    }

    public void executaProcessoPreemptivo(Processo auxProcesso, Processo processo) {
        Processo antigoProcesso = processo;
        for (int i = 0; i < processo.tempoExecucao; i++) {

            if (processo.tempoRestante == 0) {
                break;
            } else {

                if (processo.tempoRestante > auxProcesso.tempoExecucao) {

                    processo = auxProcesso;
                    auxProcesso = antigoProcesso;

                }
            }

                System.out.println("Executando processo " + processo.id + " com " + processo.tempoExecucao +
                        " unidadess de tempo." + " Tempo restante: " + (processo.tempoRestante));

                processo.tempoRestante--;

            }

        }



    public void executaAlgoritmoPreemptivo(ArrayList<Processo> processos) {


        for(int i = 0; i < this.arrayProcessos.toArray().length; i++) {

            executaProcessoPreemptivo(processos.get(i), arrayProcessos.get(i));
        }
    }

}
