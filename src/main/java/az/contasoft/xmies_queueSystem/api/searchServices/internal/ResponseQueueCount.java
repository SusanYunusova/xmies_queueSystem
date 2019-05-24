package az.contasoft.xmies_queueSystem.api.searchServices.internal;

public class ResponseQueueCount {
    private int serverCode;
    private String serverMessage;
    private int count;

    public ResponseQueueCount(int serverCode, String serverMessage, int count) {
        this.serverCode = serverCode;
        this.serverMessage = serverMessage;
        this.count = count;
    }

    public ResponseQueueCount() {
    }

    @Override
    public String toString() {
        return "ResponseQueueCount{" +
                "serverCode=" + serverCode +
                ", serverMessage='" + serverMessage + '\'' +
                ", count=" + count +
                '}';
    }

    public int getServerCode() {
        return serverCode;
    }

    public void setServerCode(int serverCode) {
        this.serverCode = serverCode;
    }

    public String getServerMessage() {
        return serverMessage;
    }

    public void setServerMessage(String serverMessage) {
        this.serverMessage = serverMessage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
