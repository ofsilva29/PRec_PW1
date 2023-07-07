package classes;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "Passageiro")
public class Passageiro extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList endereco;
    private String cpf;

    @Temporal(TemporalType.DATE)
    private Date data_nasc;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Passageiro_Telefones")
    private ArrayList<String> telefones;
    
    @OneToMany (fetch = FetchType.EAGER, mappedBy = "passageiro", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name="idPassagem")
    private List<Passagem> passagens = new LinkedList<>();

    public Passageiro(){
        super();
    }

    public Passageiro(String nome, ArrayList<String> telefone, String cpf, List<Passagem> passagem){
        super(nome, telefone);
        this.cpf = cpf;
        this.telefones = telefones;
        this.passagem = passagem;
    }

   public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(ArrayList<String> telefones) {
        this.telefones = telefones;
    }

    public List<Passagem> getPassagens() {
        return passagens;
    }

    public void setPassagens(List<Passagem> passagens) {
        this.passagens = passagens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Passageiro passageiro = (Passageiro) o;
        return (Objects.equals(passageiro.getCpf()) && Objects.equals(getTelefones(), passageiro.getTelefones()) && Objects.equals(getPassagens(), passageiro.getPassagens());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCpf(), getTelefones(), getPassagens());
    }

    @Override
    public String toString() {

        String telefonesString = telefones.toString().replaceAll("\\[|\\]", "");
        String passagensString = passagens.toString().replaceAll("\\[|\\]", "");

        return "PASSAGEIRO = " + "\n" + super.toString() +
                "CPF = " + cpf + "\n" +
                "TELEFONES = " + telefonesString + "\n\n" +
                "PASSAGENS = " + passagensString;
    }
}
