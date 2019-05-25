package az.contasoft.xmies_queueSystem.api.crudServices.internal;

import az.contasoft.xmies_queueSystem.db.entity.QueueSystem;

@Deprecated
public class QueueSystemResponse {
    private int serverCode;
    private String serverMessage;
    private QueueSystem queueSystem;

    public QueueSystemResponse(int serverCode, String serverMessage, QueueSystem queueSystem) {
        this.serverCode = serverCode;
        this.serverMessage = serverMessage;
        this.queueSystem = queueSystem;
    }

    public QueueSystem getQueueSystem() {
        return queueSystem;
    }

    public void setQueueSystem(QueueSystem queueSystem) {
        this.queueSystem = queueSystem;
    }

    public QueueSystemResponse() {
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

    @Override
    public String toString() {
        return "QueueSystemResponse{" +
                "serverCode=" + serverCode +
                ", serverMessage='" + serverMessage + '\'' +
                ", queueSystem=" + queueSystem +
                '}';
    }
}
