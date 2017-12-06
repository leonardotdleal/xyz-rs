package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Candidato;
import app.Main;

public class CandidatoDAO extends GenericDAO {
	
	public ArrayList<Candidato> getAllCandidatos(){
		
		if(!Main.getBD().getConnection())
			return null;
		
		ArrayList<Candidato> resultado = new ArrayList();
		
        try{
        	Statement st = Connect.c.createStatement();
            String sql = "SELECT * FROM pessoa";
            ResultSet rs = st.executeQuery( sql );
            
            while ( rs.next() ) {
            	Candidato candidato = new Candidato();
            	
            	candidato.setId(rs.getInt("id"));
            	candidato.setCpf(String.valueOf(rs.getLong("cpf")));
            	candidato.setNome(rs.getString("nome"));
            	candidato.setDataNascimento(rs.getString("data_nascimento"));
            	candidato.setPretensaoSalarial(rs.getFloat("pretensao_salarial"));
                
                resultado.add(candidato);
            }
            
            rs.close();
            st.close();
            Connect.c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE CONSULTA: getCandidato");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            e.printStackTrace();
        }
        
        return resultado;
    }
	/*
	public Candidato getCandidato(int id){
		
		if(!Main.getBD().getConnection())
			return null;
		
        Candidato resultado = null;
        try{
        	Statement st = Connect.c.createStatement();
            String sql = "SELECT * FROM empresas WHERE id = " + id;
            ResultSet rs = st.executeQuery( sql );
            
            while ( rs.next() ) {
                int idCandidato = rs.getInt("id");
                String razaoSocial = rs.getString("razao_social");
                
                resultado = new Candidato(idCandidato, razaoSocial);
            }
            
            rs.close();
            st.close();
            Connect.c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE CONSULTA: getCandidato");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            e.printStackTrace();
        }
        return resultado;
    }
*/	
	public boolean cadastrarCandidato(Candidato candidato){
		
		if(!Main.getBD().getConnection())
			return false;
		
        Candidato resultado = null;
        
        try{
        	Statement st = Connect.c.createStatement();
            
            String sql = "INSERT INTO pessoa (cpf, nome, data_nascimento, pretensao_salarial)"
                    	+ "VALUES (" + candidato.getCpf() + ", " +
                    			   "'" + candidato.getNome() + "', " +
                    			   "'" + candidato.getDataNascimento() + "', " +
                    			   	   + candidato.getPretensaoSalarial() + ")";
       
            st.executeUpdate( sql );
            
            st.close();
            Connect.c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE INSERÇÃO: cadastrarCandidato");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            e.printStackTrace();
            return false;
        }
        return true;
    }
/*	
	public boolean alterarCandidato(Candidato emp){
		if(!Main.getBD().getConnection())
			return false;
		
        Candidato resultado = null;
        try{
        	Statement st = Connect.c.createStatement();
        	
            String sql = "UPDATE empresa SET razao_social = '" + emp.getRazaoSocial() + "' "
                    + "WHERE id = " + emp.getId();
            
            st.executeUpdate( sql );
            st.close();
            Connect.c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE ATUALIZAÇÃO: alterarCandidato");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            e.printStackTrace();
            return false;
        }
        return true;
    }
	
	public ArrayList<Candidato> getCandidatoPorRazaoSocial(String razaoSoc) {
		if(!Main.getBD().getConnection())
			return null;
		
		ArrayList<Candidato> resultado = new ArrayList();
		
        try{
        	Statement st = Connect.c.createStatement();
            String sql = "SELECT * FROM empresa WHERE LOWER(razao_social) LIKE '%" + razaoSoc.toLowerCase() + "%'";
            ResultSet rs = st.executeQuery( sql );
            
            while ( rs.next() ) {
                int idCandidato = rs.getInt("id");
                String razaoSocial = rs.getString("razao_social");
                
                resultado.add(new Candidato(idCandidato, razaoSocial));
            }
            
            rs.close();
            st.close();
            Connect.c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE CONSULTA: getCandidato");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            e.printStackTrace();
        }
        
        return resultado;
	}
*/
}
