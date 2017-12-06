package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Empresa;
import app.Main;

public class EmpresaDAO extends GenericDAO {
	
	public ArrayList<Empresa> getAllEmpresa(){
		
		if(!Main.getBD().getConnection())
			return null;
		
		ArrayList<Empresa> resultado = new ArrayList();
		
        try{
        	Statement st = Connect.c.createStatement();
            String sql = "SELECT * FROM empresa";
            ResultSet rs = st.executeQuery( sql );
            
            while ( rs.next() ) {
                int idEmpresa = rs.getInt("id");
                String razaoSocial = rs.getString("razao_social");
                
                resultado.add(new Empresa(idEmpresa, razaoSocial));
            }
            
            rs.close();
            st.close();
            Connect.c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE CONSULTA: getEmpresa");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            e.printStackTrace();
        }
        
        return resultado;
    }
	
	public Empresa getEmpresa(int id){
		
		if(!Main.getBD().getConnection())
			return null;
		
        Empresa resultado = null;
        try{
        	Statement st = Connect.c.createStatement();
            String sql = "SELECT * FROM empresas WHERE id = " + id;
            ResultSet rs = st.executeQuery( sql );
            
            while ( rs.next() ) {
                int idEmpresa = rs.getInt("id");
                String razaoSocial = rs.getString("razao_social");
                
                resultado = new Empresa(idEmpresa, razaoSocial);
            }
            
            rs.close();
            st.close();
            Connect.c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE CONSULTA: getEmpresa");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            e.printStackTrace();
        }
        return resultado;
    }
	
	public boolean cadastrarEmpresa(Empresa emp){
		
		if(!Main.getBD().getConnection())
			return false;
		
        Empresa resultado = null;
        
        try{
        	Statement st = Connect.c.createStatement();
            
            String sql = "INSERT INTO empresa (razao_social)"
                    	+ "VALUES ('" + emp.getRazaoSocial() + "')";
            
            st.executeUpdate( sql );
            
            st.close();
            Connect.c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE INSERÇÃO: cadastrarEmpresa");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            e.printStackTrace();
            return false;
        }
        return true;
    }
	
	public boolean alterarEmpresa(Empresa emp){
		if(!Main.getBD().getConnection())
			return false;
		
        Empresa resultado = null;
        try{
        	Statement st = Connect.c.createStatement();
        	
            String sql = "UPDATE empresa SET razao_social = '" + emp.getRazaoSocial() + "' "
                    + "WHERE id = " + emp.getId();
            
            st.executeUpdate( sql );
            st.close();
            Connect.c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE ATUALIZAÇÃO: alterarEmpresa");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            e.printStackTrace();
            return false;
        }
        return true;
    }
	
	public ArrayList<Empresa> getEmpresaPorRazaoSocial(String razaoSoc) {
		if(!Main.getBD().getConnection())
			return null;
		
		ArrayList<Empresa> resultado = new ArrayList();
		
        try{
        	Statement st = Connect.c.createStatement();
            String sql = "SELECT * FROM empresa WHERE LOWER(razao_social) LIKE '%" + razaoSoc.toLowerCase() + "%'";
            ResultSet rs = st.executeQuery( sql );
            
            while ( rs.next() ) {
                int idEmpresa = rs.getInt("id");
                String razaoSocial = rs.getString("razao_social");
                
                resultado.add(new Empresa(idEmpresa, razaoSocial));
            }
            
            rs.close();
            st.close();
            Connect.c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE CONSULTA: getEmpresa");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            e.printStackTrace();
        }
        
        return resultado;
	}

}
