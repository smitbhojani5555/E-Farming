package com.services;

import javax.mail.MessagingException;

public interface EmailService {

	void sendAshtml(String parameter, String string, String string2) throws MessagingException;

}
