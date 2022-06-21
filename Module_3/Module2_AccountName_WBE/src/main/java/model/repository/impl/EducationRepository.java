package model.repository.impl;

import model.bean.Customer;
import model.bean.Education;
import model.repository.IEducationRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationRepository implements IEducationRepository {
    private static final String SELECT_ALL_EDUCATION = "select * from education_degree";
    @Override
    public List<Education> getAllEducation() {
        List<Education> educationList =new ArrayList<>();
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_EDUCATION);
            System.out.println(ps);
            // Step 3: Execute the query or update query
            ResultSet rs = ps.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int education_degree_id = rs.getInt("education_degree_id");
                String education_degree_name = rs.getString("education_degree_name");
                educationList.add(new Education(education_degree_id, education_degree_name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return educationList;
    }
}
