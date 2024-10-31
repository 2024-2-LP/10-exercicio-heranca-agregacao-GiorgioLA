package school.sptech.especialistas;

import school.sptech.Desenvolvedor;

public class DesenvolvedorMobile extends Desenvolvedor {
    private String plataforma;
    private String linguagem;
    private Integer horasPrototipacao;

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    public Integer getHorasPrototipacao() {
        return horasPrototipacao;
    }

    public void setHorasPrototipacao(Integer horasPrototipacao) {
        this.horasPrototipacao = horasPrototipacao;
    }

    @Override
    public Double calcularSalario() {
        return super.calcularSalario() + 200.0 * horasPrototipacao;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DesenvolvedorMobile{");
        sb.append("plataforma='").append(plataforma).append('\'');
        sb.append(", linguagem='").append(linguagem).append('\'');
        sb.append(", horasPrototipacao=").append(horasPrototipacao);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", qtdHoras=").append(qtdHoras);
        sb.append(", valorHora=").append(valorHora);
        sb.append('}');
        return sb.toString();
    }
}
