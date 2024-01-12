package edu.in.SMS;

import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.math.BigDecimal;

public class Example {
  // Find your Account Sid and Token at twilio.com/console
  public static final String ACCOUNT_SID = "ACffbe700df2e1cb11a789782a3b4e45fd";
  public static final String AUTH_TOKEN = "fbe1e6b6bd5a36575afc7bea6aab3aa0";

  public static void main(String[] args) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    Message message = Message.creator(
      new com.twilio.type.PhoneNumber("+918220788805"),
      new com.twilio.type.PhoneNumber("+17163126354"),
      "i ordered a book that is how to Scam People but it never came ")

    .create();

    System.out.println(message.getSid());
  }
}