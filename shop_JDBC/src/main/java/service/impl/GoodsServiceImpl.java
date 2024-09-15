package service.impl;

import java.util.List;

import dao.impl.GoodsDaoImpl;
import model.Goods;
import service.GoodsService;

public class GoodsServiceImpl implements GoodsService{
	
	private static GoodsDaoImpl mdi=new GoodsDaoImpl();

	@Override
	public void addGoods(Goods g) {
		mdi.add(g);				
	}
	
	public boolean isNameDuplicate(String name) {
		 List<Goods> goodsList = mdi.selectName(name);
		 return !goodsList.isEmpty();
	}

	@Override
	public List<Goods> selectAll() {
				
		return mdi.selectAll();
	}

	@Override
	public List<Goods> selectBy(int id) {
		
		return mdi.selectBy(id);
	}

	@Override
	public List<Goods> selectName(String name) {
		
		return mdi.selectName(name);
	}

	@Override
	public List<Goods> selectPrice(int minPrice, int maxPrice) {
		
		return mdi.selectPrice(minPrice, maxPrice);
	}

	@Override
	public void update(int id, int price, int quantity) {
		List<Goods> goodsList = mdi.selectBy(id);
		 Goods[] g = goodsList.toArray(new Goods[1]);
		 if (goodsList.isEmpty()) {
		        System.out.println("商品ID不存在！");
		     return;
		 }    
		 g[0].setPrice(price);
		 g[0].setQuantity(quantity);
		 
		 mdi.update(g[0]);		
	}
	
	public boolean updateSuccess(int id, int price, int quantity) {
	    List<Goods> goodsList = mdi.selectBy(id);
	    if (goodsList.isEmpty()) {
	    	return false;
	    }	else {
	        return true;
	    }
	}    

	@Override
	public void delete(int id) {
		mdi.delete(id);		
	}
	
	public boolean isIdDuplicate(int id) {
		 List<Goods> goodsList = mdi.selectBy(id);
		 return !goodsList.isEmpty();
	}

	@Override
	public List<Goods> selectNamePrice_1(String name, int minPrice, int maxPrice) {
		
		return mdi.selectNamePrice_1(name, minPrice, maxPrice);
	}

	@Override
	public List<Goods> selectNamePrice_2(String name, int minPrice) {
		
		return mdi.selectNamePrice_2(name, minPrice);
	}

	@Override
	public List<Goods> selectNamePrice_3(String name, int maxPrice) {

		return mdi.selectNamePrice_3(name, maxPrice);
	}

	@Override
	public List<Goods> selectByPrice_1(int minPrice) {
		
		return mdi.selectByPrice_1(minPrice);
	}

	@Override
	public List<Goods> selectByPrice_2(int maxPrice) {
		
		return mdi.selectByPrice_2(maxPrice);
	}

}
