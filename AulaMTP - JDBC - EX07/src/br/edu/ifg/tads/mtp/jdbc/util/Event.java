package br.edu.ifg.tads.mtp.jdbc.util;

public class Event {
	 
    private String name;
     
    public Event(String name) {
        super();
        this.name = name;
    }
 
    public String getName() {
        return name;
    }
     
    public void setName(String name) {
        this.name = name;
    }
}
