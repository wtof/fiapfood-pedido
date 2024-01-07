package br.com.fiapfood.pedido.application.payload.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import java.time.LocalDateTime;

public class EventoPagamentoDTO {
    private String action;
    private String apiVersion;
    private String applicationId;
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss Z 'UTC'"
    )
    @JsonDeserialize(
            using = LocalDateTimeDeserializer.class
    )
    private LocalDateTime dateCreated;
    private String id;
    private boolean liveMode;
    private String type;
    @JsonProperty("user_id")
    private String userId;
    private DataMercadoPagoDTO data;

    EventoPagamentoDTO(final String action, final String apiVersion, final String applicationId, final LocalDateTime dateCreated, final String id, final boolean liveMode, final String type, final String userId, final DataMercadoPagoDTO data) {
        this.action = action;
        this.apiVersion = apiVersion;
        this.applicationId = applicationId;
        this.dateCreated = dateCreated;
        this.id = id;
        this.liveMode = liveMode;
        this.type = type;
        this.userId = userId;
        this.data = data;
    }

    public static EventoPagamentoDTOBuilder builder() {
        return new EventoPagamentoDTOBuilder();
    }

    public String getAction() {
        return this.action;
    }

    public String getApiVersion() {
        return this.apiVersion;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public LocalDateTime getDateCreated() {
        return this.dateCreated;
    }

    public String getId() {
        return this.id;
    }

    public boolean isLiveMode() {
        return this.liveMode;
    }

    public String getType() {
        return this.type;
    }

    public String getUserId() {
        return this.userId;
    }

    public DataMercadoPagoDTO getData() {
        return this.data;
    }

    public void setAction(final String action) {
        this.action = action;
    }

    public void setApiVersion(final String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public void setApplicationId(final String applicationId) {
        this.applicationId = applicationId;
    }

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss Z 'UTC'"
    )
    @JsonDeserialize(
            using = LocalDateTimeDeserializer.class
    )
    public void setDateCreated(final LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setLiveMode(final boolean liveMode) {
        this.liveMode = liveMode;
    }

    public void setType(final String type) {
        this.type = type;
    }

    @JsonProperty("user_id")
    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public void setData(final DataMercadoPagoDTO data) {
        this.data = data;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof EventoPagamentoDTO)) {
            return false;
        } else {
            EventoPagamentoDTO other = (EventoPagamentoDTO)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.isLiveMode() != other.isLiveMode()) {
                return false;
            } else {
                label109: {
                    Object this$action = this.getAction();
                    Object other$action = other.getAction();
                    if (this$action == null) {
                        if (other$action == null) {
                            break label109;
                        }
                    } else if (this$action.equals(other$action)) {
                        break label109;
                    }

                    return false;
                }

                label102: {
                    Object this$apiVersion = this.getApiVersion();
                    Object other$apiVersion = other.getApiVersion();
                    if (this$apiVersion == null) {
                        if (other$apiVersion == null) {
                            break label102;
                        }
                    } else if (this$apiVersion.equals(other$apiVersion)) {
                        break label102;
                    }

                    return false;
                }

                Object this$applicationId = this.getApplicationId();
                Object other$applicationId = other.getApplicationId();
                if (this$applicationId == null) {
                    if (other$applicationId != null) {
                        return false;
                    }
                } else if (!this$applicationId.equals(other$applicationId)) {
                    return false;
                }

                label88: {
                    Object this$dateCreated = this.getDateCreated();
                    Object other$dateCreated = other.getDateCreated();
                    if (this$dateCreated == null) {
                        if (other$dateCreated == null) {
                            break label88;
                        }
                    } else if (this$dateCreated.equals(other$dateCreated)) {
                        break label88;
                    }

                    return false;
                }

                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                label74: {
                    Object this$type = this.getType();
                    Object other$type = other.getType();
                    if (this$type == null) {
                        if (other$type == null) {
                            break label74;
                        }
                    } else if (this$type.equals(other$type)) {
                        break label74;
                    }

                    return false;
                }

                Object this$userId = this.getUserId();
                Object other$userId = other.getUserId();
                if (this$userId == null) {
                    if (other$userId != null) {
                        return false;
                    }
                } else if (!this$userId.equals(other$userId)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof EventoPagamentoDTO;
    }

    public int hashCode() {
        int result = 1;
        result = result * 59 + (this.isLiveMode() ? 79 : 97);
        Object $action = this.getAction();
        result = result * 59 + ($action == null ? 43 : $action.hashCode());
        Object $apiVersion = this.getApiVersion();
        result = result * 59 + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $applicationId = this.getApplicationId();
        result = result * 59 + ($applicationId == null ? 43 : $applicationId.hashCode());
        Object $dateCreated = this.getDateCreated();
        result = result * 59 + ($dateCreated == null ? 43 : $dateCreated.hashCode());
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $type = this.getType();
        result = result * 59 + ($type == null ? 43 : $type.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        String var10000 = this.getAction();
        return "EventoPagamentoDTO(action=" + var10000 + ", apiVersion=" + this.getApiVersion() + ", applicationId=" + this.getApplicationId() + ", dateCreated=" + this.getDateCreated() + ", id=" + this.getId() + ", liveMode=" + this.isLiveMode() + ", type=" + this.getType() + ", userId=" + this.getUserId() + ", data=" + this.getData() + ")";
    }

    public static class EventoPagamentoDTOBuilder {
        private String action;
        private String apiVersion;
        private String applicationId;
        private LocalDateTime dateCreated;
        private String id;
        private boolean liveMode;
        private String type;
        private String userId;
        private DataMercadoPagoDTO data;

        EventoPagamentoDTOBuilder() {
        }

        public EventoPagamentoDTOBuilder action(final String action) {
            this.action = action;
            return this;
        }

        public EventoPagamentoDTOBuilder apiVersion(final String apiVersion) {
            this.apiVersion = apiVersion;
            return this;
        }

        public EventoPagamentoDTOBuilder applicationId(final String applicationId) {
            this.applicationId = applicationId;
            return this;
        }

        @JsonFormat(
                pattern = "yyyy-MM-dd HH:mm:ss Z 'UTC'"
        )
        @JsonDeserialize(
                using = LocalDateTimeDeserializer.class
        )
        public EventoPagamentoDTOBuilder dateCreated(final LocalDateTime dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public EventoPagamentoDTOBuilder id(final String id) {
            this.id = id;
            return this;
        }

        public EventoPagamentoDTOBuilder liveMode(final boolean liveMode) {
            this.liveMode = liveMode;
            return this;
        }

        public EventoPagamentoDTOBuilder type(final String type) {
            this.type = type;
            return this;
        }

        @JsonProperty("user_id")
        public EventoPagamentoDTOBuilder userId(final String userId) {
            this.userId = userId;
            return this;
        }

        public EventoPagamentoDTOBuilder data(final DataMercadoPagoDTO data) {
            this.data = data;
            return this;
        }

        public EventoPagamentoDTO build() {
            return new EventoPagamentoDTO(this.action, this.apiVersion, this.applicationId, this.dateCreated, this.id, this.liveMode, this.type, this.userId, this.data);
        }

        public String toString() {
            return "EventoPagamentoDTO.EventoPagamentoDTOBuilder(action=" + this.action + ", apiVersion=" + this.apiVersion + ", applicationId=" + this.applicationId + ", dateCreated=" + this.dateCreated + ", id=" + this.id + ", liveMode=" + this.liveMode + ", type=" + this.type + ", userId=" + this.userId + ", data=" + this.data + ")";
        }
    }
}
