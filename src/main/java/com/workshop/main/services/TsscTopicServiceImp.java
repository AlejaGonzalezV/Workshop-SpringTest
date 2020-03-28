package com.workshop.main.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.workshop.main.model.TsscTopic;
import com.workshop.main.repositories.TsscTopicRepository;


@Service
public class TsscTopicServiceImp implements TsscTopicService{
	
	@Autowired
	private TsscTopicRepository repo;

	@Autowired
	public TsscTopicServiceImp(TsscTopicRepository repo) {
		super();
		this.repo = repo;
	}
	
	@Override
	public TsscTopic addTopic(TsscTopic t) {

		TsscTopic as = null;

		if (t.getDefaultSprints() > 0 && t.getDefaultGroups() > 0) {
			repo.save(t);
			as = t;
		}

		return as;
	}

	@Override
	public TsscTopic setTopic(TsscTopic t, String name, String description) {

		if (t != null && name != null && !name.equals("") && repo.existsById(t.getId()) && description != null && !description.equals("")) {
			t.setName(name);
			t.setDescription(description);
			repo.save(t);
			return t;
		}

		return null;
	}

	@Override
	public TsscTopic findTopic(Long id) {
		
		TsscTopic encontrado = repo.findById(id).get();
		System.out.println(encontrado != null);
		
		if(encontrado != null) {
			
			return encontrado;
			
		} else {
			
			return null;
			
		}

	}

	@Override
	public boolean existById(long id) {
		return repo.existsById(id);
	}



}
