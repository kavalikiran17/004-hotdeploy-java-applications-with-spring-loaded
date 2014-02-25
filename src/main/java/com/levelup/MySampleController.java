package com.levelup;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MySampleController {
	
	@RequestMapping("/")
	public String home () {
		return "www.leveluplunch.com/";
	}
	
	class HotDeploy {
		boolean isHotDeployable = false;

		public boolean isHotDeployable() {
			return isHotDeployable;
		}

		public void setHotDeployable(boolean isHotDeployable) {
			this.isHotDeployable = isHotDeployable;
		}
	}
	
	@RequestMapping(
			value = "/hotdeploy",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE}
			) 
	public HotDeploy hotDeployable (@RequestParam(required=false) boolean isHotDeployable) {

		HotDeploy hotDeploy = new HotDeploy();
		
		if (isHotDeployable) {
			hotDeploy.setHotDeployable(isHotDeployable);
		}
		
		return hotDeploy;
	}
}
