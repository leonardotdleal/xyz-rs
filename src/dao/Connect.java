package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Paciente;

public class Connect {
    static Connection c = null;
    
    private boolean conectar(){
        try {
            //Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5000/xyz_rs",
                                            "postgres", "admin");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean getConnection() {
    	return conectar();
    }
    
    public ArrayList<Paciente> getPacientes(){
        if( !conectar() ) return null;
        ArrayList<Paciente> resultado = new ArrayList();
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "SELECT * FROM pacientes";
            ResultSet rs = stmt.executeQuery( sql );
            while ( rs.next() ) {
                int codp = rs.getInt("codp");
                String  name = rs.getString("nome");
                String  cpf = rs.getString("cpf");
                int idade  = rs.getInt("idade");
                String cidade = rs.getString("cidade");
                resultado.add( new Paciente(codp, name, cpf, idade, cidade) );
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE CONSULTA: getPacientes");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
        return resultado;
    }
    
    public Paciente getPaciente(int codigo){
        if( !conectar() ) return null;
        Paciente resultado = null;
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "SELECT * FROM pacientes WHERE codp = "+codigo;
            ResultSet rs = stmt.executeQuery( sql );
            while ( rs.next() ) {
                int codp = rs.getInt("codp");
                String  name = rs.getString("nome");
                String  cpf = rs.getString("cpf");
                int idade  = rs.getInt("idade");
                String cidade = rs.getString("cidade");
                resultado = new Paciente(codp, name, cpf, idade, cidade);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE CONSULTA: getPaciente");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
        return resultado;
    }
    
    public boolean cadastrarPaciente(Paciente p){
        if( !conectar() ) return false;
        Paciente resultado = null;
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "INSERT INTO pacientes (codp, nome, cpf, idade, cidade)"
                    + "VALUES ("+p.codp+", '"+p.nome+"', '"+p.cpf+"', "+p.idade+", '"+p.cidade+"')";
            stmt.executeUpdate( sql );
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE INSER��O: cadastrarPaciente");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            return false;
        }
        return true;
    }
    
    public boolean alterarPaciente(Paciente p){
        if( !conectar() ) return false;
        Paciente resultado = null;
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "UPDATE pacientes SET nome = '"+p.nome+"', cpf = '"+p.cpf+"', "
                    + "idade = "+p.idade+", cidade = '"+p.cidade+"' "
                    + "WHERE codp = "+p.codp;
            stmt.executeUpdate( sql );
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE ATUALIZA��O: alterarPaciente");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            return false;
        }
        return true;
    }
    
}
