package com.webcommon.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 検索結果管理クラス
 * 
 * @author Y.AKI
 * @version 1.0.0
 */
@Setter
@Getter
@ToString
public class FrontSearchResponse {
	
	/**
	 * コンストラクタ
	 */
	public FrontSearchResponse() {
    this.size = 0;
    this.list = new ArrayList<>();
  }
  
	/** 総合検索数 */
  private int size = 0;

	/** 検索リスト */
  private List<Object> list;
}
