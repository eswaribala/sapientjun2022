package com.sapient.claimkafkaconsumerapi.repositories;


import com.sapient.claimkafkaconsumerapi.models.PSPolicy;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends CassandraRepository<PSPolicy,Long> {


}