package ute.hibook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ute.hibook.dao.imp.TagsearchDaoImpl;
import ute.hibook.dto.TagsearchDTO;
import ute.hibook.entity.Tagsearch;
import ute.hibook.service.TagsearchService;

@Service
public class TagsearchServiceImpl implements TagsearchService{

	@Autowired
	TagsearchDaoImpl tagDao;
	
	public void addTag(TagsearchDTO tagDTO) {
		Tagsearch tag=new Tagsearch();
		tag.setNameTag(tagDTO.getNameTag());
		tag.setNumOfSearch(tagDTO.getNumOfSearch());
		tagDao.addTag(tag);
		System.out.println("add Tagseach successful!");
	}

	public void updateTag(TagsearchDTO tagDTO) {
		Tagsearch tag= tagDao.getTagById(tagDTO.getIdTag());
		if(tag!=null) {
			tag.setNameTag(tagDTO.getNameTag());
			tag.setNumOfSearch(tagDTO.getNumOfSearch());
			tagDao.updateTag(tag);
			System.out.println("update Tagseach successful!");
		}
	}

	public void deleteTag(int idTag) {
		Tagsearch tag= tagDao.getTagById(idTag);
		if(tag!=null) {
			tagDao.deleteTag(idTag);
			System.out.println("delete Tagseach successful!");
		}
	}

	public TagsearchDTO getTagById(int idTag) {
		Tagsearch tag= tagDao.getTagById(idTag);
		
		TagsearchDTO tagDTO= new TagsearchDTO();
		tagDTO.setIdTag(tag.getIdTag());
		tagDTO.setNameTag(tag.getNameTag());
		tagDTO.setNumOfSearch(tag.getNumOfSearch());
		
		return tagDTO;
	}

	public List<TagsearchDTO> getAllTag() {
		List<Tagsearch> lstTag= tagDao.getAllTag();
		
		List<TagsearchDTO> lstTagDTO= new ArrayList<TagsearchDTO>();
		for (Tagsearch tag : lstTag) {
			
			TagsearchDTO tagDTO= new TagsearchDTO();
			tagDTO.setIdTag(tag.getIdTag());
			tagDTO.setNameTag(tag.getNameTag());
			tagDTO.setNumOfSearch(tag.getNumOfSearch());
		
			lstTagDTO.add(tagDTO);
		}
		return lstTagDTO;
	}

}
