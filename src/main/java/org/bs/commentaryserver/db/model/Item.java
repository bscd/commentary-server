package org.bs.commentaryserver.db.model;

public class Item
{
    private Integer itemId;

    private String itemName;

    private Integer spotId;

    private String shortPicurl;

    private String shortDesc;

    private String detailPicurl;

    private String detailDesc;

    public Integer getItemId()
    {
        return itemId;
    }

    public void setItemId(Integer itemId)
    {
        this.itemId = itemId;
    }

    public String getItemName()
    {
        return itemName;
    }

    public void setItemName(String itemName)
    {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public Integer getSpotId()
    {
        return spotId;
    }

    public void setSpotId(Integer spotId)
    {
        this.spotId = spotId;
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