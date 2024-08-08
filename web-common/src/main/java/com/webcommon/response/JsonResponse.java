package com.webcommon.response;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * レスポンスデータ管理クラス
 * レスポンス出力イメージ
 * <pre>
 * {@code
 * >{
 * >  "status": "xxx",
 * >  "response":{
 * >    "size": "xx",
 * >    "list":[
 * >      {"name":"xxx", "read":"xxx"},
 * >      {"name":"xxx", "read":"xxx"}
 * >    ]
 * >  },
 * >}
 * </pre>
 * @author Y.AKI
 * @version 1.0.0
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
public class JsonResponse {
  private String status;
  private HashMap<String, Object> messageInfo;
  private Object response;

  /**
   * システムエラーをセットする
   */
  private String globalError;

  /**
   * 入力値のバリデーションエラーをセットする
   */
  private Map<String, String> inputError;
}
