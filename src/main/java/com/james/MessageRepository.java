package com.james;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by jamesyburr on 6/21/16.
 */
public interface MessageRepository extends CrudRepository<Message, Integer>{
}
