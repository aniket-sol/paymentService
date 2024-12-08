package org.example.paymentservice.Services;

import com.razorpay.RazorpayException;

public interface PaymentService {
    public String generatePaymentLink(Long orderId) throws RazorpayException;
}
