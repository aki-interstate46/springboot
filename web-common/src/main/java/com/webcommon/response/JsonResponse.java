package com.webcommon.response;

import java.util.HashMap;

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
}
