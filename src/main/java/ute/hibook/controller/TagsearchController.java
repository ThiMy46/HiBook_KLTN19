package ute.hibook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ute.hibook.dto.TagsearchDTO;
import ute.hibook.service.impl.TagsearchServiceImpl;

@Controller
public class TagsearchController {

	@Autowired
	TagsearchServiceImpl tagSer;
	
	@RequestMapping("/tags")
	public String addTag() {
		
		TagsearchDTO tagDTO= new TagsearchDTO();
		tagDTO.setNameTag("Java");
		tagDTO.setNumOfSearch(1);
		
		tagSer.addTag(tagDTO);
		return "hello";
	}
}
