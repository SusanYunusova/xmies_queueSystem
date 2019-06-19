package az.contasoft.xmies_properties.db.entity;



import java.io.Serializable;

public class Properties implements Serializable {
    private static final long serialVersionUID = 1L;

    private long idProperties;
    private  String value;
    private  int parentId;
    private  int isDelete;

    public Properties() {
    }

    public Properties(long idProperties, String value, int parentId, int isDelete) {
        this.idProperties = idProperties;
        this.value = value;
        this.parentId = parentId;
        this.isDelete = isDelete;
    }

    public long getIdProperties() {
        return idProperties;
    }

    public void setIdProperties(long idProperties) {
        this.idProperties = idProperties;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Properties{" +
                "idProperties=" + idProperties +
                ", value='" + value + '\'' +
                ", parentId=" + parentId +
                ", isDelete=" + isDelete +
                '}';

    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
