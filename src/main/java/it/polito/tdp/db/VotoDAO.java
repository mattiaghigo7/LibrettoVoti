package it.polito.tdp.db;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import it.polito.tdp.libretto.model.Voto;

public class VotoDAO {

	//CRUD - Create Read Update Delete List (CRUL)
	
	public List<Voto> listVoti(){
		
		try {
			Connection conn = DBConnect.getConnection();
			
			Statement st = conn.createStatement();
			
			String sql = "SELECT *" + "FROM voto";
			
			ResultSet res = st.executeQuery(sql);
			
			List<Voto> voti = new ArrayList<Voto>();
			
			while(res.next()) {
				String corso = res.getString("corso");
				int punti = res.getInt("punti");
				LocalDate data = res.getDate("data").toLocalDate();				
				Voto v = new Voto(corso,punti,data);
				voti.add(v);
			}
			
			conn.close();
			
			return voti;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void createVoto(Voto v) {
		String sql = "INSERT INTO `voto` (`corso`, `punti`, `data`) VALUES (?,?,?);";
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, v.getCorso());
			st.setInt(2, v.getPunti());
//			st.setDate(3, v.getDataEsame());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Voto readVoto(String corso) {
		return null;
	}
	
	public List<Voto> searchVotoPuntiMaggiore(int punti){
		return null;
		
	}
}
