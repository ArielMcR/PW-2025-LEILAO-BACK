package com.pw.leiloeiro.api.Controllers;

import com.pw.leiloeiro.api.DTO.ResponseAnyDTO;
import com.pw.leiloeiro.api.Domains.Image.Image;
import com.pw.leiloeiro.api.Domains.Payment.Payment;
import com.pw.leiloeiro.api.Services.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
@RequestMapping(value = "/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping
    public ResponseEntity<ResponseAnyDTO> create(@Valid @RequestBody Payment payment){
        paymentService.create(payment);
        return ResponseEntity.ok().body(new ResponseAnyDTO(200, "", "Pagamento cadastrado com sucesso", Collections.emptyList()));
    }
    @GetMapping
    public ResponseEntity<ResponseAnyDTO> searchAll(){
        return ResponseEntity.ok().body(new ResponseAnyDTO(200, "","", paymentService.search()));
    }

    @PutMapping
    public ResponseEntity<ResponseAnyDTO> edit(@RequestBody Payment payment){
        Payment pay = paymentService.update(payment);
        if(pay !=null){
            return ResponseEntity.ok().body(new ResponseAnyDTO(200, "", "Pagamento atualizado com sucesso", Collections.emptyList()));
        }
        return  null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseAnyDTO> delete(@PathVariable("id") Long id){
        paymentService.delete(id);
        return ResponseEntity.ok().body(new ResponseAnyDTO(200, "","Pagamento deletado com sucesos",Collections.emptyList()));
    }
}
