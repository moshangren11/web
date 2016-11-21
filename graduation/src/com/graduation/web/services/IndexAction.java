package com.graduation.web.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: TODO(用一句话描述)
 * @date 2016年11月21日 下午10:53:55
 */
@Controller
public class IndexAction extends BaseAction {

	Logger logger = LoggerFactory.getLogger(IndexAction.class);

	@RequestMapping(value = "/index")
	public String loginPage(final ModelMap model) {
		log.info("进入index");
		log.info("离开index");
		return "index";
	}

}
