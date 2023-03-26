package it.polito.tdp.db;

import java.sql.*;
import java.util.*;

import it.polito.tdp.libretto.model.Voto;

public class Prova {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mariadb://localhost/librettovoti?user=root&password=root";
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			
			Statement st = conn.createStatement();
			
			String sql = "SELECT *" + "FROM voto";
			
			ResultSet res = st.executeQuery(sql);
			
			List<Voto> voti = new ArrayList<Voto>();
			
			while(res.next()) {
				String corso = res.getString("corso");
				int punti = res.getInt("punti");
				
//				System.out.println(corso + " = " + punti);
				
				Voto v = new Voto(corso,punti,null);
				voti.add(v);
			}
			
			conn.close();
			
			System.out.println(voti);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
