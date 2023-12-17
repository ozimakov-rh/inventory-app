package com.redhat.demo;

import io.quarkus.panache.common.Sort;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.time.Instant;
import java.util.List;

@Path("/item")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InventoryItemResource {

    @Inject
    InventoryItemRepository inventoryItemRepository;

    @GET
    public List<InventoryItem> listAllItems() {
        return inventoryItemRepository.listAll(Sort.by("createdAt"));
    }

    @POST
    @Transactional
    public InventoryItem addItem(InventoryItem item) {
        item.setCreatedAt(Instant.now());
        inventoryItemRepository.persist(item);
        return item;
    }

    @GET
    @Path("/{itemId}")
    public InventoryItem fetchItemById(@PathParam("itemId") Long itemId) {
        return inventoryItemRepository.findById(itemId);
    }

    @DELETE
    @Path("/{itemId}")
    @Transactional
    public void deleteItem(@PathParam("itemId") Long itemId) {
        inventoryItemRepository.deleteById(itemId);
    }

}
