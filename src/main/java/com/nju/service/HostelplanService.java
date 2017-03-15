package com.nju.service;

import com.nju.entity.Hostelplan;

import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.10.
 */
public interface HostelplanService {


	public void add(Hostelplan u);

	public void delete(String planno);

	public void update(Hostelplan u);

	public Hostelplan get(String planno);

	public List<Hostelplan> findAll();

}
