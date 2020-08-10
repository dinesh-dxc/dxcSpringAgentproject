package com.dxc.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/agent")


public class AgentController {

	@Autowired
	AgentDao dao;
	@RequestMapping("/showagent")
	public String showAgent(Model m) 
	{
		List<Agent> list= dao.getAgent();
		 m.addAttribute("list",list);
			return "showAllAgent";
	}
	
	@RequestMapping("/editagent/{agentid}")
	public String editAgent(@PathVariable int agentid,Model m)
	{
		Agent result = dao.searchByAgentid(agentid);
		m.addAttribute("command",result);
		return "editAgent";
		
	}
	@RequestMapping("/editsave")
	public String editData(@ModelAttribute("emp") Agent agent, Model m) {
		int res = dao.update(agent);
		List<Agent> list=dao.getAgent();  
        m.addAttribute("list",list);
		return "showAllAgent";
	}
	
	@RequestMapping("/deleteagent/{agentid}")
	public String deleteAgent(@PathVariable int agentid,Model m)
	{
		int result = dao.deleteAgent(agentid);
		List<Agent> list= dao.getAgent();
		 m.addAttribute("list",list);
			return "showAllAgent";
		
	}
	@RequestMapping("/addagent")
	public String addAgent(Model m)
	{
		m.addAttribute("command", new Agent());
		return "addAgent";
	}
	@RequestMapping("/saveAgent") 
	public String saveData(@ModelAttribute("Agent") Agent agent, Model m) {
		dao.insert(agent);
		List<Agent> list=dao.getAgent();
		m.addAttribute("list",list);
		return "showAllAgent";
	}
}
