package com.dxc.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.dxc.spring.*;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class AgentDao {

	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public List<Agent> getAgent()
	{
		 return template.query("select * from agent",new RowMapper<Agent>(){  
		        public Agent mapRow(ResultSet rs, int row) throws SQLException {  
		            Agent a=new Agent();  
		            a.setAgentId(rs.getInt("agentid"));
		            a.setName(rs.getString("name"));
		            a.setCity(rs.getString("city"));
		            a.setGender(rs.getString("gender"));
		            a.setMaritalStatus(rs.getInt("maritalStatus"));
		            a.setPremium(rs.getDouble("premium"));
		            return a;  
		        }  
		    });  
	}

	public Agent searchByAgentid(int agentid) {
	    String sql="select * from agent where agentid=?";  
	    return template.queryForObject(sql,new Object[]{agentid},new BeanPropertyRowMapper<Agent>(Agent.class)); 
	}

	public int update(Agent agent) {
	
		String sql="update agent set name=?, city=?, gender=?, maritalstatus=?,premium=? where agentid= ?";
	    return template.update(sql, new Object[] {agent.getName(),agent.getCity(),agent.getGender(),agent.getMaritalStatus(),agent.getPremium(),agent.getAgentId()});
	}

	public int deleteAgent(int agentid) {
		String sql = "DELETE FROM AGENT WHERE AGENTID=?";
		return template.update(sql, new Object[] {agentid});
	}

	public int insert(Agent agent) {
		String cmd = "Insert into Agent values(?,?,?,?,?,?)";
		return template.update(cmd, new Object[] {agent.getAgentId(),agent.getName(),agent.getCity(),agent.getGender(),agent.getMaritalStatus(),agent.getPremium()});
		
	}
}
