package com.learn.model;

/**
 * Created by shivam on 13/9/15.
 */
public class RegionList {


    /**
     * Region : Ahmedabad
     */

    private String Region;

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public String getRegion() {
        return Region;
    }

    @Override
    public String toString() {
        return "RegionList{" +
                "Region='" + Region + '\'' +
                '}';
    }
}
