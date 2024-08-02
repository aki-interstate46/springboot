package com.systemcommon.util;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

/**
 * Bean登録
 * 
 * SpringでアノテーションベースのBean定義を行う場合、<br>
 * 特にBean名を明示しない限り、暗黙的にクラス名をLower Camel CaseにしたものがBean名として登録される。<br>
 * パッケージ名は無視されてしまうので、状況によってはBean名が重複した阿合エラーになるので<br>
 * パッケージを含めて登録を行う。
 * 
 * @author Y.AKI
 * @version 1.0.0
 */
public class FQCNBeanNameGenerator extends AnnotationBeanNameGenerator {
  
  @Override
  protected String buildDefaultBeanName(BeanDefinition definition) {
    return definition.getBeanClassName();
  }
}