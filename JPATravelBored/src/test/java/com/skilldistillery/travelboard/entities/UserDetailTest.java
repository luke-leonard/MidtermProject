package com.skilldistillery.travelboard.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserDetailTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private UserDetail uDetail;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("TravelBored");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		uDetail = em.find(UserDetail.class, 1);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		uDetail = null;
	}

	@Test
	void test() {
		assertNotNull(uDetail);
	}

}
