package com.webcommon.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FrontSearchResponse {
	public FrontSearchResponse() {
		this.size = 0;
		this.list = new ArrayList<>();
	}
	
	private int size;
	private List<Object> list;
}
