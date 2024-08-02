package com.webcommon.request;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * AccountApiRestControllerで利用するRequestクラス
 * 
 * @author Y.AKI
 * @version 1.0.0
 */
@Setter
@Getter
@ToString
public class AccountRequest extends BaseRequest {
	/** アカウントID */
  private String accountId;
	/** リソースID */
  private String resourceId;
	/** アカウント名 */
  private String accountName;
	/** アカウント名（かな） */
  private String accountRead;
	/** メールアドレス */
  private String mailaddress;
	/** パスワード */
  private String password;
	/** 最終ログイン日時 */
  private Date lastLoginDatetime;
	/** 状態 */
  private String active;
	/** 作成者 */
  private String createAccount;
	/** 作成日 */
  private Date createDatetime;
	/** 更新者 */
  private String updateAccount;
	/** 更新日 */
  private Date updateDatetime;
}
