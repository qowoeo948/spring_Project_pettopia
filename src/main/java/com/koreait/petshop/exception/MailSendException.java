package com.koreait.petshop.exception;

//CRUD ?��?��?�� 발생?��?�� ?��?��
public class MailSendException extends RuntimeException{
	
	public MailSendException(String msg) {
		super(msg);
	}
	public MailSendException(String msg, Throwable e) {
		super(msg, e);
	}
}
