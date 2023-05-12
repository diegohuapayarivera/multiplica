package mtrorrey.com.chipproducer.aplication.service;

import mtrorrey.com.chipproducer.domain.models.ActivationDTO;
import mtrorrey.com.chipproducer.domain.models.ActivationQueue;
import mtrorrey.com.chipproducer.domain.services.QueueStrategyFactory;
import mtrorrey.com.chipproducer.domain.util.Constants;
import mtrorrey.com.chipproducer.infrastructure.util.Serializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivationService {

    @Autowired
    QueueStrategyFactory queue;


    public void activation(ActivationDTO activationDTO){
        ActivationQueue activationQueue = new ActivationQueue();
        activationQueue.setUserId(activationDTO.getUserId());
        activationQueue.setMetrorreySerial(activationDTO.getMetrorreySerial());
        String json = Serializer.objectToJson(activationQueue);
        queue.sendMessage(Constants.ACTIVATION,json);
    }

}
