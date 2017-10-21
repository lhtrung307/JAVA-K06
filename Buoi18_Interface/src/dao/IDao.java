package dao;

import java.util.ArrayList;

public interface IDao<T> {
	public ArrayList<T> selectAll();

	public ArrayList<T> selectByID(T t);

	public boolean insert(T t);

	public boolean update(T t);

	public boolean delete(T t);
}
