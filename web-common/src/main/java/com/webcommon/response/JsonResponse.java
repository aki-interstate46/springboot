package com.webcommon.response;

import java.util.HashMap;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class JsonResponse {
	private String result;
	private HashMap<String, Object> messageInfo;
	private Object response;
}
