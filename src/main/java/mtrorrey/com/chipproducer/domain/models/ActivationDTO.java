package mtrorrey.com.chipproducer.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivationDTO {

    @NotNull
    private String provider;
    @NotNull
    public String userId;
    @NotNull
    public String metrorreySerial;

    public boolean firtsTime;


}
