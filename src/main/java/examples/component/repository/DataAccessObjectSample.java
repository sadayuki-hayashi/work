package examples.component.repository;

import examples.entity.ProductModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DataAccessObjectSample {

    private final JdbcTemplate jdbcTemplate;

    public DataAccessObjectSample(JdbcTemplate jdbcTemplate){ super();
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional(readOnly=true)
    public ProductModel getProduct(){
        String sql = "SELECT id, name, price FROM t_product WHERE id = ?";
        String id = "pen";

        Object[] args = new Object[] {id};
        ProductModel productModel = this.jdbcTemplate.queryForObject(sql, args, new RowMapper4productModel());
        return productModel;
    }

    @Transactional
    public void entryProduct(){
        String sql = "insert into t_product(id, name, price) values(?, ?, ?)";

        String id = "pc";
        String name = "Personal Computer";
        int price = 100000;
        Object[] args = new Object[] {id, name, price};

        int n = this.jdbcTemplate.update(sql, args);
        System.out.println("n=" + n);
    }

    @Transactional(readOnly=true)
    public List<ProductModel> getProducts(){
        String sql = "SELECT id, name, price FROM t_product";
        RowMapper<ProductModel> mapper = new BeanPropertyRowMapper<ProductModel>(ProductModel.class);

        Object[] args = new Object[] {};
        List<ProductModel> productList = this.jdbcTemplate.query(sql, args, mapper);
        return productList;
    }

    private static class RowMapper4productModel implements RowMapper<ProductModel> {
        public RowMapper4productModel(){
            super();
        }
        public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            ProductModel productModel = new ProductModel();
            productModel.setId(rs.getString("id"));
            productModel.setName(rs.getString("name"));
            productModel.setPrice(rs.getInt("price"));
            return productModel;
        }
    }
}

