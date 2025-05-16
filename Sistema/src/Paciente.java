public class Paciente {

    private String nome;
    private Integer idade;
    private MotivoConsulta motivoConsulta;
    private Prioridade prioridade;


    public Paciente(String nome, Integer idade, MotivoConsulta motivoConsulta, Prioridade prioridade) {
        this.nome = nome;
        this.idade = idade;
        this.motivoConsulta = motivoConsulta;
        this.prioridade = prioridade;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public MotivoConsulta getMotivoConsulta() {
        return motivoConsulta;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    @Override
    public String toString() {
        return "Paciente [nome=" + nome + ", idade=" + idade + ", motivoConsulta=" + motivoConsulta + ", prioridade="
                + prioridade + "]";
    }
    
}
