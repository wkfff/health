package com.vaizn.utils;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidatorUtils {
	
	private static Validator validator = null;
	
	/**
	 * 可对实体对象进行验证属性的合法性，
	 * 实体使用注解时需遵循JSR-303标准
	 * @param obj
	 * @return
	 */
	public static <T> String dataValidate(T obj){
		if(validator == null){
			ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();   
	        validator = validatorFactory.getValidator();
		}
		Set<ConstraintViolation<T>> valideSet = validator.validate(obj);
		if(valideSet != null && !valideSet.isEmpty()){
			StringBuilder strBuff = new StringBuilder();
	        for(ConstraintViolation<T> cv : valideSet){
	        	strBuff.append(cv.getPropertyPath()).append(":").append(cv.getMessage()).append(";");
	        }
	        return strBuff.toString();
		}else{
			return null;
		}
	}
}
