package arquivo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import dao.GenericDAOImpl;

public class ArquivoDAO extends GenericDAOImpl<Arquivo, Long> {

	public List<Arquivo> consultaArquivo(Integer idLayout) {

		Query qry = getSession()
				.createQuery(
						"select a from Arquivo a  where a.idLayout = :pIdLayout and a.diretorioGravacao is not null order by a.dataImportacao desc")
				.setParameter("pIdLayout", idLayout);
		List<Arquivo> listArquivo = new ArrayList<Arquivo>();
		listArquivo.clear();
		listArquivo = qry.list();

		return listArquivo;

	}

}
