package com.frontcommon.form;

import java.util.Date;

import com.webcommon.form.BaseWebForm;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AccountForm extends BaseWebForm {
   private String accountId;
   private String resourceId;
   private String accountName;
   private String accountRead;
   private String mailaddress;
   private String password;
   private Date lastLoginDatetime;
   private String active;
   private String createAccount;
   private Date createDatetime;
   private String updateAccount;
   private Date updateDatetime;
}
