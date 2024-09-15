package dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.GoodsDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Goods;


public class GoodsDaoImpl implements GoodsDao{

//	private static EntityManager em=DbConnection.getDb();
	@Override
	public void add(Goods g) {
		/*EntityTransaction t=em.getTransaction();
		t.begin();
		em.persist(g);
		t.commit();*/
		
		Connection conn = DbConnection.getDb();
		String SQL="insert into goods(name, price, quantity) values(?, ?, ?)";
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, g.getName());
			ps.setLong(2, g.getPrice());
			ps.setLong(3, g.getQuantity());
			
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
	        try {
	            conn.rollback(); 
	        } catch (SQLException rollbackEx) {
	            rollbackEx.printStackTrace();
	        }
	        e.printStackTrace();
	    } finally {
	        try {
	            conn.setAutoCommit(true);  
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	}

	@Override
	public List<Goods> selectAll() {
		/*String SQL="select * from shop.goods";
		Query q=em.createNativeQuery(SQL,Goods.class);	
		
		return q.getResultList();*/
		Connection conn = DbConnection.getDb();
		String SQL="select * from goods";
		List<Goods> l = new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Goods g = new Goods();
				g.setId(rs.getInt("id"));
				g.setName(rs.getString("name"));
				g.setPrice(rs.getInt("price"));
				g.setQuantity(rs.getInt("quantity"));
				
				l.add(g);
			}			
		}	catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Goods> selectBy(int id) {
		/*String SQL="select * from shop.goods where id=?";
		Query q=em.createNativeQuery(SQL,Goods.class);	
		q.setParameter(1,id);
		
		return q.getResultList();*/
		Connection conn = DbConnection.getDb();
		String SQL="select * from goods where id = ?";
		List<Goods> l = new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
	            Goods g = new Goods();
	            g.setId(rs.getInt("id"));
	            g.setName(rs.getString("name"));
	            g.setPrice(rs.getInt("price"));
	            g.setQuantity(rs.getInt("quantity"));
				
				l.add(g);
			}			
		}	catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Goods> selectName(String name) {
		/*String SQL="select * from shop.goods where name like ?";
		Query q=em.createNativeQuery(SQL,Goods.class);	
		q.setParameter(1,"%"+name+"%");
		
		return q.getResultList();*/
		Connection conn = DbConnection.getDb();
		String SQL="select * from goods where name like ?";
		List<Goods> l = new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1,"%"+name+"%");
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
			    Goods g = new Goods();
			    g.setId(rs.getInt("id"));
			    g.setName(rs.getString("name"));
			    g.setPrice(rs.getInt("price"));
			    g.setQuantity(rs.getInt("quantity"));
			    l.add(g);
			}		
		}	catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Goods> selectPrice(int minPrice, int maxPrice) {
		/*String SQL="select * from shop.goods where price between ? and ?";
		Query q=em.createNativeQuery(SQL,Goods.class);	
		q.setParameter(1, minPrice);
	    q.setParameter(2, maxPrice);
		
		return q.getResultList();*/
		
		Connection conn = DbConnection.getDb();
		String SQL="select * from goods where price between ? and ?";
		List<Goods> l = new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, minPrice);
			ps.setInt(2, maxPrice);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Goods g = new Goods();
				g.setId(rs.getInt("id"));
				g.setName(rs.getString("name"));
				g.setPrice(rs.getInt("price"));
				g.setQuantity(rs.getInt("quantity"));
				
				l.add(g);
			}			
		}	catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}	

	@Override
	public void update(Goods g) {
		/*EntityTransaction t=em.getTransaction();
		t.begin();
		em.merge(g);
		t.commit();*/
		Connection conn = DbConnection.getDb();
		String SQL="update goods set name=?, price=?, quantity=? where id=?";
		
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1,g.getName());
			ps.setInt(2, g.getPrice());
			ps.setInt(3, g.getQuantity());
			ps.setInt(4, g.getId());
			
			ps.executeUpdate();
			conn.commit();
	    } catch (SQLException e) {
	        try {
	            conn.rollback(); 
	        } catch (SQLException rollbackEx) {
	            rollbackEx.printStackTrace();
	        }
	        e.printStackTrace();
	    } finally {
	        try {
	            conn.setAutoCommit(true);  
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	}

	@Override
	public void delete(int id) {
		/*EntityTransaction t=em.getTransaction();
		t.begin();
		em.remove(id);
		t.commit();*/
		Connection conn = DbConnection.getDb();
		String SQL="delete from goods where id=?";
		
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
	        try {
	            conn.rollback(); 
	        } catch (SQLException rollbackEx) {
	            rollbackEx.printStackTrace();
	        }
	        e.printStackTrace();
	    } finally {
	        try {
	            conn.setAutoCommit(true);  
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	}

	@Override
	public List<Goods> selectNamePrice_1(String name, int minPrice, int maxPrice) {
		Connection conn = DbConnection.getDb();
		String SQL="select * from goods where name like ? and price between ? and ?";
		List<Goods> l = new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1,"%"+name+"%");
			ps.setInt(2, minPrice);
			ps.setInt(3, maxPrice);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Goods g = new Goods();
				g.setId(rs.getInt("id"));
				g.setName(rs.getString("name"));
				g.setPrice(rs.getInt("price"));
				g.setQuantity(rs.getInt("quantity"));
				
				l.add(g);
			}			
		}	catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}	

	@Override
	public List<Goods> selectNamePrice_2(String name, int minPrice) {
		Connection conn = DbConnection.getDb();
		String SQL="select * from goods where name like ? and price >= ?";
		List<Goods> l = new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1,"%"+name+"%");
			ps.setInt(2, minPrice);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Goods g = new Goods();
				g.setId(rs.getInt("id"));
				g.setName(rs.getString("name"));
				g.setPrice(rs.getInt("price"));
				g.setQuantity(rs.getInt("quantity"));
				
				l.add(g);
			}			
		}	catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}	

	@Override
	public List<Goods> selectNamePrice_3(String name, int maxPrice) {
		Connection conn = DbConnection.getDb();
		String SQL="select * from shop.goods where name like ? and price <= ?";
		List<Goods> l = new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1,"%"+name+"%");
			ps.setInt(2, maxPrice);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Goods g = new Goods();
				g.setId(rs.getInt("id"));
				g.setName(rs.getString("name"));
				g.setPrice(rs.getInt("price"));
				g.setQuantity(rs.getInt("quantity"));
				
				l.add(g);
			}			
		}	catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}	
	@Override
	public List<Goods> selectByPrice_1(int minPrice) {		
		Connection conn = DbConnection.getDb();
		String SQL="select * from goods where price >= ?";
		List<Goods> l = new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, minPrice);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
	            Goods g = new Goods();
	            g.setId(rs.getInt("id"));
	            g.setName(rs.getString("name"));
	            g.setPrice(rs.getInt("price"));
	            g.setQuantity(rs.getInt("quantity"));
				
				l.add(g);
			}			
		}	catch (SQLException e) {
			e.printStackTrace();
		}
		return l;	
	}

	@Override
	public List<Goods> selectByPrice_2(int maxPrice) {
		Connection conn = DbConnection.getDb();
		String SQL="select * from goods where price <= ?";
		List<Goods> l = new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, maxPrice);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
	            Goods g = new Goods();
	            g.setId(rs.getInt("id"));
	            g.setName(rs.getString("name"));
	            g.setPrice(rs.getInt("price"));
	            g.setQuantity(rs.getInt("quantity"));
				
				l.add(g);
			}			
		}	catch (SQLException e) {
			e.printStackTrace();
		}
		return l;	
	}
	

}
