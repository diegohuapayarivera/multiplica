package mtrorrey.com.chipproducer.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivationQueue {

    @NotNull
    public String userId;
    @NotNull
    public String metrorreySerial;

}
