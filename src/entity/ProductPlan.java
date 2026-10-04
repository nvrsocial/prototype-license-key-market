package entity;

import java.math.BigDecimal;

public class ProductPlan {
    private long id;
    private Product product;
    private ProductPeriod productPeriod;
    private BigDecimal bigDecimal;

    public ProductPlan(long id, Product product, ProductPeriod productPeriod, BigDecimal bigDecimal) {
        this.id = id;
        this.product = product;
        this.productPeriod = productPeriod;
        this.bigDecimal = bigDecimal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductPeriod getProductPeriod() {
        return productPeriod;
    }

    public void setProductPeriod(ProductPeriod productPeriod) {
        this.productPeriod = productPeriod;
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    @Override
    public String toString() {
        return "ProductPlan{" +
                "id=" + id +
                ", product=" + product +
                ", productPeriod=" + productPeriod +
                ", bigDecimal=" + bigDecimal +
                '}';
    }
}