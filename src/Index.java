import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;
public class Index {


    public static void main(String[] args) {

        int consulta;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Qual algoritmo voce deseja pesquisar?");
            System.out.println("1->FIFO");
            System.out.println("2->SFJ/Nao-Preemptivo");
            System.out.println("3->SFJ/Preemptivo");
            System.out.println("4->Prioridade/Nao-Preemptivo");
            System.out.println("5->Prioridade/Preemptivo");
            System.out.println("6->Round Robin");
            System.out.println("0->Sair do sistema");
            consulta = sc.nextInt();


            switch(consulta) {

                case 1-> {

                    Fifo fifo = new Fifo();
                    int nroProcessos = fifo.perguntaProcessos(sc);
                    sc.nextLine();
                    fifo.populaArray(nroProcessos);
                    boolean flag = fifo.perguntaPopulaRandom(sc);
                    fifo.executarAlgoritmo(flag);
                    float media = fifo.calculaTempoEsperaMedio();
                    fifo.mostraTempoEsperaMedio(media);
                }

                case 2-> {

                    SJF sjf = new SJF();

                    int nroProcessos = sjf.perguntaProcessos(sc);
                    sc.nextLine();
                    sjf.populaArray(nroProcessos);
                    boolean flag = sjf.perguntaPopulaRandom(sc);
                    sjf.populaTemposAleatorio(flag);
                    sjf.ordenaElementos();
                    sjf.executaAlgoritmo();
                    float media = sjf.calculaTempoEsperaMedio();
                    sjf.mostraTempoEsperaMedio(media);

                }

                case 3-> {

                    SJF sjf = new SJF();

                    int nroProcessos = sjf.perguntaProcessos(sc);
                    sc.nextLine();
                    sjf.populaArray(nroProcessos);
                    boolean flag = sjf.perguntaPopulaRandom(sc);
                    sjf.populaTemposAleatorio(flag);
                    sjf.ordenaElementos();

                    for(int i = 0; i < sjf.arrayProcessos.toArray().length; i++) {

                        sjf.arrayProcessos.get(i).setTempoRestante(sjf.arrayProcessos.
                                get(i).tempoExecucao);
                    }

                    ArrayList<Processo> processos = sjf.arrayProcessos;
                    sjf.mostraProcessos();
                    sjf.executaAlgoritmoPreemptivo(processos);
                    float media = sjf.calculaTempoEsperaMedio();
                    sjf.mostraTempoEsperaMedio(media);

                }

                case 4-> {

                    Prioridade prioridade = new Prioridade();
                    int nroProcessos = prioridade.perguntaProcessos(sc);
                    sc.nextLine();
                    prioridade.populaArray(nroProcessos);
                    boolean flag = prioridade.perguntaPopulaRandom(sc);
                    prioridade.populaTemposAleatorio(flag);
                    prioridade.ordenaElementos();
                    ArrayList<Processo> processos = prioridade.arrayProcessos;
                    processos.sort(Comparator.comparingInt(Processo::getPrioridade));
                    prioridade.mostraProcessos();
                    prioridade.executaAlgoritmo(processos);
                    float media = prioridade.calculaTempoEsperaMedio();
                    prioridade.mostraTempoEsperaMedio(media);


                }

                case 5-> {

                    Prioridade prioridade = new Prioridade();
                    int nroProcessos = prioridade.perguntaProcessos(sc);
                    sc.nextLine();
                    prioridade.populaArray(nroProcessos);
                    boolean flag = prioridade.perguntaPopulaRandom(sc);
                    prioridade.populaTemposAleatorio(flag);
                    prioridade.ordenaElementos();

                    for(int i = 0; i < prioridade.arrayProcessos.toArray().length; i++) {

                        prioridade.arrayProcessos.get(i).setTempoRestante(prioridade.arrayProcessos.
                                get(i).tempoExecucao);
                    }


                    ArrayList<Processo> processos = prioridade.arrayProcessos;
                    processos.sort(Comparator.comparingInt(Processo::getPrioridade));
                    prioridade.mostraProcessos();
                    prioridade.executaAlgoritmoPreemptivo(processos);
                    float media = prioridade.calculaTempoEsperaMedio();
                    prioridade.mostraTempoEsperaMedio(media);

                }

                case 6-> {

                    RoundRobin roundRobin = new RoundRobin();
                    int nroProcessos = roundRobin.perguntaProcessos(sc);
                    sc.nextLine();
                    roundRobin.populaArray(nroProcessos);
                    boolean flag = roundRobin.perguntaPopulaRandom(sc);
                    roundRobin.populaTemposAleatorio(flag);
                    roundRobin.ordenaElementos();
                    roundRobin.mostraProcessos();

                    for(int i = 0; i < roundRobin.arrayProcessos.toArray().length; i++) {

                        roundRobin.arrayProcessos.get(i).setTempoRestante(roundRobin.arrayProcessos.
                                get(i).tempoExecucao);
                    }

                    roundRobin.executaAlgoritmo();
                    float media = roundRobin.calculaTempoEsperaMedio();
                    roundRobin.mostraTempoEsperaMedio(media);

                }


            }


        }while(consulta != 0);
    }
}
