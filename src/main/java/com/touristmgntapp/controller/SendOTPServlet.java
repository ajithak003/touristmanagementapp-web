package com.touristmgntapp.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.touristmgntapp.util.OTPService;

import java.io.IOException;

@WebServlet("/sendOTP")
public class SendOTPServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OTPService otpService = new OTPService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mobileNumber = request.getParameter("mobileNumber");
        String otp = otpService.generateOTP();
        otpService.sendOTP(mobileNumber, otp);

        // Store the OTP in the session or database to verify later
        request.getSession().setAttribute("otp", otp);

        response.getWriter().write("OTP sent successfully");
    }
}

