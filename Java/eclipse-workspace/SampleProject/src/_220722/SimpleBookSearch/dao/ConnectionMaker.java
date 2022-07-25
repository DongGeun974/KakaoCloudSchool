package _220722.SimpleBookSearch.dao;

import java.sql.Connection;

public interface ConnectionMaker {
	public abstract Connection makeConnection();
}
