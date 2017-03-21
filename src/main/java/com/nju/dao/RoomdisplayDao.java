package com.nju.dao;

import com.nju.entity.Roomdisplay;

import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.17.
 */
public interface RoomdisplayDao {

	public Roomdisplay get(String hostelno, String roomno);

	public List<Roomdisplay> findAll();

}
