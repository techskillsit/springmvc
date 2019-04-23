package com.myapp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.myapp.beans.Category;
import com.myapp.beans.Product;

@Component
public class DBConfig {

	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Category> fetchCategories(){
		RowMapper<Category> rowMapper = new RowMapper<Category>() {

			@Override
			public Category mapRow(ResultSet rst, int arg1) throws SQLException {
				Category c = new Category();
				c.setId(rst.getInt(1));
				c.setName(rst.getString(2));
				c.setPriority(rst.getInt(3));
				return c;
			}
			
		};
		return jdbc.query("select * from category", rowMapper);
	}
	
	public List<Product> fetchProducts(int catId){
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("catId", catId);
		RowMapper<Product> rowMapper = new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rst, int arg1) throws SQLException {
				Product p = new Product();
				p.setId(rst.getInt(1));
				p.setName(rst.getString(2));
				p.setShortDescription(rst.getString(3));
				p.setDescription(rst.getString(4));
				p.setPrice(rst.getString(5));
				return p;
			}
			
		};
		return jdbc.query("select * from product where cat_id=:catId",map,rowMapper);
	}
	
}
