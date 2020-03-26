package com.workshop.main.services;

import com.workshop.main.model.TsscStory;

public interface TsscStoryService {
	
	public TsscStory addStory(TsscStory story, long id);
	public TsscStory setStory(TsscStory story, String priority, String description);
	public TsscStory findStory(Long id);

}