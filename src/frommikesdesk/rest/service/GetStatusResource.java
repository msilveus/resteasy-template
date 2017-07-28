package frommikesdesk.rest.service;


import frommikesdesk.rest.reponse.RestSvcResult;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author Michael Silveus <michaelsilveus@gmail.com>
 */
@Path("/get/status")
public class GetStatusResource {

    private String FAILED = "-1";
    private String SUCCESS = "0";

    @GET
    @Path("/xml")
    @Produces(MediaType.APPLICATION_XML)
    public Response getXMLStatus() {
        RestSvcResult response = new RestSvcResult();
        response.setSuccessfulResult("RUNNING");
        return Response.ok(response).build();
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJSONStatus() {
        RestSvcResult response = new RestSvcResult();
        response.setSuccessfulResult("RUNNING");
        return Response.ok(response).build();
    }

    @GET
    @Path("/text")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getTextStatus() {
        return Response.ok("RUNNING").build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getStatus() {
        return Response.ok("RUNNING").build();
    }

}
