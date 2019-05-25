package az.contasoft.xmies_queueSystem.api.searchServices.internal;

import az.contasoft.xmies_queueSystem.db.entity.QueueSystem;

import java.util.List;

@Deprecated
public class ResponseSearchListQueueSystem {
    private int serverCode;
    private String serverMessage;
    private List<QueueSystem> queueSystemList;

    public ResponseSearchListQueueSystem(int serverCode, String serverMessage, List<QueueSystem> queueSystemList) {

        this.serverCode = serverCode;
        this.serverMessage = serverMessage;
        this.queueSystemList = queueSystemList;
    }

    @Override
    public String toString() {
        return "ResponseSearchListQueueSystem{" +
                "serverCode=" + serverCode +
                ", serverMessage='" + serverMessage + '\'' +
                ", queueSystemList=" + queueSystemList +
                '}';
    }

    public ResponseSearchListQueueSystem() {
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

    public List<QueueSystem> getQueueSystemList() {
        return queueSystemList;
    }

    public void setQueueSystemList(List<QueueSystem> queueSystemList) {
        this.queueSystemList = queueSystemList;
    }
}
