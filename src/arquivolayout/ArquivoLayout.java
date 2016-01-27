package arquivolayout;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import arquivo.Arquivo;

import com.towel.el.annotation.Resolvable;

@Entity
@Table(name = "arq_layout")
public class ArquivoLayout {

	@Id
	@SequenceGenerator(name = "SEQ_ARQ_LAYOUT", sequenceName = "SEQ_ARQ_LAYOUT", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ARQ_LAYOUT")
	private Long id_arquivo_layout;

	@Column(name = "id_layout")
	private Long idLayout;

	@Column(name = "id_tipo_layout")
	private Long idTipoLayout;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "status")
	private String status;

	@Column(name = "diretorio")
	private String diretorio;

	@Column(name = "id_fin_banco")
	private Long idFinBanco;

	@Column(name = "versao_layout_febraban")
	private Long versaoLayoutFebraban;

	@Column(name = "diretorio_retorno")
	private Long diretorioRetorno;

	@ManyToOne
	@JoinColumn(name = "ID_LAYOUT", referencedColumnName = "ID_LAYOUT")
	@Resolvable
	private Arquivo arquivo;

	public Long getId_arquivo_layout() {
		return id_arquivo_layout;
	}

	public void setId_arquivo_layout(Long id_arquivo_layout) {
		this.id_arquivo_layout = id_arquivo_layout;
	}

	public Long getIdLayout() {
		return idLayout;
	}

	public void setIdLayout(Long idLayout) {
		this.idLayout = idLayout;
	}

	public Long getIdTipoLayout() {
		return idTipoLayout;
	}

	public void setIdTipoLayout(Long idTipoLayout) {
		this.idTipoLayout = idTipoLayout;
	}

	public Long getIdFinBanco() {
		return idFinBanco;
	}

	public void setIdFinBanco(Long idFinBanco) {
		this.idFinBanco = idFinBanco;
	}

	public Long getVersaoLayoutFebraban() {
		return versaoLayoutFebraban;
	}

	public void setVersaoLayoutFebraban(Long versaoLayoutFebraban) {
		this.versaoLayoutFebraban = versaoLayoutFebraban;
	}

	public Long getDiretorioRetorno() {
		return diretorioRetorno;
	}

	public void setDiretorioRetorno(Long diretorioRetorno) {
		this.diretorioRetorno = diretorioRetorno;
	}

	public Arquivo getArquivo() {
		return arquivo;
	}

	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDiretorio() {
		return diretorio;
	}

	public void setDiretorio(String diretorio) {
		this.diretorio = diretorio;
	}

}