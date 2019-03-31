package ute.hibook.service;

import java.util.List;

import ute.hibook.dto.TagsearchDTO;

public interface TagsearchService {

	public void addTag(TagsearchDTO tag);
	public void updateTag(TagsearchDTO tag);
	public void deleteTag(int idTag);
	public TagsearchDTO getTagById(int idTag);
	public List<TagsearchDTO> getAllTag();
}
