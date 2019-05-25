package az.contasoft.xmies_queueSystem.api.searchServices.internal;

import az.contasoft.xmies_queueSystem.db.entity.QueueSystem;

@Deprecated
public class ResponseSearchQueueSystem {
    private int serverCode;
    private String serverMessage;
    private QueueSystem queueSystem;

    public ResponseSearchQueueSystem(int serverCode, String serverMessage, QueueSystem queueSystem) {
        this.serverCode = serverCode;
        this.serverMessage = serverMessage;
        this.queueSystem = queueSystem;
    }

    public ResponseSearchQueueSystem() {
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

    public QueueSystem getQueueSystem() {
        return queueSystem;
    }

    public void setQueueSystem(QueueSystem queueSystem) {
        this.queueSystem = queueSystem;
    }

    @Override
    public String toString() {
        return "ResponseSearchQueueSystem{" +
                "serverCode=" + serverCode +
                ", serverMessage='" + serverMessage + '\'' +
                ", queueSystem=" + queueSystem +
                '}';
    }
}
