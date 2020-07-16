package com.github.code.references.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@NoArgsConstructor
@Data
@Builder
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Service extends HashMap<String, ServiceTypes> {
    private double az_cost = 0;
    private double gcp_cost = 0;
    private double os_cost = 0;
    private double az_cn_cost = 0;
    private double total_cost = 0;

    // To be initialized using jackson to get the instantiation working during deserialization
    @JsonCreator
    public Service(@JsonProperty("az_cost") Double az_cost, @JsonProperty("gcp_cost") Double gcp_cost, @JsonProperty("os_cost") Double os_cost, @JsonProperty("az_cn_cost") Double az_cn_cost, @JsonProperty("total_cost") Double total_cost) {
        this.az_cost = az_cost;
        this.gcp_cost = gcp_cost;
        this.os_cost = os_cost;
        this.az_cn_cost = az_cn_cost;
        this.total_cost = total_cost;
    }
}
