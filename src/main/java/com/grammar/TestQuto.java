package com.grammar;

import com.bean.User;

public class TestQuto {

	public static void main(String[] args) {
		User user=new User();
		setId(user);
		System.out.println(user.getId());
		
	}
	
	
	public static void setId(User user) {
		//user=new User();   注意有加这句和没加这句打印结果的区别
		user.setId(1);
	}
	
}
