package com.jenson.security.validater;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
//��ʾʵ���Ǹ��ط�������
@Target({ElementType.METHOD,ElementType.FIELD})
//����ʱ��ע��
@Retention(RetentionPolicy.RUNTIME)
//��ʾ����ע��,validatedBy  ע���߼����ĸ���
@Constraint(validatedBy=TestConstarint.class)
public @interface TestValidater {
	
   String message();
 
   Class<?>[] group() default{};
 
   Class<? extends Payload>[] payload() default {};
}
