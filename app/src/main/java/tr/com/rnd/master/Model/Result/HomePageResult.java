package tr.com.rnd.master.Model.Result;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomePageResult {
    public class HomePage {
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

    public class Banner {
        @SerializedName("Field")
        public Field__ field;

        @SerializedName("ParentFields")
        public List<ParentField_> parentFields = null;

        public Field__ getField() {
            return field;
        }

        public void setField(Field__ field) {
            this.field = field;
        }

        public List<ParentField_> getParentFields() {
            return parentFields;
        }

        public void setParentFields(List<ParentField_> parentFields) {
            this.parentFields = parentFields;
        }
    }

    public class Data {
        @SerializedName("Slider")
        public List<Slider> slider = null;

        @SerializedName("LeftMenu")
        public List<LeftMenu> leftMenu = null;

        @SerializedName("Menu")
        private List<Object> menu = null;

        @SerializedName("Banner")
        public List<Banner> banner = null;

        @SerializedName("H2Content")
        private H2Content h2Content;

        public List<Slider> getSlider() {
            return slider;
        }

        public void setSlider(List<Slider> slider) {
            this.slider = slider;
        }

        public List<LeftMenu> getLeftMenu() {
            return leftMenu;
        }

        public void setLeftMenu(List<LeftMenu> leftMenu) {
            this.leftMenu = leftMenu;
        }

        public List<Object> getMenu() {
            return menu;
        }

        public void setMenu(List<Object> menu) {
            this.menu = menu;
        }

        public List<Banner> getBanner() {
            return banner;
        }

        public void setBanner(List<Banner> banner) {
            this.banner = banner;
        }

        public H2Content getH2Content() {
            return h2Content;
        }

        public void setH2Content(H2Content h2Content) {
            this.h2Content = h2Content;
        }
    }

    public class Field {
        @SerializedName("Id")
        private Integer id;

        @SerializedName("ContentId")
        private Integer contentId;

        @SerializedName("Name")
        private String name;

        @SerializedName("Value")
        private String value;

        @SerializedName("Type")
        private String type;

        @SerializedName("Reference1")
        private String reference1;

        @SerializedName("Reference2")
        private String reference2;

        @SerializedName("Reference3")
        private String reference3;

        @SerializedName("Reference4")
        private String reference4;

        @SerializedName("Reference5")
        private String reference5;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getContentId() {
            return contentId;
        }

        public void setContentId(Integer contentId) {
            this.contentId = contentId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getReference1() {
            return reference1;
        }

        public void setReference1(String reference1) {
            this.reference1 = reference1;
        }

        public String getReference2() {
            return reference2;
        }

        public void setReference2(String reference2) {
            this.reference2 = reference2;
        }

        public String getReference3() {
            return reference3;
        }

        public void setReference3(String reference3) {
            this.reference3 = reference3;
        }

        public String getReference4() {
            return reference4;
        }

        public void setReference4(String reference4) {
            this.reference4 = reference4;
        }

        public String getReference5() {
            return reference5;
        }

        public void setReference5(String reference5) {
            this.reference5 = reference5;
        }

    }

    public class Field_ {
        @SerializedName("Id")
        private Integer id;

        @SerializedName("ContentId")
        private Integer contentId;

        @SerializedName("Name")
        public String name;

        @SerializedName("Value")
        public String value;

        @SerializedName("Type")
        private String type;

        @SerializedName("Reference1")
        private String reference1;

        @SerializedName("Reference2")
        private String reference2;

        @SerializedName("Reference3")
        private Object reference3;

        @SerializedName("Reference4")
        private Object reference4;

        @SerializedName("Reference5")
        private Object reference5;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getContentId() {
            return contentId;
        }

        public void setContentId(Integer contentId) {
            this.contentId = contentId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getReference1() {
            return reference1;
        }

        public void setReference1(String reference1) {
            this.reference1 = reference1;
        }

        public String getReference2() {
            return reference2;
        }

        public void setReference2(String reference2) {
            this.reference2 = reference2;
        }

        public Object getReference3() {
            return reference3;
        }

        public void setReference3(Object reference3) {
            this.reference3 = reference3;
        }

        public Object getReference4() {
            return reference4;
        }

        public void setReference4(Object reference4) {
            this.reference4 = reference4;
        }

        public Object getReference5() {
            return reference5;
        }

        public void setReference5(Object reference5) {
            this.reference5 = reference5;
        }
    }

    public class Field__ {
        @SerializedName("Id")
        private Integer id;

        @SerializedName("ContentId")
        private Integer contentId;

        @SerializedName("Name")
        private String name;

        @SerializedName("Value")
        public String value;

        @SerializedName("Type")
        private String type;

        @SerializedName("Reference1")
        private String reference1;

        @SerializedName("Reference2")
        private String reference2;

        @SerializedName("Reference3")
        private String reference3;

        @SerializedName("Reference4")
        private String reference4;

        @SerializedName("Reference5")
        private String reference5;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getContentId() {
            return contentId;
        }

        public void setContentId(Integer contentId) {
            this.contentId = contentId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getReference1() {
            return reference1;
        }

        public void setReference1(String reference1) {
            this.reference1 = reference1;
        }

        public String getReference2() {
            return reference2;
        }

        public void setReference2(String reference2) {
            this.reference2 = reference2;
        }

        public String getReference3() {
            return reference3;
        }

        public void setReference3(String reference3) {
            this.reference3 = reference3;
        }

        public String getReference4() {
            return reference4;
        }

        public void setReference4(String reference4) {
            this.reference4 = reference4;
        }

        public String getReference5() {
            return reference5;
        }

        public void setReference5(String reference5) {
            this.reference5 = reference5;
        }
    }

    public class H2Content {
        @SerializedName("Id")
        private Integer id;

        @SerializedName("ContentId")
        private Integer contentId;

        @SerializedName("Name")
        private String name;

        @SerializedName("Value")
        private String value;

        @SerializedName("Type")
        private String type;

        @SerializedName("Reference1")
        private String reference1;

        @SerializedName("Reference2")
        private String reference2;

        @SerializedName("Reference3")
        private String reference3;

        @SerializedName("Reference4")
        private String reference4;

        @SerializedName("Reference5")
        private String reference5;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getContentId() {
            return contentId;
        }

        public void setContentId(Integer contentId) {
            this.contentId = contentId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getReference1() {
            return reference1;
        }

        public void setReference1(String reference1) {
            this.reference1 = reference1;
        }

        public String getReference2() {
            return reference2;
        }

        public void setReference2(String reference2) {
            this.reference2 = reference2;
        }

        public String getReference3() {
            return reference3;
        }

        public void setReference3(String reference3) {
            this.reference3 = reference3;
        }

        public String getReference4() {
            return reference4;
        }

        public void setReference4(String reference4) {
            this.reference4 = reference4;
        }

        public String getReference5() {
            return reference5;
        }

        public void setReference5(String reference5) {
            this.reference5 = reference5;
        }
    }

    public class LeftMenu {
        @SerializedName("Field")
        public Field_ field;

        @SerializedName("ParentFields")
        public List<ParentField> parentFields = null;

        public Field_ getField() {
            return field;
        }

        public void setField(Field_ field) {
            this.field = field;
        }

        public List<ParentField> getParentFields() {
            return parentFields;
        }

        public void setParentFields(List<ParentField> parentFields) {
            this.parentFields = parentFields;
        }
    }

    public class ParentField {
        @SerializedName("Id")
        private Integer id;

        @SerializedName("ContentId")
        private Integer contentId;

        @SerializedName("Name")
        public String name;

        @SerializedName("Value")
        public String value;

        @SerializedName("Type")
        private String type;

        @SerializedName("Reference1")
        private String reference1;

        @SerializedName("Reference2")
        private String reference2;

        @SerializedName("Reference3")
        private String reference3;

        @SerializedName("Reference4")
        private String reference4;

        @SerializedName("Reference5")
        private String reference5;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getContentId() {
            return contentId;
        }

        public void setContentId(Integer contentId) {
            this.contentId = contentId;
        }

        private String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getReference1() {
            return reference1;
        }

        public void setReference1(String reference1) {
            this.reference1 = reference1;
        }

        public String getReference2() {
            return reference2;
        }

        public void setReference2(String reference2) {
            this.reference2 = reference2;
        }

        public String getReference3() {
            return reference3;
        }

        public void setReference3(String reference3) {
            this.reference3 = reference3;
        }

        public String getReference4() {
            return reference4;
        }

        public void setReference4(String reference4) {
            this.reference4 = reference4;
        }

        public String getReference5() {
            return reference5;
        }

        public void setReference5(String reference5) {
            this.reference5 = reference5;
        }

    }

    public class ParentField_ {
        @SerializedName("Id")
        private Integer id;

        @SerializedName("ContentId")
        private Integer contentId;

        @SerializedName("Name")
        private String name;

        @SerializedName("Value")
        public String value;

        @SerializedName("Type")
        private String type;

        @SerializedName("Reference1")
        private String reference1;

        @SerializedName("Reference2")
        private String reference2;

        @SerializedName("Reference3")
        private String reference3;

        @SerializedName("Reference4")
        private String reference4;

        @SerializedName("Reference5")
        private String reference5;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getContentId() {
            return contentId;
        }

        public void setContentId(Integer contentId) {
            this.contentId = contentId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getReference1() {
            return reference1;
        }

        public void setReference1(String reference1) {
            this.reference1 = reference1;
        }

        public String getReference2() {
            return reference2;
        }

        public void setReference2(String reference2) {
            this.reference2 = reference2;
        }

        public String getReference3() {
            return reference3;
        }

        public void setReference3(String reference3) {
            this.reference3 = reference3;
        }

        public String getReference4() {
            return reference4;
        }

        public void setReference4(String reference4) {
            this.reference4 = reference4;
        }

        public String getReference5() {
            return reference5;
        }

        public void setReference5(String reference5) {
            this.reference5 = reference5;
        }
    }

    public class Slider {
        @SerializedName("Id")
        private Integer id;

        @SerializedName("LanguageId")
        private Integer languageId;

        @SerializedName("Title")
        private String title;

        @SerializedName("SpotText")
        private Object spotText;

        @SerializedName("Link")
        private String link;

        @SerializedName("MainText")
        private Object mainText;

        @SerializedName("MetaTag")
        private Object metaTag;

        @SerializedName("SmallImage")
        private String smallImage;

        @SerializedName("LargeImage")
        private String largeImage;

        @SerializedName("MetaKeyword")
        private Object metaKeyword;

        @SerializedName("Fields")
        private List<Field> fields = null;

        @SerializedName("Reference1")
        private Object reference1;

        @SerializedName("Reference2")
        private Object reference2;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getLanguageId() {
            return languageId;
        }

        public void setLanguageId(Integer languageId) {
            this.languageId = languageId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Object getSpotText() {
            return spotText;
        }

        public void setSpotText(Object spotText) {
            this.spotText = spotText;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public Object getMainText() {
            return mainText;
        }

        public void setMainText(Object mainText) {
            this.mainText = mainText;
        }

        public Object getMetaTag() {
            return metaTag;
        }

        public void setMetaTag(Object metaTag) {
            this.metaTag = metaTag;
        }

        public String getSmallImage() {
            return smallImage;
        }

        public void setSmallImage(String smallImage) {
            this.smallImage = smallImage;
        }

        public String getLargeImage() {
            return largeImage;
        }

        public void setLargeImage(String largeImage) {
            this.largeImage = largeImage;
        }

        public Object getMetaKeyword() {
            return metaKeyword;
        }

        public void setMetaKeyword(Object metaKeyword) {
            this.metaKeyword = metaKeyword;
        }

        public List<Field> getFields() {
            return fields;
        }

        public void setFields(List<Field> fields) {
            this.fields = fields;
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
    }
}