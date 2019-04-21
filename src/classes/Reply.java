package classes;

public class Reply {
    private String contentType;
    private Object data;
    private String characterEncoding;
    private boolean status = false;

    public Reply setContentType(String contentType) {
        this.contentType = contentType;

        return this;
    }

    public Reply setCharacterEncoding(String encoding) {
        this.characterEncoding = encoding;

        return this;
    }

    public Reply setData(Object data) {
        this.data = data;

        return this;
    }

    public Reply setStatus(boolean status) {
        this.status = status;

        return this;
    }

    public String getJSON() {
        return data.toString();
    }
}
