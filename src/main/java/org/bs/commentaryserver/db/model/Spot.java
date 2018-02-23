package org.bs.commentaryserver.db.model;

public class Spot
{
    private Integer spotId;

    private String spotName;

    private String province;

    private String city;

    private String shortPicurl;

    private String shortDesc;

    private String detailPicurl;

    private String detailDesc;

    public Integer getSpotId()
    {
        return spotId;
    }

    public void setSpotId(Integer spotId)
    {
        this.spotId = spotId;
    }

    public String getSpotName()
    {
        return spotName;
    }

    public void setSpotName(String spotName)
    {
        this.spotName = spotName == null ? null : spotName.trim();
    }

    public String getProvince()
    {
        return province;
    }

    public void setProvince(String province)
    {
        this.province = province == null ? null : province.trim();
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city == null ? null : city.trim();
    }

    public String getShortPicurl()
    {
        return shortPicurl;
    }

    public void setShortPicurl(String shortPicurl)
    {
        this.shortPicurl = shortPicurl == null ? null : shortPicurl.trim();
    }

    public String getShortDesc()
    {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc)
    {
        this.shortDesc = shortDesc == null ? null : shortDesc.trim();
    }

    public String getDetailPicurl()
    {
        return detailPicurl;
    }

    public void setDetailPicurl(String detailPicurl)
    {
        this.detailPicurl = detailPicurl == null ? null : detailPicurl.trim();
    }

    public String getDetailDesc()
    {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc)
    {
        this.detailDesc = detailDesc == null ? null : detailDesc.trim();
    }
}