package org.example.paymentservice.Configuration;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.example.paymentservice.Services.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfiguration {
    @Value("${razorpay.key.id}")
    private String razorpayKeyId;
    @Value("${razorpay.secret.id}")
    private String razorpayKeySecret;
    @Bean
    public RazorpayClient paymentService() throws RazorpayException {
        // Initialize client
        RazorpayClient instance = new RazorpayClient(razorpayKeyId, razorpayKeySecret);
        return instance;
    }
}
