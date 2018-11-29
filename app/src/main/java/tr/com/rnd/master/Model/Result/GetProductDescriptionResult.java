package tr.com.rnd.master.Model.Result;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetProductDescriptionResult {
    public class GetProductDescription {
        @SerializedName("Success")
        private Boolean success;

        @SerializedName("Message")
        private String message;

        @SerializedName("Data")
        public Data data;

        public Boolean getSuccess() {
            return success;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setData(Data data) {
            this.data = data;
        }
    }

    public class Data {
        @SerializedName("Id")
        private Integer id;

        @SerializedName("Name")
        public String name;

        @SerializedName("OldPrice")
        public Double oldPrice;

        @SerializedName("Price")
        public Double price;

        @SerializedName("FormattedPrice")
        private String formattedPrice;

        @SerializedName("FormattedOldPrice")
        private String formattedOldPrice;

        @SerializedName("FormattedGainAmount")
        private String formattedGainAmount;

        @SerializedName("Title")
        private String title;

        @SerializedName("Explaination")
        public String explaination;

        @SerializedName("SecondExplaination")
        public String secondExplaination;

        @SerializedName("ThirdExplaination")
        private String thirdExplaination;

        @SerializedName("FourthExplaination")
        public String fourthExplaination;

        @SerializedName("ProductCode")
        private String productCode;

        @SerializedName("ManufacturerCode")
        private String manufacturerCode;

        @SerializedName("Mark")
        private Mark mark;

        @SerializedName("VatRatio")
        private Integer vatRatio;

        @SerializedName("DiscountRatio")
        private Double discountRatio;

        @SerializedName("Reference3")
        public String reference3;

        @SerializedName("RecordDate")
        private String recordDate;

        @SerializedName("Products")
        public List<Product> products = null;

        @SerializedName("RelatedProducts")
        private List<Object> relatedProducts = null;

        @SerializedName("Images")
        public List<Image> images = null;

        @SerializedName("Tags")
        private List<Tag> tags = null;

        @SerializedName("SegmentPrice")
        private SegmentPrice segmentPrice;

        @SerializedName("TagListJson")
        private List<TagListJson> tagListJson = null;

        @SerializedName("Departments")
        private List<Object> departments = null;

        @SerializedName("Reference1")
        private Boolean reference1;

        @SerializedName("StockExist")
        private Boolean stockExist;

        @SerializedName("Reference2")
        private Object reference2;

        @SerializedName("Url")
        private String url;

        @SerializedName("SaleCount")
        private Integer saleCount;

        @SerializedName("Has360Images")
        private Boolean has360Images;

        @SerializedName("FirstDetail")
        private String firstDetail;

        @SerializedName("IsInFavoriteList")
        private Boolean isInFavoriteList;

        @SerializedName("IsDiscount")
        private Boolean isDiscount;

        @SerializedName("IsNew")
        private Boolean isNew;

        @SerializedName("CommentCount")
        private Integer commentCount;

        @SerializedName("CommentAvaragePoint")
        private Integer commentAvaragePoint;

        @SerializedName("CampaignIconUrl")
        private String campaignIconUrl;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setOldPrice(Double oldPrice) {
            this.oldPrice = oldPrice;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public String getFormattedPrice() {
            return formattedPrice;
        }

        public void setFormattedPrice(String formattedPrice) {
            this.formattedPrice = formattedPrice;
        }

        public String getFormattedOldPrice() {
            return formattedOldPrice;
        }

        public void setFormattedOldPrice(String formattedOldPrice) {
            this.formattedOldPrice = formattedOldPrice;
        }

        public String getFormattedGainAmount() {
            return formattedGainAmount;
        }

        public void setFormattedGainAmount(String formattedGainAmount) {
            this.formattedGainAmount = formattedGainAmount;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setExplaination(String explaination) {
            this.explaination = explaination;
        }

        public void setSecondExplaination(String secondExplaination) {
            this.secondExplaination = secondExplaination;
        }

        public String getThirdExplaination() {
            return thirdExplaination;
        }

        public void setThirdExplaination(String thirdExplaination) {
            this.thirdExplaination = thirdExplaination;
        }

        public void setFourthExplaination(String fourthExplaination) {
            this.fourthExplaination = fourthExplaination;
        }

        public String getProductCode() {
            return productCode;
        }

        public void setProductCode(String productCode) {
            this.productCode = productCode;
        }

        public String getManufacturerCode() {
            return manufacturerCode;
        }

        public void setManufacturerCode(String manufacturerCode) {
            this.manufacturerCode = manufacturerCode;
        }

        public Mark getMark() {
            return mark;
        }

        public void setMark(Mark mark) {
            this.mark = mark;
        }

        public Integer getVatRatio() {
            return vatRatio;
        }

        public void setVatRatio(Integer vatRatio) {
            this.vatRatio = vatRatio;
        }

        public Double getDiscountRatio() {
            return discountRatio;
        }

        public void setDiscountRatio(Double discountRatio) {
            this.discountRatio = discountRatio;
        }

        public void setReference3(String reference3) {
            this.reference3 = reference3;
        }

        public String getRecordDate() {
            return recordDate;
        }

        public void setRecordDate(String recordDate) {
            this.recordDate = recordDate;
        }

        public void setProducts(List<Product> products) {
            this.products = products;
        }

        public List<Object> getRelatedProducts() {
            return relatedProducts;
        }

        public void setRelatedProducts(List<Object> relatedProducts) {
            this.relatedProducts = relatedProducts;
        }

        public void setImages(List<Image> images) {
            this.images = images;
        }

        public List<Tag> getTags() {
            return tags;
        }

        public void setTags(List<Tag> tags) {
            this.tags = tags;
        }

        public SegmentPrice getSegmentPrice() {
            return segmentPrice;
        }

        public void setSegmentPrice(SegmentPrice segmentPrice) {
            this.segmentPrice = segmentPrice;
        }

        public List<TagListJson> getTagListJson() {
            return tagListJson;
        }

        public void setTagListJson(List<TagListJson> tagListJson) {
            this.tagListJson = tagListJson;
        }

        public List<Object> getDepartments() {
            return departments;
        }

        public void setDepartments(List<Object> departments) {
            this.departments = departments;
        }

        public Boolean getReference1() {
            return reference1;
        }

        public void setReference1(Boolean reference1) {
            this.reference1 = reference1;
        }

        public Boolean getStockExist() {
            return stockExist;
        }

        public void setStockExist(Boolean stockExist) {
            this.stockExist = stockExist;
        }

        public Object getReference2() {
            return reference2;
        }

        public void setReference2(Object reference2) {
            this.reference2 = reference2;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Integer getSaleCount() {
            return saleCount;
        }

        public void setSaleCount(Integer saleCount) {
            this.saleCount = saleCount;
        }

        public Boolean getHas360Images() {
            return has360Images;
        }

        public void setHas360Images(Boolean has360Images) {
            this.has360Images = has360Images;
        }

        public String getFirstDetail() {
            return firstDetail;
        }

        public void setFirstDetail(String firstDetail) {
            this.firstDetail = firstDetail;
        }

        public Boolean getIsInFavoriteList() {
            return isInFavoriteList;
        }

        public void setIsInFavoriteList(Boolean isInFavoriteList) {
            this.isInFavoriteList = isInFavoriteList;
        }

        public Boolean getIsDiscount() {
            return isDiscount;
        }

        public void setIsDiscount(Boolean isDiscount) {
            this.isDiscount = isDiscount;
        }

        public Boolean getIsNew() {
            return isNew;
        }

        public void setIsNew(Boolean isNew) {
            this.isNew = isNew;
        }

        public Integer getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(Integer commentCount) {
            this.commentCount = commentCount;
        }

        public Integer getCommentAvaragePoint() {
            return commentAvaragePoint;
        }

        public void setCommentAvaragePoint(Integer commentAvaragePoint) {
            this.commentAvaragePoint = commentAvaragePoint;
        }

        public String getCampaignIconUrl() {
            return campaignIconUrl;
        }

        public void setCampaignIconUrl(String campaignIconUrl) {
            this.campaignIconUrl = campaignIconUrl;
        }
    }

    public class Image {
        @SerializedName("FileName")
        public String fileName;

        @SerializedName("Description")
        private String description;

        @SerializedName("Order")
        private Integer order;

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getOrder() {
            return order;
        }

        public void setOrder(Integer order) {
            this.order = order;
        }
    }

    public class Mark {
        @SerializedName("Id")
        private Integer id;

        @SerializedName("Name")
        private Object name;

        @SerializedName("Reference1")
        private Object reference1;

        @SerializedName("Reference2")
        private Object reference2;

        @SerializedName("Reference3")
        private Object reference3;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Object getName() {
            return name;
        }

        public void setName(Object name) {
            this.name = name;
        }

        public Object getReference1() {
            return reference1;
        }

        public void setReference1(Object reference1) {
            this.reference1 = reference1;
        }

        public Object getReference2() {
            return reference2;
        }

        public void setReference2(Object reference2) {
            this.reference2 = reference2;
        }

        public Object getReference3() {
            return reference3;
        }

        public void setReference3(Object reference3) {
            this.reference3 = reference3;
        }
    }

    public class Product {
        @SerializedName("Id")
        private Integer id;

        @SerializedName("Name")
        private String name;

        @SerializedName("BodyId")
        private Integer bodyId;

        @SerializedName("Body")
        public String body;

        @SerializedName("ColorId")
        private Integer colorId;

        @SerializedName("Color")
        private String color;

        @SerializedName("OldPrice")
        private Integer oldPrice;

        @SerializedName("Barcode")
        public String barcode;

        @SerializedName("Price")
        private Double price;

        @SerializedName("Stock")
        private Integer stock;

        @SerializedName("StoreStock")
        private Integer storeStock;

        @SerializedName("ProductDescriptionId")
        private Integer productDescriptionId;

        @SerializedName("ProductCode")
        private String productCode;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getBodyId() {
            return bodyId;
        }

        public void setBodyId(Integer bodyId) {
            this.bodyId = bodyId;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public Integer getColorId() {
            return colorId;
        }

        public void setColorId(Integer colorId) {
            this.colorId = colorId;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Integer getOldPrice() {
            return oldPrice;
        }

        public void setOldPrice(Integer oldPrice) {
            this.oldPrice = oldPrice;
        }

        public void setBarcode(String barcode) {
            this.barcode = barcode;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Integer getStock() {
            return stock;
        }

        public void setStock(Integer stock) {
            this.stock = stock;
        }

        public Integer getStoreStock() {
            return storeStock;
        }

        public void setStoreStock(Integer storeStock) {
            this.storeStock = storeStock;
        }

        public Integer getProductDescriptionId() {
            return productDescriptionId;
        }

        public void setProductDescriptionId(Integer productDescriptionId) {
            this.productDescriptionId = productDescriptionId;
        }

        public String getProductCode() {
            return productCode;
        }

        public void setProductCode(String productCode) {
            this.productCode = productCode;
        }
    }

    public class SegmentPrice {
    }

    public class Tag {
        @SerializedName("Id")
        private Integer id;

        @SerializedName("GroupName")
        private String groupName;

        @SerializedName("Name")
        private String name;

        @SerializedName("OrderNumber")
        private Integer orderNumber;

        @SerializedName("ColorCode")
        private String colorCode;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getOrderNumber() {
            return orderNumber;
        }

        public void setOrderNumber(Integer orderNumber) {
            this.orderNumber = orderNumber;
        }

        public String getColorCode() {
            return colorCode;
        }

        public void setColorCode(String colorCode) {
            this.colorCode = colorCode;
        }
    }

    public class TagListJson {
        @SerializedName("GroupId")
        private Integer groupId;

        @SerializedName("GroupName")
        private String groupName;

        @SerializedName("Id")
        private Integer id;

        @SerializedName("Name")
        private String name;

        @SerializedName("ColorCode")
        private String colorCode;

        @SerializedName("GroupOrder")
        private Integer groupOrder;

        @SerializedName("Order")
        private Integer order;

        public Integer getGroupId() {
            return groupId;
        }

        public void setGroupId(Integer groupId) {
            this.groupId = groupId;
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getColorCode() {
            return colorCode;
        }

        public void setColorCode(String colorCode) {
            this.colorCode = colorCode;
        }

        public Integer getGroupOrder() {
            return groupOrder;
        }

        public void setGroupOrder(Integer groupOrder) {
            this.groupOrder = groupOrder;
        }

        public Integer getOrder() {
            return order;
        }

        public void setOrder(Integer order) {
            this.order = order;
        }
    }
}