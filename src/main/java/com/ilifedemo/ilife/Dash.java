package com.ilifedemo.ilife;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;






@Entity
@Table( name = "dash")

 
public class Dash {
	
	
	
	@Id
    @GeneratedValue   
   
    private Long id;	

    private Long prestarts;
    private Long comparisons;
    private Long prospects;
    private Long agentid;
    
    

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPrestarts() {
		return prestarts;
	}
	public void setPrestarts(Long prestarts) {
		this.prestarts = prestarts;
	}
	public Long getComparisons() {
		return comparisons;
	}
	public void setComparisons(Long comparisons) {
		this.comparisons = comparisons;
	}
	public Long getProspects() {
		return prospects;
	}
	public void setProspects(Long prospects) {
		this.prospects = prospects;
	}
	public Long getAgentid() {
		return agentid;
	}
	public void setAgentid(Long agentid) {
		this.agentid = agentid;
	}
    
	
	

	
	
	
	
    


}



