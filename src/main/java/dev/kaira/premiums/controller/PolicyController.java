package dev.kaira.premiums.controller;

import dev.kaira.premiums.dto.Policy;
import dev.kaira.premiums.service.PolicyService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/policy")
public class PolicyController {

    @Inject
    PolicyService policyService;

    @POST
    @Path("/calculate")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response calculate(Policy policy) {
        return Response.ok().entity(policyService.calculate(policy)).build();
    }
}
