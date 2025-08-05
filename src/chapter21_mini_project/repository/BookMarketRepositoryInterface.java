package chapter21_mini_project.repository;

import java.util.List;

public interface BookMarketRepositoryInterface<T> {
	int insert(T entity);
	String 	findId();
	List<T> findAll();
	T find(String id);
	int update(T entity);
	int remove(T entity);
	int removeAll();
	void close();
}
