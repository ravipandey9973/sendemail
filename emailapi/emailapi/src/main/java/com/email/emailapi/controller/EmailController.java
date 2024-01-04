package com.email.emailapi.controller;

import com.email.emailapi.model.EmailRequest;
import com.email.emailapi.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class EmailController {
  @Autowired
    private EmailService emailService;
  @RequestMapping("/welcome")

    public  String welcome()
  {
      return "hello this my email api";
  }
  // api to send email
    @RequestMapping(value = "/sendemail",method= RequestMethod.POST)
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request)
    {
     //   this.emailService.sendEmail();
        System.out.println(request);
        return ResponseEntity.ok("done..");
    }
}
