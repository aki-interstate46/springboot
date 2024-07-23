package com.front.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.front.form.Sample;
import com.webcommon.spring.service.BaseWebService;

@Service
public class SampleService extends BaseWebService {

	@Override
	public void getProcessor() throws Exception {
		other("get");
	}

	@Override
	public void postProcessor() throws Exception {
		other("post");
	}

	@Override
	public void putProcessor() throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void deleteProcessor() throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	private void other(String method) {
		model.addAttribute("sampleOther", new SampleOther());
		model.addAttribute("modelValue", "モデルで設定-" + method);

		List<Sample> sampleList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Sample sample = new Sample();
			sample.setName(i + "-" + method + "-name");
			sample.setAge(i + "-" + method + "-age");
			sampleList.add(sample);
		}
		model.addAttribute("list", sampleList);

		model.addAttribute("method", method);
	}
	
    public static class SampleOther {
		public int testField1 = 1;
		public String testField2 = "testField2";

		public String getMethod() {
			return "getMethod";
		}
    }

}
