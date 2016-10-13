package com.tiad.SchoolDiary.persistence.dao.hsqldb;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tiad.SchoolDiary.persistence.dao.GenericDao;
import com.tiad.SchoolDiary.persistence.dao.SchoolDao;
import com.tiad.SchoolDiary.persistence.entities.impl.SchoolEntityImpl;

@Repository
@Transactional
public class HsqldbSchoolDao extends GenericDao<SchoolEntityImpl> implements SchoolDao<SchoolEntityImpl>{

}