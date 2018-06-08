package imnet.sid.fulltext.dao;

public interface DAO<T> {

	
	public T create(T obj);
	public T update(T objet);
	public void delete(int obj);
	public T read(int obj);
	
}
