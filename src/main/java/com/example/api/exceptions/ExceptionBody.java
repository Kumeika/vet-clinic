package com.example.api.exceptions;

public class ExceptionBody {
    private String message;
    private String timestamp;
    private String path;
    private int status;

    private ExceptionBody(ExceptionBodyBuilder b) {
        this.message = b.message;
        this.timestamp = b.timestamp;
        this.path = b.path;
        this.status = b.status;
    }

    static ExceptionBodyBuilder builder(){
        return new ExceptionBodyBuilder();
    }
    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getPath() {
        return path;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ExceptionBody{" +
                "message='" + message + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", path='" + path + '\'' +
                ", status=" + status +
                '}';
    }

    public static class ExceptionBodyBuilder{
        private String message;
        private String timestamp;
        private String path;
        private int status;

        public ExceptionBodyBuilder message(String message){
            this.message=message;
            return this;
        }
        public ExceptionBodyBuilder timestamp(String timestamp){
            this.timestamp=timestamp;
            return this;
        }
        public ExceptionBodyBuilder path(String path){
            this.path=path;
            return this;
        }
        public ExceptionBodyBuilder status(int status){
            this.status=status;
            return this;
        }
        ExceptionBody build(){
            return new ExceptionBody(this);
        }
    }
}
