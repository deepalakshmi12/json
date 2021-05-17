package com.springboot.samplerealtime.project.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.springboot.samplerealtime.project.helper.ExcelHelper;
import com.springboot.samplerealtime.project.model.Tutorial;
import com.springboot.samplerealtime.project.repository.TutorialRepository;

@Service
public class ExcelService {

@Autowired
TutorialRepository repository;

public ByteArrayInputStream load() {
	
	List<Tutorial> tutorials = repository.findAll();
	
	ObjectMapper objectMapper=new ObjectMapper();
	
	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
	
	List<Tutorial> jsonexcel=null;
	try {
		String arrayToJson = objectMapper.writeValueAsString(tutorials);
		TypeReference<List<Tutorial>> mapType = new TypeReference<List<Tutorial>>() {
		};
		jsonexcel = objectMapper.readValue(arrayToJson, mapType);
	} catch(Exception e) {
		e.printStackTrace();
	}
	ByteArrayInputStream in = ExcelHelper.tutorialToExcel(jsonexcel);
	
	return in;
	
}
}
