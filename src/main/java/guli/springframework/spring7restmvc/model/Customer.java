package guli.springframework.spring7restmvc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tools.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonDeserialize(builder = Customer.CustomerBuilder.class)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Customer {

    @JsonProperty("customerName")
    private String customerName;

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("version")
    private Integer version;

    @JsonProperty("createdDate")
    private LocalDateTime createdDate;

    @JsonProperty("lastModifiedDate")
    private LocalDateTime lastModifiedDate;
}
