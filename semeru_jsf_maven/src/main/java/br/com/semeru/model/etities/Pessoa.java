package br.com.semeru.model.etities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table (name="pessoa")
public class Pessoa implements Serializable{

    private static final Long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdPessoa", nullable=false)
    private Integer idPessoa;
    
    @Column(name="Name", nullable=false, length = 80)
    private String nome;
    
    @Column(name="Email", nullable=false, length = 80)
    private String email;
    
    @Column(name="Telefone", nullable=false, length = 15) //(xxx)-xxxx-xxxx
    private String telefone;
    
    @Column(name="CPF", nullable=false, length = 14)
    private String cpf;
    
    @Column(name="DataDeNascimento", nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeNascimento;
    
    @Column(name="DatadeCadastro", nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeCadastro;

    @ManyToOne(optional=false)
    @ForeignKey(name="PessoaSexo")
    private Pessoa pessoa;
    
    public Pessoa() {
    }

    public Pessoa(Integer idPessoa, String nome, String email, String telefone, String cpf, Date dataDeNascimento, Date dataDeCadastro) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.dataDeCadastro = dataDeCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.idPessoa != null ? this.idPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (this.idPessoa != other.idPessoa && (this.idPessoa == null || !this.idPessoa.equals(other.idPessoa))) {
            return false;
        }
        return true;
    }
          
    
}
