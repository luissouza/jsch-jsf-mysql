package dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {
	
	/** Persiste o objeto dentro do banco de dados 
	 * @param object
	 */
	public ID insert(T object);
	
	/** Retorna um objeto anteriormente persistido no banco 
     *  através da chave primary Id
     * @param id
     */
	public T select(ID id);
	
	
	/*Retorna lista de determinado objeto, select restriction like*/
	//public List<T> select (T object);
	
	/** Grava as alterações realizadas no Objeto */
	public void update(T object);
	
	/** Apaga o objeto do banco de dados */
	public void delete(T object);
	
	/** Retorna lista de objetos */
	public List<T> list();

	//List<T> selectByName(T object);  

}