import java.sql.*;
import java.util.ArrayList;

public class dml {
	
	private Connection c;
	public dml() {
		
		c = connect.get_con();
	}
	public int insert(String stdId, String sName, String contact) {
		
		int v = 0;
		try {
			
			PreparedStatement ps = c.prepareStatement("Insert into cs_student values(?,?,?)");
			ps.setString(1,stdId);
			ps.setString(2,sName);
			ps.setString(3,contact);
			
			v = ps.executeUpdate();
		} catch(Exception e) {
			
		}
		return v;
	}
	public int delete(String stdId) {
		
		int v = 0;
		try{
			
			PreparedStatement ps = c.prepareStatement("delete from cs_student where id = ?");
			
			ps.setString(1,stdId);
			v = ps.executeUpdate();
		}catch(Exception e) {
			
		}
		return v;
	}
	public  int update(String stdId,String sName) {
		
		int v = 0;
		try{
			
			PreparedStatement ps = c.prepareStatement("update cs_student set name = ? where id = ?");
			ps.setString(1,sName);
			ps.setString(2,stdId);
			
			v = ps.executeUpdate();
		}catch(Exception e) {
			
		}
		return v;
	}
	public ArrayList<ArrayList<String>> list() {
		
		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		ArrayList<ArrayList<String>> list = new ArrayList<>();
		try{
			
		    PreparedStatement ps = c.prepareStatement("select * from login");
		    ResultSet rs = ps.executeQuery();
		    while(rs.next()) {
		    	list1.add(rs.getString(1));
		    	list2.add(rs.getString(2));
		    }
		    list.add(list1);
		    list.add(list2);
		} catch(Exception e) {
			
		}
		return list;
	}
	public ArrayList<String> find(String stdId) {
		
		ArrayList<String> ans = new ArrayList<>();
		try{
			
			PreparedStatement ps = c.prepareStatement("select * from cs_student where ID = ?");
			ps.setString(1,stdId);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				for(int i=1;i<=3;i++) {
					
					ans.add(rs.getString(i));
				}
			}
		} catch(Exception e) {
			
		}
		return ans;
	}

	public int find_login(String uid,String pw) {
		
	
		try{
			
			PreparedStatement ps = c.prepareStatement("select * from login where username=? and password=?");
			ps.setString(1,uid);
			ps.setString(2,pw);
			
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) 
			{
			   	return 1;
			}
		} catch(Exception e) {
			
		}
		return 0;
	}
	
	public ArrayList<String> unique_job() {
		
		ArrayList<String> ans = new ArrayList<>();
		try{
			
			PreparedStatement ps = c.prepareStatement("select distinct JOB from emp");
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				ans.add(rs.getString(1));
			}
		} catch(Exception e) {
			
		}
		return ans;
	}

	public static void main (String[] args) {
		dml p=new dml();
		//System.out.println(p.insert("22","sss","4564512333"));
		//System.out.println(p.find_login("pp","pp@609"));
		System.out.println(p.unique_job());
     }
}