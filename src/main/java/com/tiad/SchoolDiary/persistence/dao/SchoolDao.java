package com.tiad.SchoolDiary.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tiad.SchoolDiary.persistence.entities.SchoolEntity;

@Component(value = "schoolDao")
public interface SchoolDao<T extends SchoolEntity> {
	void save(T e);

	T get(long id);

	List<T> getAll();

	void delete(long id);

	void delete(T e);

	boolean isExists(long id);

	void update(T e);
}
