package com.saree.service;

import java.util.List;

import com.saree.entity.Saree;

public interface SareeService {

	public Boolean addSaree(Saree s);
	public Boolean updateDetails(Saree s);
	public Boolean deleteSaree(String sareeId);
	
	public Saree getSareeById(String sareeId);
	public List<Saree> showAllSaree();
	public List<Saree> getSareetByType(String type);
	public List<Saree> getSareeByCategory(String category);
	public List<Saree> getSareeByColor(String color);
	
}
