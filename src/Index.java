import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class Index {


    public static void tempoAleatorio(Processo processo, boolean flag, Scanner sc) {

        Random rand = new Random();

        if(flag) {

            processo.tempoExecucao = rand.nextInt(1,10);
        } else {

            System.out.println("Informe um valor para o tempo de execucão do processo " + processo.id + ":");
            processo.tempoExecucao = sc.nextInt();
        }

    }

    public static void tempoAleatorioChegada(Processo processo, boolean flag, Scanner sc) {

        Random rand = new Random();



        if (flag) {

            processo.tempoChegada = rand.nextInt(1,10);
        } else {

            System.out.println("Informe um valor para o tempo de chegada do processo " + processo.id + ":");
            processo.tempoChegada = sc.nextInt();
        }


    }

    public static void prioridadeAleatoria(Processo processo, boolean flag,Scanner sc) {

        Random rand = new Random();

        if(flag) {

            processo.prioridade = rand.nextInt(10);
        } else {

            System.out.println("Informe um valor para a prioridade do processo " + processo.id + ":");
            processo.prioridade = sc.nextInt();
        }

    }

    public static void populaArray(ArrayList<Processo> arrayProcessos, int nProc, boolean flag, Scanner sc) {


        for(int i = 0; i < nProc; i++) {
            arrayProcessos.add(new Processo(i + 1));
            tempoAleatorio(arrayProcessos.get(i), flag, sc);
            tempoAleatorioChegada(arrayProcessos.get(i), flag, sc);
            prioridadeAleatoria(arrayProcessos.get(i), flag, sc);

        }

    }

    public static void mostraProcessos(ArrayList<Processo> arrayProcessos) {

        for(int i = 0; i < arrayProcessos.toArray().length; i++) {

            System.out.println("processo: " + arrayProcessos.get(i).id + " - tempo de execução: " + arrayProcessos.get(i).tempoExecucao +
                    " - tempo de chegada: " + arrayProcessos.get(i).tempoChegada + " - Prioridade: " + arrayProcessos.get(i).prioridade);

        }
    }


    public static void main(String[] args) {

        ArrayList<Processo> arrayProcessos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos processos voce deseja criar");
        int n_proc =  sc.nextInt();

        sc.nextLine();

        System.out.println("Voce deseja popular aleatoriamente os tempos de execucoes do processo? Y/N");
        String resposta = sc.nextLine();

        boolean flag = false;

        if(resposta.equalsIgnoreCase("y")) {

        flag = true;

        }

        populaArray(arrayProcessos, n_proc, flag, sc);

        mostraProcessos(arrayProcessos);



        int consulta;
        do {

            System.out.println("Qual algoritmo voce deseja pesquisar?");
            System.out.println("1->FIFO");
            System.out.println("2->SFJ/Nao-Preemptivo");
            System.out.println("3->SFJ/Preemptivo");
            System.out.println("4->Prioridade/Nao-Preemptivo");
            System.out.println("5->Prioridade/Preemptivo");
            System.out.println("6->Round Robin");
            System.out.println("7->Popular lista de processos");
            System.out.println("8->Imprimir lista de processos");
            System.out.println("0->Sair do sistema");
            consulta = sc.nextInt();




            switch(consulta) {

                case 1-> {

                    Fifo fifo = new Fifo();

                    fifo.initialArray(arrayProcessos);


//                    for(int i = 0; i < 1; i++) {
//
//                        fifo.populaTempos(flag, sc);
//
//                    }

                    fifo.arrayProcessos.sort(Comparator.comparingInt(Processo::getTempoChegada));
                    fifo.executarAlgoritmo();
                    float media = fifo.calculaTempoEsperaMedio();
                    fifo.mostraTempoEsperaMedio(media);
                }

                case 2-> {

                    SJF sjf = new SJF();



                    sjf.initialArray(arrayProcessos);

//                    sjf.populaArray(nroProcessos);
//                    boolean flag = sjf.perguntaPopulaRandom(sc);
//
//                    for(int i = 0; i < 1; i++) {
//
//                        sjf.populaTempos(flag, sc);
//
//                    }
                    sjf.ordenaElementos();


                    sjf.executaAlgoritmo();

                    float media = sjf.calculaTempoEsperaMedio();
                    sjf.mostraTempoEsperaMedio(media);

                }

                case 3-> {

                    SJF sjf = new SJF();

                    sjf.initialArray(arrayProcessos);
//                    sjf.populaArray(nroProcessos);
//                    boolean flag = sjf.perguntaPopulaRandom(sc);
//                    for(int i = 0; i < 1; i++) {
//
//                        sjf.populaTempos(flag, sc);
//
//                    }
                    sjf.ordenaElementos();

                    for(int i = 0; i < sjf.arrayProcessos.toArray().length; i++) {

                        sjf.arrayProcessos.get(i).setTempoRestante(sjf.arrayProcessos.
                                get(i).tempoExecucao);
                    }

                    ArrayList<Processo> processos = sjf.arrayProcessos;

                    sjf.executaAlgoritmoPreemptivo(processos);
                    float media = sjf.calculaTempoEsperaMedio();
                    sjf.mostraTempoEsperaMedio(media);

                }

                case 4-> {

                    Prioridade prioridade = new Prioridade();

                    prioridade.initialArray(arrayProcessos);
//                    prioridade.populaArray(nroProcessos);
//                    boolean flag = prioridade.perguntaPopulaRandom(sc);
//
//                    for(int i = 0; i < 1; i++) {
//
//                        prioridade.populaTempos(flag, sc);
//
//                    }


                    prioridade.ordenaElementos();
                    ArrayList<Processo> processos = prioridade.arrayProcessos;
                    processos.sort(Comparator.comparingInt(Processo::getPrioridade));

                    prioridade.executaAlgoritmo(processos);
                    float media = prioridade.calculaTempoEsperaMedio();
                    prioridade.mostraTempoEsperaMedio(media);


                }

                case 5-> {

                    Prioridade prioridade = new Prioridade();

                    prioridade.initialArray(arrayProcessos);

//                    prioridade.populaArray(nroProcessos);
//                    boolean flag = prioridade.perguntaPopulaRandom(sc);
//
//                    for(int i = 0; i < 1; i++) {
//
//                        prioridade.populaTempos(flag, sc);
//
//                    }

                    prioridade.ordenaElementos();

                    for(int i = 0; i < prioridade.arrayProcessos.toArray().length; i++) {

                        prioridade.arrayProcessos.get(i).setTempoRestante(prioridade.arrayProcessos.
                                get(i).tempoExecucao);
                    }


                    ArrayList<Processo> processos = prioridade.arrayProcessos;
                    processos.sort(Comparator.comparingInt(Processo::getPrioridade));
                    prioridade.executaAlgoritmoPreemptivo(processos);
                    float media = prioridade.calculaTempoEsperaMedio();
                    prioridade.mostraTempoEsperaMedio(media);

                }

                case 6-> {

                    RoundRobin roundRobin = new RoundRobin();

                    roundRobin.initialArray(arrayProcessos);

//                    y
                    roundRobin.ordenaElementos();


                    for(int i = 0; i < roundRobin.arrayProcessos.toArray().length; i++) {

                        roundRobin.arrayProcessos.get(i).setTempoRestante(roundRobin.arrayProcessos.
                                get(i).tempoExecucao);
                    }
                    roundRobin.mostraProcesso();
                    roundRobin.executaAlgoritmo();
                    float media = roundRobin.calculaTempoEsperaMedio();
                    roundRobin.mostraTempoEsperaMedio(media);

                }

                case 7-> {

                    arrayProcessos = new ArrayList<>();

                    populaArray(arrayProcessos, n_proc, flag, sc);

                }

                case 8-> {

                    mostraProcessos(arrayProcessos);

                }


            }


        }while(consulta != 0);
    }
}
