package com.touristmgntapp.util;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.util.Random;

public class OTPService {

    // Twilio Account SID and Auth Token
    public static final String ACCOUNT_SID = "AC4a68036ec91de033c13348768f12b05c";
    public static final String AUTH_TOKEN = "544058fe1fa53f5dd30031d4e351d5de";

    static {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    // Method to generate OTP
    public String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    // Method to send OTP
    public void sendOTP(String mobileNumber, String otp) {
    	mobileNumber = "9787274712";
    	System.out.println("mobileNumber : "+mobileNumber);
        Message.creator(
            new PhoneNumber(mobileNumber),
            new PhoneNumber("9944395568"),
            "Your OTP is: " + otp
        ).create();
    }
}
