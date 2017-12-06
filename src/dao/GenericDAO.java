package dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Empresa;
import app.Main;

public abstract class GenericDAO<T> {
	
	public long count() {
		System.out.println("count");
		return 0;
	}
	
	public T findById(int id) {
		
		if(!Main.getBD().getConnection())
			return null;
		
		T result = null;
		try {
			Statement st = Connect.c.createStatement();
            String sql = "SELECT * FROM empresa WHERE id = " + id;
            ResultSet rs = st.executeQuery( sql );
            
            T ret = this.transformRS(rs);
            
            rs.close();
            st.close();
            Connect.c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public T transformRS(ResultSet rs) {
		
		try {
			rs.next();
			long l1 = System.currentTimeMillis();
			T meuObj = this.getThisClass().newInstance();
			System.out.println("instanciando objeto: " + meuObj);
			
			for(Method m : this.getThisClass().getMethods()) {
				String metodo = m.getName();
				if(metodo.startsWith("set")) {
					System.out.println("metodo set!! " + m);
					
					String nomeVariavel = metodo.replace("set", "");
					nomeVariavel = nomeVariavel.substring(0, 1).toLowerCase() + nomeVariavel.substring(1);
					
					System.out.println("nomeDaVariavel: " + nomeVariavel);
					
					Object valorNoBanco = rs.getObject(nomeVariavel);
					
					System.out.println("Objeto de retorno: " + valorNoBanco);
					System.out.println("Classe Objeto de retorno: " + valorNoBanco.getClass());
					
					m.invoke(meuObj, valorNoBanco);
				}
			}
			
			System.out.println("levou: " + (System.currentTimeMillis() - l1) + " ms");
			
			return (T) meuObj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		throw new IllegalArgumentException("deu ruim");
	}
	
	public List<T> findAll() {
		return new ArrayList<T>();
	}
	
	public boolean save(T obj) {
		return true;
	}
	
	public Class<T> getThisClass() {
        return ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

	
}
