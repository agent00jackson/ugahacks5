package com.ugahacks5.wolf.Main;

public class StockInfo {
    private String ticker;
    private String name;
    private String description;
    private String pic;

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getPic() {
        return pic;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
