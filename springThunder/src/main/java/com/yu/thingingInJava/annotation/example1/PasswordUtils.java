package com.yu.thingingInJava.annotation.example1;

import java.util.List;

public class PasswordUtils {
	
	@UseCase(id=47, description="password must contain at latest one numeric")
	public boolean validatePassword(String password) {
		return (password.matches("\\w*\\d\\w*"));
	}
	
	@UseCase(id=48)
	public String encryptPassword(String password) {
		return new StringBuilder(password).reverse().toString();
	}
	
	@UseCase(id=49, description="new password can't equal previously used ones")
	public boolean checkNewPassword(List<String> prevPasswords, String password) {
		return !prevPasswords.contains(password);
	}
}
