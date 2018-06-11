package imnet.sid.fulltext.dao;

public interface DAO<T> {

	
	public boolean create(T obj);
	public T update(T objet);
	public void delete(int obj);
	public T read(int obj);
	
	public int getSequence();
	
}
