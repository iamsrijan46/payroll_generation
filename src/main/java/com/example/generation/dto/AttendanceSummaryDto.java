package com.example.generation.dto;

public class AttendanceSummaryDto {
    private long present;
    private long absent;
    private long holiday;

    public AttendanceSummaryDto(long present, long absent, long holiday) {
        this.present = present;
        this.absent = absent;
        this.holiday = holiday;
    }

    public long getPresent() {
        return present;
    }

    public long getAbsent() {
        return absent;
    }

    public long getHoliday() {
        return holiday;
    }
}
