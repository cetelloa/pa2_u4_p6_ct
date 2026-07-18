package uce.edu.ec.pa.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AuditoriaService {

    public void guardarAuditoria() {

        System.out.println("Id del Hilo: " + Thread.currentThread().threadId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        System.out.println("Se registra la auditoria !!!!!!");

    }

}
