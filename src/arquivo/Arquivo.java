package arquivo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import arquivolayout.ArquivoLayout;

import com.towel.el.annotation.Resolvable;

@Entity
@Table(name="arq_arquivo")
public class Arquivo implements Serializable {

	private static final long serialVersionUID = -597406531256452275L;
	
	@Id
	@SequenceGenerator(name="SEQ_ARQ_ARQUIVO", sequenceName ="SEQ_ARQ_ARQUIVO", allocationSize =1, initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ARQ_ARQUIVO")
	private Long id_arquivo;
	
	@Column(name="sequencia")
	private Long sequencia;
	
	@Column(name="id_layout")
	private Integer idLayout;
	
	@Column(name="nome_arquivo")
	private String nomeArquivo;
	
	@Column(name="dt_importacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataImportacao;
	
	@Column(name="dt_integracao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataIntegracao;

	@Column(name="tipo_arquivo")
	private String tipoArquivo;
	
	@Column(name="status_arquivo")
	private String statusArquivo;
	
	@Column(name="diretorio_geracao")
	private String diretorioGravacao;
	
	@Column(name="msg_erro")
	private String msgErro;
	
	@Column(name="id_empresa")
	private Long idEmpresa;
	
	@Column(name="cad_mail")
	private String cadMail;
	
	@OneToMany(mappedBy = "arquivo")
	@Cascade(value = {CascadeType.ALL})
    @Resolvable
	private Collection<ArquivoLayout> arquivoLayout; 
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id_arquivo == null) ? 0 : id_arquivo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arquivo other = (Arquivo) obj;
		if (id_arquivo == null) {
			if (other.id_arquivo != null)
				return false;
		} else if (!id_arquivo.equals(other.id_arquivo))
			return false;
		return true;
	}

	public Long getId_arquivo() {
		return id_arquivo;
	}

	public void setId_arquivo(Long id_arquivo) {
		this.id_arquivo = id_arquivo;
	}

	public Long getSequencia() {
		return sequencia;
	}

	public void setSequencia(Long sequencia) {
		this.sequencia = sequencia;
	}


	public Integer getIdLayout() {
		return idLayout;
	}

	public void setIdLayout(Integer idLayout) {
		this.idLayout = idLayout;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public Date getDataImportacao() {
		return dataImportacao;
	}

	public void setDataImportacao(Date dataImportacao) {
		this.dataImportacao = dataImportacao;
	}

	public Date getDataIntegracao() {
		return dataIntegracao;
	}

	public void setDataIntegracao(Date dataIntegracao) {
		this.dataIntegracao = dataIntegracao;
	}

	public String getTipoArquivo() {
		return tipoArquivo;
	}

	public void setTipoArquivo(String tipoArquivo) {
		this.tipoArquivo = tipoArquivo;
	}

	public String getStatusArquivo() {
		return statusArquivo;
	}

	public void setStatusArquivo(String statusArquivo) {
		this.statusArquivo = statusArquivo;
	}

	public String getDiretorioGravacao() {
		return diretorioGravacao;
	}

	public void setDiretorioGravacao(String diretorioGravacao) {
		this.diretorioGravacao = diretorioGravacao;
	}

	public String getMsgErro() {
		return msgErro;
	}

	public void setMsgErro(String msgErro) {
		this.msgErro = msgErro;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	

	public String getCadMail() {
		return cadMail;
		
	}

	public void setCadMail(String cadMail) {
		this.cadMail = cadMail;
	}
	

	public Collection<ArquivoLayout> getArquivoLayout() {
		return arquivoLayout;
	}

	public void setArquivoLayout(Collection<ArquivoLayout> arquivoLayout) {
		this.arquivoLayout = arquivoLayout;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

}
