package school.sptech;

public class Desenvolvedor {
    protected String nome;
    protected Integer qtdHoras;
    protected Double valorHora;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdHoras() {
        return qtdHoras;
    }

    public void setQtdHoras(Integer qtdHoras) {
        this.qtdHoras = qtdHoras;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    public Double calcularSalario() {
        return qtdHoras * valorHora;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Desenvolvedor{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", qtdHoras=").append(qtdHoras);
        sb.append(", valorHora=").append(valorHora);
        sb.append('}');
        return sb.toString();
    }
}
