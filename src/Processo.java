public class Processo {

    int id;
    int tempoExecucao;
    int tempoEspera;
    int fatiaTempo = 3;
    int tempoRestante;
    int tempoChegada;
    int prioridade;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTempoExecucao() {
        return tempoExecucao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setTempoExecucao(int tempoExecucao) {
        this.tempoExecucao = tempoExecucao;
    }

    public int getTempoEspera() {
        return tempoEspera;
    }

    public void setTempoEspera(int tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    public int getFatiaTempo() {
        return fatiaTempo;
    }

    public void setTempoRestante(int tempoRestante) {this.tempoRestante = tempoRestante;}

    public int getTempoChegada() {
        return tempoChegada;
    }

    public void setFatiaTempo(int fatiaTempo) {
        this.fatiaTempo = fatiaTempo;
    }

    public Processo(int id) {

        this.id = id;

    }

}
