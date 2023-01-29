package com.example.inventory.dao.Item;

import com.example.inventory.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ItemRepository_JDBC
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Item> getItems()
    {
        String query = "select * from item inner join item_container_list on item.sku = item_container_list.item_sku";
        List<Item> itemList = this.jdbcTemplate.query(query, new ResultSetExtractor<List<Item>>() {
            @Override
            public List<Item> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Item> items = new ArrayList<>();
                Map<String, Item> itemMap = new HashMap<>();
                while (rs.next())
                {
                    if(itemMap.containsKey(rs.getString("sku")))
                    {
                        itemMap.get(rs.getString("sku")).getContainerList().add(rs.getInt("containers"));
                    }
                    else
                    {
                        Item item = new Item();
                        item.setSku(rs.getString("sku"));
                        item.setName(rs.getString("name"));
                        item.setPrice(rs.getInt("price"));
                        item.setQuantity(rs.getInt("quantity"));
                        item.setExpiryDate(rs.getDate("expiry_date"));
                        List<Integer> containerList  = new ArrayList<>();
                        containerList.add(rs.getInt("containers"));
                        item.setContainerList(containerList);
                        itemMap.put(item.getSku(), item);
                    }
                }

                for(Item inventoryItem : itemMap.values())
                {
                    items.add(inventoryItem);
                }
                return items;
            }
        });

        return itemList;
    }

    public Item getItem(String itemId)
    {
        String query = "select * from item inner join item_container_list on item.sku = item_container_list.item_sku and item.sku=?";
        List<Item> itemList = this.jdbcTemplate.query(query, new ResultSetExtractor<List<Item>>() {
            @Override
            public List<Item> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Item> items = new ArrayList<>();
                Map<String, Item> itemMap = new HashMap<>();
                while (rs.next())
                {
                    if(itemMap.containsKey(rs.getString("sku")))
                    {
                        itemMap.get(rs.getString("sku")).getContainerList().add(rs.getInt("containers"));
                    }
                    else
                    {
                        Item item = new Item();
                        item.setSku(rs.getString("sku"));
                        item.setName(rs.getString("name"));
                        item.setPrice(rs.getInt("price"));
                        item.setQuantity(rs.getInt("quantity"));
                        item.setExpiryDate(rs.getDate("expiry_date"));
                        List<Integer> containerList  = new ArrayList<>();
                        containerList.add(rs.getInt("containers"));
                        item.setContainerList(containerList);
                        itemMap.put(item.getSku(), item);
                    }
                }

                for(Item inventoryItem : itemMap.values())
                {
                    items.add(inventoryItem);
                }
                return items;
            }
        },itemId);

        return itemList.get(0);
    }

    public String checkItem(Item tempItem)
    {
        String query = "select * from item inner join item_container_list as icl on item.sku=icl.item_sku and item.name=? and item.price=? and item.expiry_date=?";

        List<Item> itemList = this.jdbcTemplate.query(query, new ResultSetExtractor<List<Item>>() {
            @Override
            public List<Item> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Item> items = new ArrayList<>();
                Map<String, Item> itemMap = new HashMap<>();

                while (rs.next())
                {
                    if(itemMap.containsKey(rs.getString("sku")))
                    {
                        itemMap.get(rs.getString("sku")).getContainerList().add(rs.getInt("containers"));
                    }
                    else
                    {
                        Item item = new Item();
                        item.setSku(rs.getString("sku"));
                        item.setName(rs.getString("name"));
                        item.setPrice(rs.getInt("price"));
                        item.setQuantity(rs.getInt("quantity"));
                        item.setExpiryDate(rs.getDate("expiry_date"));
                        List<Integer> containerList  = new ArrayList<>();
                        containerList.add(rs.getInt("containers"));
                        item.setContainerList(containerList);
                        itemMap.put(item.getSku(), item);
                    }
                }

                for(Item inventoryItem : itemMap.values())
                {
                    items.add(inventoryItem);
                }
                return items;
            }
        },tempItem.name,tempItem.price,tempItem.expiryDate);

        if(itemList.size()==0)
            return "No Item Found!!";
        return itemList.get(0).getSku();
    }
}






























//    public String checkItem(Item item)
//    {
//        String query = "select * from item where item.name=? and item.price=? and item.expiry_date=?";
//
//        List<Item> itemList = this.jdbcTemplate.query(query, new ResultSetExtractor<List<Item>>() {
//            @Override
//            public List<Item> extractData(ResultSet rs) throws SQLException, DataAccessException {
//                List<Item> items = new ArrayList<>();
//                Map<String, Item> itemMap = new HashMap<>();
//
//                while (rs.next())
//                {
//                    if(itemMap.containsKey(rs.getString("sku")))
//                    {
//                        itemMap.get(rs.getString("sku")).getContainerList().add(rs.getInt("containers"));
//                    }
//                    else
//                    {
//                        Item item = new Item();
//                        item.setSku(rs.getString("sku"));
//                        item.setName(rs.getString("name"));
//                        item.setPrice(rs.getInt("price"));
//                        item.setQuantity(rs.getInt("quantity"));
//                        item.setExpiryDate(rs.getDate("expiry_date"));
//                        List<Integer> containerList  = new ArrayList<>();
//                        containerList.add(rs.getInt("containers"));
//                        item.setContainerList(containerList);
//                        itemMap.put(item.getSku(), item);
//                    }
//                }
//
//                for(Item inventoryItem : itemMap.values())
//                {
//                    items.add(inventoryItem);
//                }
//                return items;
//            }
//        },item.name,item.price,item.expiryDate);
//
//        if(itemList.size()==0)
//            return "No Item Found!!";
//        return itemList.get(0).getSku();
//    }
//}

