package dao;

import java.util.List;

import model.Goods;

public interface GoodsDao {
	//create
	void add(Goods g);
	
	
	//read
	List<Goods> selectAll();
	List<Goods> selectBy(int id);
	List<Goods> selectName(String name);
	List<Goods> selectPrice(int minPrice, int maxPrice);
	
	List<Goods> selectNamePrice_1(String name, int minPrice, int maxPrice);
	List<Goods> selectNamePrice_2(String name, int minPrice);
	List<Goods> selectNamePrice_3(String name, int maxPrice);
	List<Goods> selectByPrice_1(int minPrice);
	List<Goods> selectByPrice_2(int maxPrice);
	
	//update
	void update(Goods g);
	
	//delete
	void delete(int id);


}
