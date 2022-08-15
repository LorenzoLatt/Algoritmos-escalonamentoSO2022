import java.util.ArrayList;
import java.util.Comparator;

public class Prioridade extends Algoritmo{


    public void ordenaElementos() {

        arrayProcessos.sort(Comparator.comparingInt(Processo::getTempoChegada));
    }


    public void executaProcesso(Processo auxProcesso, Processo processo) {

        Processo antigoProcesso = processo;
        processo.setTempoRestante(processo.tempoExecucao);
        int auxPrioridade;
        for (int i = 0; i < processo.tempoExecucao; i++) {

            auxPrioridade = processo.prioridade;
            if (auxProcesso.tempoChegada <= antigoProcesso.tempoChegada && auxProcesso.prioridade > antigoProcesso.prioridade) {
                antigoProcesso = processo;
                processo = auxProcesso;
                auxPrioridade = auxProcesso.prioridade;
            }

            System.out.println("Executando processo " + processo.id + " com " + processo.tempoExecucao +
                    " unidades de tempo." + " Tempo restante: " + (processo.tempoRestante) + " " +
                    "Prioridade: " + auxPrioridade);

            processo.tempoRestante--;

        }
    }


        public void executaProcessoPreemptivo(Processo auxProcesso, Processo processo) {

            Processo antigoProcesso = processo;
            int auxPrioridade;

            for(int i = 0; i < 99; i++) {
                auxPrioridade = processo.prioridade;

                if(processo.tempoRestante == 0) {

                    break;
                } else {

                    if (processo.tempoChegada > auxProcesso.tempoChegada &&
                            processo.prioridade < auxProcesso.prioridade &&
                            auxProcesso.tempoChegada >= i) {

                        processo = auxProcesso;
                        auxPrioridade = auxProcesso.prioridade;
                        auxProcesso = antigoProcesso;

                    }
                }

                System.out.println("Executando processo " + processo.id + " com " + processo.tempoExecucao +
                        " unidades de tempo." + " Tempo restante: " + (processo.tempoRestante) + " " +
                        "Prioridade: " + auxPrioridade);

                processo.tempoRestante--;


            }


    }


    public void executaAlgoritmo(ArrayList<Processo> processos) {


        for(int i = 0; i < this.arrayProcessos.toArray().length; i++) {

            executaProcesso(processos.get(i), arrayProcessos.get(i)); //(maior prioridade, menor tempo de chegada )
        }
    }

    public void executaAlgoritmoPreemptivo(ArrayList<Processo> processos) {


        for(int i = 0; i < this.arrayProcessos.toArray().length; i++) {

            executaProcessoPreemptivo(processos.get(i), arrayProcessos.get(i));
        }
    }

}
