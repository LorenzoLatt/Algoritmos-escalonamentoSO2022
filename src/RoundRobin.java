import java.util.Comparator;
public class RoundRobin extends Algoritmo {


   public void ordenaElementos() {

       arrayProcessos.sort(Comparator.comparingInt(Processo::getTempoChegada));
   }

    public void mostraProcessos() {

        for(int i = 0; i < arrayProcessos.toArray().length; i++) {

            System.out.println(
                    "\nTempo de execucao do processo: " + arrayProcessos.get(i).id +
                    "\n" + arrayProcessos.get(i).tempoExecucao);
        }
    }

    public void executaProcesso(Processo processo) {

       int contador = 0;

           for (int i = 0; i < processo.tempoExecucao; i++) {

               if(processo.tempoRestante == 0) {

                   break;

               } else {

                   if (contador == (processo.tempoExecucao - 1)) {

                       contador = 0;
                   }

                   if (contador == processo.fatiaTempo) {

                       break;
                   }
               }

               System.out.println("Executando processo " + processo.id + " com " + processo.tempoExecucao +
                       " unidades de tempo." + " Tempo restante: " + (processo.tempoRestante));

               processo.tempoRestante--;
               contador++;




           }
       }


    public void executaAlgoritmo() {

       int somaTempos = 0;
       for(int i = 0; i < arrayProcessos.toArray().length; i++) {

           somaTempos += arrayProcessos.get(i).tempoExecucao;

       }

       int contador = 0;
       for(int i = 0; i < 999; i++) {
           if(somaTempos == 0) {

               break;
           }
           if(contador == arrayProcessos.toArray().length) {

               i = 0;
               contador = 0;
           }

           executaProcesso(arrayProcessos.get(i));
           contador++;
           somaTempos--;
       }

    }


}
