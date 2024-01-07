package br.com.fiapfood.pedido.application.payload.response;

public class ErrorResponse {
    private int status;
    private String message;

    public static ErrorResponseBuilder builder() {
        return new ErrorResponseBuilder();
    }

    public int getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setStatus(final int status) {
        this.status = status;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ErrorResponse)) {
            return false;
        } else {
            ErrorResponse other = (ErrorResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getStatus() != other.getStatus()) {
                return false;
            } else {
                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ErrorResponse;
    }

    public int hashCode() {
        int result = 1;
        result = result * 59 + this.getStatus();
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        return result;
    }

    public String toString() {
        int var10000 = this.getStatus();
        return "ErrorResponse(status=" + var10000 + ", message=" + this.getMessage() + ")";
    }

    public ErrorResponse() {
    }

    public ErrorResponse(final int status, final String message) {
        this.status = status;
        this.message = message;
    }

    public static class ErrorResponseBuilder {
        private int status;
        private String message;

        ErrorResponseBuilder() {
        }

        public ErrorResponseBuilder status(final int status) {
            this.status = status;
            return this;
        }

        public ErrorResponseBuilder message(final String message) {
            this.message = message;
            return this;
        }

        public ErrorResponse build() {
            return new ErrorResponse(this.status, this.message);
        }

        public String toString() {
            return "ErrorResponse.ErrorResponseBuilder(status=" + this.status + ", message=" + this.message + ")";
        }
    }
}
