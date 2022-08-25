package nl.hu.bep.countrycase.webservices;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import nl.hu.bep.countrycase.model.Country;
import nl.hu.bep.countrycase.model.World;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

public class WorldResource {

    @GET
    @Path("/countries")
    public static Response allCountries() {
        ObjectMapper objectmapper = new ObjectMapper();
        ObjectNode node = objectmapper.createObjectNode();
        for(Country cc : World.getAllCountries() ){
            node.put(cc.getName(),cc.getIso3());
        }
        return Response.ok(node).build();
    }
}