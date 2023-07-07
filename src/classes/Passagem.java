package classes;

import enums.Situacao;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;


@Entity
public class Passagem implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPassagem;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    @Temporal(TemporalType.DATE)
    private Date data_entrada;

    @Temporal(TemporalType.DATE)
    private Date data_saida;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="idPessoa")
    private Passageiro passageiro;
    

    @ManyToMany (fetch = FetchType.EAGER, cascade= CascadeType.PERSIST)
    @JoinTable( name="Voo_Passagem",
            joinColumns={ @JoinColumn(name="idPassagem")},
            inverseJoinColumns={@JoinColumn(name="idVoo")})
    private List<Voo> voos;

    public Passagem(){}

    public Passagem(Date data_entrada, Date data_saida, Passageiro passageiro, List<Voo> voos){
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;
        this.passageiro = passageiro;
        this.voos = voos;
    }

    public Long getIdPassagem() {
        return idPassagem;
    }

    public void setIdPassagem(Long idPassagem) {
        this.idPassagem = idPassagem;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Date getData_saida() {
        return data_saida;
    }

    public void setData_saida(Date data_saida) {
        this.data_saida = data_saida;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setHospede(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public List<Voo> getVoos() {
        return voos;
    }

    public void setVoos(List<Voo> voos) {
        this.voos = voos;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passagem passagem = (Passagem) o;
        return Objects.equals(getIdPassagem(), passagem.getIdPassagem()) && Objects.equals(getData_entrada(), passagem.getData_entrada()) && Objects.equals(getData_saida(), passagem.getData_saida()) && Objects.equals(getPassageiro(), passagem.getPassageiro()) && Objects.equals(getVoos(), passagem.getVoos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdPassagem(), passageiro.getNome() ,getData_entrada(), getData_saida());
    }

    @Override
    public String toString() {
    	
    	String voosStr = voos.toString().replaceAll("\\[|\\]", "");
    	
        return  "\n" +"Passagem ID = " + idPassagem  + "\n" +
                "data_entrada = " + (data_entrada.getDate())+"/"+ (data_entrada.getMonth()+1)+"/"+(data_entrada.getYear()+1900)  + "\n" +
                "data_saida = " + (data_saida.getDate())+"/"+ (data_saida.getMonth()+1)+"/"+(data_saida.getYear()+1900)  + "\n" +
                "Passageiro = " + passageiro.getNome() + "\n\n" +
                "Voos = " + "\n" + voosStr;
    }
}
