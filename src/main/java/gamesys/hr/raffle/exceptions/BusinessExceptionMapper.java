package gamesys.hr.raffle.exceptions;

import gamesys.hr.raffle.exceptions.BusinessLogicException;
import org.apache.commons.httpclient.HttpStatus;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Component
public class BusinessExceptionMapper implements ExceptionMapper<BusinessLogicException> {

    @Override
    public Response toResponse(BusinessLogicException e) {
        return Response.status(HttpStatus.SC_BAD_REQUEST).entity(new ExceptionResource(e.getMessage())).build();
    }

}
