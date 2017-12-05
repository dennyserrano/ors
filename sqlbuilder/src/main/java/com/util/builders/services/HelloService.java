package com.util.builders.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.util.builders.config.DBProperties;

@Service
public class HelloService {

	
		@Autowired
		private DBProperties db;

		public DBProperties getDb() {
			return db;
		}

		public void setDb(DBProperties db) {
			System.out.println(db);
			this.db = db;
		}
		
		
	
}
