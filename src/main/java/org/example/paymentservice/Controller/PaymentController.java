package org.example.paymentservice.Controller;

import com.razorpay.RazorpayException;
import org.example.paymentservice.DTOs.GeneratePaymentLinkDto;
import org.example.paymentservice.Services.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private final PaymentService paymentService;
    public PaymentController(@Qualifier("razorpayPaymentGateway") PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping("/payments")
    public String generatePaymentLink(@RequestBody GeneratePaymentLinkDto generatePaymentLinkDto) throws RazorpayException {
        return paymentService.generatePaymentLink(generatePaymentLinkDto.orderId);
    }
}
