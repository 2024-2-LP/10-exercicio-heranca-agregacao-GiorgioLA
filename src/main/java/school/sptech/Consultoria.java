package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria() {
        desenvolvedores = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public List<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }

    public void contratar(Desenvolvedor desenvolvedor) {
        if (desenvolvedores.size() < vagas) {
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedorWeb) {
        if (desenvolvedores.size() < vagas && desenvolvedorWeb.isFullstack()) {
            desenvolvedores.add(desenvolvedorWeb);
        }
    }

    public Double getTotalSalarios() {
//        return desenvolvedores.stream()
//                .mapToDouble(Desenvolvedor::calcularSalario)
//                .sum();
        Double soma = 0.0;
        for (int i = 0; i < desenvolvedores.size(); i++) {
            soma += desenvolvedores.get(i).calcularSalario();
        }
        return soma;
    }

    public Integer qtdDesenvolvedoresMobile() {
        return desenvolvedores.stream()
                .filter(d -> d instanceof DesenvolvedorMobile)
                .toList()
                .size();
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {
        return desenvolvedores.stream()
                .filter(d -> d.calcularSalario() >= salario)
                .toList();
    }

    public Desenvolvedor buscarMenorSalario() {
        if (desenvolvedores.isEmpty() || desenvolvedores == null) {
            return null;
        }
        return desenvolvedores.stream()
                .sorted(Comparator.comparingDouble(Desenvolvedor::calcularSalario))
                .toList()
                .get(0);
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {

        List<Desenvolvedor> retorno = new ArrayList<>();
        for (Desenvolvedor dev: desenvolvedores) {
            if (dev.toString().contains(tecnologia)) {
                retorno.add(dev);
            }
        }
        return retorno;

//        return desenvolvedores.stream()
//                .filter(d -> d instanceof DesenvolvedorMobile && (
//                        ((DesenvolvedorMobile) d).getLinguagem().contains(tecnologia) ||
//                                ((DesenvolvedorMobile) d).getPlataforma().contains(tecnologia)
//                        ) || d instanceof DesenvolvedorWeb && (
//                                ((DesenvolvedorWeb) d).getBackend().contains(tecnologia) ||
//                                        ((DesenvolvedorWeb) d).getFrontend().contains(tecnologia) ||
//                                        ((DesenvolvedorWeb) d).getSgbd().contains(tecnologia)
//                        )
//                ).toList();
//
//        ------/----------/-----------/-----------/
//
//        List<Desenvolvedor> retorno = new ArrayList<>();
//        for (int i = 0; i < desenvolvedores.size(); i++) {
//            Desenvolvedor devDaVez = desenvolvedores.get(i);
//
//            if (devDaVez instanceof DesenvolvedorMobile) {
//                if (((DesenvolvedorMobile) devDaVez).getLinguagem().contains(tecnologia)) {
//                    retorno.add(devDaVez);
//                } else if (((DesenvolvedorMobile) devDaVez).getPlataforma().contains(tecnologia)) {
//                    retorno.add(devDaVez);
//                }
//            } else if (devDaVez instanceof DesenvolvedorWeb) {
//                if (((DesenvolvedorWeb) devDaVez).getBackend().contains(tecnologia)) {
//                    retorno.add(devDaVez);
//                } else if (((DesenvolvedorWeb) devDaVez).getFrontend().contains(tecnologia)) {
//                    retorno.add(devDaVez);
//                } else if (((DesenvolvedorWeb) devDaVez).getSgbd().contains(tecnologia)) {
//                    retorno.add(devDaVez);
//                }
//            }
//        }
//        return retorno;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia) {
        List<Desenvolvedor> lista = buscarPorTecnologia(tecnologia);

        Double soma = 0.0;
        for (int i = 0; i < lista.size(); i++) {
            soma += lista.get(i).calcularSalario();
        }
        return soma;
    }
}
