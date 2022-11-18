package L2_SOLID.C1_OCP.alert;

public  class ApiLimit {
    Long maxTps = Long.MAX_VALUE;
    Long maxErrorCount = Long.MAX_VALUE;
    Long maxTimeoutCount = Long.MAX_VALUE;

    public ApiLimit() {
    }

    public ApiLimit(Long maxTps, Long maxErrorCount, Long maxTimeoutCount) {
        this.maxTps = maxTps;
        this.maxErrorCount = maxErrorCount;
        this.maxTimeoutCount = maxTimeoutCount;
    }

    public long getMaxTps() {
        return maxTps;
    }

    public void setMaxTps(long maxTps) {
        this.maxTps = maxTps;
    }

    public long getMaxErrorCount() {
        return maxErrorCount;
    }

    public void setMaxErrorCount(long maxErrorCount) {
        this.maxErrorCount = maxErrorCount;
    }

    public long getMaxTimeoutCount() {
        return maxTimeoutCount;
    }

    public void setMaxTimeoutCount(long maxTimeoutCount) {
        this.maxTimeoutCount = maxTimeoutCount;
    }
}