package com.frontcommon.form;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.webcommon.form.BaseWebForm;
import com.webcommon.validator.AsciiField;
import com.webcommon.validator.ItemNameField;
import com.webcommon.validator.ItemReadField;
import com.webcommon.validator.group.PostGroup;
import com.webcommon.validator.group.PutGroup;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AccountForm extends BaseWebForm {

	/** アカウントID */
  private String accountId;

  /** リソースID */
  private String resourceId;

  /** アカウント名 */
  @NotNull(groups={PostGroup.class, PutGroup.class})
  @ItemNameField(groups = {PostGroup.class, PutGroup.class})
  private String accountName;

  /** アカウント名（かな） */
  @NotNull(groups={PostGroup.class, PutGroup.class})
  @ItemReadField(groups = {PostGroup.class, PutGroup.class})
  private String accountRead;

  /** メールアドレス */
  @NotNull(groups={PostGroup.class, PutGroup.class})
  @AsciiField(groups={Default.class})
  @Email(groups={PostGroup.class, PutGroup.class})
  private String mailaddress;

  /** パスワード */
  @NotNull(groups={PostGroup.class, PutGroup.class})
  @AsciiField(groups={Default.class, PostGroup.class, PutGroup.class})
  @Length(max=64, groups={Default.class})
  @Length(min=8, max=64, groups={PostGroup.class, PutGroup.class})
  private String password;

  /** 最終ログイン日時 */
  private Date lastLoginDatetime;

  /** 状態 */
  @NotNull(groups={PostGroup.class, PutGroup.class})
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
