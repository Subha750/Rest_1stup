package com.banshi.demorest;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource
{
	AlienRepository repo=new AlienRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public List<Alien> getAlien()
{
		System.out.println("call getmethod");
	
	return repo.getAliens();
}
	@GET
	@Path("alien/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_XHTML_XML})
public Alien getAlien(@PathParam("id")int id)
{
		System.out.println("call getmethod");
	
	return repo.getAlien(id);
}
	@POST
	@Path("alien")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Alien createAlien(Alien a1)
	{
		repo.create(a1);
		return a1;
	}
	@PUT
	@Path("alien")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Alien updateAlien(Alien a1)
	{
		if(repo.getAlien(a1.getId()).getId()==0)
		{
			repo.create(a1);
		}
		else
		{
		repo.update(a1);
		}
		return a1;
	}
	@DELETE
	@Path("alien/{id}")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Alien deleteAlien(@PathParam("id")int id)
	{
		
			Alien a=repo.getAlien(id);
			if(a.getId()!=0)	
				repo.delete(id);
		return a;
	}
}

