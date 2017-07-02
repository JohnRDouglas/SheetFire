package com.code_monkee.SheetFire;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.code_monkee.psolib.PsoContext;
import com.code_monkee.psolib.PsoParticle;
import com.code_monkee.psolib.PsoSwarm;
import com.code_monkee.psolib.SwarmAttributes;

@Controller
public class PsoController {
	@Autowired PsoContext psoCtx;

	@RequestMapping("/greeting")
	public String index(Model model) {
		model.addAttribute("message", "Hello, world.");
		return "welcome";
	}
	
	@RequestMapping(value="/swarm", method=RequestMethod.GET)
	@ResponseBody
	public String returnSwarm() {
		init();
	
		SwarmAttributes attrib = new SwarmAttributes();
		psoCtx.makeSwarm(attrib);

		return psoCtx.getSwarms().get(0).toString();
	}
	
	@RequestMapping("/displayswarm")
	public String displaySwarm(Model model) {
		init();
		SwarmAttributes attrib = new SwarmAttributes();
		psoCtx.makeSwarm(attrib);
		PsoSwarm swarm = psoCtx.getSwarms().get(0);
		
		List<String> particlesStrings = new ArrayList<String>();
		for(PsoParticle p : swarm.getParticles()) {
			particlesStrings.add(p.toString());
		}
		
		model.addAttribute("particles", particlesStrings);
		model.addAttribute("swarm", swarm);
		return "SwarmTemplate";
	}
	
	private void init() {
		if(psoCtx == null) {
			psoCtx = new PsoContext();
		}
	}
	
	@Bean
	public PsoContext getPsoContext() {
		return this.psoCtx;
	}
	/*
	 public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "welcome";
	}
	 */
}
