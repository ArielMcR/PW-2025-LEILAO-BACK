package com.pw.leiloeiro.api.Services;

import com.pw.leiloeiro.api.Domains.Payment.Payment;
import com.pw.leiloeiro.api.Infra.Exception.NotFound;
import com.pw.leiloeiro.api.Repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    public Payment create(Payment payment){
        return paymentRepository.save(payment);
    }
    public List<Payment> search(){
        return paymentRepository.findAll();
    }

    public Payment update(Payment payment){
        Payment pagamentoBanco = buscarPorId(payment.getId_payment());
        pagamentoBanco.setStatus(payment.getStatus());
        pagamentoBanco.setValue(payment.getValue());
        return paymentRepository.save(pagamentoBanco);
    }

    public void delete(Long id){
        Payment pagamentoBanco = buscarPorId(id);
        paymentRepository.delete(pagamentoBanco);
    }

    public Payment buscarPorId(Long id){
        return paymentRepository.findById(id).orElseThrow(() -> new NotFound("Pagamento não encontrado"));
    }

}
