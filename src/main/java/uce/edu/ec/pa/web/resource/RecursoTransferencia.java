package uce.edu.ec.pa.web.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import uce.edu.ec.pa.application.service.TransferenciaService;

@Path("/transferencias")
public class RecursoTransferencia {

    @Inject
    private TransferenciaService transferenciaService;

    @POST
    @Path("/realizar")
    public String realizarTransferencia(TransferenciaResource transferenciaResource) {

        return this.transferenciaService.realizarTranseferencia(transferenciaResource.getCuentaOrigen(),
                transferenciaResource.getCuentaDestino(),
                transferenciaResource.getMonto());

    }

    @POST
    @Path("/realizarReactiva")

    public String realizarTransferenciaReactiva(TransferenciaResource transferenciaResource) {

        return this.transferenciaService.realizarTranseferenciaReactiva(transferenciaResource.getCuentaOrigen(),
                transferenciaResource.getCuentaDestino(),
                transferenciaResource.getMonto());

    }

}
