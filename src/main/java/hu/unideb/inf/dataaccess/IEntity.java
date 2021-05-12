package hu.unideb.inf.dataaccess;

import java.sql.ResultSet;

public interface IEntity<T> {
    T Map(ResultSet rs);
}
