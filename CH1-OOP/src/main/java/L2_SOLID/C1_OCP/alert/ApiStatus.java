package L2_SOLID.C1_OCP.alert;

public class ApiStatus {
    String api;
    long requestCount;
    long errorCount;
    long timeoutCount;
    long durationOfSeconds =  Long.MAX_VALUE;

    public ApiStatus(String api, long requestCount, long errorCount, long timeoutCount, long durationOfSeconds) {
        this.api = api;
        this.requestCount = requestCount;
        this.errorCount = errorCount;
        this.timeoutCount = timeoutCount;
        this.durationOfSeconds = durationOfSeconds;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public long getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(long requestCount) {
        this.requestCount = requestCount;
    }

    public long getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(long errorCount) {
        this.errorCount = errorCount;
    }

    public long getTimeoutCount() {
        return timeoutCount;
    }

    public void setTimeoutCount(long timeoutCount) {
        this.timeoutCount = timeoutCount;
    }

    public long getDurationOfSeconds() {
        return durationOfSeconds;
    }

    public void setDurationOfSeconds(long durationOfSeconds) {
        this.durationOfSeconds = durationOfSeconds;
    }
}
