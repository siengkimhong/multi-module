package com.kimhong.rest.message;

public enum SuccessMessage {
    FOUND_ALL("All records have been found successfully"),
    FOUND_ONE("Record has been found successfully"),
    IS_SAVE("Record has been saved successfully"),
    IS_UPDATE("Record has been updated successfully"),
    IS_DELETE("Record has been deleted successfully"),
    UPLOADED_IMAGE("Image has been uploaded");

    private final String message;

    SuccessMessage(String message) {
        this.message = message;
    }
    public String value(){
        return message;
    }
}
