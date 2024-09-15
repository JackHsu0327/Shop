package service;

import java.util.List;

import model.Goods;

public interface GoodsService {
	// create
	void addGoods(Goods g);

	// read
	List<Goods> selectAll();

	List<Goods> selectBy(int id);

	List<Goods> selectName(String name);

	List<Goods> selectPrice(int minPrice, int maxPrice);
	
	List<Goods> selectNamePrice_1(String name, int minPrice, int maxPrice);
	List<Goods> selectNamePrice_2(String name, int minPrice);
	List<Goods> selectNamePrice_3(String name, int maxPrice);
	List<Goods> selectByPrice_1(int minPrice);
	List<Goods> selectByPrice_2(int maxPrice);

	// update
	void update(int id, int price, int quantity);

	// delete
	void delete(int id);
}
