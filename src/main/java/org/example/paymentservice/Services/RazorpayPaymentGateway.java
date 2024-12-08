package org.example.paymentservice.Services;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("razorpayPaymentGateway")
public class RazorpayPaymentGateway implements PaymentService {
    private final RazorpayClient razorpayClient;
    RazorpayPaymentGateway(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }

    public String generatePaymentLink(Long orderId) throws RazorpayException {
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",1000);
        paymentLinkRequest.put("currency","INR");
//        paymentLinkRequest.put("accept_partial",true);
//        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by", System.currentTimeMillis() + 10*60*1000);
        paymentLinkRequest.put("reference_id", orderId.toString());
        paymentLinkRequest.put("description","Payment for order Id " + orderId);

        JSONObject customer = new JSONObject();
        customer.put("contact","+919876589788");
        customer.put("name","Aniket Solanki");
        customer.put("email","aniket.solanki@ecommerce.com");
        paymentLinkRequest.put("customer",customer);

//        JSONObject notify = new JSONObject();
//        notify.put("sms",true);
//        notify.put("email",true);
//        paymentLinkRequest.put("reminder_enable",true);

        JSONObject notes = new JSONObject();
        notes.put("policy_name","Jeevan Bima");

        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://www.github.com/aniket-sol");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);
//        JSONObject jsonObject = new JSONObject(payment.toJson());
//        System.out.println(jsonObject.getString("short_url"));

        return payment.toString();
    }
}
