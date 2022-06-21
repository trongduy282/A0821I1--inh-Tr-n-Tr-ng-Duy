package model.repository.impl;

import model.bean.Education;
import model.bean.Position;
import model.repository.IPositionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepository implements IPositionRepository {
    private static final String SELECT_ALL_POSITION = "select * from position";

    @Override
    public List<Position> getAllPosition() {
        List<Position> positionList =new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_POSITION);
            System.out.println(ps);
            // Step 3: Execute the query or update query
            ResultSet rs = ps.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int position_id = rs.getInt("position_id");
                String position_name = rs.getString("position_name");
                positionList.add(new Position(position_id, position_name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return positionList;
    }
    }

