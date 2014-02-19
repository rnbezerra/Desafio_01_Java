package br.edu.infnet.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
    private static Connection con = null;
    private static Statement st = null;
    private static ResultSet rs = null;
	
	public static Connection getConexao() {
		if(con == null){
	        String url = "jdbc:postgresql://localhost:5432/controlealuno";
	        String user = "postgres";
	        String password = "postgres";
	        System.out.println("Tentando conectar");
	        try {
	        	Class.forName("org.postgresql.Driver");
	        	
	            con = DriverManager.getConnection(url, user, password);
	            st = con.createStatement();
	            rs = st.executeQuery("SELECT VERSION()");
	
	            System.out.println("Conectou!");
	            if (rs.next()) {
	                System.out.println(rs.getString(1));
	            }
	            
	            
	
	        } catch (SQLException ex) {
	        	System.out.println("Não Conectou!");
	        	FecharConexao();
	        } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
	        	System.out.println("Driver não encontrado. Não Conectou!");
			} finally {
	            
	        }
		}
        
        return con;
    }

	public static void FecharConexao() {
		try {
		    if (rs != null) {
		        rs.close();
		    }
		    if (st != null) {
		        st.close();
		    }
		    if (con != null) {
		        con.close();
		    }

		} catch (SQLException ex) {
        	System.out.println("Erro ao fechar!");			
		}
	}
	
}
