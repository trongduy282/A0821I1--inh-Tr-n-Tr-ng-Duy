package model.repository;

import model.bean.Education;
import model.bean.Position;

import java.util.List;

public interface IPositionRepository {
    List<Position> getAllPosition();
}
