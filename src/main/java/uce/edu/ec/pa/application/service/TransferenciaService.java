package uce.edu.ec.pa.application.service;

import java.math.BigDecimal;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class TransferenciaService {

    @Inject
    private CuentaBancariaService cuentaBancariaService;
    @Inject
    private MailService mailService;
    @Inject
    private AuditoriaService auditoriaService;

    public String realizarTranseferencia(String cuentaOrigen, String cuentaDestino,
            BigDecimal monto) {
        long inicio = System.nanoTime();

        BigDecimal saldoDestino = this.cuentaBancariaService.agregarMonto(cuentaDestino, monto);
        BigDecimal saldoOrigen = this.cuentaBancariaService.restarMonto(cuentaOrigen, monto);
        this.mailService.enviarMail("cetelloa@uce.edu.ec", "Prueba", "Se realizo una transferencia de: " + monto);
        this.auditoriaService.guardarAuditoria();

        long duracionMs = (System.nanoTime() - inicio) / 1_000_000;
        return "Se realizo con exito, su saldo destino es: " + saldoDestino + "su saldo origen es: " + saldoOrigen
                + " | Tiempo de ejecución: " + duracionMs + " ms";
    }

    // aqui hago ya con las promesas
    public String realizarTranseferenciaReactiva(String cuentaOrigen, String cuentaDestino,
            BigDecimal monto) {
        long inicio = System.nanoTime();

        Uni<BigDecimal> saldoDestino = this.cuentaBancariaService.agregarMontoPromesa(cuentaDestino, monto);
        Uni<BigDecimal> saldoOrigen = this.cuentaBancariaService.restarMontoPromesa(cuentaOrigen, monto);

        this.mailService.enviarMail("cetelloa@uce.edu.ec", "Prueba", "Se realizo una transferencia de: " + monto);
        this.auditoriaService.guardarAuditoria();

        Uni.combine().all().unis(saldoDestino, saldoOrigen).asTuple().map(result -> {
            String mensaje = "Se realizo con exito, su saldo destino es: " + result.getItem1() + "su saldo origen es: "
                    + result.getItem2();

            System.out.println(mensaje);
            return mensaje;
        }).toString();

        long duracionMs = (System.nanoTime() - inicio) / 1_000_000;

        System.out.println("Tiempo de ejecución: " + duracionMs + " ms");

        return "Finalizado";
    }

}
