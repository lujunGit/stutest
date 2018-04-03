package demo.model;


import java.util.Date;

/**
 * 进货表，用于增加商品的数据
 */
public class Stock {

    private Long id;

    private Long number; //进货数量

    private String stockUser; //进货人

    private Date stockTime; //进货时间

    private Date syncTime; //同步时间

    private Boolean sync = false; //false未同步，true已同步,默认是false

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getStockUser() {
        return stockUser;
    }

    public void setStockUser(String stockUser) {
        this.stockUser = stockUser;
    }

    public Date getStockTime() {
        return stockTime;
    }

    public void setStockTime(Date stockTime) {
        this.stockTime = stockTime;
    }

    public Boolean isSync() {
        return sync;
    }

    public void setSync(Boolean sync) {
        this.sync = sync;
    }

    public Boolean getSync() {
        return sync;
    }

    public Date getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(Date syncTime) {
        this.syncTime = syncTime;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", number=" + number +
                ", stockUser='" + stockUser + '\'' +
                ", stockTime=" + stockTime +
                ", syncTime=" + syncTime +
                ", sync=" + sync +
                '}';
    }

    public Stock() {
    }

    public Stock(Long id,Long number, String stockUser, Date stockTime, Date syncTime,
            Boolean sync) {
        this.id = id;
        this.number = number;
        this.stockUser = stockUser;
        this.stockTime = stockTime;
        this.syncTime = syncTime;
        this.sync = sync;
    }
}
