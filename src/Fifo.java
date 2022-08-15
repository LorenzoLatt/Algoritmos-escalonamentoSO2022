public class Fifo extends Algoritmo{


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
    public void executarAlgoritmo() {



        for(int i = 0; i < this.arrayProcessos.toArray().length; i++) {

            executaProcesso(this.arrayProcessos.get(i));
        }

    }



}
