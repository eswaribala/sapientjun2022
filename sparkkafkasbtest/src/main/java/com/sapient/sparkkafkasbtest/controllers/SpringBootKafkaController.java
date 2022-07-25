package com.sapient.sparkkafkasbtest.controllers;

import com.sapient.sparkkafkasbtest.models.Status;
import com.sapient.sparkkafkasbtest.models.Vote;
import com.sapient.sparkkafkasbtest.producers.SpringBootKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class SpringBootKafkaController {
    @Autowired
    private SpringBootKafkaProducer springBootKafkaProducer;

    @PostMapping("/votes")
    public Status vote(@RequestBody Vote vote) throws ExecutionException, InterruptedException {

             springBootKafkaProducer.send(vote.getName());

             return new Status("ok");
         }

}
