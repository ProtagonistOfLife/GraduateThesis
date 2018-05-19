package com.pcw.bean;

import java.util.HashMap;
import java.util.Map;

import com.pcw.exception.QueryFail;
@Deprecated
public class QueryPage {
	private Long paperid;
	private Map<Long, Integer> map;
	
	public QueryPage(){
		map = new HashMap<>();
	}

	public Long getId() {
		return paperid;
	}

	public void setId(Long id) {
		this.paperid = id;
	}

	public Map<Long, Integer> getMap() {
		return map;
	}

	public void setMap(Map<Long, Integer> map) {
		this.map = map;
	}
	
	public String getQMessage() throws QueryFail{
		if(map == null)
			throw new QueryFail();
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<Long, Integer> m : map.entrySet()){
			sb.append(m.getKey()).append(":").append(m.getValue()).append(",");
		}
		return sb.toString();
	}
}
