package com.billingapplication.service;

import com.billingapplication.model.Item;
import com.billingapplication.repo.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findByItemName(String itemName) {
        return itemRepository.findByItemname(itemName);
    }

    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(Long id, Item itemDetails) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
        item.setItemname(itemDetails.getItemname());
        item.setItemprice(itemDetails.getItemprice());
        item.setDescription(itemDetails.getDescription());
        return itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }
}
