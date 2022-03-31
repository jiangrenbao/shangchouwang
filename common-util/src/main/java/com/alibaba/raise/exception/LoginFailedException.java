package com.alibaba.raise.exception;

/**
 * 登录失败后抛出的异常
 * @author parkerJ
 *
 */
public class LoginFailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LoginFailedException(String message) {
		super(message);
	}
}
