package com.example.inventory.dao.Container;

import com.example.inventory.models.Container;
import com.example.inventory.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ContainerRepository_JDBC
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Container> getAllContainers(){
        String query = "select * from container inner join location on container.location_location_id = location.location_id";
        List<Container> containers = this.jdbcTemplate.query(query, new ResultSetExtractor<List<Container>>() {
            @Override
            public List<Container> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Container> containerList = new ArrayList<>();
                while (rs.next())
                {
                    Container container = new Container();
                    container.setContainerId(rs.getInt("container_id"));
                    container.setMaxCapacity(rs.getInt("max_capacity"));
                    container.setCurrQuantity(rs.getInt("curr_quantity"));
                    container.setItemId(rs.getString("item_id"));
                    Location location = new Location();
                    location.setLocationId(rs.getInt("location_id"));
                    location.setLocationType(rs.getString("location_type"));
                    location.setLocationName(rs.getString("location_name"));
                    container.setLocation(location);
                    containerList.add(container);
                }
                return containerList;
            }
        });
        return containers;
    }

    public Container getContainer(int containerId){
        String query = "select * from container inner join location on container.location_location_id = location.location_id where container_id=?";
        List<Container> containers = this.jdbcTemplate.query(query, new ResultSetExtractor<List<Container>>() {
            @Override
            public List<Container> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Container> containerList = new ArrayList<>();
                while (rs.next())
                {
                    Container container = new Container();
                    container.setContainerId(rs.getInt("container_id"));
                    container.setMaxCapacity(rs.getInt("max_capacity"));
                    container.setCurrQuantity(rs.getInt("curr_quantity"));
                    container.setItemId(rs.getString("item_id"));
                    Location location = new Location();
                    location.setLocationId(rs.getInt("location_id"));
                    location.setLocationType(rs.getString("location_type"));
                    location.setLocationName(rs.getString("location_name"));
                    container.setLocation(location);
                    containerList.add(container);

                    containerList.add(container);
                }

                return containerList;
            }
        },containerId);
        return containers.get(0);
    }
}
