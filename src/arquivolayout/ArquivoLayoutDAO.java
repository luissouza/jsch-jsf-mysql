package arquivolayout;

import java.util.List;

import org.hibernate.Query;

import dao.GenericDAOImpl;

public class ArquivoLayoutDAO extends GenericDAOImpl<ArquivoLayout, Long> {

	public List<ArquivoLayout> consultaArquivo(int idLayout) {

		Query qry = getSession().createQuery("select a from ArquivoLayout a");
		List<ArquivoLayout> listArquivo = qry.list();

		return listArquivo;

	}

}
