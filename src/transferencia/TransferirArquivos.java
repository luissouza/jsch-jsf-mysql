package transferencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import conexao.ConexaoServidor;

import arquivo.Arquivo;
import arquivo.ArquivoDAO;

@ManagedBean(name = "transferirArquivos")
@ViewScoped
public class TransferirArquivos {

	private String destinoServidor = "/tmp";
	private String sFtpDiretorio = "/tmp";
	private String nomeArquivo;
	private StreamedContent file;

	private ArquivoDAO arquivoDao = new ArquivoDAO();
	private Arquivo arquivoSelecionado = new Arquivo();
	ConexaoServidor serverConnection = new ConexaoServidor();
	public List<Arquivo> listArquivo = new ArrayList<Arquivo>();

	public TransferirArquivos() {
		listArquivo = arquivoDao.consultaArquivo(9);
	}

	// Método para executar Download.
	public void executarDownload() {
		try {
			ConexaoServidor conexaoServidor = new ConexaoServidor();

			// Estabelece conexão com o servidor.
			conexaoServidor.iniciarConexao();

			// Nome do arquivo selecionado para download, obtido pelo
			// componente setPropertyActionListener.
			
			nomeArquivo = arquivoSelecionado.getNomeArquivo().toString();

			// Acessa o diretório informado.
			conexaoServidor.getChannelSftp().cd(sFtpDiretorio);

			// Armazena os bytes do arquivo em na instância de InputStream.
			InputStream stream = conexaoServidor.getChannelSftp().get(
					nomeArquivo);

			// Cria um novo arquivo do tipo StreamedContent
			file = new DefaultStreamedContent(stream, "application/txt",
					nomeArquivo);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// Método para executar Upload.
	public void executarUpload(FileUploadEvent event) {
		try {
			ConexaoServidor conexaoServidor = new ConexaoServidor();
			conexaoServidor.iniciarConexao();

			String fileName = event.getFile().getFileName();
			InputStream in = event.getFile().getInputstream();
			String diretorioTemp = System.getProperty("java.io.tmpdir");

			File file = new File(diretorioTemp, fileName);

			OutputStream out = new FileOutputStream(file);

			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			in.close();
			file.deleteOnExit();
			conexaoServidor.getChannelSftp().cd(destinoServidor);
			conexaoServidor.getChannelSftp().put(new FileInputStream(file),
					fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Arquivo> getListArquivo() {
		return listArquivo;
	}

	public void setListArquivo(List<Arquivo> listArquivo) {
		this.listArquivo = listArquivo;
	}

	public StreamedContent getFile() {
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}

	public Arquivo getArquivoSelecionado() {
		return arquivoSelecionado;
	}

	public void setArquivoSelecionado(Arquivo arquivoSelecionado) {
		this.arquivoSelecionado = arquivoSelecionado;
	}
	
	
	
}
