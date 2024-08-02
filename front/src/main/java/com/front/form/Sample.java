package com.front.form;

import com.webcommon.form.BaseWebForm;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Sample extends BaseWebForm {
	
	private String name;
	private String email;
	private String age;
}
