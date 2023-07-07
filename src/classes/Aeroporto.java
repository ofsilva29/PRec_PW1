package classes;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity

public class Aeroporto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAeroporto;
    private String cidade;
    private String nomeaero;



    public Aeroporto(){}

    public Aeroporto(String cidade, String nomeaero) {
        this.cidade = cidade;
        this.nomeaero = nomeaero;
        
    }

    public Long getIdAeroporto() {
        return idAeroporto;
    }

    public void setIdAeroporto(Long idAeroporto) {
        this.idAeroporto = idAeroporto;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String isNomeaero() {
        return nomeaero;
    }

    public void setNomeaero(String nomeaero) {
        this.nomeaero = nomeaero;
    }

        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aeroporto that = (Aeroporto) o;
        return isNomeaero() == that.isNomeaero() && Objects.equals(getIdAeroporto(), that.getIdAeroporto()) && Objects.equals(getCidade(), that.getCidade());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdAeroporto(), getCidade(), isNomeaero());
    }

    @Override
    public String toString() {
    	   	
        return  "Aeroporto id = " + idAeroporto + "\n" +
                "cidade = " + cidade + "\n" +
                "nomeaero = " + nomeaero + "\n";
    }
}
