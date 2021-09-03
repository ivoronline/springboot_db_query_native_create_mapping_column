package com.ivoronline.springboot_db_query_native_create_mapping_column.controllers;

import com.ivoronline.springboot_db_query_native_create_mapping_column.entities.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@RestController
public class MyController {

  @PersistenceContext EntityManager entityManager;

  //================================================================
  // SELECT PERSON
  //================================================================
  @RequestMapping("SelectPerson")
  Object[] selectPerson() {

    //CREATE QUERY
    String select = "SELECT id, name, age, name || ' is ' || age AS greet FROM Person WHERE name = :name";
    Query  query  = entityManager.createNativeQuery(select, "PersonMapping");
           query.setParameter("name", "John");

    //SELECT PERSON
    Object[] objectArray = (Object[]) query.getSingleResult();

    //RETURN PERSON
    return objectArray;

  }

}


