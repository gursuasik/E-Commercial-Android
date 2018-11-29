package tr.com.rnd.master.Model.Result;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResult {
    public class Search {
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

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }
    }

    public class Data {
        @SerializedName("Id")
        private Integer id;

        @SerializedName("ParentId")
        private Integer parentId;

        @SerializedName("Url")
        private String url;

        @SerializedName("Name")
        private String name;

        @SerializedName("Title")
        private String title;

        @SerializedName("HtmlContent")
        private String htmlContent;

        @SerializedName("MetaTag")
        private String metaTag;

        @SerializedName("ProductListCount")
        private Integer productListCount;

        @SerializedName("TotalProductCount")
        private Integer totalProductCount;

        @SerializedName("ListingType")
        private Integer listingType;

        @SerializedName("Products")
        public List<Product> products = null;

        @SerializedName("MarkList")
        private List<MarkList> markList = null;

        @SerializedName("TagList")
        private List<TagList_> tagList = null;

        @SerializedName("SpecList")
        private List<SpecList> specList = null;

        @SerializedName("Explanation")
        private Object explanation;

        @SerializedName("Explanation1")
        private Object explanation1;

        @SerializedName("Explanation2")
        private String explanation2;

        @SerializedName("Explanation3")
        private String explanation3;

        @SerializedName("IsCriteria")
        private Boolean isCriteria;

        @SerializedName("Criteria")
        private Object criteria;

        @SerializedName("MinPrice")
        private Integer minPrice;

        @SerializedName("MaxPrice")
        private Integer maxPrice;

        @SerializedName("TagGroup")
        public List<TagGroup> tagGroup = null;

        @SerializedName("SpecGroup")
        public List<SpecGroup> specGroup = null;

        @SerializedName("ImagePath")
        private Object imagePath;

        @SerializedName("IconLogoPath")
        private Object iconLogoPath;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getParentId() {
            return parentId;
        }

        public void setParentId(Integer parentId) {
            this.parentId = parentId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getHtmlContent() {
            return htmlContent;
        }

        public void setHtmlContent(String htmlContent) {
            this.htmlContent = htmlContent;
        }

        public String getMetaTag() {
            return metaTag;
        }

        public void setMetaTag(String metaTag) {
            this.metaTag = metaTag;
        }

        public Integer getProductListCount() {
            return productListCount;
        }

        public void setProductListCount(Integer productListCount) {
            this.productListCount = productListCount;
        }

        public Integer getTotalProductCount() {
            return totalProductCount;
        }

        public void setTotalProductCount(Integer totalProductCount) {
            this.totalProductCount = totalProductCount;
        }

        public Integer getListingType() {
            return listingType;
        }

        public void setListingType(Integer listingType) {
            this.listingType = listingType;
        }

        public List<Product> getProducts() {
            return products;
        }

        public void setProducts(List<Product> products) {
            this.products = products;
        }

        public List<MarkList> getMarkList() {
            return markList;
        }

        public void setMarkList(List<MarkList> markList) {
            this.markList = markList;
        }

        public List<TagList_> getTagList() {
            return tagList;
        }

        public void setTagList(List<TagList_> tagList) {
            this.tagList = tagList;
        }

        public List<SpecList> getSpecList() {
            return specList;
        }

        public void setSpecList(List<SpecList> specList) {
            this.specList = specList;
        }

        public Object getExplanation() {
            return explanation;
        }

        public void setExplanation(Object explanation) {
            this.explanation = explanation;
        }

        public Object getExplanation1() {
            return explanation1;
        }

        public void setExplanation1(Object explanation1) {
            this.explanation1 = explanation1;
        }

        public String getExplanation2() {
            return explanation2;
        }

        public void setExplanation2(String explanation2) {
            this.explanation2 = explanation2;
        }

        public String getExplanation3() {
            return explanation3;
        }

        public void setExplanation3(String explanation3) {
            this.explanation3 = explanation3;
        }

        public Boolean getIsCriteria() {
            return isCriteria;
        }

        public void setIsCriteria(Boolean isCriteria) {
            this.isCriteria = isCriteria;
        }

        public Object getCriteria() {
            return criteria;
        }

        public void setCriteria(Object criteria) {
            this.criteria = criteria;
        }

        public Integer getMinPrice() {
            return minPrice;
        }

        public void setMinPrice(Integer minPrice) {
            this.minPrice = minPrice;
        }

        public Integer getMaxPrice() {
            return maxPrice;
        }

        public void setMaxPrice(Integer maxPrice) {
            this.maxPrice = maxPrice;
        }

        public void setTagGroup(List<TagGroup> tagGroup) {
            this.tagGroup = tagGroup;
        }

        public void setSpecGroup(List<SpecGroup> specGroup) {
            this.specGroup = specGroup;
        }

        public Object getImagePath() {
            return imagePath;
        }

        public void setImagePath(Object imagePath) {
            this.imagePath = imagePath;
        }

        public Object getIconLogoPath() {
            return iconLogoPath;
        }

        public void setIconLogoPath(Object iconLogoPath) {
            this.iconLogoPath = iconLogoPath;
        }
    }

    public class List__ {
        @SerializedName("Name")
        public String name;

        @SerializedName("OrderNumber")
        private Integer orderNumber;

        @SerializedName("GroupOrderNumber")
        private Integer groupOrderNumber;

        @SerializedName("Type")
        private Integer type;

        @SerializedName("Id")
        public String id;

        @SerializedName("Select")
        private Boolean select;

        @SerializedName("Count")
        private Integer count;

        @SerializedName("GroupName")
        private String groupName;

        @SerializedName("GroupId")
        private Integer groupId;

        @SerializedName("IconImage")
        private String iconImage;

        @SerializedName("ColorCode")
        private Object colorCode;

        public void setName(String name) {
            this.name = name;
        }

        public Integer getOrderNumber() {
            return orderNumber;
        }

        public void setOrderNumber(Integer orderNumber) {
            this.orderNumber = orderNumber;
        }

        public Integer getGroupOrderNumber() {
            return groupOrderNumber;
        }

        public void setGroupOrderNumber(Integer groupOrderNumber) {
            this.groupOrderNumber = groupOrderNumber;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Boolean getSelect() {
            return select;
        }

        public void setSelect(Boolean select) {
            this.select = select;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public Integer getGroupId() {
            return groupId;
        }

        public void setGroupId(Integer groupId) {
            this.groupId = groupId;
        }

        public String getIconImage() {
            return iconImage;
        }

        public void setIconImage(String iconImage) {
            this.iconImage = iconImage;
        }

        public Object getColorCode() {
            return colorCode;
        }

        public void setColorCode(Object colorCode) {
            this.colorCode = colorCode;
        }
    }

    public class List_ {
        @SerializedName("Name")
        public String name;

        @SerializedName("OrderNumber")
        private Integer orderNumber;

        @SerializedName("GroupOrderNumber")
        private Integer groupOrderNumber;

        @SerializedName("Type")
        private Integer type;

        @SerializedName("Id")
        public String id;

        @SerializedName("Select")
        private Boolean select;

        @SerializedName("Count")
        private Integer count;

        @SerializedName("GroupName")
        private String groupName;

        @SerializedName("GroupId")
        private Integer groupId;

        @SerializedName("IconImage")
        private String iconImage;

        @SerializedName("ColorCode")
        private Object colorCode;

        public void setName(String name) {
            this.name = name;
        }

        public Integer getOrderNumber() {
            return orderNumber;
        }

        public void setOrderNumber(Integer orderNumber) {
            this.orderNumber = orderNumber;
        }

        public Integer getGroupOrderNumber() {
            return groupOrderNumber;
        }

        public void setGroupOrderNumber(Integer groupOrderNumber) {
            this.groupOrderNumber = groupOrderNumber;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Boolean getSelect() {
            return select;
        }

        public void setSelect(Boolean select) {
            this.select = select;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public Integer getGroupId() {
            return groupId;
        }

        public void setGroupId(Integer groupId) {
            this.groupId = groupId;
        }

        public String getIconImage() {
            return iconImage;
        }

        public void setIconImage(String iconImage) {
            this.iconImage = iconImage;
        }

        public Object getColorCode() {
            return colorCode;
        }

        public void setColorCode(Object colorCode) {
            this.colorCode = colorCode;
        }
    }

    public class MarkList {
        @SerializedName("Name")
        private String name;

        @SerializedName("OrderNumber")
        private Integer orderNumber;

        @SerializedName("GroupOrderNumber")
        private Integer groupOrderNumber;

        @SerializedName("Type")
        private Integer type;

        @SerializedName("Id")
        private String id;

        @SerializedName("Select")
        private Boolean select;

        @SerializedName("Count")
        private Integer count;

        @SerializedName("GroupName")
        private String groupName;

        @SerializedName("GroupId")
        private Integer groupId;

        @SerializedName("IconImage")
        private Object iconImage;

        @SerializedName("ColorCode")
        private Object colorCode;

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

        public Integer getGroupOrderNumber() {
            return groupOrderNumber;
        }

        public void setGroupOrderNumber(Integer groupOrderNumber) {
            this.groupOrderNumber = groupOrderNumber;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Boolean getSelect() {
            return select;
        }

        public void setSelect(Boolean select) {
            this.select = select;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public Integer getGroupId() {
            return groupId;
        }

        public void setGroupId(Integer groupId) {
            this.groupId = groupId;
        }

        public Object getIconImage() {
            return iconImage;
        }

        public void setIconImage(Object iconImage) {
            this.iconImage = iconImage;
        }

        public Object getColorCode() {
            return colorCode;
        }

        public void setColorCode(Object colorCode) {
            this.colorCode = colorCode;
        }
    }

    public class Product {
        @SerializedName("Id")
        private Integer id;

        @SerializedName("Name")
        public String name;

        @SerializedName("ProductCode")
        public String productCode;

        @SerializedName("ManufactureCode")
        private String manufactureCode;

        @SerializedName("Detail")
        private String detail;

        @SerializedName("FirstDetail")
        private String firstDetail;

        @SerializedName("Tags")
        private List<String> tags = null;

        @SerializedName("TagListJson")
        private List<TagListJson> tagListJson = null;

        @SerializedName("SpecsJson")
        private List<SpecsJson> specsJson = null;

        @SerializedName("Specs")
        private List<String> specs = null;

        @SerializedName("Date")
        private String date;

        @SerializedName("ActivationDate")
        private String activationDate;

        @SerializedName("ActivationDateNumeric")
        private Integer activationDateNumeric;

        @SerializedName("SaleCount")
        private Integer saleCount;

        @SerializedName("DisplayCount")
        private Integer displayCount;

        @SerializedName("Price")
        public Double price;

        @SerializedName("VatRatio")
        private Integer vatRatio;

        @SerializedName("Point")
        private Integer point;

        @SerializedName("NPoint")
        private String nPoint;

        @SerializedName("PriceInput")
        private Integer priceInput;

        @SerializedName("SegmentOldPrice")
        private Double segmentOldPrice;

        @SerializedName("OldPrice")
        private Integer oldPrice;

        @SerializedName("IsNew")
        private Boolean isNew;

        @SerializedName("IsDiscount")
        private Boolean isDiscount;

        @SerializedName("MainImage")
        private String mainImage;

        @SerializedName("MainImageDescription")
        private String mainImageDescription;

        @SerializedName("MarkId")
        private Integer markId;

        @SerializedName("Stock")
        private Integer stock;

        @SerializedName("StoreStock")
        private Integer storeStock;

        @SerializedName("TotalStock")
        private Integer totalStock;

        @SerializedName("MarkName")
        private String markName;

        @SerializedName("ProductUrl")
        private String productUrl;

        @SerializedName("MarkKey")
        private String markKey;

        @SerializedName("Reference1")
        private String reference1;

        @SerializedName("Reference3")
        private String reference3;

        @SerializedName("Order")
        private Integer order;

        @SerializedName("Departments")
        private List<Integer> departments = null;

        @SerializedName("SegmentPrice")
        private SegmentPrice segmentPrice;

        @SerializedName("SecondImage")
        private String secondImage;

        @SerializedName("PriceRatio")
        private Integer priceRatio;

        @SerializedName("PriceRangeId")
        private String priceRangeId;

        @SerializedName("Gender")
        private String gender;

        @SerializedName("GenderId")
        private String genderId;

        @SerializedName("IsFastCargo")
        private Boolean isFastCargo;

        @SerializedName("StockExist")
        private Boolean stockExist;

        @SerializedName("ColorName")
        private String colorName;

        @SerializedName("ColorIconImage")
        private String colorIconImage;

        @SerializedName("SearchName")
        private String searchName;

        @SerializedName("SortName")
        private Object sortName;

        @SerializedName("LikedCount")
        private String likedCount;

        @SerializedName("DiscountRatio")
        private Integer discountRatio;

        @SerializedName("Season")
        private Integer season;

        @SerializedName("ImageList")
        public List<String> imageList = null;

        @SerializedName("ImageListWithOrder")
        private List<String> imageListWithOrder = null;

        @SerializedName("ProductType")
        private String productType;

        @SerializedName("ProductTypeKey")
        private String productTypeKey;

        @SerializedName("ProductTypeId")
        private Integer productTypeId;

        @SerializedName("Explaination")
        private String explaination;

        @SerializedName("IsOnShow")
        private Boolean isOnShow;

        @SerializedName("TagList")
        private List<TagList> tagList = null;

        @SerializedName("Barcode")
        private String barcode;

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

        public void setProductCode(String productCode) {
            this.productCode = productCode;
        }

        public String getManufactureCode() {
            return manufactureCode;
        }

        public void setManufactureCode(String manufactureCode) {
            this.manufactureCode = manufactureCode;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getFirstDetail() {
            return firstDetail;
        }

        public void setFirstDetail(String firstDetail) {
            this.firstDetail = firstDetail;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public List<TagListJson> getTagListJson() {
            return tagListJson;
        }

        public void setTagListJson(List<TagListJson> tagListJson) {
            this.tagListJson = tagListJson;
        }

        public List<SpecsJson> getSpecsJson() {
            return specsJson;
        }

        public void setSpecsJson(List<SpecsJson> specsJson) {
            this.specsJson = specsJson;
        }

        public List<String> getSpecs() {
            return specs;
        }

        public void setSpecs(List<String> specs) {
            this.specs = specs;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getActivationDate() {
            return activationDate;
        }

        public void setActivationDate(String activationDate) {
            this.activationDate = activationDate;
        }

        public Integer getActivationDateNumeric() {
            return activationDateNumeric;
        }

        public void setActivationDateNumeric(Integer activationDateNumeric) {
            this.activationDateNumeric = activationDateNumeric;
        }

        public Integer getSaleCount() {
            return saleCount;
        }

        public void setSaleCount(Integer saleCount) {
            this.saleCount = saleCount;
        }

        public Integer getDisplayCount() {
            return displayCount;
        }

        public void setDisplayCount(Integer displayCount) {
            this.displayCount = displayCount;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Integer getVatRatio() {
            return vatRatio;
        }

        public void setVatRatio(Integer vatRatio) {
            this.vatRatio = vatRatio;
        }

        public Integer getPoint() {
            return point;
        }

        public void setPoint(Integer point) {
            this.point = point;
        }

        public String getNPoint() {
            return nPoint;
        }

        public void setNPoint(String nPoint) {
            this.nPoint = nPoint;
        }

        public Integer getPriceInput() {
            return priceInput;
        }

        public void setPriceInput(Integer priceInput) {
            this.priceInput = priceInput;
        }

        public void setSegmentOldPrice(Double segmentOldPrice) {
            this.segmentOldPrice = segmentOldPrice;
        }

        public Integer getOldPrice() {
            return oldPrice;
        }

        public void setOldPrice(Integer oldPrice) {
            this.oldPrice = oldPrice;
        }

        public Boolean getIsNew() {
            return isNew;
        }

        public void setIsNew(Boolean isNew) {
            this.isNew = isNew;
        }

        public Boolean getIsDiscount() {
            return isDiscount;
        }

        public void setIsDiscount(Boolean isDiscount) {
            this.isDiscount = isDiscount;
        }

        public String getMainImage() {
            return mainImage;
        }

        public void setMainImage(String mainImage) {
            this.mainImage = mainImage;
        }

        public String getMainImageDescription() {
            return mainImageDescription;
        }

        public void setMainImageDescription(String mainImageDescription) {
            this.mainImageDescription = mainImageDescription;
        }

        public Integer getMarkId() {
            return markId;
        }

        public void setMarkId(Integer markId) {
            this.markId = markId;
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

        public Integer getTotalStock() {
            return totalStock;
        }

        public void setTotalStock(Integer totalStock) {
            this.totalStock = totalStock;
        }

        public String getMarkName() {
            return markName;
        }

        public void setMarkName(String markName) {
            this.markName = markName;
        }

        public String getProductUrl() {
            return productUrl;
        }

        public void setProductUrl(String productUrl) {
            this.productUrl = productUrl;
        }

        public String getMarkKey() {
            return markKey;
        }

        public void setMarkKey(String markKey) {
            this.markKey = markKey;
        }

        public String getReference1() {
            return reference1;
        }

        public void setReference1(String reference1) {
            this.reference1 = reference1;
        }

        public String getReference3() {
            return reference3;
        }

        public void setReference3(String reference3) {
            this.reference3 = reference3;
        }

        public Integer getOrder() {
            return order;
        }

        public void setOrder(Integer order) {
            this.order = order;
        }

        public List<Integer> getDepartments() {
            return departments;
        }

        public void setDepartments(List<Integer> departments) {
            this.departments = departments;
        }

        public SegmentPrice getSegmentPrice() {
            return segmentPrice;
        }

        public void setSegmentPrice(SegmentPrice segmentPrice) {
            this.segmentPrice = segmentPrice;
        }

        public String getSecondImage() {
            return secondImage;
        }

        public void setSecondImage(String secondImage) {
            this.secondImage = secondImage;
        }

        public Integer getPriceRatio() {
            return priceRatio;
        }

        public void setPriceRatio(Integer priceRatio) {
            this.priceRatio = priceRatio;
        }

        public String getPriceRangeId() {
            return priceRangeId;
        }

        public void setPriceRangeId(String priceRangeId) {
            this.priceRangeId = priceRangeId;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getGenderId() {
            return genderId;
        }

        public void setGenderId(String genderId) {
            this.genderId = genderId;
        }

        public Boolean getIsFastCargo() {
            return isFastCargo;
        }

        public void setIsFastCargo(Boolean isFastCargo) {
            this.isFastCargo = isFastCargo;
        }

        public Boolean getStockExist() {
            return stockExist;
        }

        public void setStockExist(Boolean stockExist) {
            this.stockExist = stockExist;
        }

        public String getColorName() {
            return colorName;
        }

        public void setColorName(String colorName) {
            this.colorName = colorName;
        }

        public String getColorIconImage() {
            return colorIconImage;
        }

        public void setColorIconImage(String colorIconImage) {
            this.colorIconImage = colorIconImage;
        }

        public String getSearchName() {
            return searchName;
        }

        public void setSearchName(String searchName) {
            this.searchName = searchName;
        }

        public Object getSortName() {
            return sortName;
        }

        public void setSortName(Object sortName) {
            this.sortName = sortName;
        }

        public String getLikedCount() {
            return likedCount;
        }

        public void setLikedCount(String likedCount) {
            this.likedCount = likedCount;
        }

        public Integer getDiscountRatio() {
            return discountRatio;
        }

        public void setDiscountRatio(Integer discountRatio) {
            this.discountRatio = discountRatio;
        }

        public Integer getSeason() {
            return season;
        }

        public void setSeason(Integer season) {
            this.season = season;
        }

        public List<String> getImageList() {
            return imageList;
        }

        public void setImageList(List<String> imageList) {
            this.imageList = imageList;
        }

        public List<String> getImageListWithOrder() {
            return imageListWithOrder;
        }

        public void setImageListWithOrder(List<String> imageListWithOrder) {
            this.imageListWithOrder = imageListWithOrder;
        }

        public String getProductType() {
            return productType;
        }

        public void setProductType(String productType) {
            this.productType = productType;
        }

        public String getProductTypeKey() {
            return productTypeKey;
        }

        public void setProductTypeKey(String productTypeKey) {
            this.productTypeKey = productTypeKey;
        }

        public Integer getProductTypeId() {
            return productTypeId;
        }

        public void setProductTypeId(Integer productTypeId) {
            this.productTypeId = productTypeId;
        }

        public String getExplaination() {
            return explaination;
        }

        public void setExplaination(String explaination) {
            this.explaination = explaination;
        }

        public Boolean getIsOnShow() {
            return isOnShow;
        }

        public void setIsOnShow(Boolean isOnShow) {
            this.isOnShow = isOnShow;
        }

        public List<TagList> getTagList() {
            return tagList;
        }

        public void setTagList(List<TagList> tagList) {
            this.tagList = tagList;
        }

        public String getBarcode() {
            return barcode;
        }

        public void setBarcode(String barcode) {
            this.barcode = barcode;
        }
    }

    public class SegmentPrice {
    }

    public class SpecGroup {
        @SerializedName("List")
        public List<List_> list = null;

        @SerializedName("Id")
        private Integer id;

        @SerializedName("Name")
        public String name;

        @SerializedName("Count")
        private Integer count;

        @SerializedName("Order")
        private Integer order;

        public void setList(List<List_> list) {
            this.list = list;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Integer getOrder() {
            return order;
        }

        public void setOrder(Integer order) {
            this.order = order;
        }
    }

    public class SpecList {
        @SerializedName("Name")
        private String name;

        @SerializedName("OrderNumber")
        private Integer orderNumber;

        @SerializedName("GroupOrderNumber")
        private Integer groupOrderNumber;

        @SerializedName("Type")
        private Integer type;

        @SerializedName("Id")
        private String id;

        @SerializedName("Select")
        private Boolean select;

        @SerializedName("Count")
        private Integer count;

        @SerializedName("GroupName")
        private String groupName;

        @SerializedName("GroupId")
        private Integer groupId;

        @SerializedName("IconImage")
        private String iconImage;

        @SerializedName("ColorCode")
        private Object colorCode;

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

        public Integer getGroupOrderNumber() {
            return groupOrderNumber;
        }

        public void setGroupOrderNumber(Integer groupOrderNumber) {
            this.groupOrderNumber = groupOrderNumber;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Boolean getSelect() {
            return select;
        }

        public void setSelect(Boolean select) {
            this.select = select;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public Integer getGroupId() {
            return groupId;
        }

        public void setGroupId(Integer groupId) {
            this.groupId = groupId;
        }

        public String getIconImage() {
            return iconImage;
        }

        public void setIconImage(String iconImage) {
            this.iconImage = iconImage;
        }

        public Object getColorCode() {
            return colorCode;
        }

        public void setColorCode(Object colorCode) {
            this.colorCode = colorCode;
        }
    }

    public class SpecsJson {
        @SerializedName("Id")
        private Integer id;

        @SerializedName("Name")
        private String name;

        @SerializedName("Order")
        private Integer order;

        @SerializedName("SpecialityTypeId")
        private Integer specialityTypeId;

        @SerializedName("TypeName")
        private String typeName;

        @SerializedName("TypeOrder")
        private Integer typeOrder;

        @SerializedName("IconImage")
        private String iconImage;

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

        public Integer getOrder() {
            return order;
        }

        public void setOrder(Integer order) {
            this.order = order;
        }

        public Integer getSpecialityTypeId() {
            return specialityTypeId;
        }

        public void setSpecialityTypeId(Integer specialityTypeId) {
            this.specialityTypeId = specialityTypeId;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public Integer getTypeOrder() {
            return typeOrder;
        }

        public void setTypeOrder(Integer typeOrder) {
            this.typeOrder = typeOrder;
        }

        public String getIconImage() {
            return iconImage;
        }

        public void setIconImage(String iconImage) {
            this.iconImage = iconImage;
        }
    }

    public class TagGroup {
        @SerializedName("List")
        public List<List__> list = null;

        @SerializedName("Id")
        private Integer id;

        @SerializedName("Name")
        public String name;

        @SerializedName("Count")
        private Integer count;

        @SerializedName("Order")
        private Integer order;

        public void setList(List<List__> list) {
            this.list = list;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Integer getOrder() {
            return order;
        }

        public void setOrder(Integer order) {
            this.order = order;
        }
    }

    public class TagList {
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

    public class TagList_ {
        @SerializedName("Name")
        private String name;

        @SerializedName("OrderNumber")
        private Integer orderNumber;

        @SerializedName("GroupOrderNumber")
        private Integer groupOrderNumber;

        @SerializedName("Type")
        private Integer type;

        @SerializedName("Id")
        private String id;

        @SerializedName("Select")
        private Boolean select;

        @SerializedName("Count")
        private Integer count;

        @SerializedName("GroupName")
        private String groupName;

        @SerializedName("GroupId")
        private Integer groupId;

        @SerializedName("IconImage")
        private String iconImage;

        @SerializedName("ColorCode")
        private String colorCode;

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

        public Integer getGroupOrderNumber() {
            return groupOrderNumber;
        }

        public void setGroupOrderNumber(Integer groupOrderNumber) {
            this.groupOrderNumber = groupOrderNumber;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Boolean getSelect() {
            return select;
        }

        public void setSelect(Boolean select) {
            this.select = select;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public Integer getGroupId() {
            return groupId;
        }

        public void setGroupId(Integer groupId) {
            this.groupId = groupId;
        }

        public String getIconImage() {
            return iconImage;
        }

        public void setIconImage(String iconImage) {
            this.iconImage = iconImage;
        }

        public String getColorCode() {
            return colorCode;
        }

        public void setColorCode(String colorCode) {
            this.colorCode = colorCode;
        }
    }
}