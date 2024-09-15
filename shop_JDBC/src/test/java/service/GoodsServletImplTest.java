package service;

import java.util.List;

import org.junit.Test;

import model.Goods;
import servlet.impl.GoodsServletImpl;

public class GoodsServletImplTest {
	private static GoodsServletImpl mdi= new GoodsServletImpl();
	
	//@Test
	public void addTest() {
		mdi.addGoods(null);
		System.out.println("success");
	}
	
	//@Test
	public void selectAllTest(){
		System.out.println(mdi.selectAll());
	}
	
	//@Test
	public void selectByTest(){
		List<Goods> l=mdi.selectBy(1);
		Goods m=l.get(0);
		System.out.println(l);
	}
	
	//@Test
	public void selectNameTest(){
		List<Goods> l=mdi.selectName("ca");
		Goods m=l.get(0);
		System.out.println(l);
	}
	
	@Test
	public void selectPriceTest(){
		List<Goods> l=mdi.selectPrice(100, 150);
		Goods m=l.get(0);
		System.out.println(l);
	}
	
}
