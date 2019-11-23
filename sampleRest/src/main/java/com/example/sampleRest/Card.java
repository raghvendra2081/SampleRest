package com.example.sampleRest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Entity
@Table(name = "Cards")
@EntityListeners(AuditingEntityListener.class)
public class Card {
	 
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		@Column(name = "PAN", nullable = false)
	    private long PAN;
	    @Column(name = "Key", nullable = false)
	    private String Key;
	    
	    public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public long getPAN() {
			return PAN;
		}
		public void setPAN(long pAN) {
			PAN = pAN;
		}
		public String getKey() {
			return Key;
		}
		public void setKey(String key) {
			Key = key;
		}
		
		
		

}


