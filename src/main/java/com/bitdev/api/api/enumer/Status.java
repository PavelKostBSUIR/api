package com.bitdev.api.api.enumer;

public enum Status {
    ONLINE("ONLINE"), OFFLINE("OFFLINE");

    private final String code;

    Status(String code) {
        this.code = code;
    }

    //@JsonCreator
    public static Status getStatusFromCode(String value) {

        for (Status status : Status.values()) {

            if (status.getCode().equals(value)) {

                return status;
            }
        }

        return null;
    }

    public String getCode() {
        return code;
    }
}
